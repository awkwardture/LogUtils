package iantong.net.logutil

import scala.io.Source
import java.io.File


/**
  *
  */
object LogUtilMain {

  def main(args: Array[String]) {
    val sortArr=Source.fromFile(new File(args(0)), "utf-8", 1024 * 1024)
      .getLines()
      .toArray
      .map(CompareableLine(_))
      .sortWith(_.compareTo(_)<0)
      .foreach(cl=>println(cl.logline))

  }
}

