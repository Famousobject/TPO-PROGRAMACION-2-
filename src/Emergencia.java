public class Emergencia {
    private int id;
    private String descripcion;
    private String codigoInterseccion;
    private int prioridad;
    private int minutoRegistro;
    private String estado;

    public Emergencia(int id, String descripcion, String codigoInterseccion, int prioridad, int minutoRegistro) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigoInterseccion = codigoInterseccion;
        this.prioridad = prioridad;
        this.minutoRegistro = minutoRegistro;
        this.estado = "PENDIENTE";
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigoInterseccion() {
        return codigoInterseccion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getMinutoRegistro() {
        return minutoRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean tieneMasPrioridadQue(Emergencia otra) {
        if (this.prioridad > otra.prioridad) {
            return true;
        }
        if (this.prioridad < otra.prioridad) {
            return false;
        }
        if (this.minutoRegistro < otra.minutoRegistro) {
            return true;
        }
        if (this.minutoRegistro > otra.minutoRegistro) {
            return false;
        }
        return this.id < otra.id;
    }

    @Override
    public String toString() {
        return "#" + id + " [P" + prioridad + "] " + descripcion
                + " en " + codigoInterseccion
                + " | min " + minutoRegistro
                + " | " + estado;
    }
}

# 2026-05-31T21:58:03
# 2026-06-11T21:58:05
# 2026-05-29T21:59:53
# 2026-06-07T21:59:57
# 2026-06-04T22:01:26
# 2026-05-30T22:14:35
# 2026-06-01T22:14:36
# 2026-06-07T22:15:01
# 2026-06-11T22:18:03