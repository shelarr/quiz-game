import util.{AppParamUtil, ConsoleWrapper, FileParser}

object Application {

  def main(args: Array[String]) {
    val fileName = AppParamUtil.getFileName()
    val timeLimit = AppParamUtil.getTimeLimit()
    val questions = FileParser.getQuestions(fileName)
    val game = new QuizGame(questions, new ConsoleWrapper())
    val score = game.play(timeLimit)
    score.display()
  }

}
