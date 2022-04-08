import BuildHelper._

ThisBuild / organization      := "com.pirum"
ThisBuild / scalaVersion      := "2.13.8"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / scalafixDependencies ++= List(
  "com.github.liancheng" %% "organize-imports" % "0.5.0",
  "com.github.vovapolu"  %% "scaluzzi"         % "0.1.18"
)
ThisBuild / codeArtifactUrl := "$code_artifact_url$"
ThisBuild / javacOptions    := Seq("-source", "11", "-target", "11")
ThisBuild / scalacOptions   := Seq(
  "-encoding", "utf8",
  "-unchecked",
  "-deprecation",
  "-feature",
  "-explaintypes",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-target:11",
  "-Yrangepos",
  "-Wdead-code",
  "-Wunused:_",
  "-Wvalue-discard"
)
ThisBuild / resolvers += "$code_artifact_realm$" at "$code_artifact_url$"
ThisBuild / credentials += Credentials(
  "$code_artifact_realm$",
  "$code_artifact_host$",
  "aws",
  sys.env("CODEARTIFACT_AUTH_TOKEN")
)

addCommandAlias("fmt", "all scalafmtSbt scalafmt Test/scalafmt")
addCommandAlias("fix", "; all Compile/scalafix Test/scalafix; all scalafmtSbt scalafmtAll")
addCommandAlias("check", "; scalafmtSbtCheck; scalafmtCheckAll; Compile/scalafix --check; Test/scalafix --check")

lazy val $name;format="space,camel"$ = project
  .in(file("."))
  .settings(
    welcomeMessage,
    buildInfoSettings("$name;format="space,package"$"),
    Libraries.settings
  )
  .enablePlugins(BuildInfoPlugin)
