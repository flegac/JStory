package fr.flegac.story.publisher.generator.section;

import java.util.List;
import java.util.stream.Collectors;
import fr.flegac.story.publisher.Publisher;
import fr.flegac.story.publisher.generator.Generator;
import fr.flegac.story.publisher.generator.story.StoryDTO;

public class SectionGenerator extends Generator<SectionDTO> {
  private final Publisher publisher;

  public SectionGenerator(final Publisher publisher, final String template) {
    super(template);
    this.publisher = publisher;
  }

  @Override
  protected void configure(final SectionDTO input) {
    config("title", input.title());
    config("story", writeStories(input.stories()));
  }

  private List<String> writeStories(final List<StoryDTO> stories) {
    return stories.stream()
        .map(publisher.storyGenerator::generate)
        .collect(Collectors.toList());
  }

}
