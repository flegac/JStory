package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import fr.flegac.jstory.annotations.Epic;
import fr.flegac.jstory.annotations.Story;

@XmlRootElement(name = "story")
public class StoryDTO {
  @XmlAttribute
  private String type;

  @XmlElement
  private String who;
  @XmlElement
  private String what;
  @XmlElement
  private String why;

  @XmlElement(name = "scenario")
  private final List<ScenarioDTO> tests = new LinkedList<>();

  private String sourceCode;

  public StoryDTO() {
    super();
  }

  public StoryDTO(final Epic epic, final List<ScenarioDTO> tests) {
    this(epic.who(), epic.what(), epic.why(), tests);
    this.type = "EPIC";
  }

  public StoryDTO(final Story story, final List<ScenarioDTO> tests) {
    this(story.who(), story.what(), story.why(), tests);
    this.type = "STORY";
  }

  private StoryDTO(final String who, final String what, final String why, final List<ScenarioDTO> tests) {
    super();
    if (why.trim().isEmpty()) {
      throw new RuntimeException("story.why is empty : " + why);
    }
    if (who.trim().isEmpty()) {
      throw new RuntimeException("story.who is empty : " + who);
    }
    if (what.trim().isEmpty()) {
      throw new RuntimeException("story.what is empty : " + what);
    }

    this.who = who;
    this.what = what;
    this.why = why;
    this.tests.addAll(tests);
  }

  @XmlElement
  public String getSourceCode() {
    return sourceCode;
  }

  public List<ScenarioDTO> getTests() {
    return tests;
  }

  public String getWhat() {
    return what;
  }

  public String getWho() {
    return who;
  }

  public String getWhy() {
    return why;
  }

  public void setSourceCode(final String sourceCode) {
    this.sourceCode = sourceCode;
  }

}
