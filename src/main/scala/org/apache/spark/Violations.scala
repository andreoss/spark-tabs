package org.apache.spark

import org.apache.spark.ui.SparkUI

object Violations {
  implicit class ViolatedSparkContext(sc: SparkContext) {
    def uiViolated: SparkUI = sc.ui.getOrElse {
      sys.error("Unable to access Spark UI")
    }
  }
}
