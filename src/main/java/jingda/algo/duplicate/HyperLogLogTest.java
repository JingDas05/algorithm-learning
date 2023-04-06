package jingda.algo.duplicate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 */
public class HyperLogLogTest {

    @Test
    public void testHyperLogLog() {
        HyperLogLog hll = new HyperLogLog(8);

        // add some values
        hll.add("hello");
        hll.add("world");
        hll.add("hello world");
        hll.add("foo");
        hll.add("bar");
        hll.add(1);
        hll.add(2);
        hll.add(3);

        // estimate the cardinality
        long estimate = hll.count();
        System.out.println("HyperLogLog estimated cardinality: " + estimate);

        // compare with the actual cardinality
        int actualCardinality = 8;
        assertEquals(actualCardinality, estimate, 2);
    }
}
