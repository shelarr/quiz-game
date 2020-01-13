package util

import scala.io.StdIn

class ConsoleWrapper {

  def getUserAnswer(): String = {
    StdIn.readLine()
  }

}
