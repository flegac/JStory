package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "section")
public class SectionDTO {
  @XmlAttribute
  private String title;
  @XmlElement(name = "subsection")
  private final List<SubSectionDTO> subSections = new LinkedList<>();

  public SectionDTO() {
    super();
  }

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
