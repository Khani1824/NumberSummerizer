import java.util.Collection;

public class Main {
    /***
     * This class tries to create  one instance of the CollectionsHandler method is created the methods collect is called and the input string
     * is passed to create a collection of Integers called collectResult, the collection is then passed through the
     * summarizeCollection and printed. If this fails it results in a NumberFormatException exception.
     */
    public static void main(String[] args) {
        String input = "1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31";
        try {
            CollectionHandler listOfNumbers = new CollectionHandler();
            Collection<Integer> collectResult = listOfNumbers.collect(input); // creates a collection of integers
            System.out.println(listOfNumbers.summarizeCollection(collectResult));
        } catch (NumberFormatException nfe) {
            System.out.printf("Invalid input: %s should contain only numerical values.%n", input); // exception caught when invalid input is provided
        } catch (NullPointerException npe) {
            System.out.println("Invalid input: Input cannot be null");
        } catch (Exception e) {
            System.out.printf("Something has gone wrong, and an exception has been thrown: %s", e.getMessage());
        }
    }
}