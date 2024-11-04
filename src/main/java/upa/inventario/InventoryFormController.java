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

/**
 * FXML Controller class
 *
 * @author carlo
 */
public class InventoryFormController implements Initializable {
 @FXML
  private Button btnPost;

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
 @FXML
void PostServer(ActionEvent event) {
    String valueNombre = "Pepto Bismol";
    String valueBarCode = "123456789";  // Example value; replace with actual input
    String valueBrand = "ExampleBrand";  // Example value; replace with actual input
    String valueExpirationDate = "2025-12-31";  // Example value; replace with actual input
    String valueDescription = "Sample product description";  // Example value; replace with actual input
    int valueMinStock = 10;  // Example value; replace with actual input
    int valueStock = 50;  // Example value; replace with actual input
    String valueProvider = "ProviderName";  // Example value; replace with actual input
    String valueLocation = "Aisle 3";  // Example value; replace with actual input

    HttpURLConnection connection = null;
    try {
        // Create connection
        URL url = new URL("http://127.0.0.1:8000/products/Product/");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setUseCaches(false);
        connection.setDoOutput(true);

        // Prepare JSON data
        String jsonInputString = String.format(
            "{\"bar_code\": \"%s\", \"name\": \"%s\", \"brand\": \"%s\", \"expiration_date\": \"%s\", \"description\": \"%s\", \"min_stock\": %d, \"stock\": %d, \"provider\": \"%s\", \"location\": \"%s\"}",
            valueBarCode, valueNombre, valueBrand, valueExpirationDate, valueDescription, valueMinStock, valueStock, valueProvider, valueLocation
        );

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
}
  
    
}
