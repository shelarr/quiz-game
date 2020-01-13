package util

object AppParamUtil {

  private val DEFAULT_FILE = "./problems.csv"

  private val FILE_PARAM = "file"

  private val TIME_LIMIT_PARAM = "timeLimit"

  def getFileName(): String = {
    val customFile = System.getProperty(FILE_PARAM)
    if (customFile == null) {
      DEFAULT_FILE
    } else {
      customFile
    }
  }

  def getTimeLimit(): Int = {
    val timeLimit = System.getProperty(TIME_LIMIT_PARAM)
    if (timeLimit == null) {
      Int.MaxValue
    } else {
      println(s"$TIME_LIMIT_PARAM : " + timeLimit)
      timeLimit.toInt
    }
  }

}
