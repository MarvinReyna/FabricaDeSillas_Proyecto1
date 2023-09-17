package com.mgro.FabricaDeSillas_Proyecto1;

public class Silla {
	private String modelo;
    private String id;
    private double precio;

    public Silla(String modelo, String id, double precio) {
        this.modelo = modelo;
        this.id = id;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public String getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }
}
