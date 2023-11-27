package TPL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class syntaxAnalysis {
    public static boolean syntaxAnalysis(String lexicalResult) {
        // Check if lexical analysis passed
        if (lexicalResult.contains("<error>")) {

            return false; // If lexical analysis failed, syntax analysis is not applicable
        }

        // Define a simple syntax rule based on the expected lexical result
        String syntaxRegex = "<data_type> <identifier> <assignment_operator> <value> <delimiter>";
        Pattern pattern = Pattern.compile(syntaxRegex);

        // Use a Matcher to find matches in the input code
        Matcher matcher = pattern.matcher(lexicalResult);

        // Check if there is at least one match
        return matcher.find();
    }
}
