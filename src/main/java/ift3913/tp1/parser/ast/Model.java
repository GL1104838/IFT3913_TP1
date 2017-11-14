package ift3913.tp1.parser.ast;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public String name;
    public List<Declaration> declarations;

    public Model() {

    }

    public Model(String name) {
        this.name = name;
        declarations = new ArrayList<>();
    }

}
