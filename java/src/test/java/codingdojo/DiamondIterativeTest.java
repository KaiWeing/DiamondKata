package codingdojo;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * These test cases can be used to test-drive a solution to the diamond kata, in an interative manner.
 * Enable only one test case for "Diamond A", one for "Diamond B" and one for "Diamond C" at any one time.
 * The idea is that you iterate towards a full solution. 
 *
 * Instructions:
 * 1. Make the first test for Diamond A (which is failing) pass
 * 2. Remove the '@Ignore' on the next test case. Make it pass too.
 * 3. Replace the '@Ignore' on that test case, (or delete it), and instead enable the following test case
 * 4. keep doing this, always having exactly one enabled test case for each diamond, (A, B, and C) until you've got to the end of the file.
 * At that point you should have a working implementation.
 */
public class DiamondIterativeTest {

    @Test
    public void DiamondD_is_correct_in_all_aspects() {
        assertEquals("   A\n" +
                     "  B B\n" +
                     " C   C\n" +
                     "D     D\n" +
                     " C   C\n" +
                     "  B B\n" +
                     "   A", Diamond.print('D'));
    }
}
