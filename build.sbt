seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

name := "redump"

version := "0.1"

organization := "OneWebPro"

scalaVersion := "2.10.2"

mainClass := Some("main.Main")

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10"  % "2.1.2"

libraryDependencies += "org.scalatest" % "scalatest_2.9.0" % "1.6.1"

libraryDependencies += "pl.project13.scala" %% "rainbow" % "0.1"

libraryDependencies += "org.lesscss" % "lesscss" % "1.3.3"

