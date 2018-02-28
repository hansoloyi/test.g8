import com.trueaccord.scalapb.compiler.Version.scalapbVersion
import sbt._

object Dependencies {
  val json4sVersion = "3.2.11"
  val jacksonVersion = "2.6.5"
  val sparkVersion = "2.2.0"

  val videoampSparkUtils = Seq(
    "com.videoamp" %% "spark-util" % "3.0.0"
  )

  val videoampRoaringBitmap = Seq(
    "com.videoamp" % "RoaringBitmap" % "0.6.28"
  )

  val jackson = Seq(
    "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
    "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion,
    "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion
  )

  val json4s = Seq(
    "org.json4s" %% "json4s-jackson" % json4sVersion
  )

  val test = Seq(
    "org.scalatest" %% "scalatest" % "3.0.4" % "test"
  )

  val scalajHttp = Seq(
    "org.scalaj" %% "scalaj-http" % "2.3.0"
  )

  val spark = Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion
      exclude ("com.typesafe", "config"),
    "org.apache.spark" %% "spark-hive" % sparkVersion
  )

  val logging = Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"
  )

  val config = Seq(
    "com.typesafe" % "config" % "1.3.1"
  )
}