import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class GuessingGame implements ActionListener {
  JTextField inputField;
  JButton buttonGuess;
  JButton buttonAgain;
  JLabel labelGuess;
  JLabel labelSnowball;
  JLabel labelMulligan;
  int rdmNbr;

  GuessingGame() {
    Random r = new Random();
    rdmNbr = r.nextInt(101); //since nextInt is exclusive
    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);

    inputField = new JTextField(10);
    inputField.setActionCommand("myTF");

    buttonGuess = new JButton("Button");
    buttonAgain = new JButton("Play Again");

    inputField.addActionListener(this);
    buttonGuess.addActionListener(this);
    buttonAgain.addActionListener(this);

    labelGuess = new JLabel("Enter your guess:");
    labelSnowball = new JLabel("");
    labelMulligan = new JLabel("");

    frame.add(labelGuess);
    frame.add(inputField);
    frame.add(buttonGuess);
    frame.add(labelSnowball);
    frame.add(labelMulligan);
    frame.add(buttonAgain);

    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Button")) {
      int guess = Integer.parseInt(inputField.getText());
      if(guess>rdmNbr) {
        labelSnowball.setText("Too high!");
        labelMulligan.setText("Last guess was " + guess);
      }
      else if(guess<rdmNbr) {
        labelSnowball.setText("Too low!");
        labelMulligan.setText("Last guess was " + guess);
      }
      else if(guess==rdmNbr) {
        labelSnowball.setText("You got it!");
        labelMulligan.setText("Last guess was " + guess);
      }
    }
    else if(ae.getActionCommand().equals("Play Again")) {
      Random r = new Random();
      rdmNbr = r.nextInt(101);

      labelGuess.setText("Enter your guess:");
      labelSnowball.setText("");
      labelMulligan.setText("");

      inputField.setText("");
    }
    else {
      labelSnowball.setText("You pressed Enter. Please press the Guess Button.");
    }
  }
}