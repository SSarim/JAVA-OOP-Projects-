/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public abstract class generalWindow {
       
        Scene scene;
        Stage stage;
        StackPane window;
        String title;
        public void show(Stage pass){
            pass.setTitle(title);
            pass.setScene(scene);
            stage = pass;
        }
}