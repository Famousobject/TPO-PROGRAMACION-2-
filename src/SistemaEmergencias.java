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

# 2026-05-31T21:57:04
# 2026-06-04T21:57:05
# 2026-06-05T21:57:05
# 2026-06-06T21:57:06
# 2026-06-03T21:58:04
# 2026-06-09T21:59:58
# 2026-06-06T22:01:27
# 2026-06-08T22:01:28
# 2026-05-29T22:14:35
# 2026-05-30T22:14:59
# 2026-06-06T22:15:00
# 2026-06-11T22:15:02
# 2026-06-01T22:20:25
# 2026-06-02T22:20:25
