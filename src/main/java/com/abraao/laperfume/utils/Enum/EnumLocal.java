package com.abraao.laperfume.utils.Enum;

public enum EnumLocal {
    RESIDENTIAL("Residencial"),
    COMMERCIAL("Comercial");

    private final String value;

    private EnumLocal(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
