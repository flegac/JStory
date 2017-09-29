package fr.flegac.jstory.stories.other_Features_Exemple.first_feature;

import fr.flegac.jstory.Story;
import fr.flegac.jstory.TestScenario;

public class Feature1 {

  @Story(why = "allow a new user to work with the web application",
         who = "administrator",
         what = "create a new login/password for the new user")
  @TestScenario({
    "first step",
    "second step",
    "third step"
  })
  public void testScenarioExemple() {

  }

}
