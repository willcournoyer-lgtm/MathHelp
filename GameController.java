import javax.swing.JFrame;

public class GameController {

    private GameModel model;
    private GameView view;

    public GameController() {
        model = new GameModel();
        view = new GameView();

        JFrame frame = new JFrame("Math Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(view);
        frame.setVisible(true);

        // ✅ ✅ ALL EVENT CODE GOES INSIDE HERE ✅ ✅

        view.getAdditionButton().addActionListener(e -> {
            model.generateAdditionQuestion();

            String question = model.getNum1() + " + " + model.getNum2();
            view.setQuestionText(question);

            view.showAdditionScreen();
        });

        view.getAnswerField().addActionListener(e -> {
            try {
                int userAnswer = Integer.parseInt(view.getUserAnswer());

                boolean correct = model.checkAnswer(userAnswer);

                model.generateAdditionQuestion();
                String newQuestion = model.getNum1() + " + " + model.getNum2();
                view.setQuestionText(newQuestion);

                view.clearAnswerField();

            } catch (NumberFormatException ex) {
                view.clearAnswerField();
            }
        });

        // ✅ ✅ END OF CONSTRUCTOR ✅ ✅
    }

    public static void main(String[] args) {
        new GameController();
    }
}