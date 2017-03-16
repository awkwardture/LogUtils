package iantong.net.logutil

/**
  * Created by wjj on 2017/3/16.
  */
trait Filterable {
  def filter(s:String):Boolean
}
