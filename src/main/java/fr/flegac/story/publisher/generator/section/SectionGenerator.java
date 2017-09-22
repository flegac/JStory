package fr.flegac.story.publisher.generator.section;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import fr.flegac.story.Story;
import fr.flegac.story.publisher.Publisher;
import fr.flegac.story.publisher.generator.Generator;
import fr.flegac.story.publisher.generator.story.StoryDTO;

public class SectionGenerator extends Generator<SectionDTO> {
  private final Publisher publisher;

  public SectionGenerator(final Publisher publisher, final String template) {
    super(template);
    this.publisher = publisher;
  }

  @Override
  protected void configure(final SectionDTO input) {
    config("title", input.title());
    config("story", stories(input.klass));
  }

  private List<String> stories(final Class<?> klass) {
    final List<String> stories = new LinkedList<>();

    for (final Story story : klass.getAnnotationsByType(Story.class)) {
      final StoryDTO storyDTO = new StoryDTO(story, klass);
      stories.add(publisher.storyGenerator.generate(storyDTO));
    }

    for (final Method method : klass.getDeclaredMethods()) {
      for (final Story story : method.getAnnotationsByType(Story.class)) {
        final StoryDTO storyDTO = new StoryDTO(story, method);
        stories.add(publisher.storyGenerator.generate(storyDTO));
      }
    }
    return stories;
  }

}
