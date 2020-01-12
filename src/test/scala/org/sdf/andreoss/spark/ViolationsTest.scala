package org.sdf.andreoss.spark

import org.scalatest.funsuite.AnyFunSuite

class ViolationsTest extends AnyFunSuite {
  test("wraps SparkContext") {
    assertCompiles(
      """
        | import org.apache.spark._
        | import org.apache.spark.Violations._
        | def sc: SparkContext = ???
        | sc.uiViolated
        |""".stripMargin
    )
  }
}
