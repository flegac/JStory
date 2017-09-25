package fr.flegac.story.stories.otherFeaturesExemple;

import fr.flegac.story.Story;
import fr.flegac.story.TestScenario;

@Story(why = "allow a new user to work with the web application",
       who = "administrator",
       what = "create a new login/password for the new user")
@TestScenario({
  "Open web site",
  "click on login",
  "enter user/password",
  "click ok"
})
public class AdminTest {

}
