package fr.flegac.story.publisher.model;

import java.lang.reflect.Method;
import fr.flegac.story.Story;

public class StoryDTO {
  public Story story;
  public String test;

  public StoryDTO(final Story story, final Class<?> testClass) {
    super();
    this.story = story;
    this.test = testClass.getSimpleName() + ".class";
  }

  public StoryDTO(final Story story, final Method testMethod) {
    super();
    this.story = story;
    this.test = testMethod.getDeclaringClass().getSimpleName() + "." + testMethod.getName() + "()";
  }

  public String getTest() {
    return test;
  }

  public String getWhat() {
    return story.what();
  }

  public String getWho() {
    return story.who();
  }

  public String getWhy() {
    return story.why();
  }
}
