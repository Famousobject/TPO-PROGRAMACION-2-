public class ColaPrioridadEmergencias {
    private static class NodoEmergencia {
        Emergencia dato;
        NodoEmergencia siguiente;

        NodoEmergencia(Emergencia dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private NodoEmergencia frente;
    private int cantidad;

    public ColaPrioridadEmergencias() {
        frente = null;
        cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public int cantidadElementos() {
        return cantidad;
    }

    public void encolar(Emergencia emergencia) {
        NodoEmergencia nuevo = new NodoEmergencia(emergencia);

        if (estaVacia() || emergencia.tieneMasPrioridadQue(frente.dato)) {
            nuevo.siguiente = frente;
            frente = nuevo;
        } else {
            NodoEmergencia aux = frente;
            while (aux.siguiente != null && !emergencia.tieneMasPrioridadQue(aux.siguiente.dato)) {
                aux = aux.siguiente;
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
        }
        cantidad++;
    }

    public Emergencia desencolar() {
        if (estaVacia()) {
            return null;
        }
        Emergencia emergencia = frente.dato;
        frente = frente.siguiente;
        cantidad--;
        return emergencia;
    }

    public Emergencia recuperarFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.dato;
    }

    public String mostrar() {
        if (estaVacia()) {
            return "No hay emergencias pendientes";
        }

        StringBuilder sb = new StringBuilder();
        NodoEmergencia aux = frente;
        while (aux != null) {
            sb.append(aux.dato).append("\n");
            aux = aux.siguiente;
        }
        return sb.toString();
    }
}

# 2026-06-08T21:57:06
# 2026-06-09T21:57:06
# 2026-06-12T21:57:07
# 2026-05-29T21:58:02
# 2026-06-09T21:58:05
# 2026-06-08T21:59:57
# 2026-06-09T21:59:58
# 2026-06-04T22:01:26
# 2026-05-29T22:12:25
# 2026-05-30T22:12:25
# 2026-06-01T22:12:26
# 2026-06-08T22:12:28
# 2026-06-10T22:12:29
# 2026-06-10T22:12:29
# 2026-06-07T22:15:01
# 2026-05-29T22:17:59
# 2026-06-01T22:18:00
# 2026-06-12T22:18:03
# 2026-05-30T22:20:25
# 2026-06-04T22:20:26