package se.mns;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMain {
    
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void out() {
        Main.main(null);
        assertEquals("Hello World!"+System.lineSeparator(), outputStreamCaptor.toString());
    }
    
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
