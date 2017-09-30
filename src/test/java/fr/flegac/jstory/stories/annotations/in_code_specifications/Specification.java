package fr.flegac.jstory.stories.annotations.in_code_specifications;

import org.junit.Test;
import fr.flegac.jstory.annotations.Epic;
import fr.flegac.jstory.annotations.Story;

@Epic(why = "define specifications",
      who = "developper",
      what = "associate java annotations to test classes and methods")
public class Specification {

  @Test
  @Story(why = "define epic user stories",
         who = "developper",
         what = "use @Epic anotation on test classes")
  public void testEpics() throws Exception {
    // give this class use @Epic annotation
    // when this class is compiled
    // then no error occurs
  }

  @Test
  @Story(why = "define basic user stories",
         who = "developper",
         what = "use @Story anotation on test methods")
  public void testStories() throws Exception {
    // give this class use @Story annotation
    // when this class is compiled
    // then no error occurs
  }

}
