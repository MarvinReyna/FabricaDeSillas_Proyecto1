package com.mgro.FabricaDeSillas_Proyecto1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FabricaDeSillas {
	private static Map<String, Material> inventarioMateriales = new HashMap<>();
    private static List<Silla> inventarioSillas = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    // Mapa para relacionar modelos de sillas con materiales necesarios
    private static Map<String, List<Material>> materialesNecesariosPorModelo = new HashMap<>();

    // Inicialización estática del mapa de materiales necesarios
    static {
        List<Material> materialesSillaEjecutiva = new ArrayList<>();
        materialesSillaEjecutiva.add(new Material("Madera", 4));
        materialesSillaEjecutiva.add(new Material("Metal", 2));
        materialesSillaEjecutiva.add(new Material("Clavos y tornillos", 10));
        materialesSillaEjecutiva.add(new Material("Tela para tapicería", 2));
        materialesNecesariosPorModelo.put("ModeloA", materialesSillaEjecutiva);
    }
    
    static {
        List<Material> materialesBanquito = new ArrayList<>();
        materialesBanquito.add(new Material("Madera", 15));
        materialesBanquito.add(new Material("Metal", 0));
        materialesBanquito.add(new Material("Clavos y tornillos", 35));
        materialesBanquito.add(new Material("Tela para tapicería", 0));
        materialesNecesariosPorModelo.put("ModeloA", materialesBanquito);
    }
    
    static {
        List<Material> materialesComedor = new ArrayList<>();
        materialesComedor.add(new Material("Madera", 5));
        materialesComedor.add(new Material("Metal", 8));
        materialesComedor.add(new Material("Clavos y tornillos", 20));
        materialesComedor.add(new Material("Tela para tapicería", 2));
        materialesNecesariosPorModelo.put("ModeloA", materialesComedor);
    }
    
    static {
        List<Material> materialesSillaMesedora = new ArrayList<>();
        materialesSillaMesedora.add(new Material("Madera", 5));
        materialesSillaMesedora.add(new Material("Metal", 0));
        materialesSillaMesedora.add(new Material("Clavos y tornillos", 15));
        materialesSillaMesedora.add(new Material("Tela para tapicería", 0));
        materialesNecesariosPorModelo.put("ModeloA", materialesSillaMesedora);
    }

    // Función principal del programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Inventario de Materiales");
            System.out.println("2. Inventario de Sillas");
            System.out.println("3. Clientes");
            System.out.println("4. Pedidos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    menuInventarioMateriales(scanner);
                    break;
                case 2:
                    menuInventarioSillas(scanner);
                    break;
                case 3:
                    menuClientes(scanner);
                    break;
                case 4:
                    menuPedidos(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // Función para gestionar el menú de Inventario de Materiales
    private static void menuInventarioMateriales(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Inventario de Materiales:");
            System.out.println("1. Agregar Material");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    agregarMaterial(scanner);
                    break;
                case 2:
                    mostrarInventarioMateriales();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    // Función para agregar un material al inventario
    private static void agregarMaterial(Scanner scanner) {
        System.out.print("Nombre del material: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        if (inventarioMateriales.containsKey(nombre)) {
            Material materialExistente = inventarioMateriales.get(nombre);
            materialExistente.agregarCantidad(cantidad);
        } else {
            Material nuevoMaterial = new Material(nombre, cantidad);
            inventarioMateriales.put(nombre, nuevoMaterial);
        }
        System.out.println("Material agregado al inventario.");
    }

    // Función para mostrar el inventario de materiales
    private static void mostrarInventarioMateriales() {
        System.out.println("Inventario de Materiales:");
        for (Material material : inventarioMateriales.values()) {
            System.out.println(material.getNombre() + ": " + material.getCantidad());
        }
    }

    // Función para gestionar el menú de Inventario de Sillas
    private static void menuInventarioSillas(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Inventario de Sillas:");
            System.out.println("1. Agregar Silla");
            System.out.println("2. Crear Silla a partir de Materiales");
            System.out.println("3. Mostrar Inventario");
            System.out.println("4. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    agregarSilla(scanner);
                    break;
                case 2:
                    crearSillaDesdeMateriales(scanner);
                    break;
                case 3:
                    mostrarInventarioSillas();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    // Función para agregar una silla al inventario
    private static void agregarSilla(Scanner scanner) {
        System.out.print("Modelo de la silla: ");
        String modelo = scanner.nextLine();
        System.out.print("ID de la silla: ");
        String id = scanner.nextLine();
        System.out.print("Precio de la silla: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el salto de línea

        Silla silla = new Silla(modelo, id, precio);
        inventarioSillas.add(silla);
        System.out.println("Silla agregada al inventario.");
    }

    // Función para crear una silla a partir de los materiales necesarios
    private static void crearSillaDesdeMateriales(Scanner scanner) {
        System.out.print("Modelo de la silla a crear: ");
        String modeloSilla = scanner.nextLine();

        if (materialesNecesariosPorModelo.containsKey(modeloSilla)) {
            List<Material> materialesNecesarios = materialesNecesariosPorModelo.get(modeloSilla);

            boolean materialesSuficientes = true;
            for (Material material : materialesNecesarios) {
                if (!inventarioMateriales.containsKey(material.getNombre()) ||
                        inventarioMateriales.get(material.getNombre()).getCantidad() < material.getCantidad()) {
                    System.out.println("No hay suficientes " + material.getNombre() + " en el inventario.");
                    materialesSuficientes = false;
                    break;
                }
            }

            if (materialesSuficientes) {
                for (Material material : materialesNecesarios) {
                    Material materialInventario = inventarioMateriales.get(material.getNombre());
                    materialInventario.agregarCantidad(-material.getCantidad());
                }
                Silla nuevaSilla = new Silla(modeloSilla, "ID" + inventarioSillas.size(), 0);
                inventarioSillas.add(nuevaSilla);
                System.out.println("Silla creada y agregada al inventario.");
            }
        } else {
            System.out.println("El modelo de silla no se encuentra en la lista de materiales necesarios.");
        }
    }

    // Función para mostrar el inventario de sillas
    private static void mostrarInventarioSillas() {
        System.out.println("Inventario de Sillas:");
        for (Silla silla : inventarioSillas) {
            System.out.println("Modelo: " + silla.getModelo() + ", ID: " + silla.getId() + ", Precio: " + silla.getPrecio());
        }
    }

    // Función para gestionar el menú de Clientes
    private static void menuClientes(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Clientes:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    agregarCliente(scanner);
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    // Función para agregar un cliente
    private static void agregarCliente(Scanner scanner) {
        System.out.print("ID del cliente: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre);
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado.");
    }

    // Función para mostrar la lista de clientes
    private static void mostrarClientes() {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
        }
    }

    // Función para gestionar el menú de Pedidos
    private static void menuPedidos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Pedidos:");
            System.out.println("1. Crear Pedido");
            System.out.println("2. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    crearPedido(scanner);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 2);
    }

    // Función para crear un pedido
    private static void crearPedido(Scanner scanner) {
        System.out.print("ID del cliente: ");
        String idCliente = scanner.nextLine();
        Cliente cliente = buscarClientePorID(idCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Pedido nuevoPedido = new Pedido(cliente);

        do {
            System.out.print("Modelo de silla (o '0' para finalizar el pedido): ");
            String modeloSilla = scanner.nextLine();

            if (modeloSilla.equals("0")) {
                break;
            }

            Silla sillaDisponible = buscarSillaPorModelo(modeloSilla);

            if (sillaDisponible != null) {
                nuevoPedido.agregarSilla(sillaDisponible);
            } else {
                System.out.println("Silla no encontrada en el inventario.");
                System.out.println("Por favor, cree la silla a partir de los materiales antes de continuar.");
                crearSillaDesdeMateriales(scanner);
                sillaDisponible = buscarSillaPorModelo(modeloSilla);

                if (sillaDisponible != null) {
                    nuevoPedido.agregarSilla(sillaDisponible);
                } else {
                    System.out.println("Silla aun no disponible. Continue con otro modelo.");
                }
            }

        } while (true);

        double total = nuevoPedido.calcularTotal();
        System.out.println("Pedido creado con exito.");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Total a pagar: $" + total);
    }

    // Función para buscar un cliente por su ID
    private static Cliente buscarClientePorID(String idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }

    // Función para buscar una silla por su modelo
    private static Silla buscarSillaPorModelo(String modeloSilla) {
        for (Silla silla : inventarioSillas) {
            if (silla.getModelo().equals(modeloSilla)) {
                return silla;
            }
        }
        return null;
    }

}
