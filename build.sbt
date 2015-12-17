lazy val buildSettings = List(
  organization := "com.adelbertc",
  licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
  scalaVersion := "2.11.7",
  crossScalaVersions := List("2.10.6", scalaVersion.value),
  version := "0.1.0-SNAPSHOT"
)

lazy val commonSettings = List(
  scalacOptions ++= List(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard"
  ),
  libraryDependencies ++= List(
    compilerPlugin("org.spire-math"   % "kind-projector" % "0.7.1" cross CrossVersion.binary),

    "org.spire-math"              %% "algebra"            % "0.3.1",
    "org.spire-math"              %% "cats"               % "0.3.0"
  )
)

lazy val replScalaSettings = buildSettings ++ commonSettings

lazy val replScala =
  project.in(file(".")).
  settings(name := "repl-scala").
  settings(description := "").
  settings(replScalaSettings)

initialCommands :=
  """
  import scala.reflect.runtime.universe.reify
  """
