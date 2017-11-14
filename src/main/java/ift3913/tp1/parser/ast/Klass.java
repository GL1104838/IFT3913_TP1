package ift3913.tp1.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Klass extends Declaration {

    public String name;
    public List<DataItem> attributes;
    public List<Operation> operations;

    public Klass() {

    }

    public Klass(String name) {
        this.name = name;
        attributes = new ArrayList<>();
        operations = new ArrayList<>();
    }

}
