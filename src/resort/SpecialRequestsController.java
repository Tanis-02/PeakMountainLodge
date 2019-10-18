package resort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SpecialRequestsController {

  @FXML private ComboBox<?> typeOfBedding;

  @FXML private ComboBox<?> quantityOfBedding;

  @FXML private ComboBox<?> typeOfToiletry;

  @FXML private ComboBox<?> quantityOfToiletry;

  public void initialize() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      numbers.add(i);
    }
    ObservableList numberList = FXCollections.observableList(numbers);
    quantityOfBedding.getItems().clear();
    quantityOfBedding.setItems(numberList);
    quantityOfBedding.getSelectionModel().selectFirst();
    quantityOfToiletry.getItems().clear();
    quantityOfToiletry.setItems(numberList);
    quantityOfToiletry.getSelectionModel().selectFirst();
  }

  @FXML
  void goToConfirmationPage(MouseEvent event) {}

  /**
   * Universal goToPreviousPage() function is used to bring the user to the previous page they were
   * on. It will be used across almost all screens.
   *
   * @param event MouseEvent upon clicking the back button
   * @throws IOException yes, it does
   */
  @FXML
  void goToPreviousPage(MouseEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("current_guest_options.fxml"));
    Stage home = new Stage();
    home.setTitle("Please choose an option");
    home.setScene(new Scene(root, 800, 600));
    home.show();
  }
}
