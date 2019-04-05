package com.codingneko.JSON;

public class CatFact {
    private int size;
    private String fact;

    public CatFact(int size, String fact) {
        this.size = size;
        this.fact = fact;
    }

    public int getSize() {
        return this.size;
    }

    public String getFact() {
        return this.fact;
    }
}
