package iantong.net.logutil

import scala.io.Source
import java.io.{File, PrintWriter}

import org.slf4j.{Logger, LoggerFactory}


/**
  *
  */
object LogUtilMain {
  val logger: Logger = LoggerFactory.getLogger(getClass())

  def main(args: Array[String]) {
    val st = System.currentTimeMillis()

    val writer = new PrintWriter(new File(args(1)))
    Source.fromFile(new File(args(0)), "utf-8", 1024 * 1024)
      .getLines()
      .toArray
      .filter(FilterFactory().getFilter(args(2)).filter(_))
      .map(LogLineFactory().getLogLine(args(3), _))
//      .sortWith(_.compareTo(_) < 0)
      .foreach(cl => writer.println(cl.logline))
    writer.close()
    logger.info("use time " + (System.currentTimeMillis() - st).toString + " ms")
  }
}

