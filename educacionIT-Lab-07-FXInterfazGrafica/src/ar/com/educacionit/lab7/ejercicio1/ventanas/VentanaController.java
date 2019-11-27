/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.lab7.ejercicio1.ventanas;

import ar.com.educacionit.lab7.ejercicio1.dominio.Cliente;
import ar.com.educacionit.lab7.ejercicio1.dominio.Hijo;
import ar.com.educacionit.lab7.ejercicio1.dominio.Persona;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rodolfo Durante
 */
public class VentanaController implements Initializable {

    @FXML
    private TextField fld_nombre;
    @FXML
    private TextField fld_apellido;
    @FXML
    private ComboBox<Persona.SEXO> cmb_sexo;
    @FXML
    private ComboBox<Persona.ESTADOCIVIL> cmb_estado_civil;
    @FXML
    private CheckBox chk_tarjeta_de_credito;
    @FXML
    private CheckBox chk_debito_automatico;
    @FXML
    private CheckBox chk_transferencia_bancaria;
    @FXML
    private ComboBox<Hijo> cmb_hijos_jardin;
    @FXML
    private ComboBox<Hijo> cmb_hijos_primaria;
    @FXML
    private ComboBox<Hijo> cmb_hijos_secundaria;
    @FXML
    private Button btn_promover_jardin;
    @FXML
    private Button btn_promover_primaria;
    @FXML
    private TextArea txt_datos;
    @FXML
    private Button btn_guardar;
    private Ventana mainApp;
    private Hijo hijoSinSeleccionar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Llena el combo sexo
        cmb_sexo.getItems().setAll(
                Persona.SEXO.values()
        );

        // Llena el combo estado civil
        cmb_estado_civil.getItems().setAll(
                Persona.ESTADOCIVIL.values()
        );

        // Pone el valor <sin seleccionar> en los combos de hijos
        hijoSinSeleccionar = new Hijo("<seleccionar>", Hijo.LUGARDEESTUDIO.JARDIN);
        cmb_hijos_jardin.getItems().add(hijoSinSeleccionar);
        cmb_hijos_jardin.setValue(hijoSinSeleccionar);
        cmb_hijos_primaria.getItems().add(hijoSinSeleccionar);
        cmb_hijos_primaria.setValue(hijoSinSeleccionar);

        cmb_hijos_secundaria.getItems().add(hijoSinSeleccionar);
        cmb_hijos_secundaria.setValue(hijoSinSeleccionar);
        cargarCliente();

    }

    @FXML
    private void btnPromoverJardinPressed(ActionEvent event) {
        Hijo h = cmb_hijos_jardin.getValue();
        // Si no hay un hijo seleccionado, entonces muestra un mensaje de advertencia
        if (h == null || h.equals(hijoSinSeleccionar)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No se puede promover al Hijo");
            alert.setContentText("Debe haber un hijo seleccionado");
            alert.showAndWait();
        } else {
            moverHijoDeCombo(h);
        }
    }

    @FXML
    private void btnPromoverPrimariaPressed(ActionEvent event) {
        Hijo h = cmb_hijos_primaria.getValue();
        // Si no hay un hijo seleccionado, entonces muestra un mensaje de advertencia
        if (h == null || h.equals(hijoSinSeleccionar)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No se puede promover al Hijo");
            alert.setContentText("Debe haber un hijo seleccionado");
            alert.showAndWait();
        } else {
            moverHijoDeCombo(h);
        }
    }

    @FXML
    private void btnGuardarPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.setHeaderText("Actualización");
        alert.setContentText("Confirma actualización de datos?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            // Se realiza la actualizacion en la Base de Datos
            // ........
            Alert ok = new Alert(Alert.AlertType.INFORMATION);
            ok.setTitle("Informacion");
            ok.setHeaderText(null);
            ok.setContentText("Los datos han sido actualizados");
            ok.showAndWait();
        } else {
            // System.out.println("El usuario seleccionó CANCEL");
        }

    }

    @FXML
    private void cmbHijosJardinActionPerformed(ActionEvent evt) {
        // Obtiene el item seleccionado
        SingleSelectionModel<Hijo> selection = cmb_hijos_jardin.getSelectionModel();
        Hijo h = selection.getSelectedItem();
        mostrarDatosDelHijo(h);

    }

    @FXML
    private void cmbHijosPrimariaActionPerformed(ActionEvent evt) {
        // Obtiene el item seleccionado
        SingleSelectionModel<Hijo> selection = cmb_hijos_primaria.getSelectionModel();
        Hijo h = selection.getSelectedItem();
        mostrarDatosDelHijo(h);

    }

    @FXML
    private void cmbHijosSecundariaActionPerformed(ActionEvent evt) {
        // Obtiene el item seleccionado
        SingleSelectionModel<Hijo> selection = cmb_hijos_secundaria.getSelectionModel();
        Hijo h = selection.getSelectedItem();
        mostrarDatosDelHijo(h);
    }

    private void mostrarDatosDelHijo(Hijo elHijoSeleccionado) {
        // Setea los datos en el detalle
        if (!elHijoSeleccionado.equals(hijoSinSeleccionar)) {
            txt_datos.setText(elHijoSeleccionado.getNombre());
        }
    }

    private void moverHijoDeCombo(Hijo hijo) {
        if (hijo.getLugarDeEstudio() == Hijo.LUGARDEESTUDIO.JARDIN) {
            // Quita el hijo del combo Jardin
            cmb_hijos_jardin.getItems().remove(hijo);
            // Agrega el hijo en el combo Primario y lo selecciona
            hijo.setLugarDeEstudio(Hijo.LUGARDEESTUDIO.PRIMARIO);
            cmb_hijos_primaria.getItems().add(hijo);
            cmb_hijos_primaria.setValue(hijo);
        } else {
            // Quita el hijo del combo Primaria
            cmb_hijos_primaria.getItems().remove(hijo);
            // Agrega el hijo en el combo Secundario y lo selecciona
            hijo.setLugarDeEstudio(Hijo.LUGARDEESTUDIO.SECUNDARIO);
            cmb_hijos_secundaria.getItems().add(hijo);
            cmb_hijos_secundaria.setValue(hijo);
        }
    }

    public void cargarCliente() {

        Cliente elCliente = obtenerClienteDeBaseDeDatos(25);
        // Establece los valores del cliente en pantalla
        // Llena las cajas de texto
        fld_nombre.setText(elCliente.getNombre());
        fld_apellido.setText(elCliente.getApellido());
        cmb_sexo.setValue(elCliente.getSexo());
        cmb_estado_civil.setValue(elCliente.getEstadoCivil());
        chk_debito_automatico.setSelected(elCliente.isFormaDePagoDebitoAutomatico());
        chk_tarjeta_de_credito.setSelected(elCliente.isFormaDePagoTarjetaCredito());
        chk_transferencia_bancaria.setSelected(elCliente.isFormaDePagoTransferenciaBancaria());

        // Agrega los hijos
        Iterator it = elCliente.getHijos().iterator();
        while (it.hasNext()) {
            // Obtiene un hijo
            Hijo elHijo = (Hijo) it.next();
            // Llena el combo correspondiente
            switch (elHijo.getLugarDeEstudio()) {
                case JARDIN:
                    cmb_hijos_jardin.getItems().add(elHijo);
                    break;
                case PRIMARIO:
                    cmb_hijos_primaria.getItems().add(elHijo);
                    break;
                case SECUNDARIO:
                    cmb_hijos_secundaria.getItems().add(elHijo);
                    break;
            }
        }

    }

    private Cliente obtenerClienteDeBaseDeDatos(int idCliente) {
        // Realiza la busqueda en la BBDD y obtiene el cliente con id = 25
        // .....

        // Construye el cliente
        // Agrega los datos del cliente
        Cliente elCliente = new Cliente();
        elCliente.setNombre("Juan");
        elCliente.setApellido("Perez");
        elCliente.setEstadoCivil(Persona.ESTADOCIVIL.Casado);
        elCliente.setSexo(Persona.SEXO.Masculino);
        elCliente.setFormaDePagoDebitoAutomatico(true);
        elCliente.setFormaDePagoTarjetaCredito(true);
        elCliente.setFormaDePagoTransferenciaBancaria(false);

        // Agrega los hijos al cliente
        ArrayList losHijos = new ArrayList();
        losHijos.add(new Hijo("Marcelo", Hijo.LUGARDEESTUDIO.JARDIN));
        losHijos.add(new Hijo("Pedro", Hijo.LUGARDEESTUDIO.JARDIN));
        losHijos.add(new Hijo("Esteban", Hijo.LUGARDEESTUDIO.PRIMARIO));
        losHijos.add(new Hijo("Tomas", Hijo.LUGARDEESTUDIO.PRIMARIO));
        losHijos.add(new Hijo("Roberto", Hijo.LUGARDEESTUDIO.SECUNDARIO));
        elCliente.setHijos(losHijos);

        // Retorna el cliente
        return elCliente;

    }

}
