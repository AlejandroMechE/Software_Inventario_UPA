package upa.inventario;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Pane PaneClients;

    @FXML
    private Pane PaneCrud;

    @FXML
    private Pane PaneSales;

    @FXML
    private TableView<?> TableCrud;

    @FXML
    private TableView<?> TableCrud1;

    @FXML
    private TableView<?> TableCrud11;

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

    
    
//    public void hidePanes() {
//        pane_content1.setVisible(false);
//        pane_content2.setVisible(false);
//        pane_content1111.setVisible(false);
//        pane_content111.setVisible(false);
//        pane_content11.setVisible(false);
//    }
//
//    public void showPaneCrud() {
//        PaneCrud.setVisible(true);
//    }

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
      
//    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
//    Parent root = loader.load();
//
//    // Crear una nueva escena y establecerla en un nuevo Stage
//    Stage newStage = new Stage();
//    Scene scene = new Scene(root);
//    newStage.setScene(scene);
//    newStage.show();
        
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
        
    }

        @FXML
    void GoNewProvider(ActionEvent event) throws IOException {

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
    }
    
}
