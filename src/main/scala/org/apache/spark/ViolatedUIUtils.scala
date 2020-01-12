package org.apache.spark

import javax.servlet.http.HttpServletRequest
import org.apache.spark.ui.{SparkUITab, UIUtils}

import scala.xml.Node

object ViolatedUIUtils {
  def headerSparkPage(request: HttpServletRequest,
                      title: String,
                      content: => Seq[Node],
                      activeTab: SparkUITab,
                      refreshInterval: Option[Int] = None,
                      helpText: Option[String] = None,
                      showVisualization: Boolean = false,
                      useDataTables: Boolean = false): Seq[Node] =
    UIUtils.headerSparkPage(request, title, content, activeTab, refreshInterval, helpText, showVisualization, useDataTables)

  def prependBaseUri(
                      request: HttpServletRequest,
                      basePath: String = "",
                      resource: String = ""): String =
    UIUtils.prependBaseUri(request, basePath, resource)

}
