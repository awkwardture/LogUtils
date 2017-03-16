package iantong.net.logutil

/**
  * Created by wjj on 2017/3/16.
  */
class FtpLogFilter  extends Filterable{
  override def filter(s: String): Boolean = s.length>0 && s.substring(0,1) == "["
}

object FtpLogFilter{
  def apply() = new FtpLogFilter
}