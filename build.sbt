name := "zio-world"

version := "0.0.1"

scalaVersion := "2.13.6"

val zioVersion = "1.0.8"

val zioLogVersion = "0.5.10"

libraryDependencies ++= Seq(

  // zio lib
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-streams" % zioVersion,
  "dev.zio" %% "zio-logging-slf4j" % zioLogVersion
)
