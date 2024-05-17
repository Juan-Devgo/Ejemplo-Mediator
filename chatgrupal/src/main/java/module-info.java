module uniquindio.patrones.comportamentales.mediator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens uniquindio.patrones.comportamentales.mediator to javafx.fxml;
    exports uniquindio.patrones.comportamentales.mediator;

    opens uniquindio.patrones.comportamentales.mediator.Controller;
    exports uniquindio.patrones.comportamentales.mediator.Controller;
}
