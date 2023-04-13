package oop3;

/**
 * This enum contains the constants of menu option.
 */
public enum MenuOptions {
    ADD_PRODUCT_DEFAULT(1), DELETE_PRODUCT(2), SHOW_PROFESSION(3), COMPARE_PRODUCT(4),
    EXIT(5);

    final int number;
    MenuOptions(int number) {this.number = number;}
}
