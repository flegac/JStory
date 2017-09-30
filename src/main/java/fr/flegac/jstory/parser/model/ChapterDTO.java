package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chapter")
public class ChapterDTO {
  @XmlAttribute
  private String title;
  @XmlElement(name = "section")
  private final List<SectionDTO> sections = new LinkedList<>();

  public ChapterDTO() {
    super();
  }

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
