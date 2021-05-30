package hst.peter.demo

import java.util.UUID

import zio.ZLayer
import zio.clock.Clock

// console导入的类库
import zio.console.Console
import zio.logging._

// slf4j导入的类库
import zio.logging.slf4j._

package object log {

  // console实现的log环境
  val consoleEnv: ZLayer[Console with Clock, Nothing, Logging] = Logging.console(LogLevel.Info, LogFormat.ColoredLogFormat()) >>> Logging.withRootLoggerName("zio-console")

  // slf4j相关配置
  val logFormat = "[correlation-id = %s] %s"

  val slf4jEnv = Slf4jLogger.make {
    (context, message) =>
      val correlationId = LogAnnotation.CorrelationId.render(context.get(LogAnnotation.CorrelationId))
      logFormat.format(correlationId, message)
  }

  def generateCorrelationId = Some(UUID.randomUUID())
}
