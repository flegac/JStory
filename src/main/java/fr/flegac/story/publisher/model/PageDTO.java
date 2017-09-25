package fr.flegac.story.publisher.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.google.common.reflect.ClassPath;
import fr.flegac.story.TestScenario;
import fr.flegac.story.publisher.Utils;

public class PageDTO {
  private final String title;
  private final List<ChapterDTO> chapters = new LinkedList<>();
  private final List<TestDTO> tests = new LinkedList<>();

  public PageDTO(final String title, final String packageroot) throws IOException {
    super();
    this.title = title;
    computeChapters(packageroot);
    computeTests(packageroot);
  }

  public List<ChapterDTO> getChapters() {
    return chapters;
  }

  public List<TestDTO> getTests() {
    return tests;
  }

  public String getTitle() {
    return title;
  }

  private void computeChapters(final String packageroot) throws IOException {
    ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
        .filter(c -> c.getPackageName().startsWith(packageroot + "."))
        .map(ClassPath.ClassInfo::getPackageName)
        .collect(Collectors.toSet())
        .stream()
        .map(ChapterDTO::new)
        .forEach(chapters::add);
  }

  private void computeTests(final String packageroot) throws IOException {
    ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
        .filter(c -> c.getPackageName().startsWith(packageroot + "."))
        .map(ClassPath.ClassInfo::load)
        .forEach(c -> {
          for (final TestScenario test : c.getAnnotationsByType(TestScenario.class)) {
            tests.add(new TestDTO(Utils.splitCamelCase(c.getSimpleName()), test));
          }
        });

    ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
        .filter(c -> c.getPackageName().startsWith(packageroot))
        .map(ClassPath.ClassInfo::load)
        .map(c -> {
          return c.getDeclaredMethods();
        })
        .flatMap(methods -> Arrays.asList(methods).stream())
        .forEach(m -> {
          for (final TestScenario test : m.getAnnotationsByType(TestScenario.class)) {
            tests.add(new TestDTO(Utils.splitCamelCase(m.getName()), test));
          }
        });

  }

}
