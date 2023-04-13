package oop3;

import java.util.Objects;

/**
 * The class about fruits.
 */
public class Fruits extends Products{
    /**
     * The weight of fruits.
     */
    private double weight;

    /**
     * The juiciness of fruits.
     */
    private String juiciness;

    /**
     * The default constructor.
     */
    public Fruits() {
        this.juiciness = "Empty";
        this.weight = 0.0;
    }

    /**
     * The constructor with params, inputs by user.
     * @param name The name of fruit.
     * @param cost The cost of fruit.
     * @param juiciness The juiciness of fruit.
     * @param weight The weight of fruit.
     */
    public Fruits(String name, double cost, String juiciness, double weight){
        super(name, cost);
        this.juiciness = juiciness;
        this.weight = weight;
    }

    /**
     * This getter returns the weight of fruits.
     * @return The weight of fruits.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * This getter returns the juiciness of fruits.
     * @return The juiciness of fruits.
     */
    public String getJuiciness() {
        return juiciness;
    }

    /**
     * This setter check input weight of fruits and assigns a new value of weight fruits.
     */
    public void setWeight(double weight) {
        if (weight > 0.0) {
            this.weight = weight;
        }
    }

    /**
     * This setter check input juiciness of fruits and assigns a new value of juiciness fruits.
     */
    public void setJuiciness(String juiciness) {
        if (juiciness.length() > 0){
            this.juiciness = juiciness;
        }
    }

    /**
     * Compares two objects.
     * @param obj Compared object.
     * @return Equality object.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Fruits fruits = (Fruits) obj;
        return Double.compare(fruits.weight, weight) == 0 && Objects.equals(fruits.juiciness, juiciness);
    }

    /**
     * Return hash of the object.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, juiciness);
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
                        * Weight - %s
                        * Juiciness - %s""", getName(), getCost(), getWeight(), getJuiciness());
    }
}
