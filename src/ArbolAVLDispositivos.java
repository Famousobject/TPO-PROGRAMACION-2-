public class ArbolAVLDispositivos {
    private static class NodoAVL {
        Dispositivo dato;
        int altura;
        NodoAVL izquierdo;
        NodoAVL derecho;

        NodoAVL(Dispositivo dato) {
            this.dato = dato;
            this.altura = 1;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    private NodoAVL raiz;

    public ArbolAVLDispositivos() {
        raiz = null;
    }

    public void insertar(Dispositivo dispositivo) {
        raiz = insertarRecursivo(raiz, dispositivo);
    }

    public Dispositivo buscar(int codigo) {
        NodoAVL encontrado = buscarNodo(raiz, codigo);
        if (encontrado == null) {
            return null;
        }
        return encontrado.dato;
    }

    public boolean modificarEstado(int codigo, String nuevoEstado, int nuevaLectura) {
        Dispositivo dispositivo = buscar(codigo);
        if (dispositivo == null) {
            return false;
        }
        dispositivo.setEstado(nuevoEstado);
        dispositivo.setUltimaLectura(nuevaLectura);
        return true;
    }

    public int altura() {
        return altura(raiz);
    }

    public String mostrarInorden() {
        StringBuilder sb = new StringBuilder();
        inordenRecursivo(raiz, sb);
        return sb.toString();
    }

    public String mostrarPreorden() {
        StringBuilder sb = new StringBuilder();
        preordenRecursivo(raiz, sb);
        return sb.toString();
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, Dispositivo dispositivo) {
        if (nodo == null) {
            return new NodoAVL(dispositivo);
        }

        if (dispositivo.getCodigo() < nodo.dato.getCodigo()) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dispositivo);
        } else if (dispositivo.getCodigo() > nodo.dato.getCodigo()) {
            nodo.derecho = insertarRecursivo(nodo.derecho, dispositivo);
        } else {
            nodo.dato = dispositivo;
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        int balance = obtenerBalance(nodo);

        if (balance > 1 && dispositivo.getCodigo() < nodo.izquierdo.dato.getCodigo()) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && dispositivo.getCodigo() > nodo.derecho.dato.getCodigo()) {
            return rotarIzquierda(nodo);
        }

        if (balance > 1 && dispositivo.getCodigo() > nodo.izquierdo.dato.getCodigo()) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && dispositivo.getCodigo() < nodo.derecho.dato.getCodigo()) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL buscarNodo(NodoAVL nodo, int codigo) {
        if (nodo == null) {
            return null;
        }
        if (codigo == nodo.dato.getCodigo()) {
            return nodo;
        }
        if (codigo < nodo.dato.getCodigo()) {
            return buscarNodo(nodo.izquierdo, codigo);
        }
        return buscarNodo(nodo.derecho, codigo);
    }

    private int altura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL temp = x.derecho;

        x.derecho = y;
        y.izquierdo = temp;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL temp = y.izquierdo;

        y.izquierdo = x;
        x.derecho = temp;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    private void inordenRecursivo(NodoAVL nodo, StringBuilder sb) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo, sb);
            sb.append(nodo.dato).append("\n");
            inordenRecursivo(nodo.derecho, sb);
        }
    }

    private void preordenRecursivo(NodoAVL nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.dato.getCodigo()).append(" ");
            preordenRecursivo(nodo.izquierdo, sb);
            preordenRecursivo(nodo.derecho, sb);
        }
    }
}

# 2026-06-02T21:57:05
# 2026-05-29T21:58:02
# 2026-06-09T22:01:28
# 2026-06-08T22:14:38
# 2026-06-03T22:18:01
# 2026-06-06T22:18:02