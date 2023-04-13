package oop6;

/**
 * These are constants for values from the menu when entering
 */
public enum MenuOptions {
    CHECK_POINTER(1), POINTER_TO_START(2), POINTER_TO_END(3), ADD_AFTER_POINTER(4),
    ADD_BEFORE_POINTER(5), DELETE_AFTER_POINTER(6), DELETE_BEFORE_POINTER(7), POINTER_RIGHT(8),
    POINTER_LEFT(9), SWITCH_FIRST_AND_LAST(10), SHOW_LIST(11), SHOW_POINTER(12),
    EXIT(13);

    final int number;
    MenuOptions(int number) {this.number = number;}
}
