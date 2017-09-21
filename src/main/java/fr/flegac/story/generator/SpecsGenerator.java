package fr.flegac.story.generator;

import fr.flegac.story.generator.group.GroupGenerator;

public class SpecsGenerator extends Generator {
  private static String TEMPLATE;

  static {
    TEMPLATE = convertStreamToString(ClassLoader.getSystemClassLoader().getResourceAsStream("template/specs.txt"));
  }

  public SpecsGenerator(final String title, final Class<?>... sources) {
    super(TEMPLATE);

    final StringBuilder builder = new StringBuilder();
    for (final Class<?> source : sources) {
      builder.append(new GroupGenerator(source).generate());
    }

    final String stories = "";
    final String blocks = builder.toString();

    config("title", title);
    config("stories", stories);
    config("blocks", blocks);
  }

}
