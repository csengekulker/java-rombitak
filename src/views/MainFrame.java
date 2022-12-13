package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lan.bcs.InputPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
  JPanel mainPanel;

  JPanel northPanel;
    JLabel mainLabel;

  JPanel centerPanel;
    InputPanel sideInput;
    InputPanel angleInput;
    JButton submitButton;
    InputPanel perimeter;
    InputPanel area;

  JPanel southPanel;
    JButton exitButton;
    JButton creditsButton;

  public MainFrame() {

    setMainPanel();
    setComponents();
    setFrame();
  }

  private void setComponents() {

    northPanel = new JPanel();
      mainLabel = new JLabel("Rombusz adatai");

    centerPanel = new JPanel(new GridLayout(5, 1));

      sideInput = new InputPanel();
      sideInput.setText("A oldal:");
      angleInput = new InputPanel();
      angleInput.setText(("Alpha: "));

      submitButton = new JButton("Számítás");

      perimeter = new InputPanel();
      perimeter.setText("Kerület: ");
      area = new InputPanel();
      area.setText("Terület: ");

    southPanel = new JPanel(new GridLayout(1, 2));

      exitButton = new JButton("Kilépés");
      creditsButton = new JButton("Névjegy");

    northPanel.add(mainLabel);

    centerPanel.add(sideInput);
    centerPanel.add(angleInput);
    centerPanel.add(submitButton);
    centerPanel.add(perimeter);
    centerPanel.add(area);

    southPanel.add(creditsButton);
    southPanel.add(exitButton);

    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);

  }

  private void setMainPanel() {
    this.mainPanel = new JPanel(new BorderLayout());

    this.add(this.mainPanel);
  }

  private void setFrame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 300);
    this.setTitle("Rombusz");
    this.setVisible(true);

  }
}