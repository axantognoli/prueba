/*
 * Cliente.java
 *
 *
 */

package ar.com.educacionit.lab7.ejercicio1.dominio;

import java.util.ArrayList;

/**
 *
 */
public class Cliente extends Persona{
    
    /** Creates a new instance of Cliente */
    public Cliente() {
    }
    
    // Atributos
    private ArrayList hijos;
    private boolean formaDePagoTarjetaCredito;
    private boolean formaDePagoDebitoAutomatico;
    private boolean formaDePagoTransferenciaBancaria;

    public ArrayList getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList hijos) {
        this.hijos = hijos;
    }

    public boolean isFormaDePagoTarjetaCredito() {
        return formaDePagoTarjetaCredito;
    }

    public void setFormaDePagoTarjetaCredito(boolean formaDePagoTarjetaCredito) {
        this.formaDePagoTarjetaCredito = formaDePagoTarjetaCredito;
    }

    public boolean isFormaDePagoDebitoAutomatico() {
        return formaDePagoDebitoAutomatico;
    }

    public void setFormaDePagoDebitoAutomatico(boolean formaDePagoDebitoAutomatico) {
        this.formaDePagoDebitoAutomatico = formaDePagoDebitoAutomatico;
    }

    public boolean isFormaDePagoTransferenciaBancaria() {
        return formaDePagoTransferenciaBancaria;
    }

    public void setFormaDePagoTransferenciaBancaria(boolean formaDePagoTransferenciaBancaria) {
        this.formaDePagoTransferenciaBancaria = formaDePagoTransferenciaBancaria;
    }
    
    
}
