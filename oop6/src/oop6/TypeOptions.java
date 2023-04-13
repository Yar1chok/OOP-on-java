package oop6;

/**
 * These are constants for values from the menu to choose type data
 */
public enum TypeOptions {
    INTEGER(1), DOUBLE(2), STRING(3), EXIT(4);

    final int number;
    TypeOptions(int number) {this.number = number;}
}
