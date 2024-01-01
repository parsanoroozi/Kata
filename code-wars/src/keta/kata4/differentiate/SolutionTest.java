package differentiate;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.math.BigInteger;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {
    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("12"),  Equation.differentiate("12x+2", 3));
        assertEquals(new BigInteger("5"),   Equation.differentiate("x^2-x", 3));
        assertEquals(new BigInteger("-20"), Equation.differentiate("-5x^2+10x+4", 3));
    }
}