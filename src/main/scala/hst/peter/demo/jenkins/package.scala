package hst.peter.demo

import java.net.URI
import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDateTime, ZoneId}
import java.util

import com.offbytwo.jenkins.JenkinsServer
import com.offbytwo.jenkins.model.{Job, QueueReference}

package object jenkins {

  case class Config(user: String, pwd: String, url: String)

  val cfg = Config("peter", "123456", "http://jenkins.com:8080/")

  val jenkins = new JenkinsServer(new URI(cfg.url), cfg.user, cfg.pwd)

  val fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def listJobs() = {
    val jobs = jenkins.getJobs
    /*    jobs.keySet().forEach(k => {
          val name = jobs.get(k).details().getDisplayName
          val build = jobs.get(k).details().getLastBuild.getNumber
          val jobName = jobs.get(k).getName
          val lastTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(jobs.get(k).details().getLastBuild.details().getTimestamp), ZoneId.systemDefault())
          println(s"k:$k,name:$name,build:$build,jobName:$jobName,buildTime:${fmt.format(lastTime)}")
        })*/

    val k = "right"
    val name = jobs.get(k).details().getDisplayName
    val build = jobs.get(k).details().getLastBuild.getNumber
    val jobName = jobs.get(k).getName
    val rs = jobs.get(k).details().getLastBuild.details().getResult.name()
    val lastTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(jobs.get(k).details().getLastBuild.details().getTimestamp), ZoneId.systemDefault())
    val node = jobs.get(k).details()
    println(s"k:$k,name:$name,build:$build,jobName:$jobName,buildTime:${fmt.format(lastTime)}, rs:$rs")
    "ok"
  }

  def execJob(name: String) = {
    val job = jenkins.getJob(name)
    println(s"buildable: ${job.isBuildable}")
    val m = new util.HashMap[String, String]()
    m.put("tag_name", "0.0.32")

    job.build(m, true)
  }
}
