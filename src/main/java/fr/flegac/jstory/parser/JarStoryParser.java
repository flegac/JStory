package fr.flegac.jstory.parser;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * JarStoryParser parses any code in a jar file
 *
 */
public class JarStoryParser extends AbstractParser {
  private static final String CLASS_EXTENSION = ".class";

  private static Set<Class<?>> computeClasses(final String pathToJar) {
    final Set<Class<?>> result = new HashSet<>();

    try (final JarFile jarFile = new JarFile(pathToJar);
        final URLClassLoader cl = URLClassLoader.newInstance(new URL[] { new URL("jar:file:" + pathToJar + "!/") });) {

      final Enumeration<JarEntry> entries = jarFile.entries();

      while (entries.hasMoreElements()) {
        final JarEntry entry = entries.nextElement();
        if (entry.isDirectory() || !entry.getName().endsWith(CLASS_EXTENSION)) {
          continue;
        }
        final String className = entry.getName()
            .substring(0, entry.getName().length() - CLASS_EXTENSION.length())
            .replace('/', '.');
        result.add(cl.loadClass(className));
      }

      return result;
    } catch (final IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public JarStoryParser(final String packageRoot, final Path pathToJar) {
    super(packageRoot, computeClasses(pathToJar.toAbsolutePath().toString()));
  }

}
