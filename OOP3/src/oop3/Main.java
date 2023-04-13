package oop3;/*
 * Смолянинов Ярослав, КИ21-17/2Б, Вариант - 18
 * Работа с наследованием. От класса oop3.Products наследуются классы oop3.Fruits, oop3.MilkProduction и oop3.Meat.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main class, in which you can add product.
 */
public class Main {
    /**
     * Entry point to the program.
     */
    public static void main(String[] args) {
        List<Products> ProductList = new ArrayList<>();
        boolean menu = true;
        int flagAdd = 0;
        while (menu){
            System.out.println("***Menu***");
            System.out.println("*Write 1 to add object with params.");
            System.out.println("*Write 2 to delete object.");
            System.out.println("*Write 3 to show objects.");
            System.out.println("*Write 4 to compare two objects.");
            System.out.println("*Write 5 to exit from program.");
            int point = checkInputMenu();
            MenuOptions menu_option = MenuOptions.values()[point - 1];
            switch (menu_option){
                case ADD_PRODUCT_DEFAULT: // Добавление объекта с параметрами, введенными пользователем
                    int choice = addObject();
                    if (choice == 1) {
                        ProductList.add(createProduct());
                    } else if (choice == 2) {
                        ProductList.add(createFruit());
                    } else if (choice == 3) {
                        ProductList.add(createMilkProduction());
                    } else if (choice == 4) {
                        ProductList.add(createMeat());
                    }
                    System.out.println("*The object was added.");
                    flagAdd++;
                    break;
                case DELETE_PRODUCT: // Удаление объектов
                    if (flagAdd > 0){
                        showProduct(ProductList);
                        int option = checkIndexObject(ProductList);
                        ProductList.remove(option);
                        System.out.println("*The object was deleted.");
                        flagAdd--;
                    }else {
                        System.out.println("*Firstly add object!");
                    }
                    break;
                case SHOW_PROFESSION: // Вывод объектов
                    if (flagAdd > 0){
                        showProduct(ProductList);
                    }else {
                        System.out.println("*Firstly add object!");
                    }
                    break;
                case COMPARE_PRODUCT: // Сравнение двух элементов
                    if (flagAdd > 0){
                        compareObjects(ProductList);
                    }else {
                        System.out.println("*Firstly add object!");
                    }
                    break;
                case EXIT: // Выход из программы
                    System.out.println("*The program is end.");
                    menu = false;
                    break;
                default:
                    System.out.println("*Error input.");
            }
        }
    }

    /**
     * This method check input from menu on positive digit and digit from menu.
     * @return The digit from menu.
     */
    public static int checkInputMenu(){
        int MAX_MENU_POINTS = 5;
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Enter an item from the menu: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter an item from the menu: ");
                number.next();
            }
            point = number.nextInt();
            if (point > MAX_MENU_POINTS) {
                point = -1;
            }
        } while (point <= 0);
        return point;
    }


    /**
     * This method check input to choose object.
     * @return Integer to choose object.
     */
    public static int checkObject(){
        int MAX_POINTS_OBJECT = 5;
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Your choice: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Your choice: ");
                number.next();
            }
            point = number.nextInt();
            if (point > MAX_POINTS_OBJECT) {
                point = -1;
            }
        } while (point <= 0);
        return point;
    }

    /**
     * This method get the text input by the user
     * @return Text, accepted by user
     */
    public static String checkInputLine(String message){ // Ввод строки
        String lines;
        Scanner str = new Scanner (System.in);
        System.out.print(message);
        while (true) {
            lines = str.nextLine(); // Считывание
            if (lines.trim().length() == 0){
                System.out.print("*Line is empty, write your line again: ");
            }else {
                break;
            }
        }
        return lines;
    }


    /**
     * This method check input on digit.
     * @param message A string that contains the text for a certain class.
     * @return The positive digit.
     */
    public static int checkInputInt(String message){
        Scanner number = new Scanner(System.in);
        int point;
        System.out.println(message);
        do {
            System.out.print("*Enter a positive number: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter a positive number: ");
                number.next();
            }
            point = number.nextInt();
        } while (point < 0);
        return point;
    }

    /**
     * This method check input on double.
     * @param message A string that contains the text for a certain class.
     * @return The positive double.
     */
    public static double checkInputDouble(String message) {
        Scanner number = new Scanner(System.in);
        double point;
        System.out.println(message);
        do {
            System.out.print("*Enter a positive float number: ");
            while (!number.hasNextDouble()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter a positive float number: ");
                number.next();
            }
            point = number.nextDouble();
        } while (point < 0.0);
        return point;
    }

    /**
     * This method check input on digit from menu.
     * @return The digit meaning user choice.
     */
    public static int addObject(){
        System.out.println("*What would you like to add?");
        System.out.println("*1 - Product.");
        System.out.println("*2 - Fruit.");
        System.out.println("*3 - Milk product.");
        System.out.println("*4 - oop3.Meat.");
        return checkObject();
    }

    /**
     * This method check input on digit to delete object from list.
     * @param Product List oop3.Products with objects.
     */
    public static int checkIndexObject(List<Products> Product) {
        Scanner number = new Scanner(System.in);
        int choice;
        do {
            System.out.print("*Enter a number object: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter a number object: ");
                number.next();
            }
            choice = number.nextInt();
            if (choice > Product.size()){
                choice = -1;
                System.out.println("*Input error, try again.");
            }
        } while (choice <= 0);
        choice--;
        return choice;
    }

    /**
     * This method output all object from class oop3.Products.
     * @param Product List oop3.Products with objects.
     */
    public static void showProduct(List<Products> Product) {
        int i = 1;
        for (Products item: Product){
            System.out.println("*** The number of product - " + i + " ***");
            System.out.println("*  " + item.getClass().getName() + "  *");
            System.out.println(item);
            System.out.println();
            i++;
        }
    }

    /**
     * This method compare two objects from list oop3.Products.
     * @param Product List oop3.Products with objects.
     */
    public static void compareObjects(List<Products> Product) {
        int firstIndex = checkIndexObject(Product);
        int secondIndex = checkIndexObject(Product);
        if (Product.get(firstIndex).equals(Product.get(secondIndex))){
            System.out.println("*Two objects are equals!");
        } else {
            System.out.println("*Two objects are not equals.");
        }
    }

    /**
     * This method create object 'Product'.
     * @return Object 'Product'
     */
    public static Products createProduct() {
        return new Products(checkInputLine("*Write the name of product: "), checkInputDouble("*Enter the cost of product."));
    }

    /**
     * This method create object 'Fruit'.
     * @return Object 'Fruit'.
     */
    public static Fruits createFruit(){
        Products Product = createProduct();
        return new Fruits(Product.getName(), Product.getCost(), checkInputLine("*Write the juiciness: "),
                checkInputDouble("*Enter the weight."));
    }

    /**
     * This method create object 'oop3.MilkProduction'.
     * @return Object 'oop3.MilkProduction'.
     */
    public static MilkProduction createMilkProduction() {
        Products products = createProduct();
        return new MilkProduction(products.getName(), products.getCost(), checkInputDouble("*Enter the fatness."),
                checkInputLine("*Write the animal from which the product is derived: "));
    }

    /**
     * This method create object 'oop3.Meat'.
     * @return Object 'oop3.Meat'.
     */
    public static Meat createMeat(){
        Products products = createProduct();
        return new Meat(products.getName(), products.getCost(), checkInputLine("*Write the sort of product: "),
                checkInputInt("*Enter the count of product."));
    }
}