package upa.inventario;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
private TableView<Client> clientTable;

@FXML
private TableColumn<Client, String> direccionColumn;

@FXML
private TableColumn<Client, String> nombreColumn;

@FXML
private TableColumn<Client, String> recetaColumn;

@FXML
private TableColumn<Client, Integer> telefonoColumn;

// Optional: You can use the `verColumn` for actions (e.g., buttons).
@FXML
private TableColumn<Client, Void> verColumn;

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
public void initialize() {
    // Bind columns to Client properties
    nombreColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    direccionColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    recetaColumn.setCellValueFactory(new PropertyValueFactory<>("subscription"));
    telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
}


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
    public class Client {
    private String name;
    private String address;
    private String subscription;
    private Integer phone;

    // Constructor
    public Client(String name, String address, String subscription, Integer phone) {
        this.name = name;
        this.address = address;
        this.subscription = subscription;
        this.phone = phone;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
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
        URL url = new URL("http://127.0.0.1:8000/clients/Client/");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        InputStream inputStream = (responseCode >= 200 && responseCode < 300) 
                                    ? connection.getInputStream() 
                                    : connection.getErrorStream();

        StringBuilder response = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
        }

        // Parse JSON response
        String jsonResponse = response.toString();
        JSONArray jsonArray = new JSONArray(jsonResponse);
        ObservableList<Client> clients = FXCollections.observableArrayList();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String name = obj.getString("name");
            String address = obj.getString("address");
            String subscription = obj.getString("suscription");
            Integer phone = obj.getInt("phone");

            clients.add(new Client(name, address, subscription, phone));
        }

        // Populate the TableView
        clientTable.setItems(clients);

    } catch (IOException | JSONException e) {
        e.printStackTrace();
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
