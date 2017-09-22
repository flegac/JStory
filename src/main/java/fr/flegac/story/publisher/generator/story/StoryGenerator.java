package fr.flegac.story.publisher.generator.story;

import fr.flegac.story.publisher.Publisher;
import fr.flegac.story.publisher.generator.Generator;

public class StoryGenerator extends Generator<StoryDTO> {

  private final Publisher publisher;

  public StoryGenerator(final Publisher publisher, final String template) {
    super(template);
    this.publisher = publisher;
  }

  @Override
  protected void configure(final StoryDTO input) {
    config("who", input.story.who());
    config("what", input.story.what());
    config("why", input.story.why());
    config("test", input.test);

    config("scenario", input.scenario());

  }

}
