// Generated from TIP.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TIPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, MUL=15, DIV=16, ADD=17, 
		SUB=18, GT=19, GTE=20, LT=21, LTE=22, EQ=23, NE=24, NOT=25, MOD=26, AND=27, 
		OR=28, NUMBER=29, BOOLEAN=30, KALLOC=31, KINPUT=32, KWHILE=33, KIF=34, 
		KELSE=35, KVAR=36, KRETURN=37, KFOR=38, KBY=39, KNULL=40, KOUTPUT=41, 
		KERROR=42, KPOLY=43, IDENTIFIER=44, WS=45, BLOCKCOMMENT=46, COMMENT=47;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_declaration = 2, RULE_nameDeclaration = 3, 
		RULE_expr = 4, RULE_recordExpr = 5, RULE_fieldExpr = 6, RULE_statement = 7, 
		RULE_assignStmt = 8, RULE_blockStmt = 9, RULE_whileStmt = 10, RULE_ifStmt = 11, 
		RULE_ternaryIfStmt = 12, RULE_outputStmt = 13, RULE_incrStmt = 14, RULE_decrStmt = 15, 
		RULE_errorStmt = 16, RULE_forItrStmt = 17, RULE_forRngStmt = 18, RULE_returnStmt = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "function", "declaration", "nameDeclaration", "expr", "recordExpr", 
			"fieldExpr", "statement", "assignStmt", "blockStmt", "whileStmt", "ifStmt", 
			"ternaryIfStmt", "outputStmt", "incrStmt", "decrStmt", "errorStmt", "forItrStmt", 
			"forRngStmt", "returnStmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'{'", "'}'", "';'", "'.'", "'&'", "':'", 
			"'='", "'?'", "'++'", "'--'", "'..'", "'*'", "'/'", "'+'", "'-'", "'>'", 
			"'>='", "'<'", "'<='", "'=='", "'!='", "'not'", "'%'", "'and'", "'or'", 
			null, null, "'alloc'", "'input'", "'while'", "'if'", "'else'", "'var'", 
			"'return'", "'for'", "'by'", "'null'", "'output'", "'error'", "'poly'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "MUL", "DIV", "ADD", "SUB", "GT", "GTE", "LT", "LTE", 
			"EQ", "NE", "NOT", "MOD", "AND", "OR", "NUMBER", "BOOLEAN", "KALLOC", 
			"KINPUT", "KWHILE", "KIF", "KELSE", "KVAR", "KRETURN", "KFOR", "KBY", 
			"KNULL", "KOUTPUT", "KERROR", "KPOLY", "IDENTIFIER", "WS", "BLOCKCOMMENT", 
			"COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "TIP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TIPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				function();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public List<NameDeclarationContext> nameDeclaration() {
			return getRuleContexts(NameDeclarationContext.class);
		}
		public NameDeclarationContext nameDeclaration(int i) {
			return getRuleContext(NameDeclarationContext.class,i);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public TerminalNode KPOLY() { return getToken(TIPParser.KPOLY, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			nameDeclaration();
			setState(46);
			match(T__0);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(47);
				nameDeclaration();
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(48);
					match(T__1);
					setState(49);
					nameDeclaration();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(57);
			match(T__2);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KPOLY) {
				{
				setState(58);
				match(KPOLY);
				}
			}

			setState(61);
			match(T__3);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KVAR) {
				{
				{
				setState(62);
				declaration();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25597502062866L) != 0)) {
				{
				{
				setState(68);
				statement();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(74);
			returnStmt();
			setState(75);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode KVAR() { return getToken(TIPParser.KVAR, 0); }
		public List<NameDeclarationContext> nameDeclaration() {
			return getRuleContexts(NameDeclarationContext.class);
		}
		public NameDeclarationContext nameDeclaration(int i) {
			return getRuleContext(NameDeclarationContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(KVAR);
			setState(78);
			nameDeclaration();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(79);
				match(T__1);
				setState(80);
				nameDeclaration();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NameDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TIPParser.IDENTIFIER, 0); }
		public NameDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterNameDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitNameDeclaration(this);
		}
	}

	public final NameDeclarationContext nameDeclaration() throws RecognitionException {
		NameDeclarationContext _localctx = new NameDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nameDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecordRuleContext extends ExprContext {
		public RecordExprContext recordExpr() {
			return getRuleContext(RecordExprContext.class,0);
		}
		public RecordRuleContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterRecordRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitRecordRule(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(TIPParser.SUB, 0); }
		public NegationExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterNegationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitNegationExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullExprContext extends ExprContext {
		public TerminalNode KNULL() { return getToken(TIPParser.KNULL, 0); }
		public NullExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterNullExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitNullExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AllocExprContext extends ExprContext {
		public TerminalNode KALLOC() { return getToken(TIPParser.KALLOC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AllocExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterAllocExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitAllocExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegNumberContext extends ExprContext {
		public TerminalNode SUB() { return getToken(TIPParser.SUB, 0); }
		public TerminalNode NUMBER() { return getToken(TIPParser.NUMBER, 0); }
		public NegNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterNegNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitNegNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InputExprContext extends ExprContext {
		public TerminalNode KINPUT() { return getToken(TIPParser.KINPUT, 0); }
		public InputExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterInputExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitInputExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(TIPParser.AND, 0); }
		public TerminalNode OR() { return getToken(TIPParser.OR, 0); }
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitBinaryExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(TIPParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(TIPParser.SUB, 0); }
		public AdditiveExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitAdditiveExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(TIPParser.GT, 0); }
		public TerminalNode LT() { return getToken(TIPParser.LT, 0); }
		public TerminalNode GTE() { return getToken(TIPParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(TIPParser.LTE, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitRelationalExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeRefExprContext extends ExprContext {
		public TerminalNode MUL() { return getToken(TIPParser.MUL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeRefExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterDeRefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitDeRefExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumExprContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(TIPParser.NUMBER, 0); }
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitNumExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitParenExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarExprContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(TIPParser.IDENTIFIER, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitVarExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(TIPParser.NOT, 0); }
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitNotExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RefExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RefExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterRefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitRefExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ExprContext {
		public TerminalNode BOOLEAN() { return getToken(TIPParser.BOOLEAN, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitBoolExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RemainderExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOD() { return getToken(TIPParser.MOD, 0); }
		public RemainderExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterRemainderExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitRemainderExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(TIPParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(TIPParser.DIV, 0); }
		public MultiplicativeExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitMultiplicativeExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunAppExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunAppExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterFunAppExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitFunAppExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(TIPParser.EQ, 0); }
		public TerminalNode NE() { return getToken(TIPParser.NE, 0); }
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitEqualityExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccessExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(TIPParser.IDENTIFIER, 0); }
		public AccessExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitAccessExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new DeRefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(91);
				match(MUL);
				setState(92);
				expr(19);
				}
				break;
			case 2:
				{
				_localctx = new NegNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(SUB);
				setState(94);
				match(NUMBER);
				}
				break;
			case 3:
				{
				_localctx = new RefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(T__7);
				setState(96);
				expr(17);
				}
				break;
			case 4:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				((NotExprContext)_localctx).op = match(NOT);
				setState(98);
				expr(10);
				}
				break;
			case 5:
				{
				_localctx = new NegationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				((NegationExprContext)_localctx).op = match(SUB);
				setState(100);
				expr(9);
				}
				break;
			case 6:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(IDENTIFIER);
				}
				break;
			case 7:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(NUMBER);
				}
				break;
			case 8:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(BOOLEAN);
				}
				break;
			case 9:
				{
				_localctx = new InputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				match(KINPUT);
				}
				break;
			case 10:
				{
				_localctx = new AllocExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(KALLOC);
				setState(106);
				expr(4);
				}
				break;
			case 11:
				{
				_localctx = new NullExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(KNULL);
				}
				break;
			case 12:
				{
				_localctx = new RecordRuleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				recordExpr();
				}
				break;
			case 13:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				match(T__0);
				setState(110);
				expr(0);
				setState(111);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(116);
						((MultiplicativeExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MultiplicativeExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(117);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(119);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(120);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new RemainderExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(122);
						((RemainderExprContext)_localctx).op = match(MOD);
						setState(123);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(125);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(126);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(128);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(131);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new FunAppExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(134);
						match(T__0);
						setState(143);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18699784585490L) != 0)) {
							{
							setState(135);
							expr(0);
							setState(140);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__1) {
								{
								{
								setState(136);
								match(T__1);
								setState(137);
								expr(0);
								}
								}
								setState(142);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(145);
						match(T__2);
						}
						break;
					case 8:
						{
						_localctx = new AccessExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(147);
						match(T__6);
						setState(148);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecordExprContext extends ParserRuleContext {
		public List<FieldExprContext> fieldExpr() {
			return getRuleContexts(FieldExprContext.class);
		}
		public FieldExprContext fieldExpr(int i) {
			return getRuleContext(FieldExprContext.class,i);
		}
		public RecordExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterRecordExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitRecordExpr(this);
		}
	}

	public final RecordExprContext recordExpr() throws RecognitionException {
		RecordExprContext _localctx = new RecordExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_recordExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__3);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(155);
				fieldExpr();
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(156);
					match(T__1);
					setState(157);
					fieldExpr();
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(165);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldExprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TIPParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterFieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitFieldExpr(this);
		}
	}

	public final FieldExprContext fieldExpr() throws RecognitionException {
		FieldExprContext _localctx = new FieldExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(IDENTIFIER);
			setState(168);
			match(T__8);
			setState(169);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public OutputStmtContext outputStmt() {
			return getRuleContext(OutputStmtContext.class,0);
		}
		public ErrorStmtContext errorStmt() {
			return getRuleContext(ErrorStmtContext.class,0);
		}
		public ForItrStmtContext forItrStmt() {
			return getRuleContext(ForItrStmtContext.class,0);
		}
		public ForRngStmtContext forRngStmt() {
			return getRuleContext(ForRngStmtContext.class,0);
		}
		public IncrStmtContext incrStmt() {
			return getRuleContext(IncrStmtContext.class,0);
		}
		public DecrStmtContext decrStmt() {
			return getRuleContext(DecrStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				outputStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				errorStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				forItrStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(178);
				forRngStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(179);
				incrStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(180);
				decrStmt();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitAssignStmt(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			expr(0);
			setState(184);
			match(T__9);
			setState(185);
			expr(0);
			setState(186);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitBlockStmt(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__3);
			{
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25597502062866L) != 0)) {
				{
				{
				setState(189);
				statement();
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(195);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode KWHILE() { return getToken(TIPParser.KWHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(KWHILE);
			setState(198);
			match(T__0);
			setState(199);
			expr(0);
			setState(200);
			match(T__2);
			setState(201);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode KIF() { return getToken(TIPParser.KIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode KELSE() { return getToken(TIPParser.KELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(KIF);
			setState(204);
			match(T__0);
			setState(205);
			expr(0);
			setState(206);
			match(T__2);
			setState(207);
			statement();
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(208);
				match(KELSE);
				setState(209);
				statement();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class TernaryIfStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TernaryIfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryIfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterTernaryIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitTernaryIfStmt(this);
		}
	}

	public final TernaryIfStmtContext ternaryIfStmt() throws RecognitionException {
		TernaryIfStmtContext _localctx = new TernaryIfStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ternaryIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			expr(0);
			setState(213);
			match(T__10);
			setState(214);
			expr(0);
			setState(215);
			match(T__8);
			setState(216);
			expr(0);
			setState(217);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OutputStmtContext extends ParserRuleContext {
		public TerminalNode KOUTPUT() { return getToken(TIPParser.KOUTPUT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OutputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterOutputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitOutputStmt(this);
		}
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_outputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(KOUTPUT);
			setState(220);
			expr(0);
			setState(221);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IncrStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IncrStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterIncrStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitIncrStmt(this);
		}
	}

	public final IncrStmtContext incrStmt() throws RecognitionException {
		IncrStmtContext _localctx = new IncrStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_incrStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			expr(0);
			setState(224);
			match(T__11);
			setState(225);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DecrStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DecrStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decrStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterDecrStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitDecrStmt(this);
		}
	}

	public final DecrStmtContext decrStmt() throws RecognitionException {
		DecrStmtContext _localctx = new DecrStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_decrStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			expr(0);
			setState(228);
			match(T__12);
			setState(229);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ErrorStmtContext extends ParserRuleContext {
		public TerminalNode KERROR() { return getToken(TIPParser.KERROR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ErrorStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterErrorStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitErrorStmt(this);
		}
	}

	public final ErrorStmtContext errorStmt() throws RecognitionException {
		ErrorStmtContext _localctx = new ErrorStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_errorStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(KERROR);
			setState(232);
			expr(0);
			setState(233);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForItrStmtContext extends ParserRuleContext {
		public TerminalNode KFOR() { return getToken(TIPParser.KFOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForItrStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forItrStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterForItrStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitForItrStmt(this);
		}
	}

	public final ForItrStmtContext forItrStmt() throws RecognitionException {
		ForItrStmtContext _localctx = new ForItrStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forItrStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(KFOR);
			setState(236);
			match(T__0);
			setState(237);
			expr(0);
			setState(238);
			match(T__8);
			setState(239);
			expr(0);
			setState(240);
			match(T__2);
			setState(241);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForRngStmtContext extends ParserRuleContext {
		public TerminalNode KFOR() { return getToken(TIPParser.KFOR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode KBY() { return getToken(TIPParser.KBY, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForRngStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forRngStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterForRngStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitForRngStmt(this);
		}
	}

	public final ForRngStmtContext forRngStmt() throws RecognitionException {
		ForRngStmtContext _localctx = new ForRngStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forRngStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(KFOR);
			setState(244);
			match(T__0);
			setState(245);
			expr(0);
			setState(246);
			match(T__8);
			setState(247);
			expr(0);
			setState(248);
			match(T__13);
			setState(249);
			expr(0);
			setState(250);
			match(KBY);
			setState(251);
			expr(0);
			setState(252);
			match(T__2);
			setState(253);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode KRETURN() { return getToken(TIPParser.KRETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIPListener ) ((TIPListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(KRETURN);
			setState(256);
			expr(0);
			setState(257);
			match(T__5);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 21);
		case 7:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0104\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0004\u0000*\b\u0000\u000b\u0000"+
		"\f\u0000+\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0003\u00018\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001<\b\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001@\b\u0001\n\u0001\f\u0001C\t\u0001\u0001\u0001\u0005\u0001F\b\u0001"+
		"\n\u0001\f\u0001I\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002R\b\u0002\n\u0002\f\u0002"+
		"U\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004r\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u008b\b\u0004\n\u0004\f\u0004\u008e\t\u0004\u0003\u0004\u0090\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0096\b\u0004"+
		"\n\u0004\f\u0004\u0099\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u009f\b\u0005\n\u0005\f\u0005\u00a2\t\u0005\u0003\u0005"+
		"\u00a4\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00b6\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0005\t\u00bf\b\t\n\t\f\t\u00c2\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d3\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0000\u0001\b\u0014\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0005\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0012\u0001\u0000\u0013"+
		"\u0016\u0001\u0000\u0017\u0018\u0001\u0000\u001b\u001c\u0119\u0000)\u0001"+
		"\u0000\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u0004M\u0001\u0000\u0000"+
		"\u0000\u0006X\u0001\u0000\u0000\u0000\bq\u0001\u0000\u0000\u0000\n\u009a"+
		"\u0001\u0000\u0000\u0000\f\u00a7\u0001\u0000\u0000\u0000\u000e\u00b5\u0001"+
		"\u0000\u0000\u0000\u0010\u00b7\u0001\u0000\u0000\u0000\u0012\u00bc\u0001"+
		"\u0000\u0000\u0000\u0014\u00c5\u0001\u0000\u0000\u0000\u0016\u00cb\u0001"+
		"\u0000\u0000\u0000\u0018\u00d4\u0001\u0000\u0000\u0000\u001a\u00db\u0001"+
		"\u0000\u0000\u0000\u001c\u00df\u0001\u0000\u0000\u0000\u001e\u00e3\u0001"+
		"\u0000\u0000\u0000 \u00e7\u0001\u0000\u0000\u0000\"\u00eb\u0001\u0000"+
		"\u0000\u0000$\u00f3\u0001\u0000\u0000\u0000&\u00ff\u0001\u0000\u0000\u0000"+
		"(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,\u0001\u0001"+
		"\u0000\u0000\u0000-.\u0003\u0006\u0003\u0000.7\u0005\u0001\u0000\u0000"+
		"/4\u0003\u0006\u0003\u000001\u0005\u0002\u0000\u000013\u0003\u0006\u0003"+
		"\u000020\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u00007/\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009;\u0005\u0003\u0000\u0000:<\u0005+\u0000\u0000"+
		";:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000"+
		"\u0000=A\u0005\u0004\u0000\u0000>@\u0003\u0004\u0002\u0000?>\u0001\u0000"+
		"\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000BG\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"DF\u0003\u000e\u0007\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0003&\u0013\u0000KL\u0005\u0005"+
		"\u0000\u0000L\u0003\u0001\u0000\u0000\u0000MN\u0005$\u0000\u0000NS\u0003"+
		"\u0006\u0003\u0000OP\u0005\u0002\u0000\u0000PR\u0003\u0006\u0003\u0000"+
		"QO\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000VW\u0005\u0006\u0000\u0000W\u0005\u0001\u0000\u0000\u0000"+
		"XY\u0005,\u0000\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0006\u0004\uffff"+
		"\uffff\u0000[\\\u0005\u000f\u0000\u0000\\r\u0003\b\u0004\u0013]^\u0005"+
		"\u0012\u0000\u0000^r\u0005\u001d\u0000\u0000_`\u0005\b\u0000\u0000`r\u0003"+
		"\b\u0004\u0011ab\u0005\u0019\u0000\u0000br\u0003\b\u0004\ncd\u0005\u0012"+
		"\u0000\u0000dr\u0003\b\u0004\ter\u0005,\u0000\u0000fr\u0005\u001d\u0000"+
		"\u0000gr\u0005\u001e\u0000\u0000hr\u0005 \u0000\u0000ij\u0005\u001f\u0000"+
		"\u0000jr\u0003\b\u0004\u0004kr\u0005(\u0000\u0000lr\u0003\n\u0005\u0000"+
		"mn\u0005\u0001\u0000\u0000no\u0003\b\u0004\u0000op\u0005\u0003\u0000\u0000"+
		"pr\u0001\u0000\u0000\u0000qZ\u0001\u0000\u0000\u0000q]\u0001\u0000\u0000"+
		"\u0000q_\u0001\u0000\u0000\u0000qa\u0001\u0000\u0000\u0000qc\u0001\u0000"+
		"\u0000\u0000qe\u0001\u0000\u0000\u0000qf\u0001\u0000\u0000\u0000qg\u0001"+
		"\u0000\u0000\u0000qh\u0001\u0000\u0000\u0000qi\u0001\u0000\u0000\u0000"+
		"qk\u0001\u0000\u0000\u0000ql\u0001\u0000\u0000\u0000qm\u0001\u0000\u0000"+
		"\u0000r\u0097\u0001\u0000\u0000\u0000st\n\u0010\u0000\u0000tu\u0007\u0000"+
		"\u0000\u0000u\u0096\u0003\b\u0004\u0011vw\n\u000f\u0000\u0000wx\u0007"+
		"\u0001\u0000\u0000x\u0096\u0003\b\u0004\u0010yz\n\u000e\u0000\u0000z{"+
		"\u0005\u001a\u0000\u0000{\u0096\u0003\b\u0004\u000f|}\n\r\u0000\u0000"+
		"}~\u0007\u0002\u0000\u0000~\u0096\u0003\b\u0004\u000e\u007f\u0080\n\f"+
		"\u0000\u0000\u0080\u0081\u0007\u0003\u0000\u0000\u0081\u0096\u0003\b\u0004"+
		"\r\u0082\u0083\n\u000b\u0000\u0000\u0083\u0084\u0007\u0004\u0000\u0000"+
		"\u0084\u0096\u0003\b\u0004\f\u0085\u0086\n\u0015\u0000\u0000\u0086\u008f"+
		"\u0005\u0001\u0000\u0000\u0087\u008c\u0003\b\u0004\u0000\u0088\u0089\u0005"+
		"\u0002\u0000\u0000\u0089\u008b\u0003\b\u0004\u0000\u008a\u0088\u0001\u0000"+
		"\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0087\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000"+
		"\u0000\u0000\u0091\u0096\u0005\u0003\u0000\u0000\u0092\u0093\n\u0014\u0000"+
		"\u0000\u0093\u0094\u0005\u0007\u0000\u0000\u0094\u0096\u0005,\u0000\u0000"+
		"\u0095s\u0001\u0000\u0000\u0000\u0095v\u0001\u0000\u0000\u0000\u0095y"+
		"\u0001\u0000\u0000\u0000\u0095|\u0001\u0000\u0000\u0000\u0095\u007f\u0001"+
		"\u0000\u0000\u0000\u0095\u0082\u0001\u0000\u0000\u0000\u0095\u0085\u0001"+
		"\u0000\u0000\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0096\u0099\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\t\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000"+
		"\u0000\u0000\u009a\u00a3\u0005\u0004\u0000\u0000\u009b\u00a0\u0003\f\u0006"+
		"\u0000\u009c\u009d\u0005\u0002\u0000\u0000\u009d\u009f\u0003\f\u0006\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a3\u009b\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0005\u0000\u0000"+
		"\u00a6\u000b\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005,\u0000\u0000\u00a8"+
		"\u00a9\u0005\t\u0000\u0000\u00a9\u00aa\u0003\b\u0004\u0000\u00aa\r\u0001"+
		"\u0000\u0000\u0000\u00ab\u00b6\u0003\u0012\t\u0000\u00ac\u00b6\u0003\u0010"+
		"\b\u0000\u00ad\u00b6\u0003\u0014\n\u0000\u00ae\u00b6\u0003\u0016\u000b"+
		"\u0000\u00af\u00b6\u0003\u001a\r\u0000\u00b0\u00b6\u0003 \u0010\u0000"+
		"\u00b1\u00b6\u0003\"\u0011\u0000\u00b2\u00b6\u0003$\u0012\u0000\u00b3"+
		"\u00b6\u0003\u001c\u000e\u0000\u00b4\u00b6\u0003\u001e\u000f\u0000\u00b5"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b5\u00ac\u0001\u0000\u0000\u0000\u00b5"+
		"\u00ad\u0001\u0000\u0000\u0000\u00b5\u00ae\u0001\u0000\u0000\u0000\u00b5"+
		"\u00af\u0001\u0000\u0000\u0000\u00b5\u00b0\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b5\u00b2\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6"+
		"\u000f\u0001\u0000\u0000\u0000\u00b7\u00b8\u0003\b\u0004\u0000\u00b8\u00b9"+
		"\u0005\n\u0000\u0000\u00b9\u00ba\u0003\b\u0004\u0000\u00ba\u00bb\u0005"+
		"\u0006\u0000\u0000\u00bb\u0011\u0001\u0000\u0000\u0000\u00bc\u00c0\u0005"+
		"\u0004\u0000\u0000\u00bd\u00bf\u0003\u000e\u0007\u0000\u00be\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005"+
		"\u0005\u0000\u0000\u00c4\u0013\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005"+
		"!\u0000\u0000\u00c6\u00c7\u0005\u0001\u0000\u0000\u00c7\u00c8\u0003\b"+
		"\u0004\u0000\u00c8\u00c9\u0005\u0003\u0000\u0000\u00c9\u00ca\u0003\u000e"+
		"\u0007\u0000\u00ca\u0015\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\"\u0000"+
		"\u0000\u00cc\u00cd\u0005\u0001\u0000\u0000\u00cd\u00ce\u0003\b\u0004\u0000"+
		"\u00ce\u00cf\u0005\u0003\u0000\u0000\u00cf\u00d2\u0003\u000e\u0007\u0000"+
		"\u00d0\u00d1\u0005#\u0000\u0000\u00d1\u00d3\u0003\u000e\u0007\u0000\u00d2"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3"+
		"\u0017\u0001\u0000\u0000\u0000\u00d4\u00d5\u0003\b\u0004\u0000\u00d5\u00d6"+
		"\u0005\u000b\u0000\u0000\u00d6\u00d7\u0003\b\u0004\u0000\u00d7\u00d8\u0005"+
		"\t\u0000\u0000\u00d8\u00d9\u0003\b\u0004\u0000\u00d9\u00da\u0005\u0006"+
		"\u0000\u0000\u00da\u0019\u0001\u0000\u0000\u0000\u00db\u00dc\u0005)\u0000"+
		"\u0000\u00dc\u00dd\u0003\b\u0004\u0000\u00dd\u00de\u0005\u0006\u0000\u0000"+
		"\u00de\u001b\u0001\u0000\u0000\u0000\u00df\u00e0\u0003\b\u0004\u0000\u00e0"+
		"\u00e1\u0005\f\u0000\u0000\u00e1\u00e2\u0005\u0006\u0000\u0000\u00e2\u001d"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e4\u0003\b\u0004\u0000\u00e4\u00e5\u0005"+
		"\r\u0000\u0000\u00e5\u00e6\u0005\u0006\u0000\u0000\u00e6\u001f\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0005*\u0000\u0000\u00e8\u00e9\u0003\b\u0004"+
		"\u0000\u00e9\u00ea\u0005\u0006\u0000\u0000\u00ea!\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0005&\u0000\u0000\u00ec\u00ed\u0005\u0001\u0000\u0000\u00ed"+
		"\u00ee\u0003\b\u0004\u0000\u00ee\u00ef\u0005\t\u0000\u0000\u00ef\u00f0"+
		"\u0003\b\u0004\u0000\u00f0\u00f1\u0005\u0003\u0000\u0000\u00f1\u00f2\u0003"+
		"\u000e\u0007\u0000\u00f2#\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005&\u0000"+
		"\u0000\u00f4\u00f5\u0005\u0001\u0000\u0000\u00f5\u00f6\u0003\b\u0004\u0000"+
		"\u00f6\u00f7\u0005\t\u0000\u0000\u00f7\u00f8\u0003\b\u0004\u0000\u00f8"+
		"\u00f9\u0005\u000e\u0000\u0000\u00f9\u00fa\u0003\b\u0004\u0000\u00fa\u00fb"+
		"\u0005\'\u0000\u0000\u00fb\u00fc\u0003\b\u0004\u0000\u00fc\u00fd\u0005"+
		"\u0003\u0000\u0000\u00fd\u00fe\u0003\u000e\u0007\u0000\u00fe%\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0005%\u0000\u0000\u0100\u0101\u0003\b\u0004"+
		"\u0000\u0101\u0102\u0005\u0006\u0000\u0000\u0102\'\u0001\u0000\u0000\u0000"+
		"\u0011+47;AGSq\u008c\u008f\u0095\u0097\u00a0\u00a3\u00b5\u00c0\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}