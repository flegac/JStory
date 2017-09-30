package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "publication")
public class PublicationDTO {
  @XmlAttribute
  private String title;
  @XmlElement(name = "chapter")
  private final List<ChapterDTO> chapters = new LinkedList<>();

  public PublicationDTO() {
    super();
  }

  public PublicationDTO(final String title) {
    super();
    this.title = title;
  }

  public List<ChapterDTO> getChapters() {
    return chapters;
  }

  public String getTitle() {
    return title;
  }

}
