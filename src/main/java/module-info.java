module upa.inventario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphics;
    requires javafx.base;

    opens upa.inventario to javafx.fxml; // Esto ya está bien
    opens Login to javafx.fxml;          // Agrega esta línea para abrir el paquete Login

    exports upa.inventario;
    requires org.json;
}