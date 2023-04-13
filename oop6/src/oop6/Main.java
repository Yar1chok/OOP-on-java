package oop6;
/*
 * Смолянинов Ярослав, КИ21-17/2Б, Вариант - 18
 * Двунаправленный кольцевой список
 */
import java.util.Scanner;

/**
 * This is a main class, in which program is started
 */
public class Main {
    /**
     * This is a main method, which is the entry point
     */
    public static void main(String[] args) {
        boolean typeMenu = true;
        final int INT_FLAG = 1;
        final int DOUBLE_FLAG = 2;
        final int STRING_FLAG = 3;
        while (typeMenu){
            System.out.println("***Menu***");
            System.out.println("*Write 1 to create integer list");
            System.out.println("*Write 2 to create double list");
            System.out.println("*Write 3 to create string list");
            System.out.println("*Write 4 to exit the program");
            int point = checkInputType();
            switch (TypeOptions.values()[point - 1]){
                case INTEGER -> {
                    DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
                    workWithList(list, INT_FLAG);
                    typeMenu = false;
                }
                case DOUBLE -> {
                    DoubleLinkedList<Double> list = new DoubleLinkedList<>();
                    workWithList(list, DOUBLE_FLAG);
                    typeMenu = false;
                }
                case STRING -> {
                    DoubleLinkedList<String> list = new DoubleLinkedList<>();
                    workWithList(list, STRING_FLAG);
                    typeMenu = false;
                }
                case EXIT -> {
                    typeMenu = false;
                    System.out.println("*The program is end.");
                }
                default -> System.out.print("*Input error, try again: ");
            }
        }
    }

    /**
     * This method working with list, created in main method with chosen type data
     * @param list A Double linked list
     */
    public static void workWithList(DoubleLinkedList list, int typeFlag) {
        boolean optionsMenu = true;
        while (optionsMenu) {
            System.out.println();
            System.out.println("***Menu***");
            System.out.println("*Write 1 to check the list for emptiness");
            System.out.println("*Write 2 to set pointer on the beginning");
            System.out.println("*Write 3 to set pointer on the end");
            System.out.println("*Write 4 to add element behind the pointer");
            System.out.println("*Write 5 to add element before the pointer");
            System.out.println("*Write 6 to delete element behind the pointer");
            System.out.println("*Write 7 to delete element before the pointer");
            System.out.println("*Write 8 to move the pointer to the right");
            System.out.println("*Write 9 to move the pointer to the left");
            System.out.println("*Write 10 to switch elements before and after pointer");
            System.out.println("*Write 11 to show nodes");
            System.out.println("*Write 12 to show pointer");
            System.out.println("*Write 13 to exit the program");
            int choice = checkInputMenu();
            switch (MenuOptions.values()[choice - 1]) {
                case CHECK_POINTER -> {
                    if (list.isEmpty()) {
                        System.out.println("*List is empty.");
                    } else {
                        System.out.println("*List size - " + list.getSize());
                        System.out.println("Pointer position - " + list.getPointer());
                    }
                }
                case POINTER_TO_START -> {
                    list.setPointerToStart();
                    System.out.println("*The pointer indicate on the beginning.");
                }
                case POINTER_TO_END -> {
                    list.setPointerToEnd();
                    System.out.println("**The pointer indicate on the end.");
                }
                case ADD_AFTER_POINTER -> addElementAfter(list, typeFlag);
                case ADD_BEFORE_POINTER -> addElementBefore(list, typeFlag);
                case DELETE_AFTER_POINTER -> list.deleteAfterPointer();
                case DELETE_BEFORE_POINTER -> list.deleteBeforePointer();
                case POINTER_RIGHT -> System.out.println("*The pointer value: " + list.movePointerRight());
                case POINTER_LEFT -> System.out.println("*The pointer value: " + list.movePointerLeft());
                case SWITCH_FIRST_AND_LAST -> list.switchFirstAndLast();
                case SHOW_LIST -> showList(list);
                case SHOW_POINTER -> System.out.println("Pointer position - " + list.getPointer());
                case EXIT -> {
                    optionsMenu = false;
                    System.out.println("*The program is end.");
                }
                default -> System.out.print("*Input error, try again: ");
            }
        }
    }

    /**
     * This method add the element after the pointer
     * @param list A Double linked list
     */
    public static void addElementAfter(DoubleLinkedList list, int typeFlag){
        if (typeFlag == 1){
            int newElement = checkInputInt();
            list.addAfterPointer(newElement);
        } else if (typeFlag == 2){
            double newElement = checkInputDouble();
            list.addAfterPointer(newElement);
        } else if (typeFlag == 3) {
            String newElement = checkInputString();
            list.addAfterPointer(newElement);
        }
    }

    /**
     * This method add the element before the pointer
     * @param list A Double linked list
     */
    public static void addElementBefore(DoubleLinkedList list, int typeFlag){
        if (typeFlag == 1){
            int newElement = checkInputInt();
            list.addBeforePointer(newElement);
        } else if (typeFlag == 2){
            double newElement = checkInputDouble();
            list.addBeforePointer(newElement);
        } else if (typeFlag == 3) {
            String newElement = checkInputString();
            list.addBeforePointer(newElement);
        }
    }

    /**
     * This method show elements in the list
     * @param list A Double linked list
     */
    public static void showList(DoubleLinkedList list){
        if (list.isEmpty()){
            System.out.println("*List is empty.");
        }else {
            list.setPointerToStart();
            System.out.print("[");
            for (int i = 0; i != list.getSize() - 1; i++){
                System.out.print(list.getNext() + ", ");
                list.movePointerRight();
            }
            System.out.print(list.getNext() + "]");
            list.setPointerToStart();
        }

    }

    /**
     * This method check input on integer
     * @return Integer digit
     */
    public static int checkInputInt(){
        Scanner number = new Scanner(System.in);
        System.out.print("*Input digit: ");
        while (!number.hasNextInt()) {
            System.out.println("*Input error, try again.");
            System.out.print("*Enter a positive number: ");
            number.next();
        }
        return number.nextInt();
    }

    /**
     * This method check input on digit with floating digital
     * @return Digit with floating digital
     */
    public static double checkInputDouble(){
        Scanner number = new Scanner(System.in);
        System.out.print("*Input number: ");
        while (!number.hasNextDouble()) {
            System.out.println("*Input error, try again.");
            System.out.print("*Enter a positive number: ");
            number.next();
        }
        return number.nextDouble();
    }

    /**
     * This method get the text input by the user
     * @return Text, accepted by user
     */
    public static String checkInputString(){ // Ввод строки
        String lines;
        Scanner str = new Scanner (System.in);
        System.out.print("*Write your line: ");
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
     * This method check input on integer and a range of menu
     * @return Integer digit
     */
    public static int checkInputMenu(){
        int MAX_MENU_POINTS = 13;
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
     * This method check input on integer and a range of types
     * @return Integer digit
     */
    public static int checkInputType(){
        final int MAX_MENU_POINTS = 4;
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
}