import java.util.concurrent.TimeoutException

import model.{Question, Score}
import util.ConsoleWrapper

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

class QuizGame(questions: Seq[Question],
               consoleWrapper: ConsoleWrapper) {

  def play(timeLimit: Int = Int.MaxValue): Score = {
    val score = Score(0, 0)
    println("\n====================  Lets Start Quiz ======================\n")
    try {
      val f = Future {askQuestions(score)}
      Await.result(f, timeLimit seconds)
    } catch {
      case _: TimeoutException =>
        println("Time Up !")
    }
    score
  }

  private def askQuestions(score: Score) = {
    questions.foreach(
      q => {
        println("\n" + q.question)
        val playerAnswer = consoleWrapper.getUserAnswer()
        if (playerAnswer equals q.answer.trim) {
          score.totalCorrect += 1
        }
        score.totalAttempt += 1
      }
    )
    score
  }

}
