
package models.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object chat extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,org.webjars.play.WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webSocketUrl: String)(implicit webJarsUtil: org.webjars.play.WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.76*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
        <title>SSB Chatbot</title>
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="SONAE Web Bot">
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="theme-color" content="#1a274c">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("../../public/stylesheets/main.css")),format.raw/*14.114*/("""">
    </head>
    <body>
        <div id="watson" class="watson">
            <div class="mensagens">
                <div class="area" id="chat">
		</div>
            </div>
            <form id="mensagem" class="mensagem">
                <input type="text" id="chat-messages" name="chat-messages" placeholder="Digite sua mensagem"/>
                <button type="submit">Enviar</button>
            </form>
        </div>
    </body>
</html>"""))
      }
    }
  }

  def render(webSocketUrl:String,webJarsUtil:org.webjars.play.WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(webSocketUrl)(webJarsUtil)

  def f:((String) => (org.webjars.play.WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (webSocketUrl) => (webJarsUtil) => apply(webSocketUrl)(webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue May 22 10:29:51 GFT 2018
                  SOURCE: C:/Users/muchmore/chatbot-java/app/models/chat.scala.html
                  HASH: b486fd67c9677a9c550006cde002c9c43c38de8c
                  MATRIX: 977->1|1146->75|1174->77|1874->750|1889->756|1965->810
                  LINES: 28->1|33->1|34->2|46->14|46->14|46->14
                  -- GENERATED --
              */
          