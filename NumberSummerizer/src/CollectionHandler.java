import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

//TODO: In my ideal solution, input comes in through a constructor, gets validated,
// and then constructor calls `collect` and stores the result in a class variable. `Main` should then only call
// `summarizeCollection` which then uses the class variable. I have, however, gone with the below approach to stick to the
// provided interface (because maybe in a real world example these two functions are in different packages/ logical classes)

/***
 * This class implements the NumberRangeSummarizer interface in which a method that creates a collection when provided with
 * a string input. The String input then produces a comma delimited list of numbers, that groups
 * the numbers into a range when they are sequential.
 */
public class CollectionHandler implements NumberRangeSummarizer {

    /***
     * Takes in a string of integer values and converts it into a collection
     *
     * @param input A list of numbers separated by ", " provided as a string
     * @return A Collection of Integers
     */
    @Override
    public Collection<Integer> collect(String input) {

        // Using StringTokenizer to split input by commas and map each token to an Integer
        return Collections.list(new StringTokenizer(input, ","))
                .stream()
                .map(token -> Integer.parseInt(((String) token).trim()))
                .sorted()
                .collect(Collectors.toList());
    }

    /***
     * Generates a String of sorted, comma seperated, summerized numbers
     *
     * @param input A Collection of Integers
     * @return A String "summary" of the input
     */
    public String summarizeCollection(Collection<Integer> input) {

        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();  // Empty String
        ArrayList<Integer> inputSorted = new ArrayList<>(input);

        int currentNum = inputSorted.get(0);
        int nextNum = currentNum;

        for (int i = 1; i < inputSorted.size(); i++) {
            int nextInList = inputSorted.get(i);

            if (nextInList != nextNum + 1 && currentNum == nextNum) {
                // If the current number in the list is not part of a range grouping, add a comma
                result.append(currentNum).append(", ");
                currentNum = nextInList;
            } else if (nextInList != nextNum + 1) {
                // If the next number in the list is the end of a range grouping, but all numbers before were consecutive,
                // summarize the grouping
                result.append(currentNum).append("-").append(nextNum).append(", ");
                currentNum = nextInList;
            }
            nextNum = nextInList;
        }

        // Append the final range or single number
        if (currentNum == nextNum) {
            result.append(currentNum);
        } else {
            result.append(currentNum).append("-").append(nextNum);
        }

        return result.toString();
    }
}