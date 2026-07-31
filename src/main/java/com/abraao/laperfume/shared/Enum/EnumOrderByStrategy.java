package com.abraao.laperfume.shared.Enum;

public enum EnumOrderByStrategy {

    SORTBYBESTSELLING("sortbybestselling"),
    SORTBYHIGHESTRATED("sortbyhighestrated"),
    SORTBYLARGESTDISCOUNT("sortbylargestdiscount"),
    SORTBYRELEASEDATE("sortbyreleasedate"),
    SORTBYHIGHESTPRICE("sortbyhighestprice"),
    SORTBYLOWESTPRICE("sortbylowestprice");

    private String value;

    EnumOrderByStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
