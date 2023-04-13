package oop3;

import java.util.Objects;

/**
 * The class about products.
 */
public class Products {
    /**
     * The name of product.
     */
    private String name;

    /**
     * The cost of product.
     */
    private double cost;

    /**
     * The default constructor.
     */
    public Products() {
        this.name = "Empty";
        this.cost = 0;
    }

    /**
     * The constructor with params, inputs by user.
     * @param name The name of product.
     * @param price The cost of product.
     */
    public Products(String name, double price){
        this.name = name;
        this.cost = price;
    }

    /**
     * This getter returns the name of product.
     * @return The name of product.
     */
    public String getName() {
        return name;
    }

    /**
     * This getter returns the cost of product.
     * @return The cost of product.
     */
    public double getCost() {
        return cost;
    }

    /**
     * This setter check input name of product and assigns a new value of name product.
     */
    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    /**
     * This setter check input cost of product and assigns a new value of cost product.
     */
    public void setCost(double cost) {
        if (cost > 0.0){
            this.cost = cost;
        }
    }

    /**
     * Compares two objects.
     * @param obj Compared object.
     * @return Equality object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; } // Проверка не ссылается ли объект по ссылке obj на текущий объект
        if (obj == null || getClass() != obj.getClass()){ // Проверка не передан ли null или объект по ссылке obj другого класса
            return false;
        }
        Products products = (Products) obj; // Создаем класс с нашей ссылкой
        return Double.compare(products.cost, cost) == 0 && Objects.equals(products.name, name); // Сравниваем поля классов.
    }

    /**
     * Return hash of the object.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    /**
     * Converts an object to a string
     * @return Object in string format.
     */
    @Override
    public String toString() {
        return String.format("""
                        * Name - %s
                        * Cost - %s""", getName(), getCost());
    }
}
