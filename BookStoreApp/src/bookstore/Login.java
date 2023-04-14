/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

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
import javafx.stage.Stage;

public class Login extends generalWindow {
    
    private static Login instance;
    
    String title = "Login Window";
    
    Text Username, Password;
    TextField username;
    PasswordField password;
    Button loginButton, closeButton;
    
    private Login(){
        Username = new Text("Username");
        username = new TextField();
        Password = new Text("Password");
        password = new PasswordField();
        
        loginButton = new Button();
        loginButton.setText("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("attempted login with username: \"" + username.getText() + "\" password: \""+ password.getText()+"\"");
                LoginManagement.enter(username.getText(), password.getText(), stage);
                
            }
            
        });
        
        closeButton = new Button();
        closeButton.setText("Exit");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
            System.out.println("Goodbye!");
            System.exit(0);
            }
        });
        
        //hold both buttons
        HBox hbox = new HBox();
        
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(16);
        
        hbox.getChildren().add(loginButton);
        hbox.getChildren().add(closeButton);
        
        //Vertical box
        VBox vbox = new VBox();
        
        vbox.setAlignment(Pos.CENTER);
        
        vbox.setPadding(new Insets(16));
        vbox.setSpacing(16);
        
        vbox.getChildren().add(Username);
        vbox.getChildren().add(username);
        vbox.getChildren().add(Password);
        vbox.getChildren().add(password);
        vbox.getChildren().add(hbox);
        
        
        window = new StackPane();    
        window.getChildren().add(vbox);
        
        scene = new Scene(window, 300, 250);
        
    }
    
    static Login getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new Login();
            return getInstance();
        }
    }
     
}
