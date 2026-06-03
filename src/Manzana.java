public class Manzana {
    private String codigo;
    private int cantidadViviendas;
    private int incidentesRegistrados;

    public Manzana(String codigo, int cantidadViviendas) {
        this.codigo = codigo;
        this.cantidadViviendas = cantidadViviendas;
        this.incidentesRegistrados = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidadViviendas() {
        return cantidadViviendas;
    }

    public int getIncidentesRegistrados() {
        return incidentesRegistrados;
    }

    public void registrarIncidente() {
        incidentesRegistrados++;
    }

    @Override
    public String toString() {
        return "Manzana " + codigo
                + " | viviendas: " + cantidadViviendas
                + " | incidentes: " + incidentesRegistrados;
    }
}

# 2026-05-30T21:57:04
# 2026-06-03T21:57:05
# 2026-06-10T21:57:06
# 2026-06-01T21:58:03
# 2026-06-05T21:58:04
# 2026-06-07T21:58:04
# 2026-05-30T21:59:54
# 2026-06-01T21:59:55
# 2026-06-11T21:59:58
# 2026-06-10T22:01:28
# 2026-06-11T22:01:29
# 2026-06-02T22:14:36
# 2026-06-07T22:14:37
# 2026-05-29T22:17:59
# 2026-06-10T22:18:03
# 2026-05-29T22:20:24
# 2026-05-29T22:20:24
# 2026-06-10T22:20:29
