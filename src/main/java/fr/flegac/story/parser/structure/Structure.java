package fr.flegac.story.parser.structure;

import static fr.flegac.story.utils.Utils.clean;
import fr.flegac.story.parser.model.ChapterDTO;
import fr.flegac.story.parser.model.PageDTO;
import fr.flegac.story.parser.model.SectionDTO;
import fr.flegac.story.parser.model.StoryDTO;
import fr.flegac.story.parser.model.SubSectionDTO;
import fr.flegac.story.parser.model.TestDTO;

public class Structure {
  private final Node root;

  private boolean ignoreTests;

  private boolean ignoreEpics;
  private boolean ignoreStories;

  public Structure(final Node root) {
    super();
    this.root = root;
  }

  public void configure(final boolean ignoreEpics, final boolean ignoreStories, final boolean ignoreTests) {
    this.ignoreEpics = ignoreEpics;
    this.ignoreStories = ignoreStories;
    this.ignoreTests = ignoreTests;
  }

  public PageDTO getPage(final String title) {
    return page(title, root);
  }

  @Override
  public String toString() {
    return root.toString();
  }

  private ChapterDTO chapter(final Node node) {
    final String title = clean(node.getName());
    final ChapterDTO result = new ChapterDTO(title);
    for (final Node child : node.getChildren().values()) {
      result.getSections().add(section(child));
    }
    return result;
  }

  private PageDTO page(final String title, final Node node) {
    final PageDTO result = new PageDTO(title);
    for (final Node child : node.getChildren().values()) {
      result.getChapters().add(chapter(child));
    }
    return result;
  }

  private SectionDTO section(final Node node) {
    final String title = clean(node.getName());
    final SectionDTO result = new SectionDTO(title);
    for (final Node child : node.getChildren().values()) {
      result.getSubSections().add(subsection(child));
    }
    return result;
  }

  private SubSectionDTO subsection(final Node node) {
    final String title = clean(node.getName());
    final SubSectionDTO result = new SubSectionDTO(title);
    if (!ignoreEpics) {
      for (final StoryDTO epic : node.getEpics()) {
        result.getEpics().add(epic);
      }
    }
    if (!ignoreStories) {
      for (final StoryDTO story : node.getStories()) {
        result.getStories().add(story);
      }
    }
    if (!ignoreTests) {
      for (final TestDTO test : node.getTests()) {
        result.getTests().add(test);
      }
    }
    return result;
  }
}
