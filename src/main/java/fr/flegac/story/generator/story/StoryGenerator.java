package fr.flegac.story.generator.story;

import fr.flegac.story.Story;
import fr.flegac.story.generator.Generator;

public class StoryGenerator extends Generator {
  private static String TEMPLATE;

  static {
    TEMPLATE = convertStreamToString(ClassLoader.getSystemClassLoader().getResourceAsStream("template/story.txt"));
  }

  public StoryGenerator(final Story story, final String test) {
    super(TEMPLATE);
    config("who", story.who());
    config("what", story.what());
    config("why", story.why());
    config("test", test);
  }

}
