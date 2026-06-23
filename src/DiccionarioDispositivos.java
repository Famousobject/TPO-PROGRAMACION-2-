/**
 * TDA DiccionarioDispositivos.
 *
 * Implementa una tabla hash desde cero para indexar dispositivos viales
 * como semaforos, camaras o sensores mediante un codigo unico.
 *
 * No utiliza HashMap ni ninguna coleccion nativa de Java.
 *
 * La tabla usa:
 * - Arreglo fijo de NodoDiccionario.
 * - Funcion hash propia.
 * - Colisiones por encadenamiento con nodos enlazados.
 */
public class DiccionarioDispositivos {

    private NodoDiccionario[] tabla;
    private int capacidad;
    private int cantidad;

    public DiccionarioDispositivos() {
        this.capacidad = 31;
        this.tabla = new NodoDiccionario[capacidad];
        this.cantidad = 0;
    }

    public DiccionarioDispositivos(int capacidad) {
        if (capacidad <= 0) {
            capacidad = 31;
        }

        this.capacidad = capacidad;
        this.tabla = new NodoDiccionario[capacidad];
        this.cantidad = 0;
    }

    private int hash(String codigo) {
        int acumulador = 0;

        for (int i = 0; i < codigo.length(); i++) {
            acumulador = acumulador * 31 + codigo.charAt(i);
        }

        if (acumulador < 0) {
            acumulador = acumulador * -1;
        }

        return acumulador % capacidad;
    }

    public boolean insertar(String codigo, Dispositivo dispositivo) {
        if (codigo == null || dispositivo == null) {
            return false;
        }

        int posicion = hash(codigo);
        NodoDiccionario actual = tabla[posicion];

        while (actual != null) {
            if (actual.getCodigo().equals(codigo)) {
                return false;
            }

            actual = actual.getSiguiente();
        }

        NodoDiccionario nuevo = new NodoDiccionario(codigo, dispositivo);
        nuevo.setSiguiente(tabla[posicion]);
        tabla[posicion] = nuevo;
        cantidad++;

        return true;
    }

    public Dispositivo recuperar(String codigo) {
        if (codigo == null) {
            return null;
        }

        int posicion = hash(codigo);
        NodoDiccionario actual = tabla[posicion];

        while (actual != null) {
            if (actual.getCodigo().equals(codigo)) {
                return actual.getDispositivo();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean modificar(String codigo, Dispositivo nuevoDispositivo) {
        if (codigo == null || nuevoDispositivo == null) {
            return false;
        }

        int posicion = hash(codigo);
        NodoDiccionario actual = tabla[posicion];

        while (actual != null) {
            if (actual.getCodigo().equals(codigo)) {
                actual.setDispositivo(nuevoDispositivo);
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public boolean contiene(String codigo) {
        return recuperar(codigo) != null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void mostrar() {
        System.out.println("=== Diccionario de Dispositivos ===");

        for (int i = 0; i < capacidad; i++) {
            System.out.print("Posicion " + i + ": ");

            NodoDiccionario actual = tabla[i];

            if (actual == null) {
                System.out.println("vacia");
            } else {
                while (actual != null) {
                    System.out.print("[" + actual.getCodigo() + "]");

                    if (actual.getSiguiente() != null) {
                        System.out.print(" -> ");
                    }

                    actual = actual.getSiguiente();
                }

                System.out.println();
            }
        }
    }
}
