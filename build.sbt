name := "zio-world"

version := "0.0.1"

scalaVersion := "2.13.6"

val zioVersion = "1.0.8"
val zioLogVersion = "0.5.10"
val emailVersion = "0.1.0"

libraryDependencies ++= Seq(

  // zio lib
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-streams" % zioVersion,
  "dev.zio" %% "zio-logging-slf4j" % zioLogVersion,

  // email
  //  "com.funcit" %% "zio-email" % emailVersion
  "org.apache.commons" % "commons-email" % "1.5"
)
