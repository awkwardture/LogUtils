package iantong.net.logutil

/**
  * Created by wjj on 2017/3/16.
  */
object LogOrderingFactory {
  def apply(name: String): Ordering[String] = name match {
    case "FtpLogOrdering" => new FtpLogOrdering
    case "G4LogOrdering" => new G4LogOrdering
  }
}
