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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author carlo
 */
public class NewClientFormController implements Initializable {
    @FXML
  private Button clientes_Post;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
void PostClientServer(ActionEvent event) {
    String valueNombre = "Pepto Bismol";
    String valueTelefono = "123456789";  // Example value; replace with actual input
    String valueEnfermedades = "ExampleBrand";  // Example value; replace with actual input
    String valueMedicinas = "2025-12-31";  // Example value; replace with actual input
    String valueFechaNacimiento = "1985-07-22";  // Example birthdate, in a standard date format
    String valueDireccion = "ProviderAddress";  // Example value; replace with actual input
    String valueEmail = "example@example.com";  // Example email; replace with actual input
    String valueSus = "Insulina";  // Example subscription
    
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
            "{\"name\": \"%s\", \"phone\": \"%s\", \"birthdate\": \"%s\", \"email\": \"%s\", \"suscription\": \"%s\", \"address\": \"%s\", \"diseases\": \"%s\", \"medicines\": \"%s\"}",
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
