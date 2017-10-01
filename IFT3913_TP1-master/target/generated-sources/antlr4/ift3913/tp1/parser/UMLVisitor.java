// Generated from ift3913\tp1\parser\UML.g4 by ANTLR 4.7
package ift3913.tp1.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UMLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UMLParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(UMLParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(UMLParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#klass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKlass(UMLParser.KlassContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#attributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(UMLParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#dataItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataItem(UMLParser.DataItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#operationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationList(UMLParser.OperationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(UMLParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(UMLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#association}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociation(UMLParser.AssociationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#twoRoles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoRoles(UMLParser.TwoRolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRole(UMLParser.RoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#multiplicity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicity(UMLParser.MultiplicityContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#aggregation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregation(UMLParser.AggregationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#roles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoles(UMLParser.RolesContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#generalization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralization(UMLParser.GeneralizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link UMLParser#subclassNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubclassNames(UMLParser.SubclassNamesContext ctx);
}