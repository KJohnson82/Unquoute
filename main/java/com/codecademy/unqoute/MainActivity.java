package com.codecademy.unqoute;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int currentQuestionIndex, totalCorrect;
    int totalQuestions;
    int MAX = totalQuestions - 1;

    ArrayList<Question> questions;

    ImageView questionImageView;
    TextView questionTextView;
    TextView questionsRemainingTextView;
    Button answer0Button;
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button submitButton;

    // Launch the App and Create UI

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO 2-G: Show app icon in ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_unquote_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_main);

        questionImageView = findViewById(R.id.iv_main_question_image);
        questionTextView = findViewById(R.id.tv_main_question_title);
        questionsRemainingTextView = findViewById(R.id.tv_main_questions_remaining_count);
        answer0Button = findViewById(R.id.btn_main_answer_0);
        answer1Button = findViewById(R.id.btn_main_answer_1);
        answer2Button = findViewById(R.id.btn_main_answer_2);
        answer3Button = findViewById(R.id.btn_main_answer_3);
        submitButton = findViewById(R.id.btn_main_submit_answer);



        // TODO 4-E: set onClickListener for each answer Button
        answer0Button.setOnClickListener(v -> onAnswerSelected(0));
        answer1Button.setOnClickListener(v -> onAnswerSelected(1));
        answer2Button.setOnClickListener(v -> onAnswerSelected(2));
        answer3Button.setOnClickListener(v -> onAnswerSelected(3));
        submitButton.setOnClickListener(v -> onAnswerSubmission());



        startNewGame();
    }

    // displays question to screen

    void displayQuestion(Question question) {
        questionImageView.setImageResource(question.imageId);
        questionTextView.setText(question.questionText);
        answer0Button.setText(question.answer0);
        answer1Button.setText(question.answer1);
        answer2Button.setText(question.answer2);
        answer3Button.setText(question.answer3);


    }

    // Displays question remaining number

    void displayQuestionsRemaining(Integer questionsRemaining) {
        questionsRemainingTextView.setText(Integer.toString(questionsRemaining));


    }

    void onAnswerSelected(int answerSelection) {
        Question currentQuestion = getCurrentQuestion();
        currentQuestion.playerAnswer = answerSelection;
         answer0Button.setText(currentQuestion.answer0);
         answer1Button.setText(currentQuestion.answer1);
         answer2Button.setText(currentQuestion.answer2);
         answer3Button.setText(currentQuestion.answer3);

        if(answerSelection==0){
            answer0Button.setText("✔"+ currentQuestion.answer0);
            answer1Button.setText(currentQuestion.answer1);
            answer2Button.setText(currentQuestion.answer2);
            answer3Button.setText(currentQuestion.answer3);
        }
        if(answerSelection==1){
            answer0Button.setText(currentQuestion.answer0);
            answer1Button.setText("✔"+ currentQuestion.answer1);
            answer2Button.setText(currentQuestion.answer2);
            answer3Button.setText(currentQuestion.answer3);
        }
        if(answerSelection==2){
            answer0Button.setText(currentQuestion.answer0);
            answer1Button.setText(currentQuestion.answer1);
            answer2Button.setText("✔"+ currentQuestion.answer2);
            answer3Button.setText(currentQuestion.answer3);
        }
        if(answerSelection==3){
            answer0Button.setText(currentQuestion.answer0);
            answer1Button.setText(currentQuestion.answer1);
            answer2Button.setText(currentQuestion.answer2);
            answer3Button.setText("✔"+ currentQuestion.answer3);
        }

    }

    void onAnswerSubmission() {
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion.playerAnswer == -1) {
            return;
        }
        if (currentQuestion.isCorrect()) {
            totalCorrect = totalCorrect + 1;
        }
        questions.remove(currentQuestion);

        displayQuestionsRemaining(questions.size());

        if (questions.size() == 0) {
            String gameOverMessage = getGameOverMessage(totalCorrect, totalQuestions);

            AlertDialog.Builder gameOverDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            gameOverDialogBuilder.setCancelable(false);
            gameOverDialogBuilder.setTitle("Game Over!");
            gameOverDialogBuilder.setMessage(gameOverMessage);
            gameOverDialogBuilder.setPositiveButton("Play Again?", (dialog, which) -> startNewGame());
            gameOverDialogBuilder.create().show();

        }
        else {
            chooseNewQuestion();
            displayQuestion(currentQuestion);
        }



        // TODO: uncomment after implementing displayQuestion();
//        displayQuestion(currentQuestion);

    }








    void startNewGame() {
        Question quest0 = new Question(R.mipmap.img_quote_0,
                "Pretty good advice, and perhaps a scientist did say it...Who actually did?", "Albert Einstein", "Isaac Newton", "Rita Mae Brown", "Rosalind Franklin", 2);
        Question quest1 = new Question(R.mipmap.img_quote_1,
                "Was honest Abe honestly quoted? Who authored this pithy bit of wisdom?", "Edward Stieglitz", "Maya Angelou", "Abraham Lincoln", "Ralph Waldo Emerson", 0);
        Question quest2 = new Question(R.mipmap.img_quote_2,
                "Easy advice to read, difficult advice to follow — who actually said it?", "Martin Luther King Jr.", "Mother Teresa", "Fred Rogers", "Oprah Winfrey", 1);
        Question quest3 = new Question(R.mipmap.img_quote_3,
                "Insanely inspiring, insanely incorrect (maybe). Who is the true source of this inspiration?!", "Nelson Mandela", "Harriet Tubman1", "Mahatma Gandhi", "Nicholas Klein", 3);
        Question quest4 = new Question(R.mipmap.img_quote_4,
                "A peace worth striving for — who actually reminded us of this?", "Malala Yousafzai", "Martin Luther King Jr.", "Liu Xiaobo", "Dalai Lama", 1);
        Question quest5 = new Question(R.mipmap.img_quote_5,
                "Unfortunately, true — but did Marilyn Monroe convey it or did someone else?", "Laurel Thatcher Ulrich", "Eleanor Roosevelt", "Marilyn Monroe", "Queen Victoria",
                0);
        Question quest6 = new Question(R.mipmap.img_quote_6, "Here’s the truth, Will Smith did say this, but in which movie?", "Independance Day", "Bad Boys", "Men In Black", "The Pursuit of Happyness", 2 );


        questions = new ArrayList<Question>();
        questions.add(quest0);
        questions.add(quest1);
        questions.add(quest2);
        questions.add(quest3);
        questions.add(quest4);
        questions.add(quest5);
        questions.add(quest6);

        while (questions.size() > 6) {
            int questionIndexToRemove = generateRandomNumber(questions.size());
            questions.remove(questionIndexToRemove);
        }



        totalCorrect = 0;
        totalQuestions = questions.size();

        Question firstQuestion = chooseNewQuestion();
        displayQuestionsRemaining(questions.size());
        displayQuestion(firstQuestion);


    }

    int generateRandomNumber(int totalQuestions) {
        Random rand = new Random();
        int randNum = rand.nextInt(totalQuestions);
        return randNum;

    }

    Question chooseNewQuestion() {
        currentQuestionIndex = generateRandomNumber(questions.size());
        return questions.get(currentQuestionIndex);


    }

//    int generateRandomNumber(int totalQuestions) {
//        Random rand = new Random();
//        int randNum = rand.nextInt(totalQuestions);
//        return randNum;
//
//    }

    Question getCurrentQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);

        return currentQuestion;
    }

    String getGameOverMessage(int totalCorrect, int totalQuestions) {
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