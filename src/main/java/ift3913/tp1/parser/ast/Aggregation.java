package ift3913.tp1.parser.ast;

import java.util.Arrays;
import java.util.List;

public class Aggregation extends Declaration {

    public Role single;
    public List<Role> roles;

    public Aggregation() {

    }

    public Aggregation(Role single, Role... roles) {
        this.single = single;
        this.roles = Arrays.asList(roles);
    }

}
