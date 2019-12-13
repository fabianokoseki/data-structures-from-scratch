package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashtableTest {

    @Test
    public void testPutGet() {

        Hashtable<String, String> table = new Hashtable<>();

        table.put("test", "test2");

        assertEquals("test2", table.get("test"));

    }

    @Test
    public void testPutReplace() {

        Hashtable<String, String> table = new Hashtable<>();

        table.put("test", "test2");
        table.put("test", "replaced");

        assertEquals("replaced", table.get("test"));

    }

    @Test
    public void testGetHashtableSize() {
        Hashtable<String, String> table = new Hashtable<>();

        table.put("test", "test");
        table.put("test1", "test1");
        table.put("test2", "test2");
        table.put("test3", "test3");

        assertEquals(4, table.getHashtableSize());
    }

    @Test
    public void testAnArrayIndexOutOfBoundsExceptionWillNotBeThrownBecauseTheHashFunctionKnowsHowToDealWithNegativeHashCode() {
        Hashtable<String, String> table = new Hashtable<>();

        // The hashcode for "nonExistentKey" results in a negative integer
        table.put("nonExistentKey", "test");

        assertEquals("test", table.get("nonExistentKey"));
    }

    @Test
    public void testAfterRemovingOneElementInTheMiddleOfTheLinkedListTheOthersRemainIntact() {

        Hashtable<String, String> table = new Hashtable<>();

        table.put("test", "test");
        table.put("NonExistentKey", "test2");
        table.put("test1", "test1");
        table.put("test2", "test2");
        table.put("test3", "test3");

        assertEquals("test", table.get("test"));
        assertEquals("test1", table.get("test1"));
        assertEquals("test2", table.get("test2"));
        assertEquals("test3", table.get("test3"));

        table.remove("NonExistentKey");

        assertEquals("test", table.get("test"));
        assertEquals("test1", table.get("test1"));
        assertNull(table.get("NonExistentKey"));
        assertEquals("test3", table.get("test3"));

    }

    @Test
    public void testAfterRemovingTheElementThatIsTheHeadNodeTheRemainingNodesWillRemainIntact() {

        Hashtable<String, String> table = new Hashtable<>();

        table.put("test", "test");
        table.put("test1", "test1");
        table.put("test2", "test2");
        table.put("test3", "test3");

        assertEquals("test", table.get("test"));
        assertEquals("test1", table.get("test1"));
        assertEquals("test2", table.get("test2"));
        assertEquals("test3", table.get("test3"));

        table.remove("test3");

        assertEquals("test", table.get("test"));
        assertEquals("test1", table.get("test1"));
        assertEquals("test2", table.get("test2"));
        assertNull(table.get("test3"));

    }

    @Test
    public void testRemovingANonExistentKeyWillReturnNull() {
        Hashtable<String, String> table = new Hashtable<>();

        table.put("test", "test");

        assertNull(table.remove("NonExistentKey"));
    }

    @Test
    public void testHashtableWillDoubleItsCapacityWhenLoadFactorIsReached() {
        Hashtable<String, String> table = new Hashtable<>();

        table.put("test", "test");
        table.put("test1", "test1");
        table.put("test2", "test2");
        table.put("test3", "test3");
        table.put("test4", "test4");
        table.put("test5", "test5");
        table.put("test6", "test6");

        assertEquals(20, table.getBucketSize());
    }

}
