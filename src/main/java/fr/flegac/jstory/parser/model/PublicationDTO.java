package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;

public class PublicationDTO {
  private final String title;
  private final List<ChapterDTO> chapters = new LinkedList<>();
  private final List<ScenarioDTO> tests = new LinkedList<>();

  public PublicationDTO(final String title) {
    super();
    this.title = title;
  }

  public List<ChapterDTO> getChapters() {
    return chapters;
  }

  public List<ScenarioDTO> getTests() {
    return tests;
  }

  public String getTitle() {
    return title;
  }

}
