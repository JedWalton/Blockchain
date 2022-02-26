package blockchain;

import junit.framework.TestCase;
import org.junit.Test;

public class MainTest extends TestCase {

    @Test
    public void test() {
        BlockchainTest mainTest = new BlockchainTest();

        int result = mainTest.countTestCases();

        assertEquals(1, result);
    }
}