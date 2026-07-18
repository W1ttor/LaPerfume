package com.abraao.laperfume.utils.Enum;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNISSEX("Unissex");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
