package fr.flegac.story.publisher.model;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.google.common.reflect.ClassPath;

public class IndexDTO {
  public final String title;
  public final List<SectionDTO> sections = new LinkedList<>();

  public IndexDTO(final String title, final String packageroot) throws IOException {
    super();
    this.title = title;
    computeSections(packageroot);
  }

  private void computeSections(final String packageroot) throws IOException {
    ClassPath.from(ClassLoader.getSystemClassLoader())
        .getTopLevelClassesRecursive(packageroot).stream()
        .map(ClassPath.ClassInfo::load)
        .map(SectionDTO::new)
        .forEach(sections::add);
  }

}
