# JStory
An @Annotation based User Story &amp; Specifications generation framework
The goal is to put your specifications as close as possible to the code.

The @Story anotation defines a User Story in the (why, who, what) format.
The generators then build html documentation from the source code.

The framework is designed to promote functionnal tests before starting to develop new features.
The developper should first create (JUnit) classes :
- @Story defined on a method should be entirely tested in the method.
- @Story needing many method to test should be defined on the class instead.
- Each @Story MUST be defined in only one place (don't repeat yourself)
- Many different @Story can be defined on the same class or method (if strongly connected for exemple)
- Test classes should have a nice functionnal name since the class name is used to generate documentation titles.

#Usage
Build with mvn install
Run GenerateRun.java in the src/test/java directory to build the output.html file

#Things to do
- Give a way (optional?) to index stories according to some external, client relative specifications id.
