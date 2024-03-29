/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
import bookstore.BookUI.book;
import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

public class ownerUI extends generalWindow {

    String title = "Admin Window";

    Text welcomeText;
    VBox vbox;
    Button books, customers, logoutButton;

    private static ownerUI instance;
    
    private ownerUI(){
        
        welcomeText = new Text("Select what you want to edit.");
        
        books = new Button();
        books.setText("Books");
        books.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                adminBookWindow.getInstance().show(stage);
                System.out.println("books button clicked");
            }
        });

        customers = new Button();
        customers.setText("Customers");
        customers.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                adminUserWindow.getInstance().show(stage);
                System.out.println("customers button clicked");
            }
        });

        logoutButton = new Button();
        logoutButton.setText("Log Out");
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Logged out");
                Login.getInstance().show(stage);
            }
        });

        vbox = new VBox();

        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(16));
        vbox.setSpacing(16);

        vbox.getChildren().add(welcomeText);
        vbox.getChildren().add(books);
        vbox.getChildren().add(customers);

        vbox.getChildren().add(logoutButton);

        window = new StackPane();
        window.getChildren().add(vbox);

        scene = new Scene(window, 300, 250);
    }

    static ownerUI getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new ownerUI();
            return getInstance();
        }
    }

}


class adminBookWindow extends generalWindow {
    
    VBox mainVertical, subVertical;
    HBox bottomButtons;
    ArrayList<HBox> listItems;
    Button delete,back,add,save;
    TableView table;
    BookUI handler = BookUI.getInstance();
    ObservableList<BookUI.book> data;

    
    String title = "Book Window";
    
    private static adminBookWindow instance;
    
    private adminBookWindow(){
        
        ObservableList<BookUI.book> data = FXCollections.observableArrayList(handler.getBookDB());

        mainVertical = new VBox();
        subVertical = new VBox();
        bottomButtons = new HBox();
        
        
        table = new TableView();
        table.setEditable(true);
        TableColumn titleCol = new TableColumn("Title");
        TableColumn priceCol = new TableColumn("Price");
        TableColumn selectCol = new TableColumn("Select");
        selectCol.setMinWidth(25);
        
        selectCol.setCellValueFactory(new PropertyValueFactory<book,CheckBox>("selected"));
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));

        selectCol.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<book,Boolean>,ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<book, Boolean> b) {
                    return b.getValue().getSelected().selectedProperty();
                }
            });
        
        titleCol.setCellValueFactory( new PropertyValueFactory<book, String>("title") );
        
        titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
        titleCol.setOnEditCommit(
            new EventHandler<CellEditEvent<book, String>>() {
                @Override
                public void handle(CellEditEvent<book, String> t) {
                    ((book) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setTitle(t.getNewValue());
                }
            }
        );
        
        priceCol.setCellValueFactory( new PropertyValueFactory<book, Integer>("price") );
        
        
        
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceCol.setOnEditCommit(
            new EventHandler<CellEditEvent<book, Integer>>() {
                @Override
                public void handle(CellEditEvent<book, Integer> t) {
                    ((book) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setPrice(t.getNewValue());
                }
            }
        );
        
        table.setItems(data);
        table.getColumns().addAll(titleCol, priceCol, selectCol);
        
        subVertical.getChildren().add(table);
        
        back = new Button();
        
        back.setText("Back");
        back.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ownerUI.getInstance().show(stage);
                System.out.println("back button clicked");
                //do something
            }
        });
        back.setMinWidth(60);
        
        bottomButtons.getChildren().add(back);
        
        Region spacer = new Region();
        spacer.setPrefWidth(800);
        bottomButtons.getChildren().add(spacer);

        
        delete = new Button();
        
        delete.setText("Delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //handler.export();
                //handler.reload();
                ArrayList<book> toDelete = new ArrayList<book>();
                for(book b: data) {
                    if(b.getSelected().isSelected()) {
                        toDelete.add(b);
                    }
                }
                
                for(book b: toDelete){
                    handler.removeBook(b.getPrice(), b.getTitle());
                }
                ObservableList<BookUI.book> data = null;
                data = FXCollections.observableArrayList(handler.getBookDB());
                table.getItems().clear();
                table.setItems(data);
                table.refresh();
                        
                System.out.println("delete button clicked");

            }
        });
        delete.setMinWidth(60);
        
        bottomButtons.getChildren().add(delete);
        
        add = new Button();
        
        add.setText("Add");
        add.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                handler.createBook(0, "New Book");
                ObservableList<BookUI.book> data = null;
                data = FXCollections.observableArrayList(handler.getBookDB());
                table.getItems().clear();
                table.setItems(data);
                table.refresh();
                System.out.println("add button clicked");
            }
        });
        add.setMinWidth(60);
        
        bottomButtons.getChildren().add(add);
        
        save = new Button();
        
        save.setText("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                handler.export();
                System.out.println("save button clicked");
            }
        });
        save.setMinWidth(60);
        
        bottomButtons.getChildren().add(save);
        
        mainVertical.getChildren().add(subVertical);
        mainVertical.getChildren().add(bottomButtons);
        
        window = new StackPane();       
        window.getChildren().add(mainVertical);
        
        scene = new Scene(window, 300, 250);
    }
    
    static adminBookWindow getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new adminBookWindow();
            return getInstance();
        }
    }
    
}

class adminUserWindow extends generalWindow {
    
    VBox mainVertical, subVertical;
    HBox bottomButtons;
    ArrayList<HBox> listItems;
    Button delete,back,add,save;
    TableView table;
    LoginManagement handler = LoginManagement.getInstance();
    ObservableList<Customer> data;

    
    String title = "Book Window";
    
    private static adminUserWindow instance;
    
    private adminUserWindow(){
        
        ObservableList<Customer> data = FXCollections.observableArrayList(handler.getUserDB());

        mainVertical = new VBox();
        subVertical = new VBox();
        bottomButtons = new HBox();
        
        
        table = new TableView();
        table.setEditable(true);
        TableColumn nameCol = new TableColumn("Username");
        TableColumn passwordCol = new TableColumn("Password");
        TableColumn pointsCol = new TableColumn("Points");
        TableColumn selectCol = new TableColumn("Select");
        selectCol.setMinWidth(25);
        
        selectCol.setCellValueFactory(new PropertyValueFactory<Customer,CheckBox>("selected"));
        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));

        selectCol.setCellValueFactory(
            new Callback<TableColumn.CellDataFeatures<Customer,Boolean>,ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Customer, Boolean> b) {
                    return b.getValue().getSelected().selectedProperty();
                }
            });
        
        nameCol.setCellValueFactory( new PropertyValueFactory<Customer, String>("username") );
        
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Customer, String>>() {
                @Override
                public void handle(CellEditEvent<Customer, String> t) {
                    ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setUsername(t.getNewValue());
                }
            }
        );
        
        passwordCol.setCellValueFactory( new PropertyValueFactory<Customer, String>("password") );
        
        passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Customer, String>>() {
                @Override
                public void handle(CellEditEvent<Customer, String> t) {
                    ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setPassword(t.getNewValue());
                }
            }
        );
        
        pointsCol.setCellValueFactory( new PropertyValueFactory<Customer, Integer>("points") );
        
        pointsCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        pointsCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Customer, Integer>>() {
                @Override
                public void handle(CellEditEvent<Customer, Integer> t) {
                    ((Customer) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setPoints(t.getNewValue());
                }
            }
        );
        
        table.setItems(data);
        table.getColumns().addAll(nameCol, passwordCol, pointsCol, selectCol);
        
        subVertical.getChildren().add(table);
        
        back = new Button();
        
        back.setText("Back");
        back.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ownerUI.getInstance().show(stage);
                System.out.println("back button clicked");
            }
        });
        back.setMinWidth(60);
        
        bottomButtons.getChildren().add(back);
        
        Region spacer = new Region();
        spacer.setPrefWidth(800);
        bottomButtons.getChildren().add(spacer);

        
        delete = new Button();
        
        delete.setText("Delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                for(Customer b: data) {
                    if(b.getSelected().isSelected()) {
                        handler.removeBook(b);
                    }
                }
                ObservableList<Customer> data = null;
                data = FXCollections.observableArrayList(handler.getUserDB());
                table.getItems().clear();
                table.setItems(data);
                table.refresh();
                
                System.out.println("delete button clicked");
            }
        });
        delete.setMinWidth(60);
        
        bottomButtons.getChildren().add(delete);
        
         add = new Button();
        
        add.setText("Add");
        add.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                handler.createBook("username","password",0);
                ObservableList<User> data = null;
                data = FXCollections.observableArrayList(handler.getUserDB());
                table.getItems().clear();
                table.setItems(data);
                table.refresh();
                System.out.println("add button clicked");
            }
        });
        add.setMinWidth(60);
        
        bottomButtons.getChildren().add(add);
        
        save = new Button();
        
        save.setText("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                handler.export();
                System.out.println("save button clicked");
            }
        });
        save.setMinWidth(60);
        
        bottomButtons.getChildren().add(save);
        
        mainVertical.getChildren().add(subVertical);
        mainVertical.getChildren().add(bottomButtons);
        
        window = new StackPane();       
        window.getChildren().add(mainVertical);
        
        scene = new Scene(window, 300, 250);
    }
    
    static adminUserWindow getInstance(){
        if(instance != null){
            return instance;
        }else{
            instance = new adminUserWindow();
            return getInstance();
        }
    }
    
}
