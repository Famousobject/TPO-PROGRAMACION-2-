public class OrganizacionTerritorial {
    private ListaDoble<Zona> zonas;

    public OrganizacionTerritorial() {
        zonas = new ListaDoble<>();
    }

    public boolean agregarZona(String nombreZona) {
        if (buscarZona(nombreZona) != null) {
            return false;
        }
        zonas.insertarFinal(new Zona(nombreZona));
        return true;
    }

    public boolean agregarBarrio(String nombreZona, String nombreBarrio) {
        Zona zona = buscarZona(nombreZona);
        if (zona == null || zona.buscarBarrio(nombreBarrio) != null) {
            return false;
        }
        zona.agregarBarrio(new Barrio(nombreBarrio));
        return true;
    }

    public boolean agregarManzana(String nombreZona, String nombreBarrio, String codigoManzana, int viviendas) {
        Zona zona = buscarZona(nombreZona);
        if (zona == null) {
            return false;
        }
        Barrio barrio = zona.buscarBarrio(nombreBarrio);
        if (barrio == null || barrio.buscarManzana(codigoManzana) != null) {
            return false;
        }
        barrio.agregarManzana(new Manzana(codigoManzana, viviendas));
        return true;
    }

    public boolean registrarIncidente(String nombreZona, String nombreBarrio, String codigoManzana) {
        Manzana manzana = buscarManzana(nombreZona, nombreBarrio, codigoManzana);
        if (manzana == null) {
            return false;
        }
        manzana.registrarIncidente();
        return true;
    }

    public Zona buscarZona(String nombreZona) {
        for (int i = 0; i < zonas.cantidadElementos(); i++) {
            Zona zona = zonas.obtener(i);
            if (zona.getNombre().equalsIgnoreCase(nombreZona)) {
                return zona;
            }
        }
        return null;
    }

    public Manzana buscarManzana(String nombreZona, String nombreBarrio, String codigoManzana) {
        Zona zona = buscarZona(nombreZona);
        if (zona == null) {
            return null;
        }
        Barrio barrio = zona.buscarBarrio(nombreBarrio);
        if (barrio == null) {
            return null;
        }
        return barrio.buscarManzana(codigoManzana);
    }

    public String reporteGeneral() {
        if (zonas.estaVacia()) {
            return "No hay zonas cargadas.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zonas.cantidadElementos(); i++) {
            sb.append(zonas.obtener(i).reporte()).append("\n");
        }
        return sb.toString();
    }
}

# 2026-05-29T21:57:04
# 2026-05-29T21:59:53
# 2026-05-31T21:59:54
# 2026-06-10T21:59:58
# 2026-06-12T21:59:59
# 2026-06-03T22:01:26
# 2026-06-04T22:12:27
# 2026-05-31T22:14:36
# 2026-06-12T22:14:39
# 2026-06-02T22:18:01
# 2026-06-04T22:18:01
# 2026-06-06T22:18:02
# 2026-06-02T22:20:25
# 2026-06-06T22:20:27




