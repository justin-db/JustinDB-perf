package justin.db

import java.util.UUID

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Same_Node_W_Equal_To_1 extends Simulation {

  val scn = scenario("Send data to the same node with w=1 option")
    .exec(http("PUT data")
      .post("http://localhost:9000/put")
      .header(HttpHeaderNames.ContentType, HttpHeaderValues.ApplicationJson)
      .body(StringBody(s"""{
          "id"    : "${UUID.randomUUID().toString}",
          "value" : "some value",
          "w"     : 1
        }"""))
      .asJSON
      .check(status.is(204))
    )
    .pause(5.seconds)

  setUp(scn.inject(atOnceUsers(1)))
}
