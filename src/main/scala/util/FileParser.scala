package util

import model.Question

object FileParser {

  private val CSV_SEPARATOR = ","

  def getQuestions(fileName: String) = {
    val source = io.Source.fromFile(fileName)
    val seq = source.getLines.map(
      line => {
        val strings = line.split(CSV_SEPARATOR)
          .map(_.trim)
        Question(strings(0), strings(1))
      }).toSeq
    seq
  }

}
