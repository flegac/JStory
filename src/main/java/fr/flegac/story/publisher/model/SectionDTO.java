package fr.flegac.story.publisher.model;

import static fr.flegac.story.publisher.Utils.splitCamelCase;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import fr.flegac.story.Epic;
import fr.flegac.story.Story;

public class SectionDTO {

  private final String title;

  private final List<StoryDTO> epics = new LinkedList<>();
  private final List<StoryDTO> stories = new LinkedList<>();

  public SectionDTO(final Class<?> klass) {
    super();
    this.title = splitCamelCase(klass.getSimpleName());
    computeStories(klass);
    computeEpics(klass);
  }

  public List<StoryDTO> getEpics() {
    return epics;
  }

  public List<StoryDTO> getStories() {
    return stories;
  }

  public String getTitle() {
    return title;
  }

  private void computeEpics(final Class<?> klass) {
    for (final Epic epic : klass.getAnnotationsByType(Epic.class)) {
      epics.add(new StoryDTO(epic, klass));
    }
  }

  private void computeStories(final Class<?> klass) {
    for (final Method method : klass.getDeclaredMethods()) {
      for (final Story story : method.getAnnotationsByType(Story.class)) {
        stories.add(new StoryDTO(story, method));
      }
    }
  }

}
