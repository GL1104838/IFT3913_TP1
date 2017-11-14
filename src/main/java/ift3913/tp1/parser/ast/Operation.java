package ift3913.tp1.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Operation {

    public String name;
    public List<DataItem> args;
    public String type;

    public Operation() {

    }

    public Operation(String name, String type) {
        this.name = name;
        this.type = type;
        args = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Operation) {
            Operation op = (Operation) o;
            if (this.name.equals(op.name) && this.type.equals(op.type)) {
                if (this.args.size() == op.args.size()) {
                    for (int i = 0; i < this.args.size(); i++) {
                        if (!this.args.get(i).equals(op.args.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
