package fr.flegac.story.publisher.model;

import static fr.flegac.story.publisher.Utils.splitCamelCase;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.google.common.reflect.ClassPath;
import fr.flegac.story.publisher.Utils;

public class ChapterDTO {

  private final String title;

  private final List<SectionDTO> sections = new LinkedList<>();

  public ChapterDTO(final String packageRoot) {
    super();
    this.title = computeTitle(packageRoot);
    computeSections(packageRoot);
  }

  public List<SectionDTO> getSections() {
    return sections;
  }

  public String getTitle() {
    return title;
  }

  private void computeSections(final String packageroot) {
    try {
      ClassPath.from(ClassLoader.getSystemClassLoader())
          .getTopLevelClassesRecursive(packageroot).stream()
          .map(ClassPath.ClassInfo::load)
          .map(SectionDTO::new)
          .forEach(sections::add);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String computeTitle(final String packageRoot) {
    final String[] split = packageRoot.split("\\.");
    return splitCamelCase(Utils.splitUnderscore(split[split.length - 1]));
  }

}
