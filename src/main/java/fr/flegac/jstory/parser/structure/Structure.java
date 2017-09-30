package fr.flegac.jstory.parser.structure;

import static fr.flegac.jstory.utils.Utils.clean;
import fr.flegac.jstory.parser.model.ChapterDTO;
import fr.flegac.jstory.parser.model.PublicationDTO;
import fr.flegac.jstory.parser.model.SectionDTO;
import fr.flegac.jstory.parser.model.StoryDTO;
import fr.flegac.jstory.parser.model.SubSectionDTO;

public class Structure {
  private final Node root;

  public Structure(final Node root) {
    super();
    this.root = root;
  }

  public PublicationDTO getPublication(final String title) {
    return publication(title, root);
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

  private PublicationDTO publication(final String title, final Node node) {
    final PublicationDTO result = new PublicationDTO(title);
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
    for (final StoryDTO epic : node.getEpics()) {
      result.getEpics().add(epic);
    }

    for (final Node child : node.getChildren().values()) {
      for (final StoryDTO story : child.getStories()) {
        result.getStories().add(story);
      }

    }

    return result;
  }
}
