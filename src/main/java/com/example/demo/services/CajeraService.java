package com.example.demo.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;

@Service
public class CajeraService {

    @Async
    public void procesarCompra(Cliente cliente) {
        System.out.println("Iniciando el cobro para el  " + cliente.getNombre());

        long tiempoInicio = System.currentTimeMillis();

        for (Producto producto : cliente.getProductos()) {
            long inicioProducto = System.currentTimeMillis();
            
            procesarProductoSimulado(producto.getTiempoProcesamiento());

            long tiempoProducto = System.currentTimeMillis() - inicioProducto;
            System.out.println("Producto: " + producto.getNombre() + 
                               " - Precio: $" + producto.getPrecio() + 
                               " - Tiempo procesado: " + tiempoProducto + " ms");
        }

        long tiempoTotal = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Cobro finalizado para " + cliente.getNombre() + " en " + tiempoTotal + " ms.");
    }

    private void procesarProductoSimulado(int tiempoProcesamiento) {
        
        long inicio = System.nanoTime();
        while ((System.nanoTime() - inicio) / 1_000_000 < tiempoProcesamiento) {
        }
    }
}
