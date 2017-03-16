package iantong.net.logutil

/**
  * Created by wjj on 2017/3/16.
  */
class LogLineFactory {

  def getLogLine(name: String, log: String) = {
    name match {
      case "FtpLogLine" => FtpLogLine(log)
      case "G4LogLine" => G4LogLine(log)
    }
  }
}

object LogLineFactory {
  def apply() = new LogLineFactory
}
