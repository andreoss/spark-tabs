package org.sdf.andreoss.spark

import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSuite

class ViolationsTest extends FunSuite with MockFactory {
  test("wraps SparkContext") {
    assertCompiles(
      """
        | def sc: SparkContext = ???
        | sc.uiViolated
        |""".stripMargin
    )
  }
}
