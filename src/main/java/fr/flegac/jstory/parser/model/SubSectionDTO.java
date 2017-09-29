package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;

public class SubSectionDTO {
  private final String title;
  private final List<StoryDTO> epics = new LinkedList<>();
  private final List<StoryDTO> stories = new LinkedList<>();
  private final List<TestDTO> tests = new LinkedList<>();

  public SubSectionDTO(final String title) {
    super();
    this.title = title;
  }

  public List<StoryDTO> getEpics() {
    return epics;
  }

  public List<StoryDTO> getStories() {
    return stories;
  }

  public List<TestDTO> getTests() {
    return tests;
  }

  public String getTitle() {
    return title;
  }
}
