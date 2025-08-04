/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;

/**
 * Tests for static methods of Graph.
 * <p>
 * To facilitate testing multiple implementations of Graph, instance methods are
 * tested in GraphInstanceTest.
 */
public class GraphStaticTest {

    // Testing strategy
    //   empty()
    //     no inputs, only output is empty graph
    //     observe with vertices()

    @Test
    void testAssertionsEnabled() {
        assertThrows(AssertionError.class, () -> {
            assert false;  // make sure assertions are enabled with VM argument: -ea
        });
    }

    @Test
    void testEmptyVerticesEmpty() {
        assertEquals(Collections.emptySet(),
                Graph.empty().vertices(), "expected empty() graph to have no vertices");
    }

    // TODO test other vertex label types in Problem 3.2

}
