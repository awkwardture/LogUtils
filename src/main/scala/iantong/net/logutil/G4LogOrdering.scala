package iantong.net.logutil

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
  * Created by wjj on 2017/3/15.
  */
class G4LogOrdering extends Ordering[String] {
  val logger: Logger = LoggerFactory.getLogger(classOf[G4LogOrdering])

  override def compare(x: String, y: String): Int = {
    //实现4g校验日志的排序逻辑
    1

  }
}
