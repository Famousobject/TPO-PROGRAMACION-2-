public class SistemaEmergencias {
    private ColaPrioridadEmergencias pendientes;
    private ListaDoble<Emergencia> historialCronologico;
    private int proximoId;

    public SistemaEmergencias() {
        pendientes = new ColaPrioridadEmergencias();
        historialCronologico = new ListaDoble<>();
        proximoId = 1;
    }

    public Emergencia registrarEmergencia(String descripcion, String codigoInterseccion, int prioridad, int minutoRegistro) {
        Emergencia emergencia = new Emergencia(proximoId, descripcion, codigoInterseccion, prioridad, minutoRegistro);
        proximoId++;
        pendientes.encolar(emergencia);
        historialCronologico.insertarFinal(emergencia);
        return emergencia;
    }

    public String atenderSiguiente(GrafoCiudad grafo, String codigoBaseAsistencia) {
        Emergencia emergencia = pendientes.desencolar();
        if (emergencia == null) {
            return "No hay emergencias para atender.";
        }

        emergencia.setEstado("ASISTENCIA ASIGNADA");
        Ruta ruta = grafo.rutaMasCorta(codigoBaseAsistencia, emergencia.getCodigoInterseccion());

        StringBuilder sb = new StringBuilder();
        sb.append("Emergencia atendida: ").append(emergencia).append("\n");
        if (ruta.existe()) {
            sb.append("Unidad enviada desde ").append(codigoBaseAsistencia).append(". ").append(ruta);
        } else {
            sb.append("No se pudo calcular ruta desde la base ").append(codigoBaseAsistencia).append(".");
        }
        return sb.toString();
    }

    public String mostrarPendientes() {
        return pendientes.mostrar();
    }

    public String reporteCronologico() {
        if (historialCronologico.estaVacia()) {
            return "No hay emergencias registradas.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < historialCronologico.cantidadElementos(); i++) {
            sb.append(historialCronologico.obtener(i)).append("\n");
        }
        return sb.toString();
    }
}
