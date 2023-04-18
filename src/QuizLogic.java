public class QuizLogic {
    public void submitAnswer(Quiz quiz, int answer) {
        quiz.submitAnswer(answer);
    }
    
    public boolean isFinished(Quiz quiz) {
        return quiz.isFinished();
    }
}
