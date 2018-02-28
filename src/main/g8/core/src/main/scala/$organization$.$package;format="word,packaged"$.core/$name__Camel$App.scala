package $organization$.$package;format="packaged,word"$.core

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.SparkSession
import $organization$.$package;format="word,packaged"$.BuildInfo

object $name;format="Camel"$App extends LazyLogging {
  def main(args: Array[String]): Unit = {
    sys.props("app.buildInfo") = BuildInfo.toString
    println(BuildInfo.toString)

    val spark =
      SparkSession
        .builder
        .appName(s"$name$: \${BuildInfo.version}")
        .enableHiveSupport()
        .getOrCreate

    println("hello world")
    spark.stop()
  }
}