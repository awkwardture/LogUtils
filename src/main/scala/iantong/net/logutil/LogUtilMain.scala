package iantong.net.logutil

import scala.io.Source
import java.io.{File, PrintWriter}

import org.slf4j.{Logger, LoggerFactory}


/**
  *
  */
object LogUtilMain {
  val logger: Logger = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]) {
    val st = System.currentTimeMillis()

    val writer = new PrintWriter(new File(args(1)))
    Source.fromFile(new File(args(0)), "utf-8", 1024 * 1024)
      .getLines
      .toArray
      .filter(FilterFactory(args(2)))
      .sorted(LogOrderingFactory(args(3)))
      .foreach(writer.println)
    writer.close()
    logger.info("use time " + (System.currentTimeMillis() - st).toString + " ms")
  }
}

