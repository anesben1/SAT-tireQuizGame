import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionDatabase {
    // instance variable
    private ArrayList<Question> questions;
    
    // constructor
    public QuestionDatabase(String fileName) {
        questions = new ArrayList<Question>();
        
        try {
            File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            
            String questionText = parts[0];
            String[] answerChoices = parts[1].split(";");
            int correctAnswerIndex = Integer.parseInt(parts[2]);
            
            Question question = new Question(questionText, answerChoices, correctAnswerIndex);
            questions.add(question);
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
    
    
    // methods
    public ArrayList<Question> getQuestions() {
        // return the collection of questions
        return questions;
    }
}
