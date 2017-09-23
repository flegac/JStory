package fr.flegac.story.stories;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import fr.flegac.story.Story;
import fr.flegac.story.publisher.Publisher;
import fr.flegac.story.publisher.model.IndexDTO;

@Story(why = "publish user stories from source code",
       who = "publisher",
       what = "run a publishing program and generate all stories defined in functional test classes")
@Story(why = "use a single class to test multiple user stories",
       who = "developper",
       what = "add multiple @Story annotation on the same test class,"
           + "this allow for closely related user stories to be tested all at once")
public class PublisherStories {
  private static Path WORKSPACE = Paths.get("C:\\Users\\Flo\\git\\JStory");

  @Test
  @Story(why = "test multiple stories with a single JUnit test",
         who = "developper",
         what = "assign multiple @Story annotations to a single test method")
  @Story(why = "verify that 2 @Story annotations can be on the same test method",
         who = "developper",
         what = "assign multiple @Story annotations to a single test method")
  public void publish() throws Exception {
    final Path template = WORKSPACE.resolve("src/main/resources/template");
    final Path output = WORKSPACE.resolve("target");

    final IndexDTO input = new IndexDTO(
        "Autogenerated User Stories of the JStory project",
        "fr.flegac.story.stories");

    final Publisher publisher = new Publisher(template);
    publisher.generate(input, output);
    System.out.println(output);
    Assertions.assertThat(output.resolve("output")).exists();
    Assertions.assertThat(output.resolve("output/index.html")).exists();
  }

}
