package oop3;

import java.util.Objects;

/**
 * This class about meat.
 */
public class Meat extends Products{
    /**
     * The sort of meat.
     */
    private String sort;

    /**
     * The number of steaks.
     */
    private int numberSteaks;

    /**
     * The default construction.
     */
    public Meat(){
        this.numberSteaks = 0;
        this.sort = "Empty";
    }

    /**
     * The constructor with params, inputs by user.
     * @param name The name of meat.
     * @param cost The cost of meat.
     * @param sort The sort of meat.
     * @param numberSteaks The number of steaks.
     */
    public Meat(String name, double cost, String sort, int numberSteaks) {
        super(name, cost);
        this.sort = sort;
        this.numberSteaks = numberSteaks;
    }

    /**
     * This getter returns the sort of meat.
     * @return The sort of meat.
     */
    public String getSort() {
        return sort;
    }

    /**
     * This setter check input and assigns a new value of sort meat.
     */
    public void setSort(String sort) {
        if (sort.length() > 0) {
            this.sort = sort;
        }
    }

    /**
     * This getter returns the count of meat.
     * @return The number of steaks.
     */
    public int getNumberSteaks() {
        return numberSteaks;
    }

    /**
     * This setter check input and assigns a new value of count meat.
     */
    public void setNumberSteaks(int numberSteaks) {
        if (numberSteaks > 0){
            this.numberSteaks = numberSteaks;
        }
    }

    /**
     * Compares two objects.
     * @param obj Compared object.
     * @return Equality object.
     */
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return false;
        }
        Meat meat = (Meat) obj;
        return meat.numberSteaks == numberSteaks && Objects.equals(meat.sort, sort);
    }

    /**
     * Return hash of the object.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sort, numberSteaks);
    }

    /**
     * Converts an object to a string
     * @return Object in string format.
     */
    @Override
    public String toString() {
        return String.format("""
                        * Name - %s
                        * Cost - %s
                        * Sort - %s
                        * Number steaks - %s""", getName(), getCost(), getSort(), getNumberSteaks());
    }
}
