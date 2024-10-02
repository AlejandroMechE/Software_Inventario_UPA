module upa.inventario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens upa.inventario to javafx.fxml;
    exports upa.inventario;
}
