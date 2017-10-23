package ift3913.tp1.metrics;

import ift3913.tp1.parser.ast.Aggregation;
import ift3913.tp1.parser.ast.Association;
import ift3913.tp1.parser.ast.DataItem;
import ift3913.tp1.parser.ast.Declaration;
import ift3913.tp1.parser.ast.Generalization;
import ift3913.tp1.parser.ast.Klass;
import ift3913.tp1.parser.ast.Model;
import ift3913.tp1.parser.ast.Operation;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class MetricsBuilder {

    private Model model;
    private Klass target;
    private Metrics metrics;

    private List<Klass> classes;
    private List<Generalization> generalizations;
    private List<Association> associations;
    private List<Aggregation> aggregations;

    public static Metrics computeMetrics(Model model, String klassName) {
        MetricsBuilder builder = new MetricsBuilder(model, klassName);
        return builder.getResult();
    }

    public static Metrics computeMetrics(Model model, Klass target) {
        MetricsBuilder builder = new MetricsBuilder(model, target);
        return builder.getResult();
    }

    private MetricsBuilder(Model model, String klassName) {
        this.model = model;
        extract();

        this.target = getClass(klassName);
        this.metrics = new Metrics();

        if (this.target == null) {
            throw new IllegalArgumentException("Class does not exist");
        }

        compute();

    }

    private MetricsBuilder(Model model, Klass target) {
        this.model = model;
        extract();

        this.target = target;
        this.metrics = new Metrics();

        compute();
    }

    public void extract() {
        classes = new ArrayList<>();
        generalizations = new ArrayList<>();
        associations = new ArrayList<>();
        aggregations = new ArrayList<>();
        for (Declaration d : model.declarations) {
            if (d instanceof Klass) {
                classes.add((Klass) d);
            } else if (d instanceof Generalization) {
                generalizations.add((Generalization) d);
            } else if (d instanceof Association) {
                associations.add((Association) d);
            } else if (d instanceof Aggregation) {
                aggregations.add((Aggregation) d);
            }
        }
    }

    private Metrics getResult() {
        return metrics;
    }

    private Klass getClass(String name) {
        return classes
                .stream()
                .filter(k -> k.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    private Generalization getGeneralization(String name) {
        return generalizations
                .stream()
                .filter(g -> g.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    private List<Klass> getDirectSuperClasses(Klass target) {
        return generalizations
                .stream()
                .filter(g -> g.subclasses.contains(target.name))
                .map(g -> getClass(g.name))
                .collect(toList());
    }

    private List<Klass> getDirectSubClasses(Klass target) {
        Generalization gen = getGeneralization(target.name);
        if (gen != null) {
            return gen.subclasses
                    .stream()
                    .map(s -> getClass(s))
                    .collect(toList());
        } else {
            return new ArrayList<>();
        }
    }

    private List<Operation> findAllMethods(Klass target) {
        List<Operation> set = new ArrayList<>();
        findAllMethods(target, set);
        return set;
    }

    private void findAllMethods(Klass cur, List<Operation> set) {
        List<Klass> parents = getDirectSuperClasses(cur);
        for (Operation op : cur.operations) {
            if (!set.contains(op)) {
                set.add(op);
            }
        }
        for (Klass parent : parents) {
            findAllMethods(parent, set);
        }
    }

    private void compute() {
        computeANA();
        computeNOM();
        computeNOA();
        computeITC();
        computeETC();
        computeCAC();
        computeDIT();
        computeCLD();
        computeNOC();
        computeNOD();
    }

    private void computeANA() {
        double sum = 0;
        if (target.operations.size() > 0) {
            for (Operation op : target.operations) {
                sum += op.args.size();
            }
            this.metrics.ana = sum / target.operations.size();
        } else {
            this.metrics.ana = 0;
        }
    }

    private void computeNOM() {
        this.metrics.nom = findAllMethods(target).size();
    }

    private void computeNOA() {
        List<DataItem> set = new ArrayList<>();
        computeNOARec(target, set);
        this.metrics.noa = set.size();
    }

    private void computeNOARec(Klass cur, List<DataItem> set) {
        List<Klass> parents = getDirectSuperClasses(cur);
        for (DataItem di : cur.attributes) {
            set.add(di);
        }
        for (Klass parent : parents) {
            computeNOARec(parent, set);
        }
    }

    private void computeITC() {
        List<String> classNames = classes.stream().map(k -> k.name).collect(toList());
        List<Operation> methods = findAllMethods(target);
        for (Operation op : methods) {
            for (DataItem di : op.args) {
                if (classNames.contains(di.type)) {
                    this.metrics.itc++;
                }
            }
        }
    }

    private void computeETC() {
        for (Klass k : classes) {
            for (Operation op : k.operations) {
                for (DataItem di : op.args) {
                    if (di.type.equals(this.target.name)) {
                        this.metrics.etc++;
                    }
                }
            }
        }
    }

    private void computeCAC() {
        for (Association assoc : associations) {
            if (assoc.role_1.name.equals(target.name) || assoc.role_2.name.equals(target.name)) {
                this.metrics.cac++;
            }
        }

        for (Aggregation aggr : aggregations) {
            if (aggr.single.name.equals(target.name)
                    || aggr.roles.stream().anyMatch(r -> r.name.equals(target.name))) {
                this.metrics.cac++;
            }
        }
    }

    private void computeDIT() {
        this.metrics.dit = computeDITRec(target, 0) - 1;
    }

    private int computeDITRec(Klass cur, int height) {
        List<Klass> children = getDirectSuperClasses(cur);
        return 1 + height
                + children
                        .stream()
                        .map(c -> computeDITRec(c, height))
                        .max(Integer::max).orElse(0);
    }

    private void computeCLD() {
        this.metrics.cld = computeCLDRec(target, 0) - 1;
    }

    private int computeCLDRec(Klass cur, int depth) {
        List<Klass> children = getDirectSubClasses(cur);
        return 1 + depth
                + children
                        .stream()
                        .map(c -> computeCLDRec(c, depth))
                        .max(Integer::max).orElse(0);
    }

    private void computeNOC() {
        List<Klass> children = getDirectSubClasses(target);
        this.metrics.noc = children.size();
    }

    private void computeNOD() {
        computeNODRec(target);
    }

    private void computeNODRec(Klass cur) {
        List<Klass> children = getDirectSubClasses(cur);
        this.metrics.nod += children.size();
        for (Klass child : children) {
            computeNODRec(child);
        }
    }

}
