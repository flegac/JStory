package fr.flegac.jstory.parser;

import static fr.flegac.jstory.utils.Utils.clean;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import fr.flegac.jstory.annotations.Epic;
import fr.flegac.jstory.annotations.Scenario;
import fr.flegac.jstory.annotations.Story;
import fr.flegac.jstory.parser.model.PublicationDTO;
import fr.flegac.jstory.parser.model.ScenarioDTO;
import fr.flegac.jstory.parser.model.StoryDTO;
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
      final Node classNode = root.addPath(c.getName());
      fillClassNode(c, classNode);
    }
    return root;
  }

  protected void fillClassNode(final Class<?> c, final Node classNode) {
    System.out.println(c.getName());
    classNode.setEpics(computeEpics(c));

    for (final Method method : c.getDeclaredMethods()) {
      final Node node = classNode.addChild(method.getName());
      node.setStories(computeStories(method));
    }
  }

  private List<StoryDTO> computeEpics(final Class<?> klass) {
    final List<StoryDTO> epics = new LinkedList<>();
    for (final Epic story : klass.getAnnotationsByType(Epic.class)) {
      final StoryDTO storyDTO = new StoryDTO(story, computeTests(klass));
      storyDTO.setSourceCode(klass.getCanonicalName());
      epics.add(storyDTO);
    }
    return epics;
  }

  private List<StoryDTO> computeStories(final Method method) {
    final List<StoryDTO> stories = new LinkedList<>();
    for (final Story story : method.getAnnotationsByType(Story.class)) {
      final StoryDTO storyDTO = new StoryDTO(story, computeTests(method));
      storyDTO.setSourceCode(method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()");
      stories.add(storyDTO);
    }
    return stories;
  }

  private List<ScenarioDTO> computeTests(final Class<?> klass) {
    final String title = clean(klass.getSimpleName());
    final Scenario[] scenarios = klass.getAnnotationsByType(Scenario.class);
    return computeTests(title, scenarios);
  }

  private List<ScenarioDTO> computeTests(final Method method) {
    final String title = clean(method.getName());
    final Scenario[] scenarios = method.getAnnotationsByType(Scenario.class);
    return computeTests(title, scenarios);
  }

  private List<ScenarioDTO> computeTests(final String title, final Scenario[] scenarios) {
    final List<ScenarioDTO> tests = new LinkedList<>();
    for (final Scenario scenario : scenarios) {
      tests.add(new ScenarioDTO(title, scenario));
    }
    return tests;
  }

}
