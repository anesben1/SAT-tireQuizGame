import java.util.ArrayList;

public class Quiz {
    // instance variables
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private int numQuestions;
    
    // constructor
    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.numQuestions = questions.size();
    }
    

    // get question 
    public Question getQuestion() {
        return questions.get(currentQuestionIndex);
    }
    

    // submit answer 
    public void submitAnswer(int answer) {
        if (answer == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }
        currentQuestionIndex++;
    }



    //check end of the quiz 
    public boolean isFinished() {
        return currentQuestionIndex >= questions.size();
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void nextQuestion(){
        currentQuestionIndex++;
    }


    public Question getCurrentQuestion(){
        return questions.get(currentQuestionIndex);
    }
    public int getScore() {
        return score;
    }
    
    
    // methods
    // public voichd displayCurrentQuestion() {
    //     // display the current question to the user
    // }
    
    // public boolean checkAnswer(String answer) {
    //     // check if the user's answer is correct
        
    // }
    
    // public boolean hasNextQuestion() {
    //     // check if there is another question in the quiz
    // }
    
    // public void nextQuestion() {
    //     // move on to the next question
    // }
    
    // public int getScore() {
    //     // get the user's current score
    // }
    
    // public int getTotalQuestions() {
    //     // get the total number of questions in the quiz
    // }
}
