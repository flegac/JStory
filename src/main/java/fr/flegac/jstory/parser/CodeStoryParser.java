package fr.flegac.jstory.parser;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import com.google.common.reflect.ClassPath;

/**
 * CodeStoryParser parses any running code in a given package
 *
 */
public class CodeStoryParser extends AbstractParser {
  private static Set<Class<?>> getAllClasses(final String packageRoot, final ClassLoader classLoader) {
    try {
      return ClassPath.from(classLoader).getTopLevelClassesRecursive(packageRoot).stream()
          .map(ClassPath.ClassInfo::load)
          .collect(Collectors.toSet());
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }

  public CodeStoryParser(final String title, final String packageRoot) {
    super(title, packageRoot, getAllClasses(packageRoot, new ClassLoader() {}));
  }

  public CodeStoryParser(final String title, final String packageRoot, final ClassLoader classLoader) {
    super(title, packageRoot, getAllClasses(packageRoot, classLoader));
  }

}
