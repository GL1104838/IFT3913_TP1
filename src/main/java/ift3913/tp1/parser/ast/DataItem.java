package ift3913.tp1.parser.ast;

public class DataItem {

    public String ident;
    public String type;

    public DataItem() {
    }

    public DataItem(String ident, String type) {
        this.ident = ident;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DataItem) {
            DataItem di = (DataItem) o;
            return this.ident.equals(di.ident) && this.type.equals(di.type);
        }
        return false;
    }
}
