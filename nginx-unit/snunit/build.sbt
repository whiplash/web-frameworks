scalaVersion := "2.11.12"
enablePlugins(ScalaNativePlugin)
libraryDependencies ++= Seq("snunit", "snunit-routes").map("com.github.lolgab" %%% _ % "0.0.4")
nativeMode := "release-full"
nativeLTO := "thin"
