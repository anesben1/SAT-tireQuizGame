import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
       
        QuizUI quiz = new QuizUI();
        QuizLogic quizLogic = new QuizLogic();
        quizLogic.loadQuiz();



        // create a new QuestionDatabase object by passing in the file name
        QuestionDatabase questionDB = new QuestionDatabase("data/questions.txt");

        // get the list of questions from the QuestionDatabase object
        ArrayList<Question> questions = questionDB.getQuestions();

        // iterate through the list of questions and print them out
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            System.out.println("Answer Choices:");
            for (String choice : question.getAnswerChoices()) {
                System.out.println("- " + choice);
            }
            System.out.println("Correct Answer Index: " + question.getCorrectAnswerIndex());
        }


       

        
    }
}
