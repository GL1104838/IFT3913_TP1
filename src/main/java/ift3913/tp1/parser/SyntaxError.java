package ift3913.tp1.parser;

public class SyntaxError extends RuntimeException {

    public int line;
    public int col;

    public SyntaxError(String msg, int line, int col) {
        super(msg);
        this.line = line;
        this.col = col;
    }

}
