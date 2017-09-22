package fr.flegac.story.publisher;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import fr.flegac.story.publisher.generator.index.IndexDTO;
import fr.flegac.story.publisher.generator.index.IndexGenerator;
import fr.flegac.story.publisher.generator.section.SectionGenerator;
import fr.flegac.story.publisher.generator.story.StoryGenerator;

/**
 * Publisher load a full template directory and then allow to generate a full documentation in an output directory.
 *
 */
public class Publisher {

  private final Path template;

  public final IndexGenerator indexGenerator;
  public final SectionGenerator sectionGenerator;
  public final StoryGenerator storyGenerator;

  public Publisher(final Path template) {
    super();
    this.template = template;

    final String indexTemplate = Utils.convertPathToString(template.resolve("index.html"));
    final String sectionTemplate = Utils.convertPathToString(template.resolve("section.html"));
    final String storyTemplate = Utils.convertPathToString(template.resolve("story.html"));

    storyGenerator = new StoryGenerator(this, storyTemplate);
    sectionGenerator = new SectionGenerator(this, sectionTemplate);
    indexGenerator = new IndexGenerator(this, indexTemplate);
  }

  public void generate(final IndexDTO input, final Path target) {
    final Path output = target.resolve("output");
    Utils.copyFolder(template.resolve("output"), output);

    try (PrintWriter out = new PrintWriter(output.resolve("index.html").toFile());) {
      out.println(indexGenerator.generate(input));
    } catch (final FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

}
