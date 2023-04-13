package oop7;/*
 * Смолянинов Ярослав, КИ21-17/2Б, Вариант - 18
 * Программа создает класс "Professions" и хранит информацию о профессиях в базе данных.
 * Работа с потоками, создание нескольких методов, показывающих их работу.
 * Также демонстрация умения работы с SummaryStatistics.
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    /**
     * This is a main function, which is the entry point.
     */
    public static void main(String[] args) {
        boolean menu = true;
        ArrayList<Profession> Professions = new ArrayList<>();
        while (menu){
            System.out.println("***Menu***");
            System.out.println("*Write 1 to add profession by default");
            System.out.println("*Write 2 to add profession and params");
            System.out.println("*Write 3 to show added professions");
            System.out.println("*Write 4 to edit profession.");
            System.out.println("*Write 5 to sorting up professions by the specified parameter");
            System.out.println("*Write 6 to delete the profession");
            System.out.println("*Write 7 to filter professions by salary");
            System.out.println("*Write 8 to delete duplication");
            System.out.println("*Write 9 to summation of the maximum and minimum of salary");
            System.out.println("*Write 10 to group professions by status");
            System.out.println("*Write 11 to show statistic by professions");
            System.out.println("*Write 12 to summary work hours by employees");
            System.out.println("*Write 13 to exit from program");
            int point = checkInputMenu();
            MenuOptions menuOptions = MenuOptions.values()[point - 1];
            switch (menuOptions) {
                case ADD_PROFESSION_DEFAULT -> { // Добавление профессии конструктором по умолчанию
                    Professions.add(addProfession(true));
                    System.out.println("*Record successfully added");
                }
                case ADD_PROFESSION_USER -> { // Добавление профессии с параметрами, введенными пользователем
                    Professions.add(addProfession(false));
                    System.out.println("*Record successfully added");
                }
                case SHOW_PROFESSION -> { // Вывод профессий
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        showProfession(Professions.stream());
                    }
                }
                case EDIT_RECORD -> { // Редактирование профессий
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        editProfession(Professions);
                    }
                }
                case SORTING_UP -> { // Сортировка профессий по возрастанию
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        sortingUpProfession(Professions);
                    }
                }
                case DELETE_PROFESSION -> {
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        deleteProfession(Professions);
                    }
                }
                case FILTER_SALARY -> {
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        filterSalary(Professions);
                    }
                }
                case DELETE_DUPLICATION -> {
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        Professions = deleteDuplication(Professions.stream());
                    }
                }
                case SUM_MIN_MAX_SALARY -> {
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        sumMinMaxOfSalary(Professions);
                    }
                }
                case GROUPING -> {
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        grouping(Professions);
                    }
                }
                case SUMMARY_STATISTIC -> {
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        showSummaryStatistic(Professions);
                    }
                }
                case WORK_SUM -> {
                    if (Professions.isEmpty()){
                        System.out.println("*Firstly add profession!");
                    }else {
                        System.out.println("*Total number of working hours of employees - " + summaryWorkHours(Professions));
                    }
                }
                case EXIT -> { // Выход из программы
                    System.out.println("*The program is end.");
                    menu = false;
                }
                default -> System.out.println("*Error input.");
            }
        }
    }

    /**
     * This method summary all hours by employees.
     * @param professionArrayList List with professions.
     * @return Number of working hours of employees.
     */
    public static Integer summaryWorkHours(ArrayList<Profession> professionArrayList){
        return professionArrayList.stream().reduce(0, (x, y) -> x + y.getHours(), Integer::sum);
    }

    /**
     * This method collects statistics on professions based on salary.
     * @param professionArrayList List with professions.
     */
    public static void showSummaryStatistic(ArrayList<Profession> professionArrayList){
        IntSummaryStatistics summaryStatistics = professionArrayList.stream().
                collect(Collectors.summarizingInt(Profession::getSalary));
        System.out.println("\n" + summaryStatistics + "\n");
    }

    /**
     * This method groups professions by status.
     * @param professionArrayList List with professions.
     */
    public static void grouping(ArrayList<Profession> professionArrayList){
        Map<String, List<Profession>> stringListMap = professionArrayList.stream().
                collect(Collectors.groupingBy(Profession::getStatus));
        for (Map.Entry<String, List<Profession>> professions : stringListMap.entrySet()){
            System.out.println("***The group - " + professions.getKey() + "***" + "\n*Number of professions - \n" +
                    professions.getValue().size());
            for (Profession profession : professions.getValue()){
                System.out.println(profession);
            }
            System.out.println();
        }
    }

    /**
     * This method sums up the maximum and minimum salary values for professions.
     * @param professionArrayList List with professions.
     */
    public static void sumMinMaxOfSalary(ArrayList<Profession> professionArrayList){
        Optional<Integer> min = professionArrayList.stream().map(Profession::getSalary).min(Integer::compare);
        Optional<Integer> max = professionArrayList.stream().map(Profession::getSalary).max(Integer::compare);
        if (min.isPresent() && max.isPresent()){
            long sum = min.get() + max.get();
            System.out.println("*The sum of the maximum and minimum elements of list: " + sum);
        }else {
            System.out.println("*Firstly add profession!");
        }
    }

    /**
     * This method delete duplication in list of professions.
     * @param professionStream Created a stream of professions.
     * @return List without duplication.
     */
    public static ArrayList<Profession> deleteDuplication(Stream<Profession> professionStream){
        System.out.println("*Now, list stores unique values");
        return professionStream.distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * This method filters the value in the worksheet by the salary parameter and outputs those whose values
     * are greater than the one entered by the user.
     * @param professions List with professions.
     */
    public static void filterSalary(ArrayList<Profession> professions){
        int money = checkInputSalary();
        System.out.println("The number of such records: " + professions.stream()
                .filter(profession -> profession.getSalary() > money).count());
        if (professions.stream().anyMatch(profession -> profession.getSalary() > money)){
            System.out.println("*Professions are sorted");
            showProfession(professions.stream().filter(profession -> profession.getSalary() > money));
        }
    }

    /**
     * This method deletes the number of profession in list.
     * @param professions List with professions.
     */
    public static void deleteProfession(ArrayList<Profession> professions){
        showProfession(professions.stream());
        int numberProfession = checkNumberProfessionDelete(professions.size());
        professions.remove(numberProfession);
        System.out.println("*oop7.Profession is deleted.");
    }

    /**
     * This method ascending sort list of professions.
     * @param professions List with professions.
     */
    public static void sortingUpProfession(ArrayList<Profession> professions){
        showProfession(professions.stream());
        int numberParam = checkNumberParamSort();
        ProfessionOption professionOption = ProfessionOption.values()[numberParam - 1];
        switch (professionOption){
            case SALARY -> professions.sort(Comparator.comparingInt(Profession::getSalary));
            case HOURS -> professions.sort(Comparator.comparingInt(Profession::getHours));
            case EXPERIENCE -> professions.sort(Comparator.comparingDouble(Profession::getExperience));
            case NAME -> professions.sort(Comparator.comparing(Profession::getName));
            case STATUS -> professions.sort(Comparator.comparing(Profession::getStatus));
        }
        System.out.println("*Professions are sorted.");
    }

    /**
     * This method edits the profession by the parameter selected by the user.
     * @param professions List with professions.
     */
    public static void editProfession(ArrayList<Profession> professions){
        showProfession(professions.stream());
        int numberProfession = checkNumberProfession(professions.size());
        int numberParam = checkNumberParam();
        ProfessionOption professionOption = ProfessionOption.values()[numberParam - 1];
        switch (professionOption) {
            case SALARY -> professions.get(numberProfession).setSalary(checkInputSalary());
            case HOURS -> professions.get(numberProfession).setHours(checkInputHours());
            case EXPERIENCE -> professions.get(numberProfession).setExperience(checkInputExperience());
            case NAME -> professions.get(numberProfession).setName(checkInputLine());
        }
        System.out.println("*oop7.Profession is edited.");
    }

    /**
     * This method show the list of professions.
     * @param professionStream Created a stream of professions.
     */
    public static void showProfession(Stream<Profession> professionStream){
        List<Profession> professionList = professionStream.toList();
        IntStream.range(0, professionList.size()).mapToObj(index -> String.format("\n***oop7.Profession Number - "
                + (index + 1) + "***\n" + professionList.get(index).toString())).forEach(System.out::println);
    }

    /**
     * This method add new element by class 'oop7.Profession' in list.
     * @param flag A parameter meaning for adding a profession by default.
     * @return New element of class 'oop7.Profession'
     */
    public static Profession addProfession(boolean flag){
        if (flag){
            return new Profession();
        }else {
            int salary = checkInputSalary();
            int hours = checkInputHours();
            double experience = checkInputExperience();
            String name = checkInputLine();
            return new Profession(salary, hours, experience, name);
        }
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
     * This function check number to choose profession to delete.
     * @param length The length of list with professions.
     * @return The positive digit with number of profession.
     */
    public static int checkNumberProfessionDelete(int length){
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Input the number of profession would you like to delete: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Input the number of profession would you like to delete: ");
                number.next();
            }
            point = number.nextInt();
            if (point <= 0) {
                point = -1;
                System.out.println("*Input error, try again.");
            }
        } while (point > length);
        return point - 1;
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