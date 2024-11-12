import java.util.Collection;

/***
 * This interface defines a contract for classes to implement a collect method
 * that takes a string input of numbers and returns them as an Integer Collection
 */
public interface NumberRangeSummarizer{
    Collection<Integer> collect(String input); // Collection of inputs
}