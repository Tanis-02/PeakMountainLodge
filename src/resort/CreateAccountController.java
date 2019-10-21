package resort;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Everything in the CreateAccountController corresponds to items on the create_account.fxml file.
 */
public class CreateAccountController {

  /** Text field to insert the user's first name into the database. */
  @FXML private TextField firstName;

  /** Text field to insert the user's last name into the database. */
  @FXML private TextField lastName;

  /** Text field to insert the user's phone number into the database. */
  @FXML private TextField phoneNumber;

  /** Text field to insert the user's email into the database. */
  @FXML private TextField email;

  /** Combo box to allow the user to choose from which region they are from. */
  @FXML private ComboBox<String> region;

  /** Text field to insert the user's address into the database. */
  @FXML private TextField address;

  /** Text field to insert the user's zip code into the database. */
  @FXML private TextField zipCode;

  /** Text field to insert the user's password into the database. */
  @FXML private PasswordField password;

  /** Check box to receive the user's permission to send a confirmation email to them. */
  @FXML private CheckBox confirmation;

  /** Check box to receive the user's permission to send promotional emails to them. */
  @FXML private CheckBox promotions;

  /**
   * Universal goToPreviousPage() function is used to bring the user to the previous page they were
   * on. It will be used across almost all screens.
   *
   * @throws IOException yes, it does
   */
  public void initialize() {
    ObservableList<String> option =
        FXCollections.observableArrayList( "United States", "Canada", "France", "Germany", "United Kingdom");
    region.setItems(option);
    region.getSelectionModel();
  }

  @FXML
  void goToPreviousPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("available_rooms.fxml"));
    Stage home = new Stage();
    home.setTitle("Please choose a room");
    home.setScene(new Scene(root, 800, 700));
    home.show();
  }
}
