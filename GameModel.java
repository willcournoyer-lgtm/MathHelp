import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// The model handles all game logic and data.
// IMPORTANT: No Swing imports here.

public class GameModel {

    // ========================
    // GENERAL TRACKING DATA
    // ========================
    private int totalCorrect;
    private int correctInRow;
    private int totalWrong;
    private List<Integer> selectedAnswers;

    private Random random;

    // ========================
    // ADDITION SECTION
    // ========================
    private int num1;
    private int num2;
    private int correctAnswer;

    public GameModel() {
        totalCorrect = 0;
        correctInRow = 0;
        totalWrong = 0;
        selectedAnswers = new ArrayList<>();
        random = new Random();

        generateAdditionQuestion();
    }

    // ========================
    // ADDITION METHODS
    // ========================

    // Generate a new addition question
    public void generateAdditionQuestion() {
        num1 = random.nextInt(999) + 1; // 1–999
        num2 = random.nextInt(999) + 1; // 1–999
        correctAnswer = num1 + num2;
    }

    // Get current question numbers
    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    // Check user's answer
    public boolean checkAnswer(int userAnswer) {
        selectedAnswers.add(userAnswer);

        if (userAnswer == correctAnswer) {
            totalCorrect++;
            correctInRow++;
            return true;
        } else {
            totalWrong++;
            correctInRow = 0; // reset streak
            return false;
        }
    }

    // ========================
    // GETTERS FOR STATS
    // ========================

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public int getCorrectInRow() {
        return correctInRow;
    }

    public int getTotalWrong() {
        return totalWrong;
    }

    public List<Integer> getSelectedAnswers() {
        return selectedAnswers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    // Reset game
    public void resetGame() {
        totalCorrect = 0;
        correctInRow = 0;
        totalWrong = 0;
        selectedAnswers.clear();
        generateAdditionQuestion();
    }
}