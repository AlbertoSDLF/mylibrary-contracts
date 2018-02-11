package com.fm.mylibrary.producer

import akka.stream.Materializer
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.fm.mylibrary.consumer.model.Category

import scala.concurrent.ExecutionContext
import spray.json._
import com.fm.mylibrary.consumer.model.JsonProtocol._


trait Routes {

  implicit val materializer: Materializer
  implicit val executionContext: ExecutionContext

  val searchRoutes: Route = {
    pathPrefix("search" / "category") {
      get {
        complete {
          List[Category]().toJson
        }
      }
    }
  }

  val routes: Route = searchRoutes
}
