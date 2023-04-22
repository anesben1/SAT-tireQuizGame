import java.util.ArrayList;

public class QuizLogic {
    public void submitAnswer(Quiz quiz, int answer) {
        quiz.submitAnswer(answer);
    }
    
    public boolean isFinished(Quiz quiz) {
        return quiz.isFinished();
    }

    public Quiz loadQuiz(QuizCustomization quizCustomization, QuestionDatabase questionDB) {
        ArrayList<Question> allQuestions = questionDB.getQuestions();
        int numQuestions = quizCustomization.getNumQuestions();
        if (numQuestions > allQuestions.size()) {
            numQuestions = allQuestions.size();
        }
        ArrayList<Question> questions = new ArrayList<Question>();
        for (int i = 0; i < numQuestions; i++) {
            questions.add(allQuestions.get(i));
        }
        return new Quiz(questions);
    }
    
    
}
