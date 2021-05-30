package hst.peter.demo.jenkins

object Main extends App {
  val q = execJob("test")
  println(q.getQueueItemUrlPart)

}
