/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.Carpa;
import modelos.Cliente;
import singleton.Singleton;

/**
 *
 * @author LENOVO
 */
public class ControladorCarpa {
    Carpa[][] carpas;

    public ControladorCarpa() {
        carpas = Singleton.getINSTANCIA().getCarpas();
        initCarpas();
    }
    private void initCarpas(){
        if(carpas[0][0] == null){
            for(int i = 0; i < carpas.length; i++){
                for(int j = 0; j < carpas[i].length; j++){
                    carpas[i][j] = new Carpa();
                }
            }
            Singleton.getINSTANCIA().escribirCarpa();
        }else{
            Singleton.getINSTANCIA().leerCarpa();
        }
    }
   
    public Carpa obtenerCarpa(int fila, int columna){
        return carpas[fila][columna];
    }
    public void asignarCarpa(Carpa carpa, Cliente cliente, String palabraClave){
        carpa.registrarCliente(cliente);
        carpa.setPalabraClave(palabraClave);
        carpa.setEstado(Carpa.OCUPADA);
        Singleton.getINSTANCIA().escribirCarpa();
    }
    public boolean asignarCarpa(Carpa carpa, Cliente cliente){
        boolean resp = carpa.registrarCliente(cliente);
        if(resp){
            Singleton.getINSTANCIA().escribirCarpa();
            return true;
        }
        return false;
    }
    
    public void desocuparCarpa(Carpa carpa){
        carpa.desocuparCarpa();
        
    }
}
