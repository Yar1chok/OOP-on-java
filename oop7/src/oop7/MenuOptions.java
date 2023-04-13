package oop7;

/**
 * These are constants for values from the menu when entering.
 */
public enum MenuOptions {
    ADD_PROFESSION_DEFAULT(1), ADD_PROFESSION_USER(2), SHOW_PROFESSION(3), EDIT_RECORD(4),
    SORTING_UP(5), DELETE_PROFESSION(6), FILTER_SALARY(7), DELETE_DUPLICATION(8),
    SUM_MIN_MAX_SALARY(9), GROUPING(10), SUMMARY_STATISTIC(11), WORK_SUM(12), EXIT(13);

    final int number;
    MenuOptions(int number) {this.number = number;}
}
