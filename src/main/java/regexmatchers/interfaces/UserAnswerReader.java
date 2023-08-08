package regexmatchers.interfaces;

public interface UserAnswerReader<T> {
    /**
     * Returns true if the input is an valid answer
     */
    boolean isValidInput(String input);

    /**
     * Parses the user answer and returns its value
     */
    T parseInput(String input);
}
