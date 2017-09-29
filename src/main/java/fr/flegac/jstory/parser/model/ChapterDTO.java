package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;

public class ChapterDTO {
  private final String title;
  private final List<SectionDTO> sections = new LinkedList<>();

  public ChapterDTO(final String title) {
    super();
    this.title = title;
  }

  public List<SectionDTO> getSections() {
    return sections;
  }

  public String getTitle() {
    return title;
  }

}
