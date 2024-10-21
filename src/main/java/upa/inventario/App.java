package upa.inventario;

import Login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Cargar el archivo FXML para "Login.fxml"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root = loader.load();

        // Crear la escena
        scene = new Scene(root);
        primaryStage.setScene(scene);
        
        //Ponerle titulo
        primaryStage.setTitle("Login");

        // Mostrar la ventana
        primaryStage.show();
        
        //asigamos controlador
        LoginController controller = loader.getController();
        controller.setStage(primaryStage);
        primaryStage.show();
    }

    // Cambiar la raíz de la escena, en caso de necesitar cambiar la ventana
    static void setRoot(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml"));
        Parent root = loader.load();
        scene.setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
