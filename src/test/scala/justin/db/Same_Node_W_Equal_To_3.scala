package justin.db

import java.util.UUID

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class Same_Node_W_Equal_To_3 extends Simulation {

  def id = UUID.randomUUID().toString

  val scn = scenario("Send data to the same node with w=3 option").repeat(100) {
    exec(http("PUT data")
      .post("http://localhost:9000/put")
      .header(HttpHeaderNames.ContentType, HttpHeaderValues.ApplicationJson)
      .body(StringBody(session =>
        s"""{
          "id"    : "$id",
          "value" : "some value",
          "w"     : 3
        }"""))
      .asJSON
      .check(status.is(204))
    ).pause(100.millis)
  }

  setUp(scn.inject(atOnceUsers(10)))
}
