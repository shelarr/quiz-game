package model

case class Score(var totalAttempt: Int, var totalCorrect: Int) {

  def display() {
    println("======== Final Score ======== ")
    println(s"TotalAttempt : $totalAttempt  TotalCorrect : $totalCorrect ")
  }

}
