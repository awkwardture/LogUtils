package iantong.net.logutil

import java.text.SimpleDateFormat

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
  * Created by wjj on 2017/3/15.
  */
class FtpLogLine(log: String) extends LogLine[FtpLogLine](log: String) {
  val logger: Logger = LoggerFactory.getLogger(classOf[FtpLogLine])

  override def compareTo(o: FtpLogLine): Int = {
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val tname = logline.substring(1, 31)
    //    logger.info(tname)
    val otname = o.logline.substring(1, 31)
    //    logger.info(otname)
    val thisdate = sdf.parse(logline.substring(40, 59))
    val odate = sdf.parse(o.logline.substring(40, 59))
    //排序规则1，线程名
    tname.compareTo(otname) match {
      case i if i != 0 => i
      case 0 =>
        //排序规则2，时间
        thisdate.compareTo(odate) match {
          case 0 => 0
          case i => i
        }
    }


  }
}

object FtpLogLine {

  def apply(log: String): FtpLogLine = new FtpLogLine(log)

}