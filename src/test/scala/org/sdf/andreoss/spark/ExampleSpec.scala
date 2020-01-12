package org.sdf.andreoss.spark

import org.apache.spark.Violations
import org.apache.spark.sql.SparkSession
import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser

class ExampleSpec extends AnyFlatSpec with WebBrowser with Matchers with BeforeAndAfterAll {

  implicit val web: WebDriver = new HtmlUnitDriver
  var spark: SparkSession = _

  override def beforeAll() {
    spark = SparkSession.builder().master("local[1]").getOrCreate()
    import Violations._
    spark.sparkContext.uiViolated.attachTab(
      new RickrollTab(spark.sparkContext)
    )
  }

  override def afterAll() {
    spark.stop
  }

  "Spark page" should "have an extra tab" in {
    val df = spark.sql("select 1")
    go to (spark.sparkContext.uiWebUrl.get)
    clickOn(LinkTextQuery("Rickroll"))
    pageTitle should endWith("Rickroll")
    df.collect()
  }
}