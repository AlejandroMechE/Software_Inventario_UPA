package upa.inventario;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainViewController {
    @FXML
    private Button BtnNewCrud;

    @FXML
    private Button BtnNewCrud1;

    @FXML
    private Button BtnNewCrud11;

    @FXML
    private Button BtnNewCrud111;

    @FXML
    private Button BtnNewCrud112;

    @FXML
    private Button BtnNewCrud12;

    @FXML
    private Pane PaneClients;

    @FXML
    private Pane PaneCrud;

    @FXML
    private Pane PaneMontlySales;

    @FXML
    private Pane PaneProviders;

    @FXML
    private Pane PaneSales;

    @FXML
    private TableView<?> TableCrud;

    @FXML
    private TableView<?> TableCrud11;

    @FXML
    private TableView<?> TableCrud111;

    @FXML
    private TableView<?> TableCrud12;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_search;

    @FXML
    private Button button_inicio1;

    @FXML
    private Button button_inicio2;

    @FXML
    private Button button_inicio21;

    @FXML
    private Button button_inicio211;

    @FXML
    private TableView<?> clientTable;

    @FXML
        private TableColumn<?, ?> direccionColumn;

    @FXML
        private TableColumn<?, ?> nombreColumn;
   
    @FXML
        private TableColumn<?, ?> recetaColumn;
    
    @FXML
        private TableColumn<?, ?> verColumn;
      
    @FXML
        private TableColumn<?, ?> telefonoColumn;

  @FXML
    private Pane pane_content1;

    @FXML
    private Pane pane_content11;

    @FXML
    private Pane pane_content111;

    @FXML
    private Pane pane_content1111;

    @FXML
    private Pane pane_content2;

 
    @FXML
    private HBox root;

    @FXML
    private TextField search_bar;

    @FXML
    private AnchorPane side_ankerpane;

    

    @FXML
    private Pane top_pane;

   


   

@FXML
    void goWarehouse(ActionEvent event) throws IOException {
      
      pane_content1.setVisible(false);
      pane_content2.setVisible(false);
      pane_content1111.setVisible(false);
      pane_content111.setVisible(false);
      pane_content11.setVisible(false);
      
      PaneCrud.setVisible(true);
      top_pane.setVisible(true);
      PaneClients.setVisible(false);
      PaneSales.setVisible(false);
      PaneMontlySales.setVisible(false);
      PaneProviders.setVisible(false);
      
        
    }
    
@FXML
    void GoHome(ActionEvent event) {
        
      pane_content1.setVisible(true);
      pane_content2.setVisible(true);
      pane_content1111.setVisible(true);
      pane_content111.setVisible(true);
      pane_content11.setVisible(true);
      
      PaneCrud.setVisible(false);
      top_pane.setVisible(false);
      PaneClients.setVisible(false);
      PaneSales.setVisible(false);
      PaneMontlySales.setVisible(false);
      PaneProviders.setVisible(false);
        
    }

        @FXML
    void GoNewProduct(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InventoryForm.fxml"));
    Parent root = loader.load();
    
    Stage newStage = new Stage();
    Scene scene = new Scene(root);
    newStage.setScene(scene);
    newStage.show();
   
    }
    
      @FXML
void GoClients(ActionEvent event) {
    
    pane_content1.setVisible(false);
    pane_content2.setVisible(false);
    pane_content1111.setVisible(false);
    pane_content111.setVisible(false);
    pane_content11.setVisible(false);
    
    PaneClients.setVisible(true);
    top_pane.setVisible(true);
    PaneCrud.setVisible(false);  
    PaneSales.setVisible(false);
    PaneMontlySales.setVisible(false);
    PaneProviders.setVisible(false);
    
    HttpURLConnection connection = null;
    try {
        // Create connection
        URL url = new URL("http://127.0.0.1:8000/clients/Client/");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        // Get response
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        InputStream inputStream;
        if (responseCode >= 200 && responseCode < 300) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream(); // For non-2xx responses
        }

        // Read and log the JSON response
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            System.out.println("Response: " + response.toString()); // Log the JSON response
        }
    } catch (IOException e) {
        e.printStackTrace(); // Log errors for debugging
    } finally {
        if (connection != null) {
            connection.disconnect();
        }
    }
}

        @FXML
    void GoNewClient(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewClientForm.fxml"));
    Parent root = loader.load();
    
    Stage newStage = new Stage();
    Scene scene = new Scene(root);
    newStage.setScene(scene);
    newStage.show();
    }
       @FXML
    void GoToSales(ActionEvent event) {

      pane_content1.setVisible(false);
      pane_content2.setVisible(false);
      pane_content1111.setVisible(false);
      pane_content111.setVisible(false);
      pane_content11.setVisible(false);
      
      PaneClients.setVisible(false);
      top_pane.setVisible(true);
      PaneCrud.setVisible(false);  
      PaneSales.setVisible(true);
      PaneMontlySales.setVisible(false);
      PaneProviders.setVisible(false);
    }
       @FXML
    void GoToMontlySales(ActionEvent event) {

      pane_content1.setVisible(false);
      pane_content2.setVisible(false);
      pane_content1111.setVisible(false);
      pane_content111.setVisible(false);
      pane_content11.setVisible(false);
      
      PaneClients.setVisible(false);
      top_pane.setVisible(true);
      PaneCrud.setVisible(false);  
      PaneSales.setVisible(false);
      PaneMontlySales.setVisible(true);
      PaneProviders.setVisible(false);
    }

    @FXML
    void GoToCorte(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewSales.fxml"));
    Parent root = loader.load();
    
    Stage newStage = new Stage();
    Scene scene = new Scene(root);
    newStage.setScene(scene);
    newStage.show();
    }
        @FXML
    void GoProvider(ActionEvent event) {

      pane_content1.setVisible(false);
      pane_content2.setVisible(false);
      pane_content1111.setVisible(false);
      pane_content111.setVisible(false);
      pane_content11.setVisible(false);
      
      PaneClients.setVisible(false);
      top_pane.setVisible(true);
      PaneCrud.setVisible(false);  
      PaneSales.setVisible(false);
      PaneMontlySales.setVisible(false);
      PaneProviders.setVisible(true);
    }
        @FXML
    void GoNewProvider(ActionEvent event) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewProviderForm.fxml"));
    Parent root = loader.load();
    
    Stage newStage = new Stage();
    Scene scene = new Scene(root);
    newStage.setScene(scene);
    newStage.show();
    }
    
}
