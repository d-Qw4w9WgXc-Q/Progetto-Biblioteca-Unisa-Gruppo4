package it.unisa.diem.inginf.biblioteca.ui;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class App extends Application {
    @Override
    public void start(Stage stage) {
        
        Button b_utenti = new Button("Utenti");
        Button b_libri = new Button("Libri");
        Button b_prestiti = new Button("Prestiti");
        
        ToolBar toolbar = new ToolBar(b_utenti, b_libri, b_prestiti);
        
        ScrollPane list = new ScrollPane();
        list.setPrefSize(500, 400);
        
        Button add = new Button("+");
        Button remove = new Button("-");
        add.setPrefSize(40, 40);
        remove.setPrefSize(40, 40);
        
        HBox controls = new HBox(add, remove);
        
        GridPane grid = new GridPane();
        grid.add(toolbar, 0, 0);
        grid.add(list, 0, 1);
        grid.add(controls, 0, 2);
        Scene scene = new Scene(grid, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
