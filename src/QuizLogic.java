import java.util.ArrayList;

public class QuizLogic {
    public void submitAnswer(Quiz quiz, int answer) {
        quiz.submitAnswer(answer);
    }
    
    public boolean isFinished(Quiz quiz) {
        return quiz.isFinished();
    }

    public Quiz loadQuiz() {
        // create a new QuestionDatabase object by passing in the file name
        QuestionDatabase questionDB = new QuestionDatabase("data/questions.txt");
    
        // get the list of questions from the QuestionDatabase object
        ArrayList<Question> questions = questionDB.getQuestions();
    
        // create a new Quiz object and pass in the list of questions
        Quiz quiz = new Quiz(questions);
    
        return quiz;
    }
    
}
