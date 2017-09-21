package fr.flegac.story;

import org.junit.Test;

@Story(who = "global user",
       what = "execute a global dummy task",
       why = "achieve my global goal")
@Story(who = "global user2",
       what = "execute a global dummy task2",
       why = "achieve my global goal2")

public class ManyStoriesSharingManyTests {

  @Test
  @Story(who = "user1",
         what = "execute this task : dummy1",
         why = "achieve dummy goal1")
  @Story(who = "user2",
         what = "execute this task : dummy2",
         why = "achieve dummy goal2")
  public void dummy() throws Exception {

  }

  @Test
  @Story(who = "user3",
         what = "execute this task : dummy3",
         why = "achieve dummy goal3")
  public void dummy2() throws Exception {

  }

}
