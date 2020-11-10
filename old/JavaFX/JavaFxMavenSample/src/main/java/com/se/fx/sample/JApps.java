package com.se.fx.sample;


import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JApps extends Application {

    private static final Logger logger = Logger.getLogger(JApps.class.getName());
    private UserDao userRepository = new UserDao();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Add User");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userNameLabel = new Label("Username:");
        grid.add(userNameLabel, 0, 1);

        TextField usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 1);

        Label lastNameLabel = new Label("Last Name:");
        grid.add(lastNameLabel, 0, 2);

        TextField lastNameTextField = new TextField();
        grid.add(lastNameTextField, 1, 2);

        Label firstNameLabel = new Label("First Name:");
        grid.add(firstNameLabel, 0, 3);

        TextField firstNameTextField = new TextField();
        grid.add(firstNameTextField, 1, 3);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 4);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 4);

        Button saveButton = new Button("Save");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(saveButton);
        grid.add(hBox, 1, 5);

        saveButton.setOnAction(actionEvent -> {
            String username = usernameTextField.getText().trim();
            String lastName = lastNameTextField.getText().trim();
            String firstName = firstNameTextField.getText().trim();
            String password = passwordField.getText();
            if (!StringPool.BLANK.equals(username) && !StringPool.BLANK.equals(lastName)
                    && !StringPool.BLANK.equals(firstName) && !StringPool.BLANK.equals(password)) {
                try {
                    if (!userRepository.userExists(username)) {
                        User user = this.createUserObject(username, lastName, firstName, password);
                        int userId = userRepository.saveUser(user);
                        if (userId > 0) {
                            this.alert("Save", "Successful!", AlertType.INFORMATION);
                        } else {
                            this.alert("Error", "Failed!", AlertType.ERROR);
                        }
                    } else {
                        this.alert("Error", "User already exists!", AlertType.ERROR);
                    }
                } catch (Exception exception) {
                    logger.log(Level.SEVERE, exception.getMessage());
                }
            } else {
                this.alert("Error", "Please complete fields!", AlertType.ERROR);
            }

        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void alert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public User createUserObject(String username, String lastName, String firstName, String password) {
        User user = new User();
        user.setUsername(username);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setPassword(password);

        return user;
    }

    public static void main(String[] args) {
        launch(args);
    }

}