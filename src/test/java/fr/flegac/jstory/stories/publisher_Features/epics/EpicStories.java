package fr.flegac.jstory.stories.publisher_Features.epics;

import fr.flegac.jstory.annotations.Epic;
import fr.flegac.jstory.annotations.Story;

@Epic(why = "define epic stories",
      who = "developper",
      what = "associate @Epic to classes")
public class EpicStories {

  @Story(why = "show stories from an epic story",
         who = "developper",
         what = "associate @Story in method of a class")
  private void test() {
  }

}
