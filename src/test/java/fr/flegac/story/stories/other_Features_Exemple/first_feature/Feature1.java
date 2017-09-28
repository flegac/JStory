package fr.flegac.story.stories.other_Features_Exemple.first_feature;

import fr.flegac.story.Story;
import fr.flegac.story.TestScenario;

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
