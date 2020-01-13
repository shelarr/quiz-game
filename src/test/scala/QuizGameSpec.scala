import java.util.concurrent.TimeoutException

import model.Question
import org.mockito.Mockito.when
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatestplus.mockito.MockitoSugar
import util.ConsoleWrapper

import scala.collection.mutable.ArrayBuffer

class QuizGameSpec extends AnyFlatSpec with MockitoSugar {

  "play" should
    "return the score for attempted quiz questions" in {
    val questions = getQuestions
    val consoleWrapper = mock[ConsoleWrapper]
    val quizGame = new QuizGame(questions, consoleWrapper)
    when(consoleWrapper.getUserAnswer()).thenReturn("10")
      .thenReturn("3")
      .thenReturn("5")

    val score = quizGame.play()

    score.totalAttempt mustBe 3
    score.totalCorrect mustBe 2
  }

  it should
    "return the score for attempted quiz questions if there is timeout" in {

    val questions = getQuestions
    val consoleWrapper = mock[ConsoleWrapper]
    val quizGame = new QuizGame(questions, consoleWrapper)
    when(consoleWrapper.getUserAnswer()).thenReturn("10")
      .thenReturn("3")
      .thenThrow(new TimeoutException())

    val score = quizGame.play()

    score.totalAttempt mustBe 2
    score.totalCorrect mustBe 1
  }

  private def getQuestions: Seq[Question] = {
    ArrayBuffer(
      Question("5+5", "10"),
      Question("1+1", "2"),
      Question("2+3", "5")
    ).toSeq
  }

}
