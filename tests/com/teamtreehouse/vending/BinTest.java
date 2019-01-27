package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {

    private Bin bin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test
    public void putWrongItemInBin() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot restock Apple with Orange");
        bin.restock("Apple", 2, 10, 20);
        bin.restock("Orange", 1, 10, 20);
    }

    @Test
    public void shouldReturnZeroPriceIfEmpty() {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() {
        assertNull(bin.getItemName());
    }

    @Test
    public void willNotAllowOverstockingBin() throws Exception {
        int slots = bin.getAvailableSlots();
        String thrownExceptionMessage = "There are only " + slots + " spots left";

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(thrownExceptionMessage);
        bin.restock("Apple", bin.getAvailableSlots() + 1, 10, 20);
    }
}