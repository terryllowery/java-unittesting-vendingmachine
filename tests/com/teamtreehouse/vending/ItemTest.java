package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    private Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item("Apple", 10, 20);
    }


    @Test
    public void getWholesalePriceShouldByCorrectFromConstructor() {
        assertEquals(10, item.getWholesalePrice());
    }

    @Test
    public void getRetailPriceShouldByCorrectFromConstructor() {
        assertEquals(20, item.getRetailPrice());
    }

}