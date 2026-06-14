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


