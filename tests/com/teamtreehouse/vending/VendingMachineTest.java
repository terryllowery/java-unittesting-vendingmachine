package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    public class NotifierSub implements Notifier {

        @Override
        public void onSale(Item item) {
            return;
        }
    }
    @Before
    public void setUp() throws Exception {
        Notifier notifier = new NotifierSub();
        vendingMachine = new VendingMachine(notifier, 10, 6, 10);
        vendingMachine.restock("A1", "Apple", 10, 10, 20);
    }

    @Test
    public void vendingWhenStockedReturnsItem() throws Exception{
        vendingMachine.addMoney(20);

        Item item = vendingMachine.vend("A1");

        assertEquals("Apple", item.getName());
    }

    @Test
    public void vendIncrementsRunningSalesTotal() throws Exception {
        vendingMachine.addMoney(20);
        Item item = vendingMachine.vend("A1");

        assertEquals(20, vendingMachine.getRunningSalesTotal());
    }

}