package hst.peter.demo

import hst.peter.demo.email.{MailMsg, sendHtmlMail}
import hst.peter.demo.log.consoleEnv
import zio._
import zio.logging._

object Main extends App {
  val msg = MailMsg("test测试邮件", "<h1 style='color:red'>Hello, World</h1>", List("67568107@qq.com"), None, None)

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = log.info(sendHtmlMail(msg)).provideCustomLayer(consoleEnv).exitCode
}
