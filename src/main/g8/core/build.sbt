name := "$name;format="normalize"$-core"

scalacOptions := Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint:_",
  "-Ywarn-adapted-args",
  "-Ywarn-inaccessible",
  "-Ywarn-infer-any",
  "-Ywarn-nullary-override",
  "-Ywarn-nullary-unit",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-unused-import")

libraryDependencies ++= Dependencies.logging
libraryDependencies ++= Dependencies.config
libraryDependencies ++= Dependencies.spark.map(_ % "provided")
libraryDependencies ++= Dependencies.videoampSparkUtils

mainClass in Compile := Some("$organization$.$package;format="word,packaged"$.core.$name;format="Camel"$App")

test in assembly := {}

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("com.fasterxml.jackson.**" -> "shade.com.fasterxml.jackson.@1").inAll,
  ShadeRule.rename("org.json4s.**" -> "shade.org.json4s.@1").inAll
)