package regexmatchers;

import regexmatchers.interfaces.UserAnswerReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberReader implements UserAnswerReader<String> {
    private static final String PHONE_NUMBER_REGULAR_EXPRESSION = "^(?<areaCode>\\d{3})-?(?<exchangeCode>\\d{3})-?(?<lineNumber>\\d{4})$";

    @Override
    public boolean isValidInput(String input) {
        return !Pattern.matches(PHONE_NUMBER_REGULAR_EXPRESSION, input);
    }

    @Override
    public String parseInput(String input) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String areaCode = matcher.group("areaCode");
            String exchangeCode = matcher.group("exchangeCode");
            String lineNumber = matcher.group("lineNumber");

            return String.format("(%s)-%s-%s", areaCode, exchangeCode, lineNumber);
        }

        throw new IllegalArgumentException("Input does not contain a valid phone number");
    }
}
