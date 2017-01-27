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
    val mailVerifier.pattern(user,domain)= "ramandeep.kaur@knoldus.in"
    println(s"USER   :: $user")
    println(s"DOMAIN :: $domain")
  }

}