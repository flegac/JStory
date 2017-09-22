package fr.flegac.story.publisher.generator.index;

public class IndexDTO {
  public final String title;
  public Class<?>[] classes;

  public IndexDTO(final String title, final Class<?>... classes) {
    super();
    this.title = title;
    this.classes = classes.clone();
  }

}
