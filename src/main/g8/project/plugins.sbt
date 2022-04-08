// Refactoring code
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.34")

// Build metadata
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")

// Dependency management
addSbtPlugin("com.github.cb372" % "sbt-explicit-dependencies" % "0.2.16")

// Code formatting
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")

// Release to AWS CodeArtifact
addSbtPlugin("io.github.bbstilson" % "sbt-codeartifact" % "0.2.3")
