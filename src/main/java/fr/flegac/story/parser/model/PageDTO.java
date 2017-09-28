package fr.flegac.story.parser.model;

import java.util.LinkedList;
import java.util.List;

public class PageDTO {
  private final String title;
  private final List<ChapterDTO> chapters = new LinkedList<>();
  private final List<TestDTO> tests = new LinkedList<>();

  public PageDTO(final String title) {
    super();
    this.title = title;
  }

  public List<ChapterDTO> getChapters() {
    return chapters;
  }

  public List<TestDTO> getTests() {
    return tests;
  }

  public String getTitle() {
    return title;
  }

}
