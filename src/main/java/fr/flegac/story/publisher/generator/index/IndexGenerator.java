package fr.flegac.story.publisher.generator.index;

import java.util.List;
import java.util.stream.Collectors;
import fr.flegac.story.publisher.Publisher;
import fr.flegac.story.publisher.generator.Generator;
import fr.flegac.story.publisher.generator.section.SectionDTO;

public class IndexGenerator extends Generator<IndexDTO> {
  private final Publisher publisher;

  public IndexGenerator(final Publisher publisher, final String template) {
    super(template);
    this.publisher = publisher;
  }

  @Override
  protected void configure(final IndexDTO input) {
    config("title", input.title);
    config("section", writeSections(input));
  }

  private List<String> writeSections(final IndexDTO input) {
    return input.classes.stream()
        .map(classinfo -> {
          return classinfo.load();
        })
        .map(SectionDTO::new)
        .map(publisher.sectionGenerator::generate)
        .collect(Collectors.toList());
  }

}
