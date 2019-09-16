package duke.user;

import duke.command.ExitCommandEvent;
import duke.main.Duke;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Random;


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
    @FXML
    private StackPane header;

    private Duke duke;
    private Random random;

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        random = new Random();
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing. Adds an animated fish to the screen.
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
            animatedFish();
        } catch (ExitCommandEvent e) {
            dialogContainer.getChildren().addAll(
                    new Group(UserBox.getUserDialog("bye")),
                    new Group(QBox.getQDialog("Bye. Hope to see you again soon!"))
            );
            userInput.clear();
            new TimedExit();
        }
    }

    /**
     * Creates an animated fish on the screen.
     */
    @FXML
    private void animatedFish() {
        final ImageView fish = new ImageView();
        fish.setImage(new Image(this.getClass().getResourceAsStream("/images/fish.png")));
        fish.setFitHeight(30);
        fish.setPreserveRatio(true);
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(0.3 * (0.5 - random.nextDouble()));
        colorAdjust.setBrightness(0.1 * (2 - random.nextDouble()));
        colorAdjust.setSaturation(0.2 * (0.9 - random.nextDouble()));
        fish.setEffect(colorAdjust);
        header.getChildren().add(fish);
        Path path = new Path();
        path.getElements().add(new MoveTo(-40, -20 - random.nextDouble() * 100));
        path.getElements().add(new CubicCurveTo( 300 + random.nextDouble() * 900, 0, random.nextDouble() * 300, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120 + random.nextDouble() * 200, 0, 240, 380, 240));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(random.nextDouble() * 2000 + 1500));
        pathTransition.setPath(path);
        pathTransition.setNode(fish);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(3 + random.nextInt(5));
        pathTransition.play();
    }
}