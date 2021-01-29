package se.mns;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class TestMain {

    @Test
    public void printHelloWorld() {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.main(null);
        assertEquals("Hello World!" + System.lineSeparator(), outputStreamCaptor.toString());
        System.setOut(standardOut);
    }

}
