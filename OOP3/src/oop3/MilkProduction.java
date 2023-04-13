package oop3;

import java.util.Objects;

/**
 * The class about milk production.
 */
public class MilkProduction extends Products{
    /**
     * The fatness of milk production.
     */
    private double fat;

    /**
     * The animal from which the product is derived.
     */
    private String animal;

    /**
     * The default constructor.
     */
    public MilkProduction() {
        this.fat = 0.0;
        this.animal = "Empty";
    }

    /**
     * The constructor with params, inputs by user.
     * @param name The name of milk production.
     * @param cost The cost of milk production.
     * @param fat The fatness of milk production.
     * @param animal The animal from which the product is derived.
     */
    public MilkProduction(String name, double cost, double fat, String animal){
        super(name, cost);
        this.fat = fat;
        this.animal = animal;
    }

    /**
     * This getter returns the fatness of milk production.
     * @return The fatness of milk production.
     */
    public double getFat() {
        return fat;
    }

    /**
     * This setter check input fatness of milk production and assigns a new value of fatness milk production.
     */
    public void setFat(double fat) {
        if (fat > 0.0){
            this.fat = fat;
        }
    }

    /**
     * This getter returns the animal from which the product is derived from milk production.
     * @return The animal from which the product is derived.
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * This setter check input and assigns a new value of animal from which the product.
     */
    public void setAnimal(String animal) {
        if (animal.length() > 0)
            this.animal = animal;
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
        MilkProduction milkProduction = (MilkProduction) obj;
        return Double.compare(milkProduction.fat, fat) == 0 && Objects.equals(milkProduction.animal, animal);
    }

    /**
     * Return hash of the object.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fat, animal);
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
                        * Fatness - %s
                        * Animal - %s""", getName(), getCost(), getFat(), getAnimal());
    }
}
