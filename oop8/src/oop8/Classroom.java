package oop8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * This class generated classroom for students.
 */
public class Classroom {
    /**
     * Instance class by desk.
     */
    private final Desk desk;

    /**
     * Create instance classroom.
     */
    public Classroom() {
        desk = new Desk();
    }

    /**
     * Accepts an exam for a given number of students and returns the result when everyone has finished.
     * @param countStudents Count of students.
     * @return List with results of exam by students.
     */
    public List<ResultExam> acceptedExam(int countStudents){
        Student[] student = new Student[countStudents];
        for (int i = 0; i < countStudents; i++){
            student[i] = new Student(String.format("*oop8.Student %d", i + 1), desk);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(countStudents);
        List<Future<ResultExam>> tasks;
        try {
            tasks = executorService.invokeAll(Arrays.asList(student));
        } catch (InterruptedException interruptedException){
            throw new RuntimeException(interruptedException);
        }
        List<ResultExam> resultExams = new ArrayList<>(tasks.size());
        for (Future<ResultExam> task : tasks){
            ResultExam resultExam;
            try {
                resultExam = task.get();
            }catch (InterruptedException | ExecutionException exception){
                throw new RuntimeException(exception);
            }
            resultExams.add(resultExam);
        }
        executorService.shutdown();
        return resultExams;
    }
}
