package org.sdf.andreoss.spark

import javax.servlet.http.HttpServletRequest
import org.apache.spark._
import org.apache.spark.sql.SparkSession
import org.json4s.JsonAST

import scala.xml.Node

class UIPage(prefix: String) extends ViolatedWebUIPage(prefix) {
  override
  def render(request: HttpServletRequest): Seq[Node] = Seq()

  override
  def renderJson(request: HttpServletRequest): JsonAST.JValue =
    super.renderJson(request)
}

object App extends {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local").getOrCreate()
    val tab = UITab(spark, "Foo")
    Thread.sleep(120000)
  }
}

class UITab(val sc: SparkContext, override val name: String)
  extends ViolatedSparkUITab(sc, "???") {
  def attach(): Unit = {}

  Thread.sleep(1000)
}

object UITab {
  def apply(spark: SparkSession, name: String) =
    new UITab(spark.sparkContext, name)
}
