import snunit._
import snunit.routes._
import trail._

object Main {
  def main(args: Array[String]): Unit = {
    val server = SyncServerBuilder()
      .withRequestHandler(
        _.withMethod(Method.GET)
         .withPath("/")(_.send(StatusCode.OK, "", Seq.empty))
      )
      .withRequestHandler(
        _.withMethod(Method.POST)
         .withPath("/user")(_.send(StatusCode.OK, "", Seq.empty))
      )
      .withRequestHandler(
        _.withMethod(Method.GET)
         .withRoute(Root / "user" / Arg[Int]) { case (req, id) =>
           req.send(StatusCode.OK, id.toString, Seq.empty)
         }
      )
      .withRequestHandler(
        _.send(StatusCode.NotFound, "Not found", Seq.empty)
      )
      .build()

    server.listen()
  }
}
