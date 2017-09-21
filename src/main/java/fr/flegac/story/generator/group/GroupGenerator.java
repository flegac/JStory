package fr.flegac.story.generator.group;

import java.lang.reflect.Method;
import fr.flegac.story.Story;
import fr.flegac.story.generator.Generator;
import fr.flegac.story.generator.story.StoryGenerator;

public class GroupGenerator extends Generator {
  private static String TEMPLATE;

  static {
    TEMPLATE = convertStreamToString(ClassLoader.getSystemClassLoader().getResourceAsStream("template/group.txt"));
  }

  public GroupGenerator(final Class<?> source) {
    super(TEMPLATE);
    config("title", splitCamelCase(source.getSimpleName()));
    config("stories", stories(source));
  }

  private String stories(final Class<?> source) {
    final StringBuilder builder = new StringBuilder();
    for (final Story story : source.getAnnotationsByType(Story.class)) {
      final String test = source.getSimpleName() + ".class";
      builder.append(new StoryGenerator(story, test).generate());
    }

    for (final Method method : source.getDeclaredMethods()) {
      for (final Story story : method.getAnnotationsByType(Story.class)) {
        final String test = method.getDeclaringClass().getSimpleName()
            + "." + method.getName() + "()";
        builder.append(new StoryGenerator(story, test).generate());
      }
    }
    final String stories = builder.toString();
    return stories;
  }

}
