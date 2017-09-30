package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import fr.flegac.jstory.annotations.Scenario;
import fr.flegac.jstory.annotations.Step;

@XmlRootElement(name = "scenario")
public class ScenarioDTO {

  @XmlAttribute
  private String title;

  @XmlElement(name = "step")
  private final List<StepDTO> steps = new LinkedList<>();

  public ScenarioDTO() {
    super();
  }

  public ScenarioDTO(final String title, final Scenario scenario) {
    super();
    this.title = title;
    for (final Step step : scenario.value()) {
      steps.add(new StepDTO(step));
    }
  }

  public List<StepDTO> getSteps() {
    return steps;
  }

  public String getTitle() {
    return title;
  }

}
