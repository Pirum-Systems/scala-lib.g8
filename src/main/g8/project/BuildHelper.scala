import sbt.Keys._
import sbt._
import sbtbuildinfo.BuildInfoKeys._
import sbtbuildinfo._

object BuildHelper {

  def buildInfoSettings(packageName: String) = Seq(
    buildInfoKeys    := Seq[BuildInfoKey](organization, moduleName, name, version, scalaVersion, sbtVersion, isSnapshot),
    buildInfoPackage := packageName
  )

  def welcomeMessage = onLoadMessage := {
    import scala.Console

    def item(text: String): String    = s"\${Console.GREEN}> \${Console.CYAN}\$text\${Console.RESET}"
    def subItem(text: String): String = s"  \${Console.YELLOW}> \${Console.CYAN}\$text\${Console.RESET}"

    s"""|Useful sbt tasks:
        |\${item("build")}   - Prepares sources, compiles and runs tests.
        |\${item("prepare")} - Prepares sources by applying both scalafix and scalafmt
        |\${item("fix")}     - Fixes source files using scalafix
        |\${item("fmt")}     - Formats source files using scalafmt
        |\${item("check")}   - Checks the source code for conformance to the formatting and scalafix rules
    """.stripMargin
  }
}
