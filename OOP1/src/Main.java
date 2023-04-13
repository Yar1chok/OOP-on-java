/*
Смолянинов Ярослав Евгеньевич, КИ21-17/2Б, вариант 18
Работа с текстом. Программа получает текст и результатом алгоритма является массив слов исходного текста, каждое
из которых развернуто.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * Main function, which is the entry point
     */
    public static void main(String[] args) {
        boolean menu = true;
        int flag_input = 0;
        int flag_reverse = 0;
        String line = "";
        String[] result = new String[0];
        while (menu){
            System.out.println("***Menu***");
            System.out.println("*Write 1 to input your text.");
            System.out.println("*Write 2 to create random text.");
            System.out.println("*Write 3 to show your text.");
            System.out.println("*Write 4 to reverse your text.");
            System.out.println("*Write 5 to show reverse text.");
            System.out.println("*Write 6 to exit from program.");
            System.out.print("*Enter an item from the menu: ");
            int point = check_input_menu();
            menu_options menu_option = menu_options.values()[point - 1];
            switch (menu_option){
                case ENTER_TEXT: // Ввод строки
                    line = input_line();
                    flag_input = 1;
                    break;
                case RANDOM_TEXT: // Случайная генерация текста
                    line = random_generation();
                    flag_input = 1;
                case SHOW_TEXT: // Вывод исходного текста
                    if (flag_input == 1){
                        System.out.println(line);
                    }else{
                        System.out.println("*Firstly enter the text!");
                    }
                    break;
                case REVERSE_TEXT: // Разворот строки
                    if (flag_input == 1){
                        result = reverse_text(line);
                        flag_reverse = 1;
                    }else{
                        System.out.println("*Firstly enter the text!");
                    }
                    break;
                case SHOW_REVERSE: // Вывод развернутой строки
                    if (flag_reverse == 1){
                        for (String s : result){
                            System.out.print(s + " ");
                        }
                        System.out.println();
                    }else{
                        System.out.println("*Firstly reverse the text!");
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
     * This function checks the data input by the user for a number
     * @return A number point of menu
     */
    public static int check_input_menu(){
        Scanner number = new Scanner(System.in);
        int point = 0;
        if (number.hasNextInt()){
            point = number.nextInt();
        }else {
            System.out.println("*Input error, try again.");
        }
        return point;
    }

    /**
     * This function get the text input by the user
     * @return Text, accepted by user
     */
    public static String input_line(){ // Ввод строки
        String lines;
        Scanner str = new Scanner (System.in);
        System.out.print("*Write your line: ");
        while (true) {
            lines = str.nextLine(); // Считывание
            if (lines.trim().length() == 0){
                System.out.print("*Line is empty,write your line again: ");
            }else {
                break;
            }
        }
        return lines;
    }

    /**
     * This function generation random text in length, accepted by user
     * @return String with random generation
     */
    public static String random_generation(){ // Генерация текста
        System.out.print("*Choose length of line: ");
        int length = check_input_menu();
        int count = 1;
        String[] english_alphabet = new String[count];
        String[] row = new String[length];
        Random random = new Random();
        for (int i = 'a'; i <= 'z'; i++){
            english_alphabet[count - 1] = String.valueOf((char) i);
            count++;
            english_alphabet = Arrays.copyOf(english_alphabet, count);
        }
        english_alphabet[count - 1] = String.valueOf(' ');
        for (int j = 0; j < length; j++){
            row[j] = english_alphabet[random.nextInt(count)];
        }
        return String.join("", row);
    }

    /**
     * This function reverse source text (Hello - olleH)
     * @param line Accepted or randomly generated string
     * @return Array with reverse words
     */
    public static String[] reverse_text(String line){ // Разворот строки
        StringBuilder new_line = new StringBuilder();
        for (int i = 0; i < line.length(); i++)
            new_line.insert(0, line.charAt(i));
        return new_line.toString().split(" ");
    }
}