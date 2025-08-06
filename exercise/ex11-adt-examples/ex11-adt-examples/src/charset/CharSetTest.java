package charset;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CharSetTest {

    // Testing strategy
    //
    // CharSet()
    //   only one test case
    // size()
    //   partition on size: 0, 1, n
    // contains(e)
    //   partition on size: 0, 1, n
    //   partition on e present or not
    // add(e)/remove(e):
    //   partition on size before: 0, 1, n
    //   partition on size after: 0, 1, n
    //   partition on e present or not
    //

    private static Set<Character> empty() {
        return new CharSet3();
    }

    @Test
    void testEmpty() {
        Set<Character> cs = empty();
        assertEquals(0, cs.size());
        assertFalse(cs.contains('z'));
    }

    @Test
    void testAddSingleton() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        assertEquals(1, cs.size());
        assertTrue(cs.contains('b'));
        assertFalse(cs.contains('z'));
    }

    @Test
    void testAddRedundant() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.add('b'); // cs is still {b}
        assertEquals(1, cs.size());
        assertTrue(cs.contains('b'));
        assertFalse(cs.contains('z'));
    }

    @Test
    void testAddPair() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.add('c'); // cs is now {b, c}
        assertEquals(2, cs.size());
        assertTrue(cs.contains('b'));
        assertTrue(cs.contains('c'));
        assertFalse(cs.contains('y'));
    }

    @Test
    void testAddTriple() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.add('c'); // cs is now {b, c}
        cs.add('d'); // cs is now {b, c, d}
        assertEquals(3, cs.size());
        assertTrue(cs.contains('b'));
        assertTrue(cs.contains('c'));
        assertTrue(cs.contains('d'));
        assertFalse(cs.contains('x'));
    }

    @Test
    void testSingletonRemove() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.remove('b'); // cs is now {}
        assertEquals(0, cs.size());
        assertFalse(cs.contains('b'));
        assertFalse(cs.contains('z'));
    }

    @Test
    void testRemoveFromEmptySet() {
        Set<Character> cs = empty();
        cs.remove('a');
        assertEquals(0, cs.size());
        assertFalse(cs.contains('a'));
    }

    @Test
    void testRemoveNonExistentFromMultiElementSet() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.add('c'); // cs is now {b, c}
        int sizeBefore = cs.size();
        cs.remove('d'); // cs is still {b, c}
        assertEquals(sizeBefore, cs.size());
        assertTrue(cs.contains('b'));
        assertTrue(cs.contains('c'));
    }

    @Test
    void testRemoveFromTriple() {
        Set<Character> cs = empty();
        cs.add('b'); cs.add('c'); cs.add('d');
        cs.remove('c');
        assertEquals(2, cs.size());
        assertFalse(cs.contains('c'));
        assertTrue(cs.contains('b'));
        assertTrue(cs.contains('d'));
    }

    @Test
    void testRemoveFromPair() {
        Set<Character> cs = empty();
        cs.add('b'); cs.add('d');
        cs.remove('b');
        assertEquals(1, cs.size());
        assertFalse(cs.contains('b'));
        assertTrue(cs.contains('d'));
    }
}
