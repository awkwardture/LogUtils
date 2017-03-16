package iantong.net.logutil

/**
  * Created by wjj on 2017/3/16.
  * 类直接继承函数，配合apply，类实例就是一个函数可以直接调用
  * val fl=new FtpLogFilter
  * fl("abc")
  */
class FtpLogFilter  extends Function[String,Boolean]{
  def apply(s: String): Boolean = s.length>0 && s.substring(0,1) == "["
}
