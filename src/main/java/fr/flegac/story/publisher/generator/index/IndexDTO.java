package fr.flegac.story.publisher.generator.index;

import java.io.IOException;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class IndexDTO {
  public final String title;
  public ImmutableSet<ClassInfo> classes;

  public IndexDTO(final String title, final String packageroot) {
    super();
    this.title = title;
    try {
      this.classes = ClassPath.from(ClassLoader.getSystemClassLoader()).getTopLevelClassesRecursive(packageroot);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }

}
