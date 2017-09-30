package fr.flegac.jstory.stories.annotations.in_code_test_scenarios;

import org.junit.Test;
import fr.flegac.jstory.annotations.Epic;
import fr.flegac.jstory.annotations.Step;
import fr.flegac.jstory.annotations.Story;

@Epic(why = "define test scenarios",
      who = "developper",
      what = "associate java annotations to test classes and methods")
@Step(given = "this class use @Step annotation over the class",
      when = "this class is compiled",
      then = "no error occurs")
public class TestScenarios {

  @Test
  @Story(why = "define test scenarios",
         who = "developper",
         what = "use @Step anotation on test classes")
  @Step(given = "this class use @Step annotation over a method",
        when = "this class is compiled",
        then = "no error occurs")
  public void testEpics() throws Exception {
  }

}
