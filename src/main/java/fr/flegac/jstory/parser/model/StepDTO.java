package fr.flegac.jstory.parser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import fr.flegac.jstory.annotations.Step;

@XmlRootElement(name = "step")
public class StepDTO {
  @XmlElement
  private String given;
  @XmlElement
  private String when;
  @XmlElement
  private String then;

  public StepDTO() {
    super();
  }

  public StepDTO(final Step step) {
    super();
    this.given = step.given();
    this.when = step.when();
    this.then = step.then();
  }

  public String getGiven() {
    return given;
  }

  public String getThen() {
    return then;
  }

  public String getWhen() {
    return when;
  }

}