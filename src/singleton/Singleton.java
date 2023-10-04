/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelos.Carpa;
import modelos.Cliente;
import util.LSE;

/**
 *
 * @author LENOVO
 */
public class Singleton {

    private static final Singleton INSTANCIA = new Singleton();

    private Carpa[][] carpas;
    private LSE<Cliente> clientes;

    private Singleton() {
        carpas = leerCarpa();
        clientes = leerCliente();
    }

    public static Singleton getINSTANCIA() {
        return INSTANCIA;
    }

    public Carpa[][] getCarpas() {
        return carpas;
    }

    public LSE<Cliente> getClientes() {
        return clientes;
    }

    public void escribirCarpa() {

        try {
            FileOutputStream archivo = new FileOutputStream("carpas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(carpas);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Carpa[][] leerCarpa() {
        try {
            FileInputStream archivo = new FileInputStream("carpas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Carpa[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Carpa[3][6];
        }
    }

    public void escribirCliente() {

        try {
            FileOutputStream archivo = new FileOutputStream("carpas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(clientes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public LSE<Cliente> leerCliente() {
        try {
            FileInputStream archivo = new FileInputStream("clientes.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (LSE<Cliente>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new LSE<>();
        }
    }

}
