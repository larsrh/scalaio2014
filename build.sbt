scalaVersion := "2.10.4"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.0"

libraryDependencies += "org.scalaz" %% "scalaz-concurrent" % "7.1.0"

initialCommands += "import scalaz._, Scalaz._, failing._, flatmap._, flatmapproper._;"
