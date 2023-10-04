/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class LSE<S> implements Serializable {
    
    Nodo<S> primero;
    int size;

    public LSE() {
        this.primero = null;
        this.size = 0;
    }
    public void add(S dato){
        Nodo<S> nuevo = new Nodo<>(dato);
        
        if(primero == null){
            this.primero = nuevo;
        }else{
            Nodo<S> aux = primero;
            while(aux.getNodoSiguiente() != null){
                aux = aux.getNodoSiguiente();
            }
            aux.setNodoSiguiente(nuevo);
        }
        size++;
    }
    public int size(){
        return size;
    }
    
    public S get(int index){
        
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Para el índice"+index);
        }else{
            if(index == 0){
                return this.primero.getDato();
            }else{
                Nodo<S> aux = primero;
                int contador = 0;
                while(contador < index){
                    aux = aux.getNodoSiguiente();
                    contador++;
                }
                return aux.getDato();
            }
        }
    }
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Para el indice"+index);
                
            
        }else{
            if(index == 0){
                primero = this.primero.getNodoSiguiente();
            }else{
                Nodo aux = primero;
                int contador = 0;
                while(aux.getNodoSiguiente() != null && contador < index -1){
                    aux = aux.getNodoSiguiente();
                    contador++;
                }
                aux.setNodoSiguiente(aux.getNodoSiguiente().getNodoSiguiente());
            }
            size--;
        }
    } 
    public void add(S dato, int index){
        Nodo<S> nuevoNodo = new Nodo<>(dato);
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Para el indice"+index);
        }else{
//            index(aux) se encuentre en el primer nodo (0).
            if(index == 0){
                nuevoNodo.setNodoSiguiente(primero); //conectar nodo nuevo con el que era el primero
                this.primero = nuevoNodo;
            }else{
                Nodo<S> aux = primero;
                int contador = 0;               
                while(contador < index -1){
                    aux = aux.getNodoSiguiente();
                    contador++;
                }
                nuevoNodo.setNodoSiguiente(aux.getNodoSiguiente());
                aux.setNodoSiguiente(nuevoNodo);
                
            }
            size++;
        }    
    }
}
