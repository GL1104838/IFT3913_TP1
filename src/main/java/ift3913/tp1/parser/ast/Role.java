package ift3913.tp1.parser.ast;

public class Role {

    public String name;
    public Multiplicity multiplicity;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
        this.multiplicity = Multiplicity.ONE;
    }

}
