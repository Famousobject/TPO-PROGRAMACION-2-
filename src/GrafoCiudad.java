public class GrafoCiudad {
    private ListaDoble<Interseccion> intersecciones;

    public GrafoCiudad() {
        this.intersecciones = new ListaDoble<>();
    }

    public boolean agregarInterseccion(String codigo, String nombre) {
        if (obtenerInterseccion(codigo) != null) {
            return false;
        }
        intersecciones.insertarFinal(new Interseccion(codigo, nombre));
        return true;
    }

    public boolean conectarBidireccional(String codigoA, String codigoB, String nombreCalle, double tiempoMinutos) {
        boolean ida = conectarDirigida(codigoA, codigoB, nombreCalle, tiempoMinutos);
        boolean vuelta = conectarDirigida(codigoB, codigoA, nombreCalle, tiempoMinutos);
        return ida && vuelta;
    }

    public boolean conectarDirigida(String codigoOrigen, String codigoDestino, String nombreCalle, double tiempoMinutos) {
        Interseccion origen = obtenerInterseccion(codigoOrigen);
        Interseccion destino = obtenerInterseccion(codigoDestino);

        if (origen == null || destino == null || tiempoMinutos <= 0) {
            return false;
        }

        origen.agregarCalle(new Calle(nombreCalle, origen, destino, tiempoMinutos));
        return true;
    }

    public Interseccion obtenerInterseccion(String codigo) {
        for (int i = 0; i < intersecciones.cantidadElementos(); i++) {
            Interseccion actual = intersecciones.obtener(i);
            if (actual.getCodigo().equalsIgnoreCase(codigo)) {
                return actual;
            }
        }
        return null;
    }

    public int cantidadIntersecciones() {
        return intersecciones.cantidadElementos();
    }

    public Ruta rutaMasCorta(String codigoOrigen, String codigoDestino) {
        int n = intersecciones.cantidadElementos();
        int origen = indiceDeCodigo(codigoOrigen);
        int destino = indiceDeCodigo(codigoDestino);

        if (origen == -1 || destino == -1) {
            return Ruta.sinRuta(codigoOrigen, codigoDestino);
        }

        double[] distancia = new double[n];
        boolean[] visitado = new boolean[n];
        int[] anterior = new int[n];

        for (int i = 0; i < n; i++) {
            distancia[i] = Double.MAX_VALUE / 4;
            visitado[i] = false;
            anterior[i] = -1;
        }
        distancia[origen] = 0;

        for (int vuelta = 0; vuelta < n; vuelta++) {
            int actual = minimoNoVisitado(distancia, visitado);
            if (actual == -1) {
                break;
            }

            visitado[actual] = true;
            Interseccion interseccionActual = intersecciones.obtener(actual);

            for (int i = 0; i < interseccionActual.getCalles().cantidadElementos(); i++) {
                Calle calle = interseccionActual.getCalles().obtener(i);
                if (!calle.estaHabilitada()) {
                    continue;
                }

                int indiceDestino = indiceDeCodigo(calle.getDestino().getCodigo());
                double nuevaDistancia = distancia[actual] + calle.getTiempoMinutos();

                if (nuevaDistancia < distancia[indiceDestino]) {
                    distancia[indiceDestino] = nuevaDistancia;
                    anterior[indiceDestino] = actual;
                }
            }
        }

        if (distancia[destino] >= Double.MAX_VALUE / 8) {
            return Ruta.sinRuta(codigoOrigen, codigoDestino);
        }

        return construirRuta(destino, anterior, distancia[destino]);
    }

    public boolean cortarCalle(String codigoOrigen, String codigoDestino) {
        Calle calle = buscarCalle(codigoOrigen, codigoDestino);
        if (calle == null) {
            return false;
        }
        calle.setHabilitada(false);
        return true;
    }

    public boolean habilitarCalle(String codigoOrigen, String codigoDestino) {
        Calle calle = buscarCalle(codigoOrigen, codigoDestino);
        if (calle == null) {
            return false;
        }
        calle.setHabilitada(true);
        return true;
    }

    public String mostrarGrafo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intersecciones.cantidadElementos(); i++) {
            Interseccion actual = intersecciones.obtener(i);
            sb.append(actual).append(" -> ");
            if (actual.getCalles().estaVacia()) {
                sb.append("sin calles");
            } else {
                sb.append(actual.getCalles().mostrarAdelante());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private Calle buscarCalle(String codigoOrigen, String codigoDestino) {
        Interseccion origen = obtenerInterseccion(codigoOrigen);
        if (origen == null) {
            return null;
        }
        for (int i = 0; i < origen.getCalles().cantidadElementos(); i++) {
            Calle calle = origen.getCalles().obtener(i);
            if (calle.getDestino().getCodigo().equalsIgnoreCase(codigoDestino)) {
                return calle;
            }
        }
        return null;
    }

    private int indiceDeCodigo(String codigo) {
        for (int i = 0; i < intersecciones.cantidadElementos(); i++) {
            if (intersecciones.obtener(i).getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    private int minimoNoVisitado(double[] distancia, boolean[] visitado) {
        int indiceMenor = -1;
        double menor = Double.MAX_VALUE;

        for (int i = 0; i < distancia.length; i++) {
            if (!visitado[i] && distancia[i] < menor) {
                menor = distancia[i];
                indiceMenor = i;
            }
        }
        return indiceMenor;
    }

    private Ruta construirRuta(int destino, int[] anterior, double tiempoTotal) {
        int[] recorrido = new int[intersecciones.cantidadElementos()];
        int cantidad = 0;
        int actual = destino;

        while (actual != -1) {
            recorrido[cantidad] = actual;
            cantidad++;
            actual = anterior[actual];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = cantidad - 1; i >= 0; i--) {
            Interseccion interseccion = intersecciones.obtener(recorrido[i]);
            sb.append(interseccion.getCodigo());
            if (i > 0) {
                sb.append(" -> ");
            }
        }
        return new Ruta(true, sb.toString(), tiempoTotal);
    }
}

# 2026-05-31T21:58:03
# 2026-06-02T21:58:04
# 2026-06-08T21:58:05
# 2026-06-07T21:59:57
# 2026-05-30T22:01:25
# 2026-05-31T22:01:25
# 2026-06-02T22:12:27
# 2026-06-06T22:14:37
# 2026-06-02T22:14:59
# 2026-06-02T22:18:01
# 2026-05-30T22:20:25