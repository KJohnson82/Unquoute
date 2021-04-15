
public class Question {
	
	int correctAnswer;
	int playerAnswer;
	int imageId;
	
	String questionText;
	String answer0, answer1, answer2, answer3;
	
	
	public Question(int imageIdentifier, String questionString, String answerZero, String answerOne, String answerTwo, 
			String answerThree, int correctAnswerIndex) {
		imageId = imageIdentifier;
		questionText = questionString;
		answer0 = answerZero;
		answer1 = answerOne;
		answer2 = answerTwo;
		answer3 = answerThree;
		correctAnswer = correctAnswerIndex;
		playerAnswer = -1;
		
	}
	
	public boolean isCorrect() {
		if (playerAnswer == correctAnswer) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	

}
