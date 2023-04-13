package oop7;

import java.util.Objects;

/**
 * This class stores 5 fields for professions, salary, time of work, work experience, name and status.
 */
public class Profession {
    /**
     * Param means getting salary worker's.
     */
    private int salary;

    /**
     * Param means how much a worker works per month.
     */
    private int hours;

    /**
     * Pairs means experience of worker.
     */
    private double experience;

    /**
     * Pairs means the name of profession.
     */
    private String name;

    /**
     * Pairs means the ratio of salary to working time.
     */
    private String status;

    /**
     * This is a constructor with params for class 'oop2.oop7.Profession'.
     * @param money Param means getting salary worker's.
     * @param hour Pairs means experience of worker.
     * @param experiences Pairs means experience of worker.
     * @param title Pairs means the ratio of salary to working time.
     */
    public Profession(int money, int hour, double experiences, String title) {
        this.salary = money;
        this.hours = hour;
        this.experience = experiences;
        this.name = title;
        this.status = strStatus();
    }

    /**
     *This is a default constructor for class 'oop7.Profession', which randomly fills in the fields.
     */
    public Profession() {
        this.salary = 0;
        this.hours = 0;
        this.experience = 0;
        this.name = "Empty";
        this.status = "Empty";
    }

    /**
     * Compares two objects.
     * @param obj Compared object.
     * @return Equality object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Profession that)) return false;
        return salary == that.salary && hours == that.hours && Double.compare(that.experience, experience) == 0 && name.equals(that.name) && status.equals(that.status);
    }

    /**
     * Return hash of the object.
     * @return Hash by element.
     */
    @Override
    public int hashCode() {
        return Objects.hash(salary, hours, experience, name, status);
    }

    /**
     * Converts an object to a string
     * @return Object in string format.
     */
    @Override
    public String toString() {
        return  "*1)The worker's salary - " + salary + "\n" +
                "*2)The worker's hours at month - " + hours + "\n" +
                "*3)The worker's experience - " + experience + "\n" +
                "*4)The name of profession - " + name + "\n" +
                "*5)Status by earnings per hour - " + status + "\n";
    }

    /**
     *This getter returns the value of the name.
     * @return The name of oop2.oop7.Profession.
     */
    public String getName() {
        return name;
    }

    /**
     * This getter returns the value of the salary.
     * @return The worker salary.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * This getter returns the value of the experience.
     * @return The experience of worker.
     */
    public double getExperience() {
        return experience;
    }

    /**
     * This getter returns the ratio of salary to working time.
     * @return The status of worker.
     */
    public String getStatus() {
        return status;
    }

    /**
     * This getter returns hours of work of the worker.
     * @return The how much a worker works per month.
     */
    public int getHours() {
        return hours;
    }

    /**
     * This setter assigns a new value of salary.
     * @param salary The worker salary.
     */
    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
            this.status = strStatus();
        }
    }

    /**
     * This setter assigns a new value of worker's experience.
     * @param experience The experience of worker.
     */
    public void setExperience(double experience) {
        if (experience > 0){
            this.experience = experience;
        }
    }

    /**
     * This setter assigns a new value of professions name.
     * @param name The name of professions.
     */
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    /**
     * This setter assigns a new value of worker's hours.
     * @param hours The worker's hours.
     */
    public void setHours(int hours) {
        if (hours > 0){
            this.hours = hours;
            this.status = strStatus();
        }
    }

    /**
     * This setter assigns a new value of worker's status.
     */
    public void setStatus() {
        this.status = strStatus();
    }

    /**
     * This method calculates a value of worker's status.
     * @return The value of worker status.
     */
    private String strStatus() {
        final int ZERO = 0;
        final int MAX_BEGINNER = 200;
        final int MAX_SKILLED = 500;
        if (((this.salary / this.hours) >= ZERO) && ((this.salary / this.hours) <= MAX_BEGINNER)){
            return "beginner";
        } else if (((this.salary / this.hours) <= MAX_SKILLED) && ((this.salary / this.hours) > MAX_BEGINNER)){
            return "skilled";
        }
        else {
            return "expert";
        }
    }
}
