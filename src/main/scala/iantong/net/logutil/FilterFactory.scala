package iantong.net.logutil

/**
  * Created by wjj on 2017/3/16.
  */
class FilterFactory {

  def getFilter(name:String):Filterable={
    name match {
      case "FtpLogFilter" =>FtpLogFilter()
    }
  }
}

object FilterFactory {
  def apply() = new FilterFactory
}