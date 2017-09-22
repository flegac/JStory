package fr.flegac.story.publisher.generator.story;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
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

  public List<String> scenario() {
    return new LinkedList<>();
  }
}
