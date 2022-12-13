package controllers;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import lan.bcs.InputPanel;

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

  InputPanel sideInput;
  InputPanel angleInput;

  InputPanel perimeterDisplay;
  InputPanel areaDisplay;
  
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

    sideInput = mainFrame.getSideInput();
    angleInput = mainFrame.getAngleInput();

    perimeterDisplay = mainFrame.getPerimeterDisplay();
    areaDisplay = mainFrame.getAreaDisplay();
  }

  private void addActionEvents() {
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
    exitButton.addActionListener(this);
    creditsButton.addActionListener(this);
  }

  public void calculate() {

    String sideInputString = sideInput.getValue();
    String angleInputString = angleInput.getValue();

    Double side = Double.parseDouble(sideInputString);
    Double angle = Double.parseDouble(angleInputString);

    Double perimeter = 4 * side;

    Double area = Math.pow(side, 2) * Math.sin(Math.toRadians(angle));

    perimeterDisplay.setValue(perimeter.toString());
    areaDisplay.setValue(area.toString());

  }

  private void reset() {
    sideInput.setValue(null);
    angleInput.setValue(null);
    perimeterDisplay.setValue(null);
    areaDisplay.setValue(null);
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