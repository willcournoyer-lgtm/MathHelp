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
        // ADDITION BUTTON
        // ========================
        view.getAdditionButton().addActionListener(e -> {
            model.generateAdditionQuestion();

            view.setQuestionText(
                model.getNum1() + " + " + model.getNum2()
            );

            view.clearAnswer();
            view.showGame();
        });

        // ========================
        // SUBTRACTION BUTTON
        // ========================
        view.getSubtractionButton().addActionListener(e -> {
            model.generateSubtractionQuestion();

            view.setQuestionText(
                model.getNum1() + " - " + model.getNum2()
            );

            view.clearAnswer();
            view.showGame();
        });

        // ========================
        // ANSWER SUBMIT
        // ========================
        view.getAnswerField().addActionListener(e -> {
            try {
                int answer = Integer.parseInt(view.getUserAnswer());

                boolean correct = model.checkAnswer(answer);

                view.setResult(correct);
                view.setStats(
                        model.getTotalCorrect(),
                        model.getCorrectInRow(),
                        model.getTotalWrong()
                );

                view.showResult();

            } catch (Exception ex) {
                view.clearAnswer();
            }
        });

        // ========================
        // NEXT QUESTION
        // ========================
        view.getNextButton().addActionListener(e -> {

            if (model.getCurrentMode().equals("ADDITION")) {
                model.generateAdditionQuestion();
                view.setQuestionText(
                    model.getNum1() + " + " + model.getNum2()
                );
            } else if (model.getCurrentMode().equals("SUBTRACTION")) {
                model.generateSubtractionQuestion();
                view.setQuestionText(
                    model.getNum1() + " - " + model.getNum2()
                );
            }

            view.clearAnswer();
            view.showGame();
        });

        // ========================
        // HOME BUTTON
        // ========================
        view.getHomeButton().addActionListener(e -> {
            view.showMenu();
        });
    }

    public static void main(String[] args) {
        new GameController();
    }
}
