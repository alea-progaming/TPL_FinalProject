package TPL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lexicalAnalysis {
    private String code;
    public lexicalAnalysis(String code) {
        this.code = code;
    }
        public String analyze() {
            String dataTypeRegex = "\\b(int|double|char|String)\\b";
            String assignmentOperatorRegex = "=";
            String delimiterRegex = ";";
            String valueRegex = "\\b(\\d+|\"[^\"]*\"|'[^']*')\\b";
            String identifierRegex = "\\b[a-zA-Z_]\\w*\\b";
            // Combine the regular expressions into a single pattern
            String combinedRegex = String.format("(%s)|(%s)|(%s)|(%s)|(%s)", dataTypeRegex, assignmentOperatorRegex,
                    delimiterRegex, valueRegex, identifierRegex);
            Pattern pattern = Pattern.compile(combinedRegex);

            // Use a StringBuilder to store the result
            StringBuilder result = new StringBuilder();

            // Use a Matcher to find matches in the input code
            Matcher matcher = pattern.matcher(code);
            while (matcher.find()) {
                String match = matcher.group();

                // Categorize the token based on the matched pattern
                if (match.matches(dataTypeRegex)) {
                    result.append("<data_type> ");
                } else if (match.equals("=")) {
                    result.append("<assignment_operator> ");
                } else if (match.equals(";")) {
                    result.append("<delimiter> ");
                } else if (match.matches(valueRegex)) {
                    result.append("<value> ");
                } else if (match.matches(identifierRegex)) {
                    result.append("<identifier> ");
                }
            }

            return result.toString().trim();

        }
}
