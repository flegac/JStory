package fr.flegac.jstory.publisher.web;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import fr.flegac.jstory.parser.model.PublicationDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class WebTemplate {
  private static final String TEMPLATE_ASSETS_FOLDER = "assets";
  private static final String TEMPLATE_ENTRY_POINT = "index.ftlh";

  private final Configuration cfg;
  private final Path assets;
  private final Template template;

  public WebTemplate(final Path templatePath) throws IOException {
    super();
    this.assets = templatePath.resolve(TEMPLATE_ASSETS_FOLDER);

    cfg = new Configuration(Configuration.VERSION_2_3_25);
    cfg.setDirectoryForTemplateLoading(templatePath.toFile());
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    template = cfg.getTemplate(TEMPLATE_ENTRY_POINT);
  }

  public Path assets() {
    return assets;
  }

  public void process(final PublicationDTO publication, final Writer out) throws TemplateException, IOException {
    template.process(computeParameters(publication), out);
  }

  private Map computeParameters(final PublicationDTO publication) {
    final Map parameters = new HashMap();
    parameters.put("page", publication);
    return parameters;
  }

}
