package ift3913.tp1.parser;

import ift3913.tp1.parser.ast.*;
import java.util.List;
import static java.util.stream.Collectors.toList;
import org.antlr.v4.runtime.*;

public class ModelParser {

    public static Model parseModel(String src) {
        CharStream cs = CharStreams.fromString(src);
        UMLLexer lexer = new UMLLexer(cs);
        TokenStream tokens = new CommonTokenStream(lexer);
        UMLParser parser = new UMLParser(tokens);

        ModelVisitor visitor = new ModelVisitor();
        return visitor.visit(parser.model());
    }

    private static List<DataItem> collectDataItems(List<UMLParser.DataItemContext> list) {
        DataItemVisitor dataItemVisitor = new DataItemVisitor();
        return list.stream()
                .map(item -> item.accept(dataItemVisitor))
                .collect(toList());
    }

    private static class ModelVisitor extends UMLBaseVisitor<Model> {

        @Override
        public Model visitModel(UMLParser.ModelContext ctx) {
            if (ctx.ID() == null || ctx.declaration() == null) {
                return null;
            }

            DeclarationVisitor visitor = new DeclarationVisitor();

            Model m = new Model();
            m.name = ctx.ID().getText();
            m.declarations = ctx.declaration()
                    .stream()
                    .map(decl -> decl.accept(visitor))
                    .collect(toList());
            return m;
        }
    }

    private static class DeclarationVisitor extends UMLBaseVisitor<Declaration> {

        @Override
        public Declaration visitDeclaration(UMLParser.DeclarationContext ctx) {
            Declaration decl = null;

            if (ctx.klass() != null) {
                decl = ctx.klass().accept(new KlassVisitor());
            } else if (ctx.association() != null) {
                decl = ctx.association().accept(new AssociationVisitor());
            } else if (ctx.generalization() != null) {
                decl = ctx.generalization().accept(new GeneralizationVisitor());
            } else if (ctx.aggregation() != null) {
                decl = ctx.aggregation().accept(new AggregationVisitor());
            }
            return decl;
        }
    }

    private static class KlassVisitor extends UMLBaseVisitor<Klass> {

        @Override
        public Klass visitKlass(UMLParser.KlassContext ctx) {
            OperationVisitor visitor = new OperationVisitor();
            Klass k = new Klass();
            k.name = ctx.ID().getText();
            k.attributes = collectDataItems(ctx.attributeList().dataItem());
            k.operations = ctx.operationList().operation()
                    .stream()
                    .map(op -> op.accept(visitor))
                    .collect(toList());
            return k;
        }
    }

    private static class AssociationVisitor extends UMLBaseVisitor<Association> {

        @Override
        public Association visitAssociation(UMLParser.AssociationContext ctx) {
            RoleVisitor roleVisitor = new RoleVisitor();
            Association a = new Association();
            a.name = ctx.ID().getText();
            a.role_1 = ctx.twoRoles().role(0).accept(roleVisitor);
            a.role_2 = ctx.twoRoles().role(1).accept(roleVisitor);
            return a;
        }
    }

    private static class GeneralizationVisitor extends UMLBaseVisitor<Generalization> {

        @Override
        public Generalization visitGeneralization(UMLParser.GeneralizationContext ctx) {
            Generalization g = new Generalization();
            g.name = ctx.ID().getText();
            g.subclasses = ctx.subclassNames().ID().stream().map(s -> s.getText()).collect(toList());
            return g;
        }
    }

    private static class AggregationVisitor extends UMLBaseVisitor<Aggregation> {

        @Override
        public Aggregation visitAggregation(UMLParser.AggregationContext ctx) {
            RoleVisitor roleVisitor = new RoleVisitor();

            Aggregation a = new Aggregation();
            a.single = ctx.role().accept(roleVisitor);
            a.roles = ctx.roles().role().stream().map(r -> r.accept(roleVisitor)).collect(toList());
            return a;
        }
    }

    private static class DataItemVisitor extends UMLBaseVisitor<DataItem> {

        @Override
        public DataItem visitDataItem(UMLParser.DataItemContext ctx) {
            DataItem item = new DataItem();
            item.ident = ctx.ID().getText();
            item.type = ctx.type().ID().getText();
            return item;
        }
    }

    private static class OperationVisitor extends UMLBaseVisitor<Operation> {

        @Override
        public Operation visitOperation(UMLParser.OperationContext ctx) {
            Operation op = new Operation();
            op.name = ctx.ID().getText();
            op.type = ctx.type().ID().getText();
            op.args = collectDataItems(ctx.dataItem());
            return op;
        }
    }

    private static class RoleVisitor extends UMLBaseVisitor<Role> {

        @Override
        public Role visitRole(UMLParser.RoleContext ctx) {
            Role r = new Role();
            r.name = ctx.ID().getText();
            r.multiplicity = ctx.multiplicity().accept(new MultiplicityVisitor());
            return r;
        }
    }

    private static class MultiplicityVisitor extends UMLBaseVisitor<Multiplicity> {

        @Override
        public Multiplicity visitMultiplicity(UMLParser.MultiplicityContext ctx) {
            switch (ctx.getText()) {
                case "ONE":
                    return Multiplicity.ONE;
                case "MANY":
                    return Multiplicity.MANY;
                case "ONE_OR_MANY":
                    return Multiplicity.ONE_OR_MANY;
                case "OPTIONALLY_ONE":
                    return Multiplicity.OPTIONALLY_ONE;
                case "UNDEFINED":
                    return Multiplicity.UNDEFINED;
                default:
                    throw new RuntimeException("this should be unreachable");
            }
        }
    }
}
