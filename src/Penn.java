import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by young on 6/29/17.
 */
public class Penn {

    static TextArea letter;
    static String name;

    public static void display(String a) {
        name = a;

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Your Penn Application");
        window.setResizable(false);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #ffffff;");
        hbox.setAlignment(Pos.TOP_LEFT);

        letter = new TextArea();
        letter.setEditable(false);
        int caretPosition = letter.getCaretPosition();
        Image pennLogo = new Image("file:donotedit/Penn.png");
        // Get random number. 0~5 acceptance, 6~99 rejection
        Random decision = new Random();
        int num = decision.nextInt(100);
        if (num >= 0 && num < 10) {
            getAcceptanceText();
        } else if (num >= 10 && num < 20) {
            getWaitlistText();
        } else {
            getRejectionText();
        }
        letter.positionCaret(caretPosition);
        ImageView image = new ImageView();
        image.setImage(pennLogo);
        image.setFitWidth(350);
        image.setPreserveRatio(true);
        hbox.getChildren().add(image);

        letter.setWrapText(true);
        letter.setStyle("-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background ;");

        BorderPane layout = new BorderPane();
        layout.setCenter(letter);
        layout.setTop(hbox);
        layout.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout, 800, 700);

        window.setScene(scene);
        window.showAndWait();
    }

    private static void getRejectionText() {
        try {
            Scanner sc = new Scanner(new File("donotedit/PennRejection.txt"));
            letter.appendText("March 31, 2017");
            letter.appendText("\n\n");
            letter.appendText("Dear " + name + ",\n\n");
            while (sc.hasNext()) {
                letter.appendText(sc.nextLine() + " ");
                letter.appendText("\n");
            }
        } catch (FileNotFoundException c) {
            System.out.println("File not found.");
        }
    }

    private static void getAcceptanceText() {
        try {
            Scanner sc = new Scanner(new File("donotedit/PennAcceptance.txt"));
            letter.appendText("March 31, 2017");
            letter.appendText("\n\n");
            letter.appendText("Dear " + name + ",\n\n");
            while (sc.hasNext()) {
                letter.appendText(sc.nextLine() + " ");
                letter.appendText("\n");
            }
        } catch (FileNotFoundException c) {
            System.out.println("File not found.");
        }
    }

    private static void getWaitlistText() {
        try {
            Scanner sc = new Scanner(new File("donotedit/PennWaitlist.txt"));
            letter.appendText("March 31, 2017");
            letter.appendText("\n\n");
            letter.appendText("Dear " + name + ",\n\n");
            while (sc.hasNext()) {
                letter.appendText(sc.nextLine() + " ");
                letter.appendText("\n");
            }
        } catch (FileNotFoundException c) {
            System.out.println("File not found.");
        }
    }
}
