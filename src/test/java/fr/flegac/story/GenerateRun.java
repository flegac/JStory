package fr.flegac.story;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import fr.flegac.story.generator.SpecsGenerator;

public class GenerateRun {
  public static void main(final String[] args) throws FileNotFoundException {
    final String specs = new SpecsGenerator("My Application Documentation & Specifications",
        SingleStoryWithManyTests.class, ManyStoriesOnSingleMethods.class, ManyStoriesSharingManyTests.class,
        AdminTest.class).generate();

    try (PrintWriter out = new PrintWriter("output.html");) {
      out.println(specs);
    }

  }

}
