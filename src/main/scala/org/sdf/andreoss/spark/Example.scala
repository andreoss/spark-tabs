package org.sdf.andreoss.spark

import javax.servlet.http.HttpServletRequest
import org.apache.spark._
import org.apache.spark.sql.SparkSession

import scala.xml.Node

class RickrollTab(parent: SparkContext) extends ViolatedSparkUITab(parent, "rickroll") {
  init()

  private def init(): Unit = {
    attachPage(new RickrollPage(this))
  }

}

class RickrollPage(parent: ViolatedSparkUITab)
  extends ViolatedWebUIPage("") {

  def render(request: HttpServletRequest): Seq[Node] = {
    val content =
      <div>
        {<script src={ViolatedUIUtils.prependBaseUri(request, "/static/utils.js")}></script>}<iframe src="https://www.youtube.com/embed/dQw4w9WgXcQ" width="420" height="315" frameborder="0" allowfullscreen="">
      </iframe>

      </div>

    ViolatedUIUtils.headerSparkPage(request, "Rickroll", content, parent, useDataTables = true)
  }
}

object Example extends App {

  import Violations._

  val spark: SparkSession = SparkSession.builder.master("local").getOrCreate()

  spark.sparkContext.uiViolated.attachTab(
    new RickrollTab(spark.sparkContext)
  )
  Thread.sleep(100000)
}


