import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/***
 * A number of unit tests to test functionality given a number of inputs
 */
class CollectionHandlerTest {
    // NB: Tests assume JUnit 5.8.1 is in the project classpath

    /***
     * Tests that when the correct input is provided, the function provides the expected output
     */
    @Test
    void testValidInput() {
        String validInput = "1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31";
        CollectionHandler listOfNumbers = new CollectionHandler();
        Collection<Integer> collectResult = listOfNumbers.collect(validInput);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", listOfNumbers.summarizeCollection(collectResult));
    }

    /***
     * When empty input is provided, an empty string should be returned.
     */
    @Test
    void testEmptyInput() {
        String validInput = "";
        CollectionHandler listOfNumbers = new CollectionHandler();
        Collection<Integer> collectResult = listOfNumbers.collect(validInput);
        assertEquals(listOfNumbers.summarizeCollection(collectResult), "");
    }

    /***
     * When empty input is provided, an empty string should be returned.
     */
    @Test
    void testNullInput() {
        String nullInput = null;
        CollectionHandler listOfNumbers = new CollectionHandler();
        assertThrows(NullPointerException.class, () -> listOfNumbers.collect(nullInput));
    }
    
    /***
     * A parameterised unit test to ensure that when a number of incorrect inputs are provided,
     * the function throws a NumberFormatException
     *
     * @param invalidInput an array that contains a list of invalid inputs
     */
    @ParameterizedTest
    @CsvSource({"'1, x, 3, 5 ,dd'", "'1, , , 5 ,dd'",})
    void testWithInvalidInputs(String invalidInput) {
        CollectionHandler listOfNumbers = new CollectionHandler();
        assertThrows(NumberFormatException.class, () -> listOfNumbers.collect(invalidInput));
    }
}