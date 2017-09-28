package fr.flegac.story.publisher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import fr.flegac.story.parser.model.PageDTO;
import fr.flegac.story.utils.Utils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Publisher load a full templatePath directory and then allow to generate a full documentation in an output directory.
 *
 */
public class Publisher {
  private static final String TEMPLATE_OUTPUT_FOLDER = "output";

  private static final String TEMPLATE_ENTRY_POINT = "index.ftlh";

  private final Configuration cfg;
  private final Path templateOutput;
  private final Template template;

  public Publisher(final Path templatePath) throws IOException {
    super();
    this.templateOutput = templatePath.resolve(TEMPLATE_OUTPUT_FOLDER);

    cfg = new Configuration(Configuration.VERSION_2_3_25);
    cfg.setDirectoryForTemplateLoading(templatePath.toFile());
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    template = cfg.getTemplate(TEMPLATE_ENTRY_POINT);
  }

  public void generate(final PageDTO input, final Path target, final String filename) {
    final Path outputPath = target.resolve(TEMPLATE_OUTPUT_FOLDER);

    // copy resources from template to the publication
    Utils.copyFolder(templateOutput, outputPath);

    // create publication
    final Path outputIndexPath = outputPath.resolve(filename);
    try (PrintWriter out = new PrintWriter(outputIndexPath.toFile());) {
      template.process(computeParameters(input), out);
    } catch (final TemplateException | IOException e) {
      throw new RuntimeException(e);
    }

  }

  private Map computeParameters(final PageDTO page) {
    final Map parameters = new HashMap();
    parameters.put("page", page);
    return parameters;
  }

}
