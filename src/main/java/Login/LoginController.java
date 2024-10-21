package Login;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import upa.inventario.MainViewController;

public class LoginController {

    @FXML
    private Button BtnEnter;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;
    private Stage stage;
    
//    public void initialize() {
//    txtUser.requestFocus();
//}

    @FXML
void ValidationFields(ActionEvent event) throws IOException {
    
    String valueUser = txtUser.getText();
    String valuePassword = txtPassword.getText();
    
//    String regex = "^[a-zA-Z0-9]+$";
    
    
    System.out.println("Hola");
    System.out.println(valueUser);
    System.out.println(valuePassword);
    
   
    if ( "up230328".equals(valueUser) && "holaUpa24".equals(valuePassword) ){
        System.out.println("Exito");
    //    else if( ! valueUser.matches(regex) ){
//          System.out.println("Error: El nombre de usuario solo puede contener letras y números.");
//    }
//    else if( valuePassword.length() < 8  ){
//        System.out.println("Error: ");
//    }
    
        // Cargar la nueva vista desde el archivo FXML
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
    Parent root = loader.load();

    // Crear una nueva escena y establecerla en un nuevo Stage
    Stage newStage = new Stage();
    Scene scene = new Scene(root);
    newStage.setScene(scene);
    newStage.show();

    // Cerrar la ventana actual (ventana de login)
    Stage currentStage = (Stage) BtnEnter.getScene().getWindow();
    currentStage.close();
    }
    else{
        System.out.println("Error: Los campos estan vacios");
    }
}



    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }




}