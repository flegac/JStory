package fr.flegac.story.stories.other_Features_Exemple;

import fr.flegac.story.Epic;
import fr.flegac.story.TestScenario;

@Epic(why = "allow a new user to work with the web application",
      who = "administrator",
      what = "create a new login/password for the new user")
public class AdminTest {

  @TestScenario({
    "Open web site",
    "click on login",
    "enter user/password",
    "click ok"
  })
  private void testLogin() {

  }
}
