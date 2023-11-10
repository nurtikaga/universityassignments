import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

// Singleton pattern
class GameData extends Observable {
    private static GameData instance;

    private int secretNumber;
    private int attempts;

    private GameData() {
        resetGame();
    }

    public static synchronized GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }
        return instance;
    }

    public void resetGame() {
        secretNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
        setChanged();
        notifyObservers("Game reset. Try guessing a new number.");
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void incrementAttempts() {
        attempts++;
    }
}

// Strategy pattern
interface GuessValidationStrategy {
    boolean validateGuess(int guess);
}

class BasicGuessValidationStrategy implements GuessValidationStrategy {
    @Override
    public boolean validateGuess(int guess) {
        return true;
    }
}

class RangeGuessValidationStrategy implements GuessValidationStrategy {
    @Override
    public boolean validateGuess(int guess) {
        return guess >= 1 && guess <= 100;
    }
}

// Decorator pattern
abstract class GuessDecorator implements GuessValidationStrategy {
    protected GuessValidationStrategy guessValidationStrategy;

    public GuessDecorator(GuessValidationStrategy guessValidationStrategy) {
        this.guessValidationStrategy = guessValidationStrategy;
    }
}

class EvenNumberGuessDecorator extends GuessDecorator {
    public EvenNumberGuessDecorator(GuessValidationStrategy guessValidationStrategy) {
        super(guessValidationStrategy);
    }

    @Override
    public boolean validateGuess(int guess) {
        return guessValidationStrategy.validateGuess(guess) && guess % 2 == 0;
    }
}

// Adapter pattern
class GuessAdapter implements GuessValidationStrategy {
    private RangeGuessValidationStrategy rangeStrategy;

    public GuessAdapter(RangeGuessValidationStrategy rangeStrategy) {
        this.rangeStrategy = rangeStrategy;
    }

    @Override
    public boolean validateGuess(int guess) {
        // Adapt RangeGuessValidationStrategy to work as GuessValidationStrategy
        return rangeStrategy.validateGuess(guess);
    }
}

// Observer pattern
class GameObserver implements Observer {
    private JTextArea resultArea;

    public GameObserver(JTextArea resultArea) {
        this.resultArea = resultArea;
    }

    @Override
    public void update(Observable o, Object arg) {
        resultArea.append(arg.toString() + "\n");
    }
}

// Factory Method pattern
class GuessValidationStrategyFactory {
    public static GuessValidationStrategy createGuessValidationStrategy(boolean rangeValidation, boolean evenNumberValidation) {
        GuessValidationStrategy strategy = new BasicGuessValidationStrategy();

        if (rangeValidation) {
            strategy = new RangeGuessValidationStrategy();
        }

        if (evenNumberValidation) {
            strategy = new EvenNumberGuessDecorator(strategy);
        }

        return strategy;
    }
}

// MVC components
class GuessNumberView extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    protected JTextArea resultArea;

    public GuessNumberView() {
        super("Guess the Number Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        add(new JLabel("Enter your guess:"));
        add(guessField);
        add(guessButton);
        add(new JScrollPane(resultArea));

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(guessField.getText());
                GameController.makeGuess(guess);
            }
        });
    }

    public void updateResult(String result) {
        resultArea.append(result + "\n");
    }
}

class GameController {
    private static GameData gameData;
    private static GuessNumberView view;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gameData = GameData.getInstance();
                view = new GuessNumberView();
                view.setVisible(true);

                // Observer registration
                GameObserver gameObserver = new GameObserver(view.resultArea);
                gameData.addObserver(gameObserver);
            }
        });
    }

    public static void makeGuess(int guess) {
        GuessValidationStrategy strategy = GuessValidationStrategyFactory.createGuessValidationStrategy(true, true);

        if (strategy.validateGuess(guess)) {
            gameData.incrementAttempts();

            if (guess == gameData.getSecretNumber()) {
                gameData.resetGame();
            } else {
                String result = guess < gameData.getSecretNumber() ? "Try a higher number." : "Try a lower number.";
                view.updateResult(result);
            }
        } else {
            view.updateResult("Invalid guess. Please enter a valid even number between 1 and 100.");
        }
    }
}
