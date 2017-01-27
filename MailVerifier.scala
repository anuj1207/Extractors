package com.knoldus.extractors

/**
  * Created by Anuj and Ramandeep on 25/1/17.
  */
class MailVerifier {

  val pattern = """(^[A-Za-z0-9][A-Za-z0-9\.]*)@((?:[A-Za-z0-9]+\.)+[A-Za-z]{2,63}$)""".r
}


object MailVerifier {

  def main(args: Array[String]) {
    val mailVerifier = new MailVerifier()
    val input = "ramandeep.kaur@knoldus.in"
    input match {
      case mailVerifier.pattern(user,domain)=>{
        println(s"USER   :: $user")
        println(s"DOMAIN :: $domain")
      }
      case _ => println("Invalid Email")
    }
  }

}
