public class ColaCircularVehiculos {
    private Vehiculo[] datos;
    private int frente;
    private int fin;
    private int cantidad;

    public ColaCircularVehiculos(int capacidad) {
        datos = new Vehiculo[capacidad];
        frente = -1;
        fin = -1;
        cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == datos.length;
    }

    public int cantidadElementos() {
        return cantidad;
    }

    public boolean encolar(Vehiculo vehiculo) {
        if (estaLlena()) {
            return false;
        }

        if (estaVacia()) {
            frente = 0;
            fin = 0;
        } else {
            fin = (fin + 1) % datos.length;
        }
        datos[fin] = vehiculo;
        cantidad++;
        return true;
    }

    public Vehiculo desencolar() {
        if (estaVacia()) {
            return null;
        }

        Vehiculo vehiculo = datos[frente];
        datos[frente] = null;
        cantidad--;

        if (cantidad == 0) {
            frente = -1;
            fin = -1;
        } else {
            frente = (frente + 1) % datos.length;
        }
        return vehiculo;
    }

    public Vehiculo recuperarFrente() {
        if (estaVacia()) {
            return null;
        }
        return datos[frente];
    }

    public String mostrar() {
        if (estaVacia()) {
            return "Cola vacia";
        }

        StringBuilder sb = new StringBuilder();
        int indice = frente;
        for (int i = 0; i < cantidad; i++) {
            sb.append(datos[indice]);
            if (i < cantidad - 1) {
                sb.append(" <- ");
            }
            indice = (indice + 1) % datos.length;
        }
        return sb.toString();
    }
}

# 2026-05-29T21:58:02
# 2026-06-06T21:58:04
# 2026-05-31T21:59:54
# 2026-06-01T21:59:55
# 2026-06-01T22:01:26
# 2026-06-07T22:12:28
# 2026-06-08T22:14:38
# 2026-05-31T22:18:00
# 2026-06-04T22:18:01
# 2026-06-09T22:18:03