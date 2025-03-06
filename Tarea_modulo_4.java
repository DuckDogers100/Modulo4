/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea_modulo_4;

/**
 *
 * @author gerar
 */
import java.util.ArrayList;
import java.util.Scanner;

// Clase Empleado con encapsulamiento
class Empleado {
    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Salario: " + salario);
    }
}

// Clase GestorEmpleados para manejar la lista de empleados
class GestorEmpleados {
    private ArrayList<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : empleados) {
                emp.mostrarInfo();
            }
        }
    }
    
    public void buscarEmpleado(String nombre) {
        boolean encontrado = false;
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombre)) {
                emp.mostrarInfo();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    }
}

// Clase principal para ejecutar el programa
public class Tarea_modulo_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Edad: ");
                int edad = scanner.nextInt();
                System.out.print("Salario: ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
                gestor.agregarEmpleado(nuevoEmpleado);
                System.out.println("Empleado agregado correctamente.");
            } else if (opcion == 2) {
                gestor.mostrarEmpleados();
            } else if (opcion == 3) {
                System.out.print("Ingrese el nombre del empleado a buscar: ");
                String nombreBusqueda = scanner.nextLine();
                gestor.buscarEmpleado(nombreBusqueda);
            } else if (opcion == 4) {
                System.out.println("Saliendo del programa...");
                break;
            } else {
                System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
}
