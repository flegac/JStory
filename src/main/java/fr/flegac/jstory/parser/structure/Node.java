package fr.flegac.jstory.parser.structure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fr.flegac.jstory.parser.model.StoryDTO;
import fr.flegac.jstory.parser.model.TestDTO;

public class Node {
  private final String name;
  private Node parent;
  private final Map<String, Node> children = new HashMap<>();

  private List<StoryDTO> stories;
  private List<StoryDTO> epics;
  private List<TestDTO> tests;

  public Node(final String name) {
    super();
    this.name = name;
  }

  public void addChild(final String childName) {
    if (!children.containsKey(childName)) {
      children.put(childName, new Node(childName));
    }
  }

  public Node addPath(final String path) {
    final String[] split = path.replace(getFullName() + ".", "").split("\\.");
    Node node = this;
    for (final String part : split) {
      node.addChild(part);
      node = node.get(part);
    }
    return node;
  }

  public Node get(final String childName) {
    if (children.containsKey(childName)) {
      return children.get(childName);
    }
    return null;
  }

  public Map<String, Node> getChildren() {
    return children;
  }

  public List<StoryDTO> getEpics() {
    return epics;
  }

  public String getFullName() {
    if (parent == null) {
      return name;
    }
    return parent.getFullName() + "." + name;
  }

  public String getName() {
    return name;
  }

  public List<StoryDTO> getStories() {
    return stories;
  }

  public List<TestDTO> getTests() {
    return tests;
  }

  public void setEpics(final List<StoryDTO> epics) {
    this.epics = epics;
  }

  public void setStories(final List<StoryDTO> stories) {
    this.stories = stories;
  }

  public void setTests(final List<TestDTO> tests) {
    this.tests = tests;
  }

  @Override
  public String toString() {
    final String childs = children.isEmpty() ? name : children.values().toString();
    return name + childs + "";
  }

}
