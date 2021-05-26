package ru.training.hw6.utils;

public enum HeaderElements {
    HOME(1),
    CONTACT_FORM(2),
    SERVICE(3),
    METALS_AND_COLORS(4);

    private final int position;

    HeaderElements(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
