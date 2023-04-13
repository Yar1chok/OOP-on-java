package oop8;/*
Смолянинов Ярослав, гр.КИ21-17/2Б, Вариант - 8 (18), работа с многопоточностью.
Студенты (потоки) сдают экзамен, возвращается результаты экзамена.
 */
import java.util.List;
import java.util.Scanner;

/**
 * The entry point class.
 */
public class Main {
    /**
     * The entry point method.
     */
    public static void main(String[] args) {
        System.out.println("***Menu***");
        int linked = checkInput();
        Classroom classroom = new Classroom();
        //noinspection InfiniteLoopStatement
        while (true){
            System.out.println("\n***Exam started***\n");
            List<ResultExam> resultExams = classroom.acceptedExam(linked);
            System.out.println();
            resultExams.forEach(System.out::println);
            try {
                //noinspection BusyWait
                Thread.sleep(7000);
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    /**
     * This function check input on positive digit.
     * @return The positive digit.
     */
    public static int checkInput(){
        Scanner number = new Scanner(System.in);
        int point;
        do {
            System.out.print("*Enter a positive number: ");
            while (!number.hasNextInt()) {
                System.out.println("*Input error, try again.");
                System.out.print("*Enter a positive number: ");
                number.next();
            }
            point = number.nextInt();
        } while (point <= 0);
        return point;
    }
}