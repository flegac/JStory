package fr.flegac.story.publisher.generator;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fr.flegac.story.publisher.Utils;

/**
 * Generator allows to fill a template string with some configuration values.
 *
 * @param <INPUT> the type of data to fill the wilcard of the template
 *
 */
public abstract class Generator<INPUT> {
  private static class ConfigValue {
    final List<String> values;

    ConfigValue(final String... values) {
      super();
      this.values = Arrays.asList(values);
    }
  }

  private final String template;
  private final Map<String, ConfigValue> config = new HashMap<>();

  public Generator(final String template) {
    super();
    this.template = template;
  }

  public String generate(final INPUT input) {
    configure(input);

    String output = template();
    for (final String key : config.keySet()) {
      final ConfigValue values = config.get(key);
      final String pattern = "\\{" + key + "\\}";
      for (final String value : values.values) {
        // allow multiple values by keeping the pattern after the replacement
        output = output.replaceAll(pattern, Utils.cleanup(value) + pattern);
      }
      // remove the pattern at end
      output = output.replaceAll(pattern, "");
    }
    return output;
  }

  protected void config(final String key, final Collection<String> values) {
    config(key, values.toArray(new String[values.size()]));
  }

  protected void config(final String key, final String... values) {
    config.put(key, new ConfigValue(values));
  }

  protected abstract void configure(INPUT input);

  protected String template() {
    return template;
  }
}
