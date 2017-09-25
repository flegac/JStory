package fr.flegac.story.publisher.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import fr.flegac.story.TestScenario;

public class TestDTO {
  private final String title;
  private final List<String> steps = new LinkedList<>();

  public TestDTO(final String title, final TestScenario test) {
    super();
    this.title = title;
    steps.addAll(Arrays.asList(test.value()));
  }

  public List<String> getSteps() {
    return steps;
  }

  public String getTitle() {
    return title;
  }

}
