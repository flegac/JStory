package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subsection")
public class SubSectionDTO {
  private String title;
  private final List<StoryDTO> epics = new LinkedList<>();
  private final List<StoryDTO> stories = new LinkedList<>();

  public SubSectionDTO() {
    super();
  }

  public SubSectionDTO(final String title) {
    super();
    this.title = title;
  }

  @XmlElement(name = "epic")
  public List<StoryDTO> getEpics() {
    return epics;
  }

  @XmlElement(name = "story")
  public List<StoryDTO> getStories() {
    return stories;
  }

  @XmlAttribute
  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }
}
