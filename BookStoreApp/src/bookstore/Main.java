/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 *
 * @author super
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Login.getInstance().show(primaryStage);
        primaryStage.show();
    }
    
    @Override
    public void stop(){
        BookUI.getInstance().export();
        LoginManagement.getInstance().export();
        System.out.println("Goodbye!");
    }
    public static void main(String[] args) {
        System.out.println("Hello!");
        launch(args);
    }

   

}
