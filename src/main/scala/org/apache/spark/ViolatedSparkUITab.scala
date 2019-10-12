package org.apache.spark

import org.apache.spark.ui.{SparkUI, SparkUITab, WebUIPage}
import org.apache.spark.Violations._

abstract class ViolatedWebUIPage(prefix: String)
  extends WebUIPage(prefix)

abstract class ViolatedSparkUITab(sc: SparkContext, prefix: String)
  extends SparkUITab(sc.uiViolated, prefix) {

  def ui: Option[SparkUI] = sc.ui
}
