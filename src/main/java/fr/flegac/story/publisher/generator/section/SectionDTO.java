package fr.flegac.story.publisher.generator.section;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import fr.flegac.story.Story;
import fr.flegac.story.publisher.Utils;
import fr.flegac.story.publisher.generator.story.StoryDTO;

public class SectionDTO {
  public Class<?> klass;

  public SectionDTO(final Class<?> klass) {
    super();
    this.klass = klass;
  }

  public List<StoryDTO> stories() {
    final List<StoryDTO> stories = new LinkedList<>();

    for (final Story story : klass.getAnnotationsByType(Story.class)) {
      stories.add(new StoryDTO(story, klass));
    }

    for (final Method method : klass.getDeclaredMethods()) {
      for (final Story story : method.getAnnotationsByType(Story.class)) {
        stories.add(new StoryDTO(story, method));
      }
    }
    return stories;
  }

  public String title() {
    return Utils.splitCamelCase(klass.getSimpleName());
  }

}
