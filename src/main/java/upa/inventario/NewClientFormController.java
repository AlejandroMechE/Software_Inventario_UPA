/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package upa.inventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author carlo
 */
public class NewClientFormController implements Initializable {
    @FXML
    private Button clientes_Post;

    @FXML
    private TextField direccionClientes;

    @FXML
    private TextField emailCliente;

    @FXML
    private TextField enfermedadesClientes;

    @FXML
    private TextField fechaNacimientoClientes;

    @FXML
    private TextField nombreCliente;

    @FXML
    private TextField suscripCliente;

    @FXML
    private TextField telefonoCliente;

      @FXML
    private ComboBox<String> medicinasBox;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          populateProductDropdown();
// Add a listener to display the selected product's ID
        medicinasBox.setOnAction(event -> {
        String selectedProductName = medicinasBox.getValue();
        Integer selectedProductId = productMap.get(selectedProductName);
        System.out.println("Selected Product ID: " + selectedProductId);
    });
        // TODO
    }   

// A Map to store product names and IDs
private Map<String, Integer> productMap = new HashMap<>();



private void populateProductDropdown() {
    HttpURLConnection connection = null;
    try {
        URL url = new URL("http://127.0.0.1:8000/products/Product/");
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

        // Parse the JSON response
        String jsonResponse = response.toString();
        JSONArray jsonArray = new JSONArray(jsonResponse);

        // Populate the ComboBox and Map
        ObservableList<String> productList = FXCollections.observableArrayList();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            int productId = obj.getInt("id"); // Assuming API returns "id"
            String productName = obj.getString("name"); // Assuming API returns "name"
            
            // Add name to ComboBox and map name to ID
            productList.add(productName);
            productMap.put(productName, productId);
        }

        medicinasBox.setItems(productList);

    } catch (IOException | JSONException e) {
        e.printStackTrace();
    } finally {
        if (connection != null) {
            connection.disconnect();
        }
    }
}

   
  
    
    
    
    
    
    
    
    @FXML
void PostClientServer(ActionEvent event) {
    
    String valueNombre = nombreCliente.getText();
    Long valueTelefono = Long.parseLong(telefonoCliente.getText());
    Integer valueEnfermedades = Integer.parseInt(enfermedadesClientes.getText()); 
    Integer valueMedicinas = productMap.get(medicinasBox.getValue());
    String valueFechaNacimiento = fechaNacimientoClientes.getText();  
    String valueEmail = emailCliente.getText(); 
    String valueSus = suscripCliente.getText(); 
    String valueDireccion = direccionClientes.getText();
    System.out.println(valueMedicinas);
    
    System.out.println(String.format("Nombre: %s, Telefono: %d, Fecha de Nacimiento: %s, Email: %s, Suscripción: %s, Dirección: %s, Enfermedades: %d, Medicinas: %d",
        valueNombre, valueTelefono, valueFechaNacimiento, valueEmail, valueSus, valueDireccion, valueEnfermedades, valueMedicinas));
    
    HttpURLConnection connection = null;
   
    try {
        // Create connection
        URL url = new URL("http://127.0.0.1:8000/clients/Client/");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setUseCaches(false);
        connection.setDoOutput(true);

        // Prepare JSON data
        String jsonInputString = String.format(
            "{\"name\": \"%s\", \"phone\": \"%d\", \"birthdate\": \"%s\", \"email\": \"%s\", \"suscription\": \"%s\", \"address\": \"%s\", \"diseases\": \"%d\", \"medicines\": \"%d\"}",
            valueNombre, valueTelefono, valueFechaNacimiento, valueEmail, valueSus, valueDireccion, valueEnfermedades, valueMedicinas
        );

        // Print JSON data for debugging
        System.out.println("JSON Data Sent: " + jsonInputString);

        // Send request
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(jsonInputString);
            wr.flush();
        }

        // Get response
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        InputStream inputStream;
        if (responseCode >= 200 && responseCode < 300) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream(); // For non-2xx responses
        }

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            System.out.println("Response: " + response.toString());
        }
    } catch (IOException e) {
    } finally {
        if (connection != null) {
            connection.disconnect();
        }
    }
    Stage currentStage = (Stage) clientes_Post.getScene().getWindow();
    currentStage.close();
}

    
}
