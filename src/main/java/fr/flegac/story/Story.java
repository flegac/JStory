package fr.flegac.story;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeatable(Stories.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({
  ElementType.TYPE, ElementType.METHOD
})
public @interface Story {
  String what();

  String who();

  String why();

}