package com.pokemonGame.GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.Node; 

public class MainController {

    @FXML
    private StackPane contentArea;

    // Controladores de las vistas que los inyectara en automatico es decir jalara en automatico los hijos 
    // y puedes tener acceso a dicho controlador

    // Por ejemplo podemos llamar a metodos setters de dicha vista si necesitamos acceder a propiedades del padre
    @FXML private View1Controller view1Controller;
    @FXML private View2Controller view2Controller;

    // Este es el nodo en si, la vista.
    @FXML private Node view1; 
    @FXML private Node view2; 

    @FXML
    public void initialize() {
        // Inicializa las vistas como no visibles y no manegables por lo que no 
        // no se tomaran en cuenta tampoco para mostrar las vistas
        view1.setVisible(false);
        view1.setManaged(false); 

        view2.setVisible(false);
        view2.setManaged(false);}
        // Muestra la vista correspondiente
        showView(view1);
    }

    @FXML
    public void navigateToView(int view) {
        // Podemos hacer un ternario para que solo el de la vista deseada se muestra
        
        showView(view1);


        System.out.println("Navegando a la Vista 1");
    }
}