package fr.flegac.jstory.parser;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import fr.flegac.jstory.parser.model.ChapterDTO;
import fr.flegac.jstory.parser.model.PublicationDTO;
import fr.flegac.jstory.parser.model.ScenarioDTO;
import fr.flegac.jstory.parser.model.SectionDTO;
import fr.flegac.jstory.parser.model.StepDTO;
import fr.flegac.jstory.parser.model.StoryDTO;
import fr.flegac.jstory.parser.model.SubSectionDTO;

public class XmlStoryParser implements StoryParser {

  private final File xmlFile;
  private final Unmarshaller unmarshaller;

  public XmlStoryParser(final File xmlFile) throws JAXBException {
    super();
    final JAXBContext jc = JAXBContext.newInstance(
        PublicationDTO.class,
        ChapterDTO.class,
        SectionDTO.class,
        SubSectionDTO.class,
        StoryDTO.class,
        ScenarioDTO.class,
        StepDTO.class);

    unmarshaller = jc.createUnmarshaller();

    this.xmlFile = xmlFile;
  }

  @Override
  public PublicationDTO getPublication() {
    try {
      return (PublicationDTO) JAXBIntrospector.getValue(unmarshaller.unmarshal(xmlFile));
    } catch (final JAXBException e) {
      throw new RuntimeException(e);
    }
  }

}
