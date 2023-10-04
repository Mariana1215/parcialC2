/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import singleton.Singleton;
import util.LSE;

/**
 *
 * @author LENOVO
 */
public class Carpa implements Serializable {

    public static final String DISPONIBLE = "Disponible";
    public static final String OCUPADA = "Ocupada";

    private String estado;
    private LSE<Cliente> clientes;
    private String palabraClave;

    public Carpa() {
        this.estado = DISPONIBLE;
        this.clientes = new LSE<>();

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LSE<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LSE<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public boolean registrarCliente(Cliente cliente) {
        if (clientes.size() < 3) {
            clientes.add(cliente);
            Singleton.getINSTANCIA().escribirCliente();
            return true;

        }
        return false;
    }

    public void eliminarClientes() {
        int numTotal = clientes. size();

        
        for (int i = 0; i < numTotal; i++) {
            clientes.remove(0);
        }
        Singleton.getINSTANCIA().escribirCliente();
    }

    public void desocuparCarpa() {
        eliminarClientes();
        setEstado(Carpa.DISPONIBLE);
        Singleton.getINSTANCIA().escribirCarpa();
    }

}
