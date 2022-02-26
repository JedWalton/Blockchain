package blockchain;

import junit.framework.TestCase;
import org.junit.Test;

public class BlockchainTest extends TestCase {

    @Test
    public void test() {
        BlockchainTest blockchainTest = new BlockchainTest();

        int result = blockchainTest.countTestCases();

        assertEquals(1, result);
    }

}