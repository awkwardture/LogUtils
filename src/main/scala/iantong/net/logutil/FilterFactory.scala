package iantong.net.logutil

/**
  * Created by wjj on 2017/3/16.
  * scala的工厂模式，直接用object，配合apply
  */
object FilterFactory {
  def apply(name:String):Function[String,Boolean] = name match {
    case "FtpLogFilter" =>new FtpLogFilter
  }
}