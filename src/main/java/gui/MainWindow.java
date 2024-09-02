package gui;

import friendlybot.FriendlyBot;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private FriendlyBot friendlyBot;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user-icon.png"));
    private Image friendlyBotImage = new Image(this.getClass().getResourceAsStream("/images/friendlybot-icon.png"));

    /** Initializes the MainWindow instance */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getFriendlyBotDialog("Hello! I am Friendly Bot! How may I assist you today?",
                        friendlyBotImage)
        );
    }

    /** Injects the FriendlyBot instance */
    public void setFriendlyBot(FriendlyBot d) {
        friendlyBot = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing FriendlyBot's reply and then appends
     * them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = friendlyBot.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getFriendlyBotDialog(response, friendlyBotImage)
        );
        userInput.clear();
    }
}
