package ift3913.tp1.parser.ast;

import java.util.Arrays;
import java.util.List;

public class Generalization extends Declaration {

    public String name;
    public List<String> subclasses;

    public Generalization() {

    }

    public Generalization(String name, String... subclasses) {
        this.name = name;
        this.subclasses = Arrays.asList(subclasses);
    }

}
