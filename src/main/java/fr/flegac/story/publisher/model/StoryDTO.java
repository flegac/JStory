package fr.flegac.story.publisher.model;

import java.lang.reflect.Method;
import fr.flegac.story.Epic;
import fr.flegac.story.Story;

public class StoryDTO {
  private final String who;
  private final String what;
  private final String why;
  public String test;

  public StoryDTO(final Epic epic, final Class<?> testClass) {
    this(epic.why(), epic.who(), epic.what(), testClass.getSimpleName() + ".class");
  }

  public StoryDTO(final Story story, final Method testMethod) {
    this(story, testMethod.getDeclaringClass().getSimpleName() + "." + testMethod.getName() + "()");
  }

  private StoryDTO(final Story story, final String test) {
    this(story.why(), story.who(), story.what(), test);
  }

  private StoryDTO(final String why, final String who, final String what, final String test) {
    super();
    if (why.trim().isEmpty()) {
      throw new RuntimeException("story.why is empty : " + test);
    }
    if (who.trim().isEmpty()) {
      throw new RuntimeException("story.who is empty : " + test);
    }
    if (what.trim().isEmpty()) {
      throw new RuntimeException("story.what is empty : " + test);
    }

    this.why = why;
    this.who = who;
    this.what = what;
    this.test = test;
  }

  public String getTest() {
    return test;
  }

  public String getWhat() {
    return what;
  }

  public String getWho() {
    return who;
  }

  public String getWhy() {
    return why;
  }
}
