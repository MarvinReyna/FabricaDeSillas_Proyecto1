package com.mgro.FabricaDeSillas_Proyecto1;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Silla> sillas;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.sillas = new ArrayList<>();
    }

    public void agregarSilla(Silla silla) {
        sillas.add(silla);
    }

    public List<Silla> getSillas() {
        return sillas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calcularTotal() {
        double total = 0;
        for (Silla silla : sillas) {
            total += silla.getPrecio();
        }
        return total;
    }
}