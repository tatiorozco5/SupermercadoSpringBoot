package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.services.CajeraService;

@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {

    @Autowired
    private CajeraService cajeraService;

    @PostMapping("/procesarCompra")
    public String procesarCompra(@RequestBody List<Cliente> clientes) {
        try {
            for (Cliente cliente : clientes) {
                System.out.println("Recibiendo cliente: " + cliente.getNombre());
                cajeraService.procesarCompra(cliente);
            }
            return "Las compras están en proceso y se recibirán notificaciones al completarse.";
        } catch (Exception e) {
            return "Ocurrió un error al procesar las compras: " + e.getMessage();
        }
    }

}
