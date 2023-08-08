package regexmatchers;

import regexmatchers.interfaces.UserAnswerReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailReader implements UserAnswerReader<String> {
    private static final String EMAIL_REGULAR_EXPRESSION = "\\b([\\w.]{1,32}@(?:gmail\\.com|yahoo\\.com|bing\\.com))\\b";

    @Override
    public boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile(EMAIL_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(input);

        int numberOfMatches = 0;
        while (matcher.find()) {
            numberOfMatches++;
        }

        return numberOfMatches != 1;
    }

    @Override
    public String parseInput(String input) {
        Pattern pattern = Pattern.compile(EMAIL_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(0);
        }

        throw new IllegalArgumentException("Input does not contain a valid email");
    }
}
