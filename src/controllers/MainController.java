package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import models.MainModel;
import views.MainFrame;

public class MainController implements ActionListener {
  MainFrame mainFrame;
  MainModel mainModel;
  
  public MainController() {
    this.mainFrame = new MainFrame();
    this.mainModel = new MainModel();

    addActionEvents();
  }

  private void addActionEvents() {
    mainFrame.submitButton.addActionListener(this);
    mainFrame.exitButton.addActionListener(this);
    mainFrame.creditsButton.addActionListener(this);
  }

  private void exit() {
    System.exit(0);
  }

  public void calculate() {
    Double side = Double.parseDouble(mainFrame.sideInput.getValue());
    Double angle = Double.parseDouble(mainFrame.angleInput.getValue());

    Double perimeter = 4 * side;

    Double area = Math.pow(side, 2) * Math.sin(Math.toRadians(angle));

    System.out.println(area);

    mainFrame.perimeter.setValue(perimeter.toString());
    mainFrame.area.setValue(area.toString());

  }

  @Override
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == mainFrame.submitButton) {
      calculate();
    } else if (event.getSource() == mainFrame.creditsButton) {
      System.out.println("Credits");
    } else if (event.getSource() == mainFrame.exitButton) {
      System.out.println("o");
      exit();
    }
  }
}