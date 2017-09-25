package fr.flegac.story.publisher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Utils {
  public static String capitalize(final String s) {
    if (s.length() == 0) {
      return s;
    }
    if (s.length() == 1) {
      return s.toUpperCase();
    }

    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  public static void copyFolder(final Path src, final Path dest) {
    try {
      Files.walk(src)
          .forEach(s -> {
            try {
              final Path d = dest.resolve(src.relativize(s));
              if (Files.isDirectory(s)) {
                if (!Files.exists(d)) {
                  Files.createDirectory(d);
                }
                return;
              }
              Files.copy(s, d, StandardCopyOption.REPLACE_EXISTING);// use flag to override existing
            } catch (final Exception e) {
              e.printStackTrace();
            }
          });
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }

  public static String splitCamelCase(final String s) {
    return s.replaceAll(
        String.format("%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])",
            "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])"),
        " ");
  }
}
