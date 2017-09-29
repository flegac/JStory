package fr.flegac.jstory.publisher;

import java.nio.file.Path;
import fr.flegac.jstory.parser.model.PublicationDTO;

public interface Publisher {
  void publish(final PublicationDTO input, final Path target);
}
