package hst.peter.demo

import org.apache.commons.mail.{Email, HtmlEmail}

package object email {

  case class MailMsg(subject: String, text: String, to: List[String], cc: Option[List[String]], bcc: Option[List[String]])

  case class Setting(host: String, smtpPort: Int = 25, username: String, pwd: String, formEmail: String)

  val email = new HtmlEmail()
  val setting = Setting("smtp.qq.com", 465, "67568107@qq.com", "zzzzz", "67568107@qq.com")

  /**
   * 发送邮件函数
   *
   * @param msg
   * @return
   */
  def sendHtmlMail(msg: MailMsg) = {
    val email = new HtmlEmail()
    fullConfig(email)
    email.addTo(msg.to: _*)
    msg.cc.collect(c => email.addCc(c: _*))
    msg.bcc.collect(b => email.addBcc(b: _*))
    email.setSubject(msg.subject)
    email.setHtmlMsg(msg.text)
    email.send()
  }

  /**
   * 填充配置
   *
   * @param email
   */
  private def fullConfig(email: Email): Unit = {
    email.setHostName(setting.host)
    email.setSmtpPort(setting.smtpPort)
    email.setAuthentication(setting.username, setting.pwd)
    email.setSSLOnConnect(setting.smtpPort == 465)
    email.setFrom(setting.formEmail)
  }

}
