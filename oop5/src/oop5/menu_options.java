package oop5;

/**
 * These are constants for values from the menu when entering.
 */
public enum menu_options {
    ADD_PROFESSION_DEFAULT(1), ADD_PROFESSION_USER(2), SHOW_PROFESSION(3), EDIT_RECORD(4),
    SORTING_UP(5), EXIT(6);

    final int number;
    menu_options(int number) {this.number = number;}
}
