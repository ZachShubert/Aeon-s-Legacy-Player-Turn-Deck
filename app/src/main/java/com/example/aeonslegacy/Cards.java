package com.example.aeonslegacy;

public class Cards {
    String name;
    int Color;

    public Cards(String name, int color) {
        this.name = name;
        Color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }
}
