package util

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

class FileParserSpec extends AnyFlatSpec {

  "getQuestions" should
    "return questions from file" in {
    val questions = FileParser.getQuestions("./problems.csv")
    questions.size mustBe 12
    questions(0).question mustBe "5+5"
    questions(0).answer mustBe "10"
  }

}
