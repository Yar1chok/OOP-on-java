package oop8;

import java.util.concurrent.Callable;

/**
 * Creates students to take the exam.
 */
public class Student implements Callable<ResultExam> {
    /**
     * Delay for the method "call".
     */
    private static final long STUDENT_DELAY = 800;
    /**
     * Name of student.
     */
    private final String name;
    /**
     * Teaching desk.
     */
    private final Desk desk;

    /**
     * Creates student instance.
     * @param name Name of student.
     * @param desk Teaching desk.
     */
    public Student(String name, Desk desk){
        this.name = name;
        this.desk = desk;
    }

    /**
     * Gets name of student.
     * @return The name of student.
     */
    public String getName() {
        return name;
    }

    /**
     * This method starts streams and outputs the student's exam result
     * @return oop8.Student's number, result and number of attempts
     */
    @Override
    public ResultExam call(){
        int attemptCount = 0;
        ResultAttempt resultAttempt;
        do {
            attemptCount++;
            try {
                Thread.sleep(STUDENT_DELAY);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            resultAttempt = desk.DoAttempt();
            System.out.format("%s made an attempt with result %s. Attempts: %d\n", name, resultAttempt.toString(),
                    attemptCount);
        }while (resultAttempt == ResultAttempt.RETRY);
        return new ResultExam(this, resultAttempt, attemptCount);
    }
}
