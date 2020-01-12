package org.apache.spark

import org.apache.spark.Violations._
import org.apache.spark.ui.{SparkUI, SparkUITab}


abstract class ViolatedSparkUITab(sc: SparkContext, prefix: String)
  extends SparkUITab(sc.uiViolated, prefix) {

  def ui: Option[SparkUI] = sc.ui
}
