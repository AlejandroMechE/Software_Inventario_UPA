/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package upa.inventario;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;

/**
 * FXML Controller class
 *
 * @author aleja
 */
public class InventarioFormController implements Initializable {
 @FXML
    private Button formBtn;
 @FXML
    private TextField NombreField;
 String ProductName= "Pepto";
HttpURLConnection connection = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
   void PostServer (ActionEvent event) throws IOException {
       try {
    //Create connection
    URL url = new URL("http://127.0.0.1:8000/clients/Client/");
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    
  

    connection.setUseCaches(false);
    connection.setDoOutput(true);

    //Send request
    DataOutputStream wr = new DataOutputStream (
        connection.getOutputStream());
    wr.close();

    //Get Response  
    InputStream is = connection.getInputStream();
    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
    String line;
    while ((line = rd.readLine()) != null) {
      response.append(line);
      response.append('\r');
    }
    rd.close();
    System.out.println(response.toString());
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    if (connection != null) {
      connection.disconnect();
    }
  }
   }
}

 