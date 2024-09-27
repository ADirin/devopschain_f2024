import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestTest {

    // Create an instance of the Test class
    Calculator testInstance = new Calculator();

    @Test
    public void testAddition() {
        // Test case 1: Positive numbers
        int num1 = 5;
        int num2 = 10;
        int expectedSum = 15;

        // Call the addNumbers method using the instance
        int actualSum = testInstance.addNumbers(num1, num2);  // Changed to use instance
        assertEquals(expectedSum, actualSum);

        // Test case 2: Negative numbers
        num1 = -5;
        num2 = -10;
        expectedSum = -15;

        actualSum = testInstance.addNumbers(num1, num2);  // Changed to use instance
        assertEquals(expectedSum, actualSum);

        // Test case 3: Mixed numbers
        num1 = -5;
        num2 = 10;
        expectedSum = 5;

        actualSum = testInstance.addNumbers(num1, num2);  // Changed to use instance
        assertEquals(expectedSum, actualSum);
    }
}
