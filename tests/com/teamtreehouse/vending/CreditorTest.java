package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {

    private Creditor creditor;
    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();

    }

    @Test
    public void addingFundsIncrementsAvailFunds() {
        // Arrange



        // Act
        creditor.addFunds(25);
        creditor.addFunds(25);

        // Assert
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() {
        // Arrange
        creditor.addFunds(10);

        // Act
        int refund = creditor.refund();

        // Assert
        assertEquals(10, refund);
    }

    @Test
    public void refundingRemovesAllAvailableFunds() {
        // Arrange
        creditor.addFunds(10);

        // Act
        creditor.refund();

        // Assert
        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test(expected = NotEnoughFundsException.class)
    public void deductFromAvailableCreditWhenZeroNotAllowed() throws Exception {
        creditor.deduct(10);
    }

    @Test(expected = NotEnoughFundsException.class)
    public void deductFromAvailableCreditMoreThanFundsAvailable() throws Exception {
        creditor.addFunds(10);
        creditor.deduct(20);
    }
}