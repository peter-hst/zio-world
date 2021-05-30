package hst.peter.demo

import hst.peter.demo.jenkins.listJobs
import hst.peter.demo.log.consoleEnv
import zio._
import zio.logging._

object Main extends App {
  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = log.info(listJobs()).provideCustomLayer(consoleEnv).exitCode
}
