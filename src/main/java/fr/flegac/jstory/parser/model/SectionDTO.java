package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;

public class SectionDTO {
  private final String title;
  private final List<SubSectionDTO> subSections = new LinkedList<>();

  public SectionDTO(final String title) {
    super();
    this.title = title;
  }

  public List<SubSectionDTO> getSubSections() {
    return subSections;
  }

  public String getTitle() {
    return title;
  }

}
