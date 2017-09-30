package fr.flegac.jstory.utils;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import fr.flegac.jstory.parser.model.ChapterDTO;
import fr.flegac.jstory.parser.model.PublicationDTO;
import fr.flegac.jstory.parser.model.ScenarioDTO;
import fr.flegac.jstory.parser.model.SectionDTO;
import fr.flegac.jstory.parser.model.StepDTO;
import fr.flegac.jstory.parser.model.StoryDTO;
import fr.flegac.jstory.parser.model.SubSectionDTO;

public class Utils {
  public static String clean(final String s) {
    return splitUnderscore(splitCamelCase(s));
  }

  public static void copyFolder(final Path src, final Path dest) {
    try {
      Files.walk(src).forEach(s -> {
        try {
          final Path d = dest.resolve(src.relativize(s));
          if (Files.isDirectory(s)) {
            if (!Files.exists(d)) {
              Files.createDirectory(d);
            }
            return;
          }
          Files.copy(s, d, StandardCopyOption.REPLACE_EXISTING);// use flag to override existing
        } catch (final Exception e) {
          e.printStackTrace();
        }
      });
    } catch (final Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void print(final PublicationDTO pub, final OutputStream out) {
    try {
      final JAXBContext jc = JAXBContext.newInstance(
          PublicationDTO.class,
          ChapterDTO.class,
          SectionDTO.class,
          SubSectionDTO.class,
          StoryDTO.class,
          ScenarioDTO.class,
          StepDTO.class);

      final Marshaller marshaller = jc.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      // Marshal Publication
      marshaller.marshal(pub, out);
    } catch (final JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  private static String splitCamelCase(final String s) {
    return s.replaceAll(
        String.format("%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])",
            "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])"),
        " ");
  }

  private static String splitUnderscore(final String s) {
    return String.join(" ", s.split("_"));
  }

}
