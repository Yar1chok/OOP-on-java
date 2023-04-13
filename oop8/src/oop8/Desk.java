package oop8;

import java.util.Random;

/**
 * Creates "thread" as student.
 */
public class Desk {
    /**
     * Delay for the method "DoAttempt".
     */
    private static final long ATTEMPT_DELAY = 500;

    /**
     * Instance by random.
     */
    private final Random random;

    /**
     * Creates desk instance.
     */
    public Desk(){
        this.random = new Random();
    }

    /**
     * The student attempts to pass the exam and returns the result of the attempt.
     * @return Result of the attempt.
     */
    public ResultAttempt DoAttempt(){
        synchronized (random){
            try {
                Thread.sleep(ATTEMPT_DELAY);
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            int index = random.nextInt(ResultAttempt.class.getEnumConstants().length);
            return ResultAttempt.class.getEnumConstants()[index];
        }
    }
}
