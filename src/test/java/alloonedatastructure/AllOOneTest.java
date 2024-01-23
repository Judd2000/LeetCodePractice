package alloonedatastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AllOOneTest {
    AllOOne test;
    @BeforeEach
    void setUp() {
        this.test = new AllOOne();
    }

    // Functionality tests

    @Test
    void testInc() {
        this.test.inc("Walter");
        assertTrue(this.test.keyLocations.containsKey("Walter"));

        assertEquals("Walter", this.test.getMaxKey());

        String newMaxKey = "Nathaniel";
        this.test.inc("Nathaniel");
        assertTrue(this.test.head.next.keys.containsAll(Arrays.asList("Walter", newMaxKey)));

        this.test.inc(newMaxKey);
        assertFalse(this.test.keyLocations.get("Walter").keys.contains(newMaxKey));
        assertEquals(newMaxKey, this.test.getMaxKey());
        assertEquals(2, this.test.keyLocations.get(newMaxKey).count);
        assertEquals(newMaxKey, this.test.getMaxKey());
        assertEquals("Walter", this.test.getMinKey());

        // Instance where there is a gap between the one that is incrementing and the max key
        this.test.inc("Placeholder");
        this.test.inc(newMaxKey);
        this.test.inc(newMaxKey);
        this.test.inc(newMaxKey);
        this.test.inc("Walter");

        assertFalse(this.test.head.keys.contains("Walter"));
        assertEquals(2, this.test.keyLocations.get("Walter").count);
        assertEquals("Placeholder", this.test.getMinKey());

        // Increment Walter into a space where Nathaniel has passed through
        this.test.inc("Walter");
        assertNotEquals("Walter", this.test.getMaxKey());
        assertEquals(3, this.test.keyLocations.get("Walter").count);
    }

    @Test
    void testDec() {
        String personOne = "I am Person One";
        String personTwo = "I am Person Two";
        String personThree = "I am Person Three";
        String personFour = "I am Person Four";

        this.test.inc(personOne);
        this.test.inc(personTwo);
        this.test.inc(personThree);

        assertTrue(this.test.tail.prev.keys.containsAll(Arrays.asList(personOne, personTwo, personThree)));

        this.test.dec(personOne);

        assertFalse(this.test.tail.keys.contains(personOne));
        assertFalse(this.test.keyLocations.containsKey(personOne));

        this.test.dec(personTwo);
        this.test.inc(personFour);
        this.test.inc(personFour);
        this.test.dec(personThree);

        assertEquals(personFour, this.test.getMinKey());
    }

    @Test
    void leetCodeTestCases() {
//        ["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
//        [[],["hello"],["hello"],[],[],["leet"],[],[]]
        this.test.inc("hello");
        this.test.inc("hello");
        assertEquals("hello", this.test.getMaxKey());
        assertEquals("hello", this.test.getMinKey());

        this.test = new AllOOne();
//        ["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
//        [[],["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]
//        [null,null,null,null,null,null,null,null,"b","a"]
        this.test.inc("a");
        this.test.inc("b");
        this.test.inc("b");
        this.test.inc("b");
        this.test.inc("b");
        this.test.dec("b");
        this.test.dec("b");

        assertEquals("b", this.test.getMaxKey());
        assertEquals("a", this.test.getMinKey());
    }

    // TODO: Implement runtime tests

}
