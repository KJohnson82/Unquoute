import java.util.ArrayList;
import java.util.Random;

public class MainActivity {
	

    // TODO #1: add integer member variables here
	int currentQuestionIndex;
	int totalCorrect;
	int totalQuestions;

    // TODO #2: add ArrayList member variable here
	ArrayList<Question> questions;

    // TODO #3 add startNewGame() here
	public Question startNewGame() {
		Question quest1 = new Question(9211238, "How tall is the Eiffel tower?", "1024 ft", "1063 ft", "1124 ft", "1163 ft", 1);
    	Question quest2 = new Question(107343, "Who invented the computer algorithm?", "Charles Babbage", "John Carmack", "Alan Turing", "Ada Lovelace", 3);
    	Question quest3 = new Question(748294, "What is the name for the patch of skin found on your elbow?", "Elbow Skin", "Fascia Elbora", "Wenis", "Todd", 2);
    	
    	ArrayList<Question> quiz = new ArrayList<>();
    	this.questions = quiz;
    	this.questions.add(quest1);
    	this.questions.add(quest2);
    	this.questions.add(quest3);
	}
    	
    	
    	


    // TODO #4 add chooseNewQuestion() here

    // TODO #5 add getCurrentQuestion() here

    // TODO #6 add onAnswerSubmission() here
	
	
	// Generate Random Number
	public int generateRandomNumber(int max) {
		Random rand = new Random();
    int randNum = rand.nextInt(3);
		return randNum;
		
	}
	
	//Game Over Method
	public String getGameOverMessage(int totalCorrect, int totalQuestions) {
		if (totalCorrect == totalQuestions) {
			String allCorrect = "You got all " + totalQuestions + " correct! You win!";
			return allCorrect;
		}
		else {
			String numCorrect = "You got " + totalCorrect + " correct out of " + totalQuestions + ". Better luck next time!";
			return numCorrect;
		}
	}
	
	
	
}