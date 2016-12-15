enablePlugins(GatlingPlugin)

lazy val root = (project in file(".")).settings(
  name         := "JustinDB-load-testing",
  version      := "0.0.1",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.3" % "test,it",
    "io.gatling"            % "gatling-test-framework"    % "2.2.3" % "test,it"
  )
)
