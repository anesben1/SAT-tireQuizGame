public class QuizCustomization {
    private int numQuestions;
    private int timeLimit;

    public QuizCustomization(int numQuestions, int timeLimit) {
        this.numQuestions = numQuestions;
        this.timeLimit = timeLimit;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
