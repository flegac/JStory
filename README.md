# JStory
JStory allows to :
- annotate Java code with user stories and test scenario,
- generate specifications as a web site from the annotated code.

# Motivations
Short : https://en.wikipedia.org/wiki/Behavior-driven_development

Lose of business focus is a recurring problem in many teams.
I think it often comes from misunderstandings between business and developper teams and lack of acceptance criteria definition before development.

With this project I want to reach the following goals :
- define a workflow that helps developpers to think about how to test a feature before starting any developement,
- decrease misunderstandings between business and developpers
- link deeply the business specification, its acceptance criteria and its implementation,
- generate an up-to-date specification directly from source code.

# Workflow
The original idea behind JStory is to follow this simple process :
- The business team comunicates the required feature to the developper (any media is ok)
- (Optional if already user stories) The specifications is rewritten as a list of independant user stories
- The developper maps each user story to a @Story annotation. The annotation has to be in a JUnit test class.
- The developper fill the test class with automatic tests or @TestScenario annotations.
This ensures that any user story will be covered in the next developement phase and that the developper knows how to test it.
- The business team read the generated specifications and check that its is correct.
- The developper is ready to implement the feature using TDD (optional).

# Recommendations
- Unit/technical tests should be separated from business tests because they do not have the same purpose and life cycle.
- Stories defined on a method should be entirely tested in the method.
- Stories needing many methods to be tested should be defined on a class with the @Epic annotation.
- Each @Story MUST be defined in a single place (don't repeat yourself)

# Specifications
The generated specifications is organised as this (work in progress) :
- Chapter     -> first level package : the name is generated from the package name
- Section     -> second level package : idem
- Subsection  -> class : the name is generated from the class name
- Epic        -> @Epic annotation over a class (at most one per Subsection)
- Story       -> @Story annotation over a method (any number)
- Test        -> @TestScenario annotation over a method : title is generated from the method name

The resulting code should directly reflect the specification organisation (by feature).

# Usage (publication)
To publish the specifications from the source code look at PublisherStories.java.
Specifications can be generated from a jar file or directly from the running application.

To test the generation :
- clone the JStory project
- run mvn clean install
- open the index.html generated in the target/output folder

# Things to do
- Give a way (optional?) to index stories according to some external specifications id,
- Link each story to its coresponding test scenari (or automatic testing class),
- Publish generated specifications as word (docx) documents.

# Exemple ( generated from JStory source code)

1. Publisher Features
1.1. Publisher
1.1.1. Publisher Stories

In order to publish user stories from source code
As a publisher
I want to run a publishing program and generate all stories defined in functional test classes.

In order to generate specifications from jar file
As a developper
I want to parse a given jar file containing java code with specifications and genrate a web site wfrom it.

In order to generate specifications from source code
As a developper
I want to parse source code containing specifications and generate a web site from it.

1.2. Epics
1.2.1. Epic Stories

In order to define epic stories
As a developper
I want to associate @Epic to classes.
