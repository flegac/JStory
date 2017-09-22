package fr.flegac.story.publisher;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Utils {
  public static String cleanup(final String s) {
    return s.trim().replaceAll("\\s+", " ");
  }

  public static String convertPathToString(final Path path) {
    try (final FileInputStream is = new FileInputStream(path.toFile());
        Scanner scanner = new Scanner(is);) {
      try (final Scanner s = scanner.useDelimiter("\\A");) {
        return s.hasNext() ? s.next() : "";
      }
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
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
