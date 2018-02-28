import scala.language.postfixOps

name := "$name;format="normalize"$"

shellPrompt in ThisBuild := { state => s"\${Project.extract(state).currentRef.project}-\${version.value}> " }

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

lazy val commonSettings = Seq(
  updateOptions := updateOptions.value.withCachedResolution(true),

  publishTo := {
    val nexus = "https://videoamp.jfrog.io/videoamp/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "snapshot")
    else
      Some("releases" at nexus + "release")
  },

  parallelExecution in Test := false,
  fork in Test := true,

  organization := "$organization$",
  scalaVersion := "2.11.11",

  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),

  resolvers += "vamp release repo" at "https://videoamp.jfrog.io/videoamp/release/",
  resolvers += "vamp snapshot repo" at "https://videoamp.jfrog.io/videoamp/snapshot/",
  resolvers += "vamp test repo" at "https://videoamp.jfrog.io/videoamp/test",
  resolvers += Resolver.sonatypeRepo("public"),
  resolvers += "clojars.org" at "https://clojars.org/repo/",
  resolvers += "central" at "http://repo1.maven.org/maven2",
  resolvers += Resolver.jcenterRepo
)

lazy val core = Project(id = "$name;format="normalize"$-core",
  base = file("core")
).enablePlugins(AssemblyPlugin)
  .settings(commonSettings)

lazy val root = Project(id = "$name;format="normalize"$",
  base = file(".")
).settings(commonSettings)
  .aggregate(core)


publish := ()
publishLocal := ()
