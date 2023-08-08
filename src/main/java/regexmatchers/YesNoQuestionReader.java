package regexmatchers;

import regexmatchers.interfaces.UserAnswerReader;

import java.util.regex.Pattern;

public class YesNoQuestionReader implements UserAnswerReader<Boolean> {
    private static final String ANSWER_REGULAR_EXPRESSION = "^(?i)(yes|no)$";

    @Override
    public boolean isValidInput(String input) {
        return !Pattern.matches(ANSWER_REGULAR_EXPRESSION, input);
    }

    @Override
    public Boolean parseInput(String input) {
        return input.equalsIgnoreCase("yes");
    }
}
