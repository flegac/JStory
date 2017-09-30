package fr.flegac.jstory.stories.parsing.parsing;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import fr.flegac.jstory.annotations.Epic;
import fr.flegac.jstory.annotations.Step;
import fr.flegac.jstory.annotations.Story;

@Epic(why = "publish structured specifications from source code",
      who = "publisher",
      what = "run a programm and get a structured web site containing all specifications")
public class Parsing {

  private static final Path WORKSPACE = Paths.get(System.getProperty("user.dir"));
  private static final Path WEB_TEMPLATE = WORKSPACE.resolve("src/main/resources/web-template");
  private static final Path outputSource = WORKSPACE.resolve("target/outputSource");
  private static final Path outputJar = WORKSPACE.resolve("target/outputJar");

  private static final Path JAR_PATH = WORKSPACE.resolve("src/test/java/jstory-doc-0.0.1-SNAPSHOT.jar");
  private static final String INDEX_HTML = "index.html";
  private static final String STORIES_PACKAGE = "fr.flegac.jstory.stories";

  @Story(why = "link stories to test scenario",
         who = "publisher",
         what = "link each story and each test scenario to the class or method where it is defined")
  @Step(given = "A jar file with code annoted by JStory",
        when = "Run the publication process",
        then = "the documentation has been generated")
  @Step(when = "Navigate the generated documentation to find a story",
        then = "the story is associated to a test scenario")
  public void eachStoryShouldBeLinkedToASpecificJavaClassOrMethod() {

  }

  @Test
  @Story(why = "generate specifications from source code",
         who = "developper",
         what = "parse source code containing specifications and generate a web site from it")
  @Story(why = "verify that 2 @Story annotations can be on the same test method",
         who = "developper",
         what = "assign multiple @Story annotations to a single test method")
  public void publishFromCode() throws Exception {
  }

  @Test
  @Story(why = "generate specifications from jar file",
         who = "developper",
         what = "parse a given jar file containing java code with specifications and genrate a web site wfrom it")
  public void publishFromJar() throws Exception {
  }

}
