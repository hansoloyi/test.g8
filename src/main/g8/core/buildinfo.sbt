enablePlugins(BuildInfoPlugin)

buildInfoPackage := "$organization$.$package;format="word,packaged"$"

buildInfoKeys := Seq[BuildInfoKey](
  version
)
