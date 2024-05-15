module uniquindio.patrones.comportamentales.mediator {
    requires javafx.controls;
    requires javafx.fxml;

    opens uniquindio.patrones.comportamentales.mediator to javafx.fxml;
    exports uniquindio.patrones.comportamentales.mediator;
}
