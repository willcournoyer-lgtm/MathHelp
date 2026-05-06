import javax.swing.JFrame;

// The controller connects the model and view,
// handles user input, and starts the application.

public class GameController {

    private GameModel model;
    private GameView view;

    public GameController() {
        // Initialize model and view
        model = new GameModel();
        view = new GameView();

        // Create the main application window
        JFrame frame = new JFrame("Math Game");

        // Set up frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Add view to frame
        frame.add(view);

        // Make window visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Start the game
        new GameController();
    }

    // Placeholder for control logic

    // Connect user actions to model updates
    public void handleUserInput() {
        // TODO: Listen for button clicks / input
        // and update model + view
    }
}
