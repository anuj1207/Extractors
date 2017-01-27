package com.knoldus.extractors

/**
  * Created by ANUJ RAMANDEEP on 1/26/2017.
  */

object URL{

  def

  apply(protocol:String,domain:String,path:String, params:Map[String,String]):String = {

    val paramString = params.view map {
      case (key, value) => key + "=" + value
    } mkString ("&")

    s"$protocol://$domain$path?$paramString"

  }



  def unapply(url:String):Option[(String , String, String,Map[String,String])] = {

    if(url.contains("://")){

      val protocolPlusRest = url.split("://")
      val protocol = protocolPlusRest(0)
      if(protocolPlusRest(1).contains('/')){
        val domainPlusPath = protocolPlusRest(1).split("/",2)
        val domain = domainPlusPath(0)

        if(domainPlusPath(1).contains('?')){
          val pathPlusParams = domainPlusPath(1).split("\\?")
          val path = s"/${pathPlusParams(0)}"
          val params = for(x <- pathPlusParams(1).split("&")) yield {
            (x.split("=")(0),x.split("=")(1))
          }
          Some(protocol,domain,path,params.toMap)
        }
        else{
          val path = domainPlusPath(1)
          Some(protocol,domain,path,Map())
        }
      }
      else{
        val domain = protocolPlusRest(1)
        Some(protocol,domain,"",Map())
      }
    }
    else
      None
  }
}


object ExtractorOps {

  def main(args: Array[String]): Unit = {
    val s = "https://aws.amazon.com"

    s match {

      case URL(protocol,domain,path,params) => println(s"Protocol:$protocol\nDomain:$domain\nPath:$path\nParam:$params")
      case _ => println("URL not RECOGNISED")

    }
  }

}
