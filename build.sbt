name := "LearnScala"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.1.0"
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.17"

val AkkaVersion = "2.6.15"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion
libraryDependencies += "junit" % "junit" % "4.12" % "test"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
