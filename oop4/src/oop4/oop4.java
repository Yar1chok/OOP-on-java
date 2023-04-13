package oop4;/*
Смолянинов Ярослав, КИ21-17/2Б, Вариант - 8
Данная программа создает интерфейс 'oop4.AnalyseLine', от которого создаются два класса 'oop4.CountVowels' и 'oop4.CountConsonant'
с помощью интерфейса.
 */

import java.util.Scanner;

/**
 * This is a main class, in which you can write string and count consonant and vowels.
 */
public class oop4 {
    /**
     * Entry point to the program.
     */
    public static void main(String[] args) {
        boolean menu = true;
        while (menu){
            System.out.println("***Menu***");
            System.out.println("*Write 1 to input your string.");
            System.out.println("*Write 2 to exit from program.");
            int point = checkInputMenu();
            switch (MenuOptions.values()[point - 1]){
                case INPUT_STRING -> {
                    String string = checkInputLine();
                    int countVowels = countVowels(string);
                    int countConsonant = countConsonant(string);
                    System.out.println("*Number of vowels per line - " + countVowels);
                    System.out.println("*Number of consonant per line - " + countConsonant);
                }
                case EXIT -> {
                    System.out.println("*The program is end.");
                    menu = false;
                }
                default -> System.out.println("*Error input.");
            }
        }
    }

    /**
     * This method check input from menu on positive digit and digit from menu.
     * @return The digit from menu.
     */
    public static int checkInputMenu(){
        int MAX_MENU_POINTS = 2;
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
     * This method get the text input by the user
     * @return Text, accepted by user
     */
    public static String checkInputLine(){ // Ввод строки
        String lines;
        Scanner str = new Scanner (System.in);
        System.out.print("*Input your line: ");
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
     * This method counts the number vowels in string.
     * @param str Input string
     * @return Count of vowels in string.
     */
    public static int countVowels(String str){
        return new CountVowels().analyse(str);
    }

    /**
     * This method counts the number consonant in string.
     * @param str Input string
     * @return Count of consonant in string.
     */
    public static int countConsonant(String str){
        return new CountConsonant().analyse(str);
    }
}