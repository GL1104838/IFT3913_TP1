// Generated from ift3913\tp1\parser\UML.g4 by ANTLR 4.7
package ift3913.tp1.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, WS=22, ID=23;
	public static final int
		RULE_model = 0, RULE_declaration = 1, RULE_klass = 2, RULE_attributeList = 3, 
		RULE_dataItem = 4, RULE_operationList = 5, RULE_operation = 6, RULE_type = 7, 
		RULE_association = 8, RULE_twoRoles = 9, RULE_role = 10, RULE_multiplicity = 11, 
		RULE_aggregation = 12, RULE_roles = 13, RULE_generalization = 14, RULE_subclassNames = 15;
	public static final String[] ruleNames = {
		"model", "declaration", "klass", "attributeList", "dataItem", "operationList", 
		"operation", "type", "association", "twoRoles", "role", "multiplicity", 
		"aggregation", "roles", "generalization", "subclassNames"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'MODEL'", "';'", "'CLASS'", "'ATTRIBUTES'", "'OPERATIONS'", "','", 
		"':'", "'('", "')'", "'RELATION'", "'ROLES'", "'ONE'", "'MANY'", "'ONE_OR_MANY'", 
		"'OPTIONALLY_ONE'", "'UNDEFINED'", "'AGGREGATION'", "'CONTAINER'", "'PARTS'", 
		"'GENERALIZATION'", "'SUBCLASSES'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "WS", "ID"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "UML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModelContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			match(ID);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__9) | (1L << T__16) | (1L << T__19))) != 0)) {
				{
				{
				setState(34);
				declaration();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public KlassContext klass() {
			return getRuleContext(KlassContext.class,0);
		}
		public AssociationContext association() {
			return getRuleContext(AssociationContext.class,0);
		}
		public GeneralizationContext generalization() {
			return getRuleContext(GeneralizationContext.class,0);
		}
		public AggregationContext aggregation() {
			return getRuleContext(AggregationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(40);
				klass();
				}
				break;
			case T__9:
				{
				setState(41);
				association();
				}
				break;
			case T__19:
				{
				setState(42);
				generalization();
				}
				break;
			case T__16:
				{
				setState(43);
				aggregation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(46);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KlassContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public OperationListContext operationList() {
			return getRuleContext(OperationListContext.class,0);
		}
		public KlassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_klass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitKlass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KlassContext klass() throws RecognitionException {
		KlassContext _localctx = new KlassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_klass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__2);
			setState(49);
			match(ID);
			setState(50);
			match(T__3);
			setState(51);
			attributeList();
			setState(52);
			match(T__4);
			setState(53);
			operationList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeListContext extends ParserRuleContext {
		public List<DataItemContext> dataItem() {
			return getRuleContexts(DataItemContext.class);
		}
		public DataItemContext dataItem(int i) {
			return getRuleContext(DataItemContext.class,i);
		}
		public AttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(55);
				dataItem();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(56);
					match(T__5);
					setState(57);
					dataItem();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataItemContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DataItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitDataItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataItemContext dataItem() throws RecognitionException {
		DataItemContext _localctx = new DataItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dataItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(ID);
			setState(66);
			match(T__6);
			setState(67);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationListContext extends ParserRuleContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public OperationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operationList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitOperationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationListContext operationList() throws RecognitionException {
		OperationListContext _localctx = new OperationListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(69);
				operation();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(70);
					match(T__5);
					setState(71);
					operation();
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<DataItemContext> dataItem() {
			return getRuleContexts(DataItemContext.class);
		}
		public DataItemContext dataItem(int i) {
			return getRuleContext(DataItemContext.class,i);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(79);
			match(ID);
			setState(80);
			match(T__7);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(81);
				dataItem();
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(82);
					match(T__5);
					setState(83);
					dataItem();
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(91);
			match(T__8);
			setState(92);
			match(T__6);
			setState(93);
			type();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssociationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public TwoRolesContext twoRoles() {
			return getRuleContext(TwoRolesContext.class,0);
		}
		public AssociationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_association; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitAssociation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociationContext association() throws RecognitionException {
		AssociationContext _localctx = new AssociationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_association);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__9);
			setState(98);
			match(ID);
			setState(99);
			match(T__10);
			setState(100);
			twoRoles();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TwoRolesContext extends ParserRuleContext {
		public List<RoleContext> role() {
			return getRuleContexts(RoleContext.class);
		}
		public RoleContext role(int i) {
			return getRuleContext(RoleContext.class,i);
		}
		public TwoRolesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_twoRoles; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitTwoRoles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TwoRolesContext twoRoles() throws RecognitionException {
		TwoRolesContext _localctx = new TwoRolesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_twoRoles);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			role();
			setState(103);
			match(T__5);
			setState(104);
			role();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public MultiplicityContext multiplicity() {
			return getRuleContext(MultiplicityContext.class,0);
		}
		public RoleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitRole(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoleContext role() throws RecognitionException {
		RoleContext _localctx = new RoleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_role);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__2);
			setState(107);
			match(ID);
			setState(108);
			multiplicity();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicityContext extends ParserRuleContext {
		public MultiplicityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicity; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitMultiplicity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicityContext multiplicity() throws RecognitionException {
		MultiplicityContext _localctx = new MultiplicityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multiplicity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregationContext extends ParserRuleContext {
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
		}
		public AggregationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitAggregation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregationContext aggregation() throws RecognitionException {
		AggregationContext _localctx = new AggregationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_aggregation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__16);
			setState(113);
			match(T__17);
			setState(114);
			role();
			setState(115);
			match(T__18);
			setState(116);
			roles();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RolesContext extends ParserRuleContext {
		public List<RoleContext> role() {
			return getRuleContexts(RoleContext.class);
		}
		public RoleContext role(int i) {
			return getRuleContext(RoleContext.class,i);
		}
		public RolesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roles; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitRoles(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RolesContext roles() throws RecognitionException {
		RolesContext _localctx = new RolesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_roles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			role();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(119);
				match(T__5);
				setState(120);
				role();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralizationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UMLParser.ID, 0); }
		public SubclassNamesContext subclassNames() {
			return getRuleContext(SubclassNamesContext.class,0);
		}
		public GeneralizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalization; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitGeneralization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralizationContext generalization() throws RecognitionException {
		GeneralizationContext _localctx = new GeneralizationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_generalization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__19);
			setState(127);
			match(ID);
			setState(128);
			match(T__20);
			setState(129);
			subclassNames();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubclassNamesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(UMLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UMLParser.ID, i);
		}
		public SubclassNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subclassNames; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UMLVisitor ) return ((UMLVisitor<? extends T>)visitor).visitSubclassNames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubclassNamesContext subclassNames() throws RecognitionException {
		SubclassNamesContext _localctx = new SubclassNamesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_subclassNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(ID);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(132);
				match(T__5);
				setState(133);
				match(ID);
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u008e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\3\5\3/\n\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\5\5B\n\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\7\7K\n\7\f\7\16\7N\13\7\5\7P\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\7\bW\n\b\f\b\16\bZ\13\b\5\b\\\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17|\n\17\f\17\16\17\177\13\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u0089\n\21\f\21\16\21\u008c"+
		"\13\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\16"+
		"\22\2\u0089\2\"\3\2\2\2\4.\3\2\2\2\6\62\3\2\2\2\bA\3\2\2\2\nC\3\2\2\2"+
		"\fO\3\2\2\2\16Q\3\2\2\2\20a\3\2\2\2\22c\3\2\2\2\24h\3\2\2\2\26l\3\2\2"+
		"\2\30p\3\2\2\2\32r\3\2\2\2\34x\3\2\2\2\36\u0080\3\2\2\2 \u0085\3\2\2\2"+
		"\"#\7\3\2\2#\'\7\31\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(\3\3\2\2\2)\'\3\2\2\2*/\5\6\4\2+/\5\22\n\2,/\5\36\20\2-/\5\32\16"+
		"\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\60\3\2\2\2\60\61\7\4\2\2\61"+
		"\5\3\2\2\2\62\63\7\5\2\2\63\64\7\31\2\2\64\65\7\6\2\2\65\66\5\b\5\2\66"+
		"\67\7\7\2\2\678\5\f\7\28\7\3\2\2\29>\5\n\6\2:;\7\b\2\2;=\5\n\6\2<:\3\2"+
		"\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2A9\3\2\2\2AB\3\2"+
		"\2\2B\t\3\2\2\2CD\7\31\2\2DE\7\t\2\2EF\5\20\t\2F\13\3\2\2\2GL\5\16\b\2"+
		"HI\7\b\2\2IK\5\16\b\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2"+
		"\2NL\3\2\2\2OG\3\2\2\2OP\3\2\2\2P\r\3\2\2\2QR\7\31\2\2R[\7\n\2\2SX\5\n"+
		"\6\2TU\7\b\2\2UW\5\n\6\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\\\3"+
		"\2\2\2ZX\3\2\2\2[S\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\13\2\2^_\7\t\2\2"+
		"_`\5\20\t\2`\17\3\2\2\2ab\7\31\2\2b\21\3\2\2\2cd\7\f\2\2de\7\31\2\2ef"+
		"\7\r\2\2fg\5\24\13\2g\23\3\2\2\2hi\5\26\f\2ij\7\b\2\2jk\5\26\f\2k\25\3"+
		"\2\2\2lm\7\5\2\2mn\7\31\2\2no\5\30\r\2o\27\3\2\2\2pq\t\2\2\2q\31\3\2\2"+
		"\2rs\7\23\2\2st\7\24\2\2tu\5\26\f\2uv\7\25\2\2vw\5\34\17\2w\33\3\2\2\2"+
		"x}\5\26\f\2yz\7\b\2\2z|\5\26\f\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3"+
		"\2\2\2~\35\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\26\2\2\u0081\u0082\7\31"+
		"\2\2\u0082\u0083\7\27\2\2\u0083\u0084\5 \21\2\u0084\37\3\2\2\2\u0085\u008a"+
		"\7\31\2\2\u0086\u0087\7\b\2\2\u0087\u0089\7\31\2\2\u0088\u0086\3\2\2\2"+
		"\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b!\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\f\'.>ALOX[}\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}