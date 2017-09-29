package fr.flegac.jstory.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Utils {
  public static String clean(final String s) {
    return splitUnderscore(splitCamelCase(s));
  }

  public static void copyFolder(final Path src, final Path dest) {
    try {
      Files.walk(src).forEach(s -> {
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

  private static String splitCamelCase(final String s) {
    return s.replaceAll(
        String.format("%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])",
            "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])"),
        " ");
  }

  private static String splitUnderscore(final String s) {
    return String.join(" ", s.split("_"));
  }
}