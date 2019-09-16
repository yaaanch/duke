package duke.user;

import duke.command.ExitCommandEvent;
import duke.main.Duke;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
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

    private Duke duke;

//    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
//    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/duke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        try {
            String input = userInput.getText();
            String response = duke.getResponse(input);
            dialogContainer.getChildren().addAll(
                    new Group(UserBox.getUserDialog(input)),
                    new Group(QBox.getQDialog(response))
            );
            userInput.clear();
        } catch (ExitCommandEvent e) {
            dialogContainer.getChildren().addAll(
                    new Group(UserBox.getUserDialog("bye")),
                    new Group(QBox.getQDialog("Bye. Hope to see you again soon!"))
            );
            userInput.clear();
            new TimedExit();
        }
    }
}