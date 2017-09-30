package fr.flegac.jstory.parser.model;

import java.util.LinkedList;
import java.util.List;
import fr.flegac.jstory.annotations.Scenario;
import fr.flegac.jstory.annotations.Step;

public class ScenarioDTO {

  public static class StepDTO {
    private final String given;
    private final String when;
    private final String then;

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

  private final String title;
  private final List<StepDTO> steps = new LinkedList<>();

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
