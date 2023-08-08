package regexmatchers;

import regexmatchers.interfaces.UserAnswerReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNameReader implements UserAnswerReader<FullNameReader.FullName> {
    private static final String FULL_NAME_REGULAR_EXPRESSION = "^([A-Z][a-z]+) ([A-Z][a-z]+$)";

    @Override
    public boolean isValidInput(String input) {
        return !Pattern.matches(FULL_NAME_REGULAR_EXPRESSION, input);
    }

    @Override
    public FullName parseInput(String input) {
        Pattern pattern = Pattern.compile(FULL_NAME_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String firstName = matcher.group(1);
            String lastName = matcher.group(2);
            return new FullName(firstName, lastName);
        }

        throw new IllegalArgumentException("Input does not contain a valid name");
    }

    public static final class FullName {
        private final String firstName;
        private final String lastName;

        public FullName(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "FullName{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
