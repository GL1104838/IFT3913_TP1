package ift3913.tp1.parser.ast;

public class Association extends Declaration {

    public String name;
    public Role role_1;
    public Role role_2;

    public Association() {

    }

    public Association(String name, Role r1, Role r2) {
        this.name = name;
        this.role_1 = r1;
        this.role_2 = r2;
    }

}
