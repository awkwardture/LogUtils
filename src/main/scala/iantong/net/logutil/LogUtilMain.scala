package iantong.net.logutil

import scala.io.Source
import java.io.{File, PrintWriter}


/**
  *
  */
object LogUtilMain {

  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("C:\\Users\\ture.wujianjun\\Desktop\\learningScala.txt"))

    Source.fromFile(new File(args(0)), "utf-8", 1024 * 1024)
      .getLines()
      .toArray
      .map(CompareableLine(_))
      .sortWith(_.compareTo(_)<0)
      .foreach(cl=>writer.println(cl.logline))
    writer.close()

  }
}

