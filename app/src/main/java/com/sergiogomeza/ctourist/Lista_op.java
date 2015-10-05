package com.sergiogomeza.ctourist;

/**
 * Created by Sergio on 04/10/2015.
 */
public class Lista_op {
    private int ident;
    private String name;
    private String other;

    public Lista_op(int ident, String name, String other) {
        this.ident = ident;
        this.name = name;
        this.other = other;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdent() {
        return ident;
    }

    public String getName() {
        return name;
    }

    public String getOther() {
        return other;
    }
}

