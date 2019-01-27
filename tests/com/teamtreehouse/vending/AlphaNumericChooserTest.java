package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        // Act
         AlphaNumericChooser.Location location = chooser.locationFromInput("B4");

        // Assert
        assertEquals("proper row", 1, location.getRow());
        assertEquals("proper column",3, location.getColumn());
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingWrongLocationIsNotAllowed() throws Exception {
        chooser.locationFromInput("ZZ");

    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargerThenMaxNotAllowed() throws Exception {
        chooser.locationFromInput("B99");
    }

    @Test
    public void constructingLargerThenAllowedAlphaNumericNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Maximum rows supported is 26");
        chooser = new AlphaNumericChooser(27, 10);
    }
}