package ru.training.hw6.utils;

public enum ResultSectionItems {
    SUMMARY(1),
    ELEMENTS(2),
    COLOR(3),
    METAL(4),
    VEGETABLES(5);

    private final int position;

    ResultSectionItems(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
