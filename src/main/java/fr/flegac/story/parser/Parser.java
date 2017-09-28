package fr.flegac.story.parser;

import static fr.flegac.story.utils.Utils.clean;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import fr.flegac.story.Epic;
import fr.flegac.story.Story;
import fr.flegac.story.TestScenario;
import fr.flegac.story.parser.model.StoryDTO;
import fr.flegac.story.parser.model.TestDTO;
import fr.flegac.story.parser.structure.Node;
import fr.flegac.story.parser.structure.Structure;

public class Parser {
  private final ImmutableSet<ClassInfo> classes;
  private final Structure structure;

  public Parser(final String packageRoot) throws IOException {

    classes = ClassPath.from(ClassLoader.getSystemClassLoader())
        .getTopLevelClassesRecursive(packageRoot);

    final Node root = computeStructure(packageRoot);
    structure = new Structure(root);
  }

  public Structure getStructure() {
    return structure;
  }

  protected Node computeStructure(final String packageRoot) {
    final Node root = new Node(packageRoot);

    for (final ClassInfo c : classes) {
      final Node classNode = root.addPath(c.getName());
      final Class<?> klass = c.load();
      classNode.setEpics(computeEpics(klass));
      classNode.setStories(computeStories(klass));
      classNode.setTests(computeTests(klass));
    }
    return root;
  }

  private List<StoryDTO> computeEpics(final Class<?> klass) {
    final List<StoryDTO> epics = new LinkedList<>();
    for (final Epic epic : klass.getAnnotationsByType(Epic.class)) {
      epics.add(new StoryDTO(epic));
    }
    return epics;
  }

  private List<StoryDTO> computeStories(final Class<?> klass) {
    final List<StoryDTO> stories = new LinkedList<>();
    for (final Method method : klass.getDeclaredMethods()) {
      for (final Story story : method.getAnnotationsByType(Story.class)) {
        stories.add(new StoryDTO(story));
      }
    }
    return stories;
  }

  private List<TestDTO> computeTests(final Class<?> klass) {
    final List<TestDTO> tests = new LinkedList<>();

    for (final TestScenario test : klass.getAnnotationsByType(TestScenario.class)) {
      tests.add(new TestDTO(clean(klass.getSimpleName()), test));
    }

    for (final Method method : klass.getDeclaredMethods()) {
      tests.addAll(computeTests(method));
    }

    return tests;
  }

  private List<TestDTO> computeTests(final Method method) {
    final List<TestDTO> tests = new LinkedList<>();

    for (final TestScenario test : method.getAnnotationsByType(TestScenario.class)) {
      tests.add(new TestDTO(clean(method.getName()), test));
    }

    return tests;
  }

}
