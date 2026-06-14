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
