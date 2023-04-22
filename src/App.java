import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
       
        // create a new QuestionDatabase object by passing in the file name
        QuestionDatabase questionDB = new QuestionDatabase("data/questions.txt");

        // get the list of questions from the QuestionDatabase object
        ArrayList<Question> questions = questionDB.getQuestions();


        // get user preferences for quiz customization
        int numQuestions = Integer.parseInt(JOptionPane.showInputDialog("How many questions would you like in the quiz?"));
        int timeLimit = Integer.parseInt(JOptionPane.showInputDialog("How many minutes would you like for the quiz time limit?"));
        QuizCustomization quizCustomization = new QuizCustomization(numQuestions, timeLimit);

        QuizLogic quizLogic = new QuizLogic();
        Quiz quiz = quizLogic.loadQuiz(quizCustomization,questionDB);

        QuizUI quizUI = new QuizUI(quiz);
        quizUI.displayNextQuestion();
    

      


       

        
    }
}
