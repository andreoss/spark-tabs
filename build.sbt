import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "org.sdf.andreoss"
ThisBuild / organizationName := "spark-tabs"
ThisBuild / scapegoatVersion := "1.3.8"

lazy val root = (project in file("."))
  .settings(
    name := "Spark Tabs",
    libraryDependencies += scalaTest % Test
  )

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.3"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.3"
libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "9.4.28.v20200408"
libraryDependencies += "org.scalatestplus" %% "selenium-3-141" % "3.1.1.0" % "test"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.2"
