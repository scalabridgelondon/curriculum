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


def changeExtension(file: File, currentExt: String, newExt: String): File = {
  val path = file.getParent()
  val name = file.getName()
  val idx = name.lastIndexOf(currentExt)
  val newName = if (idx > -1) name.substring(0, idx) ++ newExt else name

  new File(path, newName)
}

def changePath(file: File, srcPath: File, destPath: File): File = {
  val path = file.getParent()
  val name = file.getName()
  val newPath = path.replace(srcPath.getPath(), destPath.getPath())

  new File(newPath, name)
}

def mdToScala(file: File, srcPath: File, destPath: File): File = {
  changeExtension(changePath(file, srcPath, destPath), "md", "scala")
}

val build = taskKey[Unit]("Build all the curriculum material")
build := {
  import sbt.io._

  val _ = mdoc.toTask("").value
  val src = sourceDirectory.value / "main" / "scala"
  val mdFiles = PathFinder(mdocOut.value).**("*.md")
  IO.copy(mdFiles.get.map(input => (input, mdToScala(input, mdocOut.value, src))), CopyOptions().withOverwrite(true))
  val scalaFiles = PathFinder(mdocOut.value).**("*.scala")
  IO.copy(scalaFiles.get.map(input => (input, changePath(input, mdocOut.value, src))), CopyOptions().withOverwrite(true))
}


val cleanBuild = taskKey[Unit]("Clean up artifacts produced by build")
cleanBuild := {
  import sbt.io._
  val srcDir = sourceDirectory.value / "main" / "scala"
  val mdDir = mdocOut.value
  val mdFiles = PathFinder(mdDir).**("*.md")
  IO.delete(mdFiles.get.map(file => mdToScala(file, mdDir, srcDir)))
  val scalaFiles = PathFinder(mdocOut.value).**("*.scala")
  IO.delete(scalaFiles.get.map(file => changePath(file, mdDir, srcDir)))
}
