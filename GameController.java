import javax.swing.JFrame;

public class GameController {

    private GameModel model;
    private GameView view;

    public GameController() {
        model = new GameModel();
        view = new GameView();

        JFrame frame = new JFrame("Math Tutor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.add(view);
        frame.setVisible(true);

        // ========================
        // MENU -> ADDITION
        // ========================
        view.getAdditionButton().addActionListener(e -> {
            model.generateAdditionQuestion();

            String question = model.getNum1() + " + " + model.getNum2();
            view.setQuestionText(question);

            view.clearAnswerField();
            view.showAdditionScreen();
        });

        // ========================
        // SUBMIT ANSWER
        // ========================
        view.getAnswerField().addActionListener(e -> {
            try {
                int userAnswer = Integer.parseInt(view.getUserAnswer());

                boolean correct = model.checkAnswer(userAnswer);

                view.setResultText(correct);
                view.setStatsText(
                        model.getTotalCorrect(),
                        model.getCorrectInRow(),
                        model.getTotalWrong()
                );

                view.showResultScreen();

            } catch (NumberFormatException ex) {
                view.clearAnswerField();
            }
        });

        // ========================
        // NEXT QUESTION
        // ========================
        view.getNextButton().addActionListener(e -> {
            model.generateAdditionQuestion();

            String question = model.getNum1() + " + " + model.getNum2();
            view.setQuestionText(question);

            view.clearAnswerField();
            view.showAdditionScreen();
        });

        // ========================
        // BACK TO MENU
        // ========================
        view.getHomeButton().addActionListener(e -> {
            view.showMenu();
        });
    }

    public static void main(String[] args) {
        new GameController();
    }
}