// Generated from ift3913\tp1\parser\UML.g4 by ANTLR 4.7
package ift3913.tp1.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, WS=22, ID=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "WS", "ID"
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


	public UMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00de\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\6\27\u00d2\n\27\r\27\16\27"+
		"\u00d3\3\27\3\27\3\30\3\30\7\30\u00da\n\30\f\30\16\30\u00dd\13\30\2\2"+
		"\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\5\5\2\13\f\17\17\"\"\5"+
		"\2\62;C\\c|\6\2\62;C\\aac|\2\u00df\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\67\3\2\2\2\79\3\2\2"+
		"\2\t?\3\2\2\2\13J\3\2\2\2\rU\3\2\2\2\17W\3\2\2\2\21Y\3\2\2\2\23[\3\2\2"+
		"\2\25]\3\2\2\2\27f\3\2\2\2\31l\3\2\2\2\33p\3\2\2\2\35u\3\2\2\2\37\u0081"+
		"\3\2\2\2!\u0090\3\2\2\2#\u009a\3\2\2\2%\u00a6\3\2\2\2\'\u00b0\3\2\2\2"+
		")\u00b6\3\2\2\2+\u00c5\3\2\2\2-\u00d1\3\2\2\2/\u00d7\3\2\2\2\61\62\7O"+
		"\2\2\62\63\7Q\2\2\63\64\7F\2\2\64\65\7G\2\2\65\66\7N\2\2\66\4\3\2\2\2"+
		"\678\7=\2\28\6\3\2\2\29:\7E\2\2:;\7N\2\2;<\7C\2\2<=\7U\2\2=>\7U\2\2>\b"+
		"\3\2\2\2?@\7C\2\2@A\7V\2\2AB\7V\2\2BC\7T\2\2CD\7K\2\2DE\7D\2\2EF\7W\2"+
		"\2FG\7V\2\2GH\7G\2\2HI\7U\2\2I\n\3\2\2\2JK\7Q\2\2KL\7R\2\2LM\7G\2\2MN"+
		"\7T\2\2NO\7C\2\2OP\7V\2\2PQ\7K\2\2QR\7Q\2\2RS\7P\2\2ST\7U\2\2T\f\3\2\2"+
		"\2UV\7.\2\2V\16\3\2\2\2WX\7<\2\2X\20\3\2\2\2YZ\7*\2\2Z\22\3\2\2\2[\\\7"+
		"+\2\2\\\24\3\2\2\2]^\7T\2\2^_\7G\2\2_`\7N\2\2`a\7C\2\2ab\7V\2\2bc\7K\2"+
		"\2cd\7Q\2\2de\7P\2\2e\26\3\2\2\2fg\7T\2\2gh\7Q\2\2hi\7N\2\2ij\7G\2\2j"+
		"k\7U\2\2k\30\3\2\2\2lm\7Q\2\2mn\7P\2\2no\7G\2\2o\32\3\2\2\2pq\7O\2\2q"+
		"r\7C\2\2rs\7P\2\2st\7[\2\2t\34\3\2\2\2uv\7Q\2\2vw\7P\2\2wx\7G\2\2xy\7"+
		"a\2\2yz\7Q\2\2z{\7T\2\2{|\7a\2\2|}\7O\2\2}~\7C\2\2~\177\7P\2\2\177\u0080"+
		"\7[\2\2\u0080\36\3\2\2\2\u0081\u0082\7Q\2\2\u0082\u0083\7R\2\2\u0083\u0084"+
		"\7V\2\2\u0084\u0085\7K\2\2\u0085\u0086\7Q\2\2\u0086\u0087\7P\2\2\u0087"+
		"\u0088\7C\2\2\u0088\u0089\7N\2\2\u0089\u008a\7N\2\2\u008a\u008b\7[\2\2"+
		"\u008b\u008c\7a\2\2\u008c\u008d\7Q\2\2\u008d\u008e\7P\2\2\u008e\u008f"+
		"\7G\2\2\u008f \3\2\2\2\u0090\u0091\7W\2\2\u0091\u0092\7P\2\2\u0092\u0093"+
		"\7F\2\2\u0093\u0094\7G\2\2\u0094\u0095\7H\2\2\u0095\u0096\7K\2\2\u0096"+
		"\u0097\7P\2\2\u0097\u0098\7G\2\2\u0098\u0099\7F\2\2\u0099\"\3\2\2\2\u009a"+
		"\u009b\7C\2\2\u009b\u009c\7I\2\2\u009c\u009d\7I\2\2\u009d\u009e\7T\2\2"+
		"\u009e\u009f\7G\2\2\u009f\u00a0\7I\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2"+
		"\7V\2\2\u00a2\u00a3\7K\2\2\u00a3\u00a4\7Q\2\2\u00a4\u00a5\7P\2\2\u00a5"+
		"$\3\2\2\2\u00a6\u00a7\7E\2\2\u00a7\u00a8\7Q\2\2\u00a8\u00a9\7P\2\2\u00a9"+
		"\u00aa\7V\2\2\u00aa\u00ab\7C\2\2\u00ab\u00ac\7K\2\2\u00ac\u00ad\7P\2\2"+
		"\u00ad\u00ae\7G\2\2\u00ae\u00af\7T\2\2\u00af&\3\2\2\2\u00b0\u00b1\7R\2"+
		"\2\u00b1\u00b2\7C\2\2\u00b2\u00b3\7T\2\2\u00b3\u00b4\7V\2\2\u00b4\u00b5"+
		"\7U\2\2\u00b5(\3\2\2\2\u00b6\u00b7\7I\2\2\u00b7\u00b8\7G\2\2\u00b8\u00b9"+
		"\7P\2\2\u00b9\u00ba\7G\2\2\u00ba\u00bb\7T\2\2\u00bb\u00bc\7C\2\2\u00bc"+
		"\u00bd\7N\2\2\u00bd\u00be\7K\2\2\u00be\u00bf\7\\\2\2\u00bf\u00c0\7C\2"+
		"\2\u00c0\u00c1\7V\2\2\u00c1\u00c2\7K\2\2\u00c2\u00c3\7Q\2\2\u00c3\u00c4"+
		"\7P\2\2\u00c4*\3\2\2\2\u00c5\u00c6\7U\2\2\u00c6\u00c7\7W\2\2\u00c7\u00c8"+
		"\7D\2\2\u00c8\u00c9\7E\2\2\u00c9\u00ca\7N\2\2\u00ca\u00cb\7C\2\2\u00cb"+
		"\u00cc\7U\2\2\u00cc\u00cd\7U\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7U\2\2"+
		"\u00cf,\3\2\2\2\u00d0\u00d2\t\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3"+
		"\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d6\b\27\2\2\u00d6.\3\2\2\2\u00d7\u00db\t\3\2\2\u00d8\u00da\t\4\2\2"+
		"\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\60\3\2\2\2\u00dd\u00db\3\2\2\2\5\2\u00d3\u00db\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}