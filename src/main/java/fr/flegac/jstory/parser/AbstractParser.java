package fr.flegac.jstory.parser;

import static fr.flegac.jstory.utils.Utils.clean;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import fr.flegac.jstory.Epic;
import fr.flegac.jstory.Story;
import fr.flegac.jstory.TestScenario;
import fr.flegac.jstory.parser.model.PublicationDTO;
import fr.flegac.jstory.parser.model.StoryDTO;
import fr.flegac.jstory.parser.model.TestDTO;
import fr.flegac.jstory.parser.structure.Node;
import fr.flegac.jstory.parser.structure.Structure;

public class AbstractParser implements StoryParser {
  private final Structure structure;

  public AbstractParser(final String packageRoot, final Set<Class<?>> classes) {
    super();
    final Node root = new Node(packageRoot);
    computeStructure(root, classes);
    structure = new Structure(root);
  }

  @Override
  public PublicationDTO getPublication(final String title) {
    return structure.getPublication(title);
  }

  protected Node computeStructure(final Node root, final Set<Class<?>> classes) {
    for (final Class<?> c : classes) {
      System.out.println(c.getName());
      final Node classNode = root.addPath(c.getName());
      classNode.setEpics(computeEpics(c));
      classNode.setStories(computeStories(c));
      classNode.setTests(computeTests(c));
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
