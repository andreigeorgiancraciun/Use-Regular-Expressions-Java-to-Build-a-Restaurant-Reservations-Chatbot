package regexmatchers;

import regexmatchers.interfaces.UserAnswerReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberChoiceReader implements UserAnswerReader<Integer> {
    private static final String NUMBER_REGULAR_EXPRESSION = ".*\\b(\\d{1,3})\\b.*";

    @Override
    public boolean isValidInput(String input) {
        return !Pattern.matches(NUMBER_REGULAR_EXPRESSION, input);
    }

    @Override
    public Integer parseInput(String input) {
        Pattern pattern = Pattern.compile(NUMBER_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String number = matcher.group(1);
            return Integer.parseInt(number);

        }

        throw new IllegalArgumentException("Input does not contain a valid number of people");
    }
}
