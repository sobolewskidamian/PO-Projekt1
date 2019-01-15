package agh.objects;

import java.util.LinkedList;

public class Judge {
    private String name;
    private String function;
    private LinkedList<String> specialRoles;

    public Judge(String name, String function) {
        this.name = name;
        this.function = function;
        this.specialRoles = new LinkedList<>();
    }

    public void addSpecialRole(String specialRole) {
        this.specialRoles.add(specialRole);
    }

    public String getName() {
        return this.name;
    }

    public String getFunction() {
        return this.function;
    }

    public LinkedList<String> getSpecialRoles() {
        return this.specialRoles;
    }
}
