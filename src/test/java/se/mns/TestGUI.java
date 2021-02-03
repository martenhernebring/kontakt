package se.mns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.awt.Robot;

public class TestGUI {
  Robot bot;

  @BeforeEach
  void init() {
    try {
      bot = new Robot();
    } catch (AWTException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
  }
  
  @Test
  void testQuit() {
  }
}
