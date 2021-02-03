package se.mns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.awt.Robot;

public class TestGUI {
  Robot bot;

  @BeforeAll
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
    //TODO
  }
}
