// The model handles all game logic and data.
// IMPORTANT: No Swing imports here.

public class GameModel {

    // Example fields (to be expanded later)
    private int score;

    public GameModel() {
        // Initialize game state
        score = 0;
    }

    // Placeholder methods

    // Generate a math question
    public void generateQuestion() {
        // TODO: Create random math problem
    }

    // Check if answer is correct
    public boolean checkAnswer(int answer) {
        // TODO: Compare answer to correct value
        return false;
    }

    // Get current score
    public int getScore() {
        return score;
    }

    // Update score
    public void incrementScore() {
        score++;
    }
}
