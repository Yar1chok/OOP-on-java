/*
 * Смолянинов Ярослав, КИ21-17/2Б, Вариант - 18
 * Программа создает класс "Professions" и хранит информацию о профессиях в базе данных.
 */
package oop2;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    /**
     * This is a main function, which is the entry point.
     */
    public static void main(String[] args) {
        boolean menu = true;
        int flag_input = 0;
        int number_profession;
        int number_param;
        List<Profession> Professions = new ArrayList<>();
        while (menu){
            System.out.println("***Menu***");
            System.out.println("*Write 1 to add profession by default.");
            System.out.println("*Write 2 to add profession and params.");
            System.out.println("*Write 3 to show added professions.");
            System.out.println("*Write 4 to edit profession.");
            System.out.println("*Write 5 to sorting up professions by the specified parameter.");
            System.out.println("*Write 6 to exit from program.");
            int point = checkInputMenu();
            menu_options menu_option = menu_options.values()[point - 1];
            switch (menu_option){
                case ADD_PROFESSION_DEFAULT: // Добавление профессии конструктором по умолчанию
                    Professions.add(new Profession());
                    System.out.println("*Record successfully added.");
                    flag_input = 1;
                    break;
                case ADD_PROFESSION_USER: // Добавление профессии с параметрами, введенными пользователем
                    int salary = checkInputSalary();
                    int hours = checkInputHours();
                    double experience = checkInputExperience();
                    String name = checkInputLine();
                    Professions.add(new Profession(salary, hours, experience, name));
                    flag_input = 1;
                    break;
                case SHOW_PROFESSION: // Вывод профессий
                    if (flag_input == 1){
                        showProfessions(Professions);
                    }
                    else {
                        System.out.println("*Firstly add profession!");
                    }
                    break;
                case EDIT_RECORD: // Редактирование профессий
                    if (flag_input == 1) {
                        showProfessions(Professions);
                        number_profession = checkNumberProfession(Professions.size());
                        number_param = checkNumberParam();
                        if (number_param == 1){
                            int money = checkInputSalary();
                            Professions.get(number_profession - 1).setSalary(money);
                        } else if (number_param == 2) {
                            int hour = checkInputHours();
                            Professions.get(number_profession - 1).setHours(hour);
                        } else if (number_param == 3) {
                            double practice = checkInputExperience();
                            Professions.get(number_profession - 1).setExperience(practice);
                        }else {
                            String surname = checkInputLine();
                            Professions.get(number_profession - 1).setName(surname);
                        }
                    }else{
                        System.out.println("*Firstly add profession!");
                    }
                    break;
                case SORTING_UP: // Сортировка профессий по возрастанию
                    if (flag_input == 1){
                        showProfessions(Professions);
                        number_param = checkNumberParamSort();
                        if (number_param == 1) {
                            Professions.sort(Comparator.comparingInt(Profession::getSalary));
                            System.out.println("*Professions are sorted.");
                        } else if (number_param == 2) {
                            Professions.sort(Comparator.comparingInt(Profession::getHours));
                            System.out.println("*Professions are sorted.");
                        } else if (number_param == 3) {
                            Professions.sort(Comparator.comparingDouble(Profession::getExperience));
                            System.out.println("*Professions are sorted.");
                        } else if (number_param == 4) {
                            Professions.sort(Comparator.comparing(Profession::getName));
                            System.out.println("*Professions are sorted.");
                        } else if (number_param == 5) {
                            Professions.sort(Comparator.comparing(Profession::getStatus));
                            System.out.println("*Professions are sorted.");
                        }
                    } else {
                        System.out.println("*Firstly add profession!");
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
     * This function check input from menu on positive digit and digit from menu.
     * @return The digit from menu.
     */
    public static int checkInputMenu(){
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
            if (point > 6) {
                point = -1;
            }
        } while (point <= 0);
        return point;
    }

    /**
     * This function check input on positive digit.
     * @return The digit means worker salary.
     */
    public static int checkInputSalary(){
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Enter a positive number to add salary: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter a positive number to add salary: ");
                number.next();
            }
            point = number.nextInt();
        } while (point <= 0);
        return point;
    }

    /**
     * This function check input on positive digit from 50 to 250.
     * @return The digit means worker hours.
     */
    public static int checkInputHours(){
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Enter a number from 50 to 250 to add work hours: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter a number from 50 to 250 to add work hours: ");
                number.next();
            }
            point = number.nextInt();
            if (point >= 250) {
                point = -1;
            }
        } while (point < 50);
        return point;
    }

    /**
     * This function check input on float from 0 to 20.
     * @return The float means worker experience.
     */
    public static double checkInputExperience(){
        Scanner number = new Scanner(System.in);
        double point;
        do {
            System.out.print("*Enter a float number from 0 to 20 to add worker experience: ");
            while (!number.hasNextDouble()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter a float number from 0 to 20 to add worker experience: ");
                number.next();
            }
            point = number.nextDouble();
            if (point >= 20.0) {
                point = -1.0;
            }
        } while (point < 0.0);
        return point;
    }

    /**
     * This function get the text input by the user
     * @return Text, accepted by user
     */
    public static String checkInputLine(){ // Ввод строки
        String lines;
        Scanner str = new Scanner (System.in);
        System.out.print("*Write the name of profession: ");
        while (true) {
            lines = str.nextLine(); // Считывание
            if (lines.trim().length() == 0){
                System.out.print("*Line is empty, write your line again: ");
            }else {
                break;
            }
        }
        return lines.toLowerCase();
    }

    /**
     * This function show notes from class Professions.
     * @param Professions The list of class Professions with added notes.
     */
    public static void showProfessions(List<Profession> Professions) {
        for (int i = 0; i < Professions.size(); i++) {
            System.out.println("***oop2.Profession number - " + (i + 1) + " ***");
            System.out.println("*1)The worker's salary - " + Professions.get(i).getSalary());
            System.out.println("*2)The worker's hours at month - " + Professions.get(i).getHours());
            System.out.println("*3)The worker's experience - " +
                    new DecimalFormat("#.##").format(Professions.get(i).getExperience()));
            System.out.println("*4)The name of profession - " + Professions.get(i).getName());
            System.out.println("*5)Status by earnings per hour - " + Professions.get(i).getStatus());
            System.out.println();
        }
    }

    /**
     * This function check number to choose profession.
     * @param length The length of list with professions.
     * @return The positive digit with number of profession.
     */
    public static int checkNumberProfession(int length){
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Input the number of profession would you like to edit: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Input the number of profession would you like to edit: ");
                number.next();
            }
            point = number.nextInt();
            if (point <= 0) {
                point = -1;
                System.out.println("*Input error, try again.");
            }
        } while (point > length);
        return point;
    }

    /**
     * This function check number to choose param of profession.
     * @return The positive digit with number param of profession.
     */
    public static int checkNumberParam(){
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Input the number from 1 to 4 for param would you like to edit: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Input the number from 1 to 4 for param would you like to edit: ");
                number.next();
            }
            point = number.nextInt();
            if (point <= 0 || point > 4) {
                point = -1;
                System.out.println("*Input error, try again.");
            }
        } while (point <= 0);
        return point;
    }

    /**
     * This function check number to choose param to sort.
     * @return The positive digit with number to sort.
     */
    public static int checkNumberParamSort(){
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Input the number from 1 to 5 for param would you like to sorting up: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Input the number from 1 to 5 for param would you like to sorting up: ");
                number.next();
            }
            point = number.nextInt();
            if (point <= 0 || point > 5) {
                point = -1;
                System.out.println("*Input error, try again.");
            }
        } while (point <= 0);
        return point;
    }
}