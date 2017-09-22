package fr.flegac.story.publisher.generator.story;

import java.lang.reflect.Method;
import fr.flegac.story.Story;

public class StoryDTO {
  public Story story;
  public String test;

  public StoryDTO(final Story story, final Class<?> klass) {
    super();
    this.story = story;
    this.test = klass.getSimpleName() + ".class";
  }

  public StoryDTO(final Story story, final Method method) {
    super();
    this.story = story;
    this.test = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
  }

  public StoryDTO(final Story story, final String test) {
    super();
    this.story = story;
    this.test = test;
  }

}
