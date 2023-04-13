package oop7;

public enum ProfessionOption {
    SALARY(1), HOURS(2), EXPERIENCE(3), NAME(4), STATUS(5);
    final int number;
    ProfessionOption(int number) {this.number = number;}
}
