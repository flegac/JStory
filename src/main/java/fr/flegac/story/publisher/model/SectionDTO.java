package fr.flegac.story.publisher.model;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import fr.flegac.story.Story;
import fr.flegac.story.publisher.Utils;

public class SectionDTO {

  private final String title;

  private final List<StoryDTO> stories = new LinkedList<>();

  public SectionDTO(final Class<?> klass) {
    super();
    this.title = Utils.splitCamelCase(klass.getSimpleName());
    computeStories(klass);
  }

  public List<StoryDTO> getStories() {
    return stories;
  }

  public String getTitle() {
    return title;
  }

  private void computeStories(final Class<?> klass) {
    for (final Story story : klass.getAnnotationsByType(Story.class)) {
      stories.add(new StoryDTO(story, klass));
    }

    for (final Method method : klass.getDeclaredMethods()) {
      for (final Story story : method.getAnnotationsByType(Story.class)) {
        stories.add(new StoryDTO(story, method));
      }
    }
  }

}
