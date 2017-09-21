package fr.flegac.story.generator;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Generator {
  protected static String cleanup(final String s) {
    return s.trim().replaceAll("\\s+", " ");
  }

  protected static String convertStreamToString(final InputStream is) {
    try (Scanner scanner = new Scanner(is);) {
      try (final Scanner s = scanner.useDelimiter("\\A");) {
        return s.hasNext() ? s.next() : "";
      }
    }
  }

  protected static String splitCamelCase(final String s) {
    return s.replaceAll(
        String.format("%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])",
            "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])"),
        " ");
  }

  private final String template;
  private final Map<String, String> config = new HashMap<>();

  public Generator(final String template) {
    super();
    this.template = template;
  }

  public void config(final String key, final String value) {
    config.put(key, value);
  }

  public String generate() {
    String output = template();
    for (final String key : config.keySet()) {
      output = output.replaceAll("\\{" + key + "\\}", cleanup(config.get(key)));
    }
    return output;
  }

  protected String template() {
    return template;
  }
}
