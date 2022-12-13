package controllers;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.event.ActionEvent;

import models.MainModel;
import views.MainFrame;

public class MainController implements ActionListener {
  MainFrame mainFrame;
  MainModel mainModel;

  JButton submitButton;
  JButton resetButton;
  JButton creditsButton;
  JButton exitButton;
  
  public MainController() {

    start();
    addActionEvents();
  }

  private void start() {
    this.mainFrame = new MainFrame();
    this.mainModel = new MainModel();

    submitButton = mainFrame.getSubmitButton();
    resetButton = mainFrame.getResetButton();
    creditsButton = mainFrame.getCreditsButton();
    exitButton = mainFrame.getExitButton();
  }

  private void addActionEvents() {
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
    exitButton.addActionListener(this);
    creditsButton.addActionListener(this);
  }

  public void calculate() {
    Double side = Double.parseDouble(mainFrame.sideInput.getValue());
    Double angle = Double.parseDouble(mainFrame.angleInput.getValue());

    Double perimeter = 4 * side;

    Double area = Math.pow(side, 2) * Math.sin(Math.toRadians(angle));

    mainFrame.perimeterDisplay.setValue(perimeter.toString());
    mainFrame.areaDisplay.setValue(area.toString());

  }

  private void reset() {
    mainFrame.sideInput.setValue(null);
    mainFrame.angleInput.setValue(null);
    mainFrame.perimeterDisplay.setValue(null);
    mainFrame.areaDisplay.setValue(null);
  }

  private void displayCredits() {
    System.out.println("Credits");
  }

  private void exit() {
    System.exit(0);
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == submitButton) {
      calculate();
    } else if (event.getSource() == resetButton) {
      reset();
    } else if (event.getSource() == creditsButton) {
      displayCredits();
    } else if (event.getSource() == exitButton) {
      exit();
    }
  }
}