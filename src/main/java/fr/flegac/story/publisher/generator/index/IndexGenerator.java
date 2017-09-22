package fr.flegac.story.publisher.generator.index;

import java.util.LinkedList;
import java.util.List;
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
    final List<String> sections = new LinkedList<>();

    for (final Class<?> source : input.classes) {
      sections.add(publisher.sectionGenerator.generate(new SectionDTO(source)));
    }

    config("title", input.title);
    config("section", sections);
  }

}
