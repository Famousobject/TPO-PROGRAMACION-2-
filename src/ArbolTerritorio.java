/**
 * TDA ArbolTerritorio.
 *
 * Representa la organizacion territorial de la ciudad:
 *
 * Ciudad
 *   -> Zonas
 *        -> Barrios
 *              -> Manzanas
 *
 * Es un arbol N-ario porque cada territorio puede tener multiples hijos.
 *
 * No utiliza ArrayList ni ninguna coleccion nativa de Java.
 * Los hijos de cada nodo se almacenan con ListaDoble<NodoTerritorio>.
 */
public class ArbolTerritorio {

    private NodoTerritorio raiz;

    public ArbolTerritorio(String nombreCiudad) {
        this.raiz = new NodoTerritorio(nombreCiudad, "Ciudad");
    }

    public NodoTerritorio getRaiz() {
        return raiz;
    }

    /**
     * Inserta una zona como hija directa de la ciudad.
     */
    public boolean insertarZona(String nombreZona) {
        if (nombreZona == null) {
            return false;
        }

        if (buscarZona(nombreZona) != null) {
            return false;
        }

        NodoTerritorio zona = new NodoTerritorio(nombreZona, "Zona");
        raiz.agregarHijo(zona);

        return true;
    }

    /**
     * Inserta un barrio dentro de una zona existente.
     */
    public boolean insertarBarrio(String nombreZona, String nombreBarrio) {
        if (nombreZona == null || nombreBarrio == null) {
            return false;
        }

        NodoTerritorio zona = buscarZona(nombreZona);

        if (zona == null) {
            return false;
        }

        if (buscarHijoDirecto(zona, nombreBarrio, "Barrio") != null) {
            return false;
        }

        NodoTerritorio barrio = new NodoTerritorio(nombreBarrio, "Barrio");
        zona.agregarHijo(barrio);

        return true;
    }

    /**
     * Inserta una manzana dentro de un barrio perteneciente a una zona.
     */
    public boolean insertarManzana(String nombreZona, String nombreBarrio, String nombreManzana) {
        if (nombreZona == null || nombreBarrio == null || nombreManzana == null) {
            return false;
        }

        NodoTerritorio zona = buscarZona(nombreZona);

        if (zona == null) {
            return false;
        }

        NodoTerritorio barrio = buscarHijoDirecto(zona, nombreBarrio, "Barrio");

        if (barrio == null) {
            return false;
        }

        if (buscarHijoDirecto(barrio, nombreManzana, "Manzana") != null) {
            return false;
        }

        NodoTerritorio manzana = new NodoTerritorio(nombreManzana, "Manzana");
        barrio.agregarHijo(manzana);

        return true;
    }

    /**
     * Busca una zona por nombre.
     */
    public NodoTerritorio buscarZona(String nombreZona) {
        return buscarHijoDirecto(raiz, nombreZona, "Zona");
    }

    /**
     * Busca un hijo directo de un nodo segun nombre y tipo.
     *
     * Este metodo asume que ListaDoble tiene:
     * - tamanio()
     * - obtenerPorPosicion(int posicion)
     *
     * Si en su ListaDoble esos metodos tienen otros nombres,
     * adaptar solamente esas dos llamadas.
     */
    private NodoTerritorio buscarHijoDirecto(NodoTerritorio padre, String nombre, String tipo) {
        if (padre == null || nombre == null || tipo == null) {
            return null;
        }

        ListaDoble<NodoTerritorio> hijos = padre.getHijos();

        for (int i = 0; i < hijos.tamanio(); i++) {
            NodoTerritorio hijo = hijos.obtenerPorPosicion(i);

            if (hijo.getNombre().equals(nombre) && hijo.getTipo().equals(tipo)) {
                return hijo;
            }
        }

        return null;
    }

    /**
     * Busca cualquier territorio del arbol por nombre y tipo.
     */
    public NodoTerritorio buscar(String nombre, String tipo) {
        return buscarRecursivo(raiz, nombre, tipo);
    }

    private NodoTerritorio buscarRecursivo(NodoTerritorio actual, String nombre, String tipo) {
        if (actual == null) {
            return null;
        }

        if (actual.getNombre().equals(nombre) && actual.getTipo().equals(tipo)) {
            return actual;
        }

        ListaDoble<NodoTerritorio> hijos = actual.getHijos();

        for (int i = 0; i < hijos.tamanio(); i++) {
            NodoTerritorio hijo = hijos.obtenerPorPosicion(i);
            NodoTerritorio encontrado = buscarRecursivo(hijo, nombre, tipo);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    /**
     * Muestra toda la estructura territorial.
     */
    public void mostrar() {
        mostrarRecursivo(raiz, 0);
    }

    private void mostrarRecursivo(NodoTerritorio actual, int nivel) {
        if (actual == null) {
            return;
        }

        imprimirEspacios(nivel);
        System.out.println("- " + actual.getTipo() + ": " + actual.getNombre());

        ListaDoble<NodoTerritorio> hijos = actual.getHijos();

        for (int i = 0; i < hijos.tamanio(); i++) {
            NodoTerritorio hijo = hijos.obtenerPorPosicion(i);
            mostrarRecursivo(hijo, nivel + 1);
        }
    }

    private void imprimirEspacios(int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }
    }
}
