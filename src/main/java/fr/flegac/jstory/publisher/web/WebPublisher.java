package fr.flegac.jstory.publisher.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import fr.flegac.jstory.parser.model.PublicationDTO;
import fr.flegac.jstory.publisher.Publisher;
import fr.flegac.jstory.utils.Utils;
import freemarker.template.TemplateException;

public class WebPublisher implements Publisher {
  private static final String OUTPUT_INDEX = "index.html";
  private final WebTemplate template;

  public WebPublisher(final WebTemplate template) {
    super();
    this.template = template;
  }

  @Override
  public void publish(final PublicationDTO input, final Path outputPath) {
    // copy assets from template to the publication
    Utils.copyFolder(template.assets(), outputPath);

    // create publication
    final Path outputIndexPath = outputPath.resolve(OUTPUT_INDEX);
    try (PrintWriter out = new PrintWriter(outputIndexPath.toFile());) {
      template.process(input, out);
    } catch (final TemplateException | IOException e) {
      throw new RuntimeException(e);
    }

  }

}
