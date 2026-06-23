/**
 * TDA ColaVehiculos.
 *
 * Implementa una cola simple FIFO:
 * First In, First Out.
 *
 * No utiliza Queue ni ninguna coleccion nativa de Java.
 * Se implementa con nodos enlazados y referencias a frente y fin.
 */
public class ColaVehiculos {

    private NodoVehiculo frente;
    private NodoVehiculo fin;
    private int cantidad;

    public ColaVehiculos() {
        this.frente = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public void encolar(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return;
        }

        NodoVehiculo nuevo = new NodoVehiculo(vehiculo);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        cantidad++;
    }

    public Vehiculo desencolar() {
        if (estaVacia()) {
            return null;
        }

        Vehiculo vehiculoLiberado = frente.getVehiculo();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        cantidad--;

        return vehiculoLiberado;
    }

    public Vehiculo verFrente() {
        if (estaVacia()) {
            return null;
        }

        return frente.getVehiculo();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void mostrar() {
        System.out.println("=== Cola de Vehiculos ===");

        if (estaVacia()) {
            System.out.println("No hay vehiculos esperando.");
            return;
        }

        NodoVehiculo actual = frente;

        while (actual != null) {
            System.out.println(actual.getVehiculo());
            actual = actual.getSiguiente();
        }
    }
}
