import java.util.ArrayList;
import java.util.List;

// The model handles all game logic and data.
// IMPORTANT: No Swing imports here.

public class GameModel {

    // Total number of correct answers
    private int totalCorrect;

    // Number of correct answers in a row (streak)
    private int correctInRow;

    // Total number of wrong answers
    private int totalWrong;

    // Stores all answers selected by the player
    private List<Integer> selectedAnswers;

    public GameModel() {
        totalCorrect = 0;
        correctInRow = 0;
        totalWrong = 0;
        selectedAnswers = new ArrayList<>();
    }

    // Record a correct answer
    public void recordCorrectAnswer(int answer) {
        totalCorrect++;
        correctInRow++;
        selectedAnswers.add(answer);
    }

    // Record a wrong answer
    public void recordWrongAnswer(int answer) {
        totalWrong++;
        correctInRow = 0; // reset streak
        selectedAnswers.add(answer);
    }

    // Get total correct answers
    public int getTotalCorrect() {
        return totalCorrect;
    }

    // Get current correct streak
    public int getCorrectInRow() {
        return correctInRow;
    }

    // Get total wrong answers
    public int getTotalWrong() {
        return totalWrong;
    }

    // Get all selected answers
    public List<Integer> getSelectedAnswers() {
        return selectedAnswers;
    }

    // Reset game stats
    public void resetGame() {
        totalCorrect = 0;
        correctInRow = 0;
        totalWrong = 0;
        selectedAnswers.clear();
    }
}
