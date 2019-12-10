/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusotemporizador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import temporizador.Temporizador;

/**
 * FXML Controller class
 *
 * @author rafae
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtTiempo;
    @FXML
    private Temporizador temporizador;
    @FXML
    private Label lbEventCatch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTiempo.setOnAction(value->{
            try
            {
                temporizador.setTiempo(Integer.parseInt(txtTiempo.getText()));
            }
            catch(NumberFormatException ex)
            {
                txtTiempo.setText("Not a Integer");
                return;
            }
            temporizador.initTemporizador();
        });
        
        temporizador.addEventHandler(EventType.ROOT, eventHandler->{
            if(eventHandler.getSource().getClass() == temporizador.getClass())
            {
                lbEventCatch.setText("Cuenta atrás finalizada");
            }
        });
    }    
    
}
