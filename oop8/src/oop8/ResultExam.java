package oop8;

/**
 * Represents the exam result of a particular student.
 */
public class ResultExam {
    /**
     * Instance by student.
     */
    private final Student student;

    /**
     * The current result of the student's attempt.
     */
    private final ResultAttempt resultAttempt;

    /**
     * Total number of attempts.
     */
    private final int attempt;

    /**
     * Stores the students' exam result.
     * @param student oop8.Student instance.
     * @param resultAttempt The result of attempt.
     * @param attempt The count of attempts.
     */
    public ResultExam(Student student, ResultAttempt resultAttempt, int attempt){
        this.student = student;
        this.resultAttempt = resultAttempt;
        this.attempt = attempt;
    }

    /**
     * Gets student instance.
     * @return oop8.Student instance.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets result of attempt.
     * @return Result of attempt.
     */
    public ResultAttempt getResultAttempt() {
        return resultAttempt;
    }

    /**
     * Gets the total number of attempts.
     * @return The total number of attempts.
     */
    public int getAttempt() {
        return attempt;
    }

    /**
     * The method returns data as a string.
     * @return Data as a string.
     */
    @Override
    public String toString() {
        return "*oop8.Student - " + student.getName() +
                ", *Result - " + resultAttempt.toString() +
                ", *Attempt - " + attempt;
    }
}
