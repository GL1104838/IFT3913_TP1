package ift3913.tp1;

import ift3913.tp1.metrics.Metrics;
import ift3913.tp1.metrics.MetricsBuilder;
import ift3913.tp1.parser.ast.Aggregation;
import ift3913.tp1.parser.ast.Association;
import ift3913.tp1.parser.ast.DataItem;
import ift3913.tp1.parser.ast.Generalization;
import ift3913.tp1.parser.ast.Klass;
import ift3913.tp1.parser.ast.Model;
import ift3913.tp1.parser.ast.Operation;
import ift3913.tp1.parser.ast.Role;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestMetrics {

    @Test
    public void testANA() {
        Model m = new Model("test");
        Klass k = new Klass("foo");

        Operation o1 = new Operation("foobar", "int");
        o1.args.add(new DataItem("foo", "int"));
        o1.args.add(new DataItem("bar", "float"));

        Operation o2 = new Operation("foobaz", "float");
        o2.args.add(new DataItem("foo", "int"));
        o2.args.add(new DataItem("bar", "float"));
        o2.args.add(new DataItem("baz", "bool"));
        o2.args.add(new DataItem("qux", "string"));

        k.operations.add(o1);
        k.operations.add(o2);
        m.declarations.add(k);

        Metrics x = MetricsBuilder.computeMetrics(m, k);
        assertEquals(3.0, x.ana, 0);
    }

    @Test
    public void testNOM() {
        Model m = new Model("test");
        Klass parent = new Klass("parent");
        Klass child = new Klass("child");

        parent.operations.add(new Operation("foobar", "void")); // inherited
        parent.operations.add(new Operation("foobaz", "void")); // inherited

        child.operations.add(new Operation("foobar", "void"));  // re-defined
        child.operations.add(new Operation("foobaz", "int"));   // diff. signature

        m.declarations.add(parent);
        m.declarations.add(child);
        m.declarations.add(new Generalization("parent", "child"));

        Metrics x = MetricsBuilder.computeMetrics(m, child);
        assertEquals(3, x.nom);
    }

    @Test
    public void testNOA() {
        Model m = new Model("test");
        Klass parent = new Klass("parent");
        Klass child = new Klass("child");

        parent.attributes.add(new DataItem("qux", "int"));
        child.attributes.add(new DataItem("bar", "float"));

        m.declarations.add(parent);
        m.declarations.add(child);
        m.declarations.add(new Generalization("parent", "child"));

        Metrics x = MetricsBuilder.computeMetrics(m, child);
        assertEquals(2, x.noa);
    }

    @Test
    public void testITC() {
        Model m = new Model("test");
        Klass main = new Klass("main");
        Klass foo1 = new Klass("foo1");
        Klass foo2 = new Klass("foo2");

        Operation o1 = new Operation("qux", "void");
        o1.args.add(new DataItem("foo", "foo1")); // class
        o1.args.add(new DataItem("bar", "foo2")); // class

        Operation o2 = new Operation("quux", "void");
        o2.args.add(new DataItem("baz", "foo2")); // class
        o2.args.add(new DataItem("box", "int"));  // not class

        main.operations.add(o1);
        main.operations.add(o2);

        m.declarations.add(main);
        m.declarations.add(foo1);
        m.declarations.add(foo2);

        Metrics x = MetricsBuilder.computeMetrics(m, main);
        assertEquals(3, x.itc);
    }

    @Test
    public void testETC() {
        Model m = new Model("test");
        Klass main = new Klass("main");
        Klass foo1 = new Klass("foo1");
        Klass foo2 = new Klass("foo2");

        Operation o1 = new Operation("qux", "void");
        o1.args.add(new DataItem("foo", "main")); // class
        o1.args.add(new DataItem("bar", "main")); // class

        Operation o2 = new Operation("quux", "void");
        o2.args.add(new DataItem("baz", "main")); // class
        o2.args.add(new DataItem("box", "int"));  // not class

        foo1.operations.add(o1);
        foo2.operations.add(o2);

        m.declarations.add(main);
        m.declarations.add(foo1);
        m.declarations.add(foo2);

        Metrics x = MetricsBuilder.computeMetrics(m, main);
        assertEquals(3, x.etc);
    }

    @Test
    public void testCAC() {
        Model m = new Model("test");
        Klass main = new Klass("main");
        Klass foo1 = new Klass("foo1");
        Klass foo2 = new Klass("foo2");

        m.declarations.add(main);
        m.declarations.add(foo1);
        m.declarations.add(foo2);

        m.declarations.add(new Aggregation(new Role("main"), new Role("foo1")));
        m.declarations.add(new Association("qux", new Role("foo1"), new Role("main")));

        Metrics x = MetricsBuilder.computeMetrics(m, main);
        assertEquals(2, x.cac);
    }

    @Test
    public void testDIT() {
        Model m = new Model("test");
        Klass grandmother = new Klass("grandmother");
        Klass mother = new Klass("mother");
        Klass father = new Klass("father");
        Klass child = new Klass("child");

        m.declarations.add(grandmother);
        m.declarations.add(mother);
        m.declarations.add(father);
        m.declarations.add(child);

        m.declarations.add(new Generalization("grandmother", "mother"));
        m.declarations.add(new Generalization("mother", "child"));
        m.declarations.add(new Generalization("father", "child"));

        Metrics x = MetricsBuilder.computeMetrics(m, child);
        assertEquals(2, x.dit);
    }

    @Test
    public void testCLD() {
        Model m = new Model("test");
        Klass root = new Klass("root");
        Klass sibling1 = new Klass("sibling1");
        Klass sibling2 = new Klass("sibling2");
        Klass subsibling1_1 = new Klass("subsibling1_1");

        m.declarations.add(root);
        m.declarations.add(sibling1);
        m.declarations.add(sibling2);
        m.declarations.add(subsibling1_1);

        m.declarations.add(new Generalization("root", "sibling1", "sibling2"));
        m.declarations.add(new Generalization("sibling1", "subsibling1_1"));

        Metrics x = MetricsBuilder.computeMetrics(m, root);
        assertEquals(2, x.cld);
    }

    @Test
    public void testNOC() {
        Model m = new Model("test");
        Klass root = new Klass("root");
        Klass sibling1 = new Klass("sibling1");
        Klass sibling2 = new Klass("sibling2");
        Klass subsibling1_1 = new Klass("subsibling1_1");

        m.declarations.add(root);
        m.declarations.add(sibling1);
        m.declarations.add(sibling2);
        m.declarations.add(subsibling1_1);

        m.declarations.add(new Generalization("root", "sibling1", "sibling2"));
        m.declarations.add(new Generalization("sibling1", "subsibling1_1"));

        Metrics x = MetricsBuilder.computeMetrics(m, root);
        assertEquals(2, x.noc);
    }

    @Test
    public void testNOD() {
        Model m = new Model("test");
        Klass root = new Klass("root");
        Klass sibling1 = new Klass("sibling1");
        Klass sibling2 = new Klass("sibling2");
        Klass subsibling1_1 = new Klass("subsibling1_1");

        m.declarations.add(root);
        m.declarations.add(sibling1);
        m.declarations.add(sibling2);
        m.declarations.add(subsibling1_1);

        m.declarations.add(new Generalization("root", "sibling1", "sibling2"));
        m.declarations.add(new Generalization("sibling1", "subsibling1_1"));

        Metrics x = MetricsBuilder.computeMetrics(m, root);
        assertEquals(3, x.nod);
    }
}
