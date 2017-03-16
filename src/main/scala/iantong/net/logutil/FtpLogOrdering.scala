package iantong.net.logutil

import java.text.SimpleDateFormat

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
  * Created by wjj on 2017/3/15.
  */
class FtpLogOrdering extends Ordering[String] {
  val logger: Logger = LoggerFactory.getLogger(classOf[FtpLogOrdering])

  override def compare(x: String, y: String): Int = {
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val tname = x.substring(1, 31)
    //    logger.info(tname)
    val otname = y.substring(1, 31)
    //    logger.info(otname)
    val thisdate = sdf.parse(x.substring(40, 59))
    val odate = sdf.parse(y.substring(40, 59))
    //排序规则1，线程名
    tname.compareTo(otname) match {
      case 0 =>
        //排序规则2，时间
        thisdate.compareTo(odate)
      case i => i
    }

  }
}