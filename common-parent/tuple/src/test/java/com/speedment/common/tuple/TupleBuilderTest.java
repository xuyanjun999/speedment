/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.speedment.common.tuple;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Per Minborg
 */
public class TupleBuilderTest {

    @Test
    public void testBuilder() {
        final Tuple3<Integer, String, Long> expected = Tuples.of(1, "Olle", Long.MAX_VALUE);
        final Tuple3<Integer, String, Long> actual = TupleBuilder.builder().add(1).add("Olle").add(Long.MAX_VALUE).build();
        assertEquals(expected, actual);
        
        Tuples.of(1,3,4,4,"Arne");
        
        TupleBuilder.builder().add(1).add("Arne").build();

    }

}
