package com.abraao.laperfume.shared.Enum;

public enum FragranceOrLine {
    FRAGRANCE("Fragrance"),
    LINE("Line"),;

    private final String name;

    FragranceOrLine(String name) {
        this.name = name;
    }

    String getFragranceOrLineName() {
        return name;
    }

}
