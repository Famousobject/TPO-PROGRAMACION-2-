public class ListaDoble<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int cantidad;

    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public int cantidadElementos() {
        return cantidad;
    }

    public void insertarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;
        }
        cantidad++;
    }

    public void insertarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;
        }
        cantidad++;
    }

    public T eliminarInicio() {
        if (estaVacia()) {
            return null;
        }

        T dato = inicio.dato;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        cantidad--;
        return dato;
    }

    public T eliminarFinal() {
        if (estaVacia()) {
            return null;
        }

        T dato = fin.dato;
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        cantidad--;
        return dato;
    }

    public boolean buscar(T dato) {
        return indiceDe(dato) != -1;
    }

    public int indiceDe(T dato) {
        NodoDoble<T> aux = inicio;
        int posicion = 0;
        while (aux != null) {
            if (dato == null) {
                if (aux.dato == null) {
                    return posicion;
                }
            } else if (dato.equals(aux.dato)) {
                return posicion;
            }
            aux = aux.siguiente;
            posicion++;
        }
        return -1;
    }

    public T obtener(int posicion) {
        NodoDoble<T> nodo = nodoEn(posicion);
        if (nodo == null) {
            return null;
        }
        return nodo.dato;
    }

    public boolean modificar(int posicion, T nuevoDato) {
        NodoDoble<T> nodo = nodoEn(posicion);
        if (nodo == null) {
            return false;
        }
        nodo.dato = nuevoDato;
        return true;
    }

    public boolean eliminarPorValor(T dato) {
        NodoDoble<T> aux = inicio;
        while (aux != null) {
            boolean encontrado;
            if (dato == null) {
                encontrado = aux.dato == null;
            } else {
                encontrado = dato.equals(aux.dato);
            }

            if (encontrado) {
                if (aux == inicio) {
                    eliminarInicio();
                } else if (aux == fin) {
                    eliminarFinal();
                } else {
                    aux.anterior.siguiente = aux.siguiente;
                    aux.siguiente.anterior = aux.anterior;
                    cantidad--;
                }
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public String mostrarAdelante() {
        StringBuilder sb = new StringBuilder();
        NodoDoble<T> aux = inicio;
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.siguiente != null) {
                sb.append(" <-> ");
            }
            aux = aux.siguiente;
        }
        return sb.toString();
    }

    public String mostrarAtras() {
        StringBuilder sb = new StringBuilder();
        NodoDoble<T> aux = fin;
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.anterior != null) {
                sb.append(" <-> ");
            }
            aux = aux.anterior;
        }
        return sb.toString();
    }

    private NodoDoble<T> nodoEn(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }

        if (posicion <= cantidad / 2) {
            NodoDoble<T> aux = inicio;
            for (int i = 0; i < posicion; i++) {
                aux = aux.siguiente;
            }
            return aux;
        }

        NodoDoble<T> aux = fin;
        for (int i = cantidad - 1; i > posicion; i--) {
            aux = aux.anterior;
        }
        return aux;
    }

    @Override
    public String toString() {
        return mostrarAdelante();
    }
}

# 2026-05-30T21:58:03
# 2026-05-30T21:58:03
# 2026-06-10T21:58:05
# 2026-06-11T21:58:05
# 2026-06-05T21:59:56
# 2026-06-08T22:01:28
# 2026-05-31T22:12:26
# 2026-06-04T22:12:27
# 2026-06-05T22:15:00
# 2026-06-11T22:15:02
# 2026-06-12T22:15:02
# 2026-06-11T22:18:03
# 2026-06-08T22:20:28