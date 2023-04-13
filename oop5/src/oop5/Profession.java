package oop5;

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
     * This is a constructor with params for class 'oop2.oop5.Profession'.
     * @param money Param means getting salary worker's.
     * @param hour Pairs means experience of worker.
     * @param experiences Pairs means experience of worker.
     * @param title Pairs means the ratio of salary to working time.
     */
    public Profession(int money, int hour, double experiences, String title) throws NegativeIntException, EmptyException{
        if (money < 0){
            throw new NegativeIntException("The number of money must be greater than zero!");}
        if (hour < 0){
            throw new NegativeIntException("The number of hour must be greater than zero!");}
        if (experiences < 0){
            throw new NegativeIntException("The number of experience must be greater than zero!");}
        if (title.isEmpty()){
            throw new EmptyException("The field name must be filled in!");}
        this.salary = money;
        this.hours = hour;
        this.experience = experiences;
        this.name = title;
        this.status = strStatus();
    }

    /**
     *This is a default constructor for class 'oop2.oop5.Profession', which randomly fills in the fields.
     */
    public Profession() {
        this.salary = 0;
        this.hours = 0;
        this.experience = 0;
        this.name = "Empty";
        this.status = "Empty";
    }

    /**
     *This getter returns the value of the name.
     * @return The name of oop2.oop5.Profession.
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
    public void setSalary(int salary) throws NegativeIntException{
        if (salary > 0){
            this.salary = salary;
            this.status = strStatus();
        }else {
            throw new NegativeIntException("The salary field must be greater than zero!");
        }
    }

    /**
     * This setter assigns a new value of worker's experience.
     * @param experience The experience of worker.
     */
    public void setExperience(double experience) throws EmptyException{
        if (experience > 0){
            this.experience = experience;
        }else {
            throw new EmptyException("The field experience must be filled in!");
        }
    }

    /**
     * This setter assigns a new value of professions name.
     * @param name The name of professions.
     */
    public void setName(String name) throws EmptyException{
        if (!name.isEmpty()){
            this.name = name;
        }else {
            throw new EmptyException("The field name must be filled in!");
        }
    }

    /**
     * This setter assigns a new value of worker's hours.
     * @param hours The worker's hours.
     */
    public void setHours(int hours) throws EmptyException{
        if (hours > 0){
            this.hours = hours;
            this.status = strStatus();
        }
        else {
            throw new EmptyException("The field hours must be filled in!");
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
        try {
            if (((this.salary / this.hours) >= ZERO) && ((this.salary / this.hours) <= MAX_BEGINNER)){
                return "beginner";
            } else if (((this.salary / this.hours) <= MAX_SKILLED) && ((this.salary / this.hours) > MAX_BEGINNER)){
                return "skilled";
            }
            else {
                return "expert";
            }
        }catch (ArithmeticException exception){
            this.status = "Empty";
        }
        return null;
    }
}
