package iantong.net.logutil

import java.text.SimpleDateFormat

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
  * Created by wjj on 2017/3/15.
  */
class CompareableLine(log: String) extends java.lang.Comparable[CompareableLine] {
  val logger: Logger = LoggerFactory.getLogger(classOf[CompareableLine])
  val logline: String = log
  val tagline = ".java:"
  val tagul = "UploadLessThanOneHourJob"
  val tagdl = "DownloadJob"
  val tagum = "UploadMoreThanOneHourJob"
  val tagftp = "Ftp.java"

  def sortByCN(o: CompareableLine, tag: String, step: Int): Int = {

    val start = logline.indexOf(tag + tagline)
    val ostart = o.logline.indexOf(tag + tagline)
    val end = logline.indexOf(")", start)
    val oend = o.logline.indexOf(")", start)
    //    logger.info(logline)
    val codeline = logline.substring(start + step, end).toInt
    //    logger.info(codeline.toString)
    //    logger.info(o.logline)
    val ocodeline = o.logline.substring(ostart + step, oend).toInt
    //    logger.info(ocodeline.toString)
    codeline - ocodeline
  }

  override def compareTo(o: CompareableLine): Int = {
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    try {
      val thisdate = sdf.parse(logline.substring(8, 27))
      val odate = sdf.parse(o.logline.substring(8, 27))

      //排序规则1，时间
      if (thisdate.compareTo(odate) == 0) {

        //排序规则2，ul放第1类
        if (logline.contains(tagul)) {

          if (o.logline.contains(tagul)) {
            //排序规则2.1，都是ul，按代码行数排序
            sortByCN(o, tagul, 30)
          } else -1
        } //排序规则3，um放第2类
        else if (logline.contains(tagum)) {

          if (o.logline.contains(tagul)) {
            1
          } else if (o.logline.contains(tagum)) {
            //排序规则3.1，都是um，按代码行数排序
            sortByCN(o, tagum, 30)
          } else -1
        } //排序规则4，dl放第3类
        else if (logline.contains(tagdl)) {

          if (o.logline.contains(tagul) || o.logline.contains(tagum)) {
            1
          } else if (o.logline.contains(tagdl)) {
            //排序规则4.1，都是dl，按代码行数排序
            sortByCN(o, tagdl, 17)
          } else -1
        } //排序规则5，ftp放最后
        else if (logline.contains(tagftp)) {

          if (o.logline.contains(tagftp)) {
            //排序规则3.1，都是um，按代码行数排序
            sortByCN(o, "Ftp", 9)
          } else 1
        } //异常，没有包含任何tag，放最后，输出该行
        else {
          logger.info("异常行：" + logline)
          1
        }

      } else {
        thisdate.compareTo(odate)
      }

    } catch {
      case e: Exception => 1
    }

  }
}

object CompareableLine {

  def apply(log: String): CompareableLine = new CompareableLine(log)

}