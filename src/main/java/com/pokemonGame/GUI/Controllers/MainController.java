package com.pokemonGame.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

public class MainController
{
    @FXML
    private StackPane contentArea;

    @FXML private View1Controller view1Controller;
    @FXML private View2Controller view2Controller;

    @FXML private Node view1;
    @FXML private Node view2;

    @FXML public void initialize(){
        view1.setVisible(false);
        view1.setManaged(false);

        view2.setVisible(false);
        view2.setManaged(false);

        showView(view1);
    }

    @FXML public void navigateToView(int view){
        showView(view1);

        System.out.println("Navegando a vista 1");
    }
}
