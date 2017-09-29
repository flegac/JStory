package fr.flegac.jstory.parser;

import fr.flegac.jstory.parser.model.PublicationDTO;

public interface StoryParser {
  PublicationDTO getPublication(String title);
}
