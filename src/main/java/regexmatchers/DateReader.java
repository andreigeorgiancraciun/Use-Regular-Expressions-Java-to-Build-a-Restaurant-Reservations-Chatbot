package regexmatchers;

import regexmatchers.interfaces.UserAnswerReader;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateReader implements UserAnswerReader<LocalDate> {
    private static final String DATE_REGULAR_EXPRESSION = ".*(?<month>\\d{1,2})(?<dateDelimiter>[./])" +
            "(?<day>\\d{1,2})\\k<dateDelimiter>(?<year>\\d{4})";

    @Override
    public boolean isValidInput(String input) {
        return !Pattern.matches(DATE_REGULAR_EXPRESSION, input);
    }

    @Override
    public LocalDate parseInput(String input) {
        Pattern pattern = Pattern.compile(DATE_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            int month = Integer.parseInt(matcher.group("month"));
            int day = Integer.parseInt(matcher.group("day"));
            int year = Integer.parseInt(matcher.group("year"));
            return LocalDate.of(year, month, day);
        }

        throw new IllegalArgumentException("Input does not contain a valid date");

    }
}
