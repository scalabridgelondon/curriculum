import java.io.File

val scala3Version = "3.0.0"

ThisBuild / name := "scalabridge"
ThisBuild / scalaVersion := scala3Version

libraryDependencies ++= Seq(
  "org.creativescala" %% "mads" % "0.2.0",
  "org.typelevel" %% "cats-core" % "2.6.1",
  "org.scalameta" %% "munit" % "0.7.26" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

enablePlugins(MdocPlugin)


def mdToScala(file: File, srcPath: File, destPath: File): File = {
  val path = file.getParent()
  val name = file.getName()
  val idx = name.lastIndexOf(".md")
  val newPath = path.replace(srcPath.getPath(), destPath.getPath())
  val newName = if (idx > -1) name.substring(0, idx) ++ ".scala" else name

  new File(newPath, newName)
}

val build = taskKey[Unit]("Build all the curriculum material")

build := {
  import sbt.io._

  val _ = mdoc.toTask("").value
  val src = sourceDirectory.value / "main" / "scala"
  val files = PathFinder(mdocOut.value).**("*.md")
  IO.copy(files.get.map(input => (input, mdToScala(input, mdocOut.value, src))), CopyOptions().withOverwrite(true))
}
