package se.mns;

import static org.assertj.swing.launcher.ApplicationLauncher.application;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestGUI extends AssertJSwingJUnitTestCase {

  @Override
  protected void onSetUp() throws Exception {
    // without arguments
    application(Main.class).start();
  }

  private static FrameFixture window;

  @BeforeAll
  public static void setup() {
    GraphicalUserInterface frame = GuiActionRunner.execute(() -> new GraphicalUserInterface());
    window = new FrameFixture(frame);
    window.show(); // shows the frame to test
  }

  @Test
  public void shouldShowErrorWhenPhoneIsEmpty() {
    window.textBox("nameText").enterText("marten hernebring");
    window.button("addButton").click();
    window.label("error").requireText("Skriv in ditt telefonnummer med enbart siffror.");
  }


  @AfterAll
  public static void tear() {
    window.cleanUp();
  }
}