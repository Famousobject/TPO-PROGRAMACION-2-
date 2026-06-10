import java.util.Scanner;

public class Main {
    private static GrafoCiudad grafo;
    private static SistemaEmergencias emergencias;
    private static ArbolAVLDispositivos dispositivos;
    private static OrganizacionTerritorial territorio;
    private static ColaCircularVehiculos colaVehiculos;

    public static void main(String[] args) {
        cargarDatosIniciales();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Opcion: ");
            System.out.println();

            switch (opcion) {
                case 1:
                    menuMapa(scanner);
                    break;
                case 2:
                    menuEmergencias(scanner);
                    break;
                case 3:
                    menuDispositivos(scanner);
                    break;
                case 4:
                    menuTerritorio();
                    break;
                case 5:
                    menuFlujoVehicular(scanner);
                    break;
                case 6:
                    ejecutarDemoCompleta();
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("============================================");
        System.out.println(" Sistema Inteligente de Trafico y Emergencias");
        System.out.println("============================================");
        System.out.println("1. Mapa de la ciudad y ruta mas corta");
        System.out.println("2. Despacho de emergencias");
        System.out.println("3. Dispositivos indexados por AVL");
        System.out.println("4. Organizacion territorial");
        System.out.println("5. Flujo vehicular FIFO en interseccion");
        System.out.println("6. Demo completa");
        System.out.println("0. Salir");
    }

    private static void menuMapa(Scanner scanner) {
        System.out.println("--- Mapa de la ciudad ---");
        System.out.println(grafo.mostrarGrafo());
        String origen = leerTexto(scanner, "Codigo origen: ");
        String destino = leerTexto(scanner, "Codigo destino: ");
        System.out.println(grafo.rutaMasCorta(origen, destino));
    }

    private static void menuEmergencias(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--- Emergencias ---");
            System.out.println("1. Registrar emergencia");
            System.out.println("2. Ver pendientes por prioridad");
            System.out.println("3. Atender siguiente desde base E");
            System.out.println("4. Reporte cronologico");
            System.out.println("0. Volver");
            opcion = leerEntero(scanner, "Opcion: ");

            switch (opcion) {
                case 1:
                    String desc = leerTexto(scanner, "Descripcion: ");
                    String inter = leerTexto(scanner, "Codigo de interseccion: ");
                    int prioridad = leerEntero(scanner, "Prioridad 1=baja, 2=media, 3=alta: ");
                    int minuto = leerEntero(scanner, "Minuto de reporte: ");
                    Emergencia nueva = emergencias.registrarEmergencia(desc, inter, prioridad, minuto);
                    System.out.println("Registrada: " + nueva);
                    break;
                case 2:
                    System.out.println(emergencias.mostrarPendientes());
                    break;
                case 3:
                    System.out.println(emergencias.atenderSiguiente(grafo, "E"));
                    break;
                case 4:
                    System.out.println(emergencias.reporteCronologico());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void menuDispositivos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--- Dispositivos AVL ---");
            System.out.println("1. Mostrar inorden");
            System.out.println("2. Buscar por codigo");
            System.out.println("3. Modificar estado");
            System.out.println("0. Volver");
            opcion = leerEntero(scanner, "Opcion: ");

            switch (opcion) {
                case 1:
                    System.out.println(dispositivos.mostrarInorden());
                    System.out.println("Altura del AVL: " + dispositivos.altura());
                    break;
                case 2:
                    int codigo = leerEntero(scanner, "Codigo: ");
                    Dispositivo encontrado = dispositivos.buscar(codigo);
                    System.out.println(encontrado == null ? "No encontrado" : encontrado);
                    break;
                case 3:
                    int cod = leerEntero(scanner, "Codigo: ");
                    String estado = leerTexto(scanner, "Nuevo estado: ");
                    int lectura = leerEntero(scanner, "Nueva lectura numerica: ");
                    boolean ok = dispositivos.modificarEstado(cod, estado, lectura);
                    System.out.println(ok ? "Estado actualizado" : "Dispositivo inexistente");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void menuTerritorio() {
        System.out.println("--- Organizacion territorial ---");
        System.out.println(territorio.reporteGeneral());
    }

    private static void menuFlujoVehicular(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--- Flujo vehicular FIFO ---");
            System.out.println("Cola actual: " + colaVehiculos.mostrar());
            System.out.println("1. Ingresar vehiculo");
            System.out.println("2. Liberar siguiente vehiculo");
            System.out.println("0. Volver");
            opcion = leerEntero(scanner, "Opcion: ");

            switch (opcion) {
                case 1:
                    String patente = leerTexto(scanner, "Patente: ");
                    String tipo = leerTexto(scanner, "Tipo: ");
                    int minuto = leerEntero(scanner, "Minuto de llegada: ");
                    boolean encolado = colaVehiculos.encolar(new Vehiculo(patente, tipo, minuto));
                    System.out.println(encolado ? "Vehiculo ingresado" : "Cola llena");
                    break;
                case 2:
                    Vehiculo liberado = colaVehiculos.desencolar();
                    System.out.println(liberado == null ? "No hay vehiculos" : "Liberado: " + liberado);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void ejecutarDemoCompleta() {
        System.out.println("--- DEMO COMPLETA ---");
        System.out.println("1) Grafo de ciudad con lista de adyacencia:");
        System.out.println(grafo.mostrarGrafo());
        System.out.println("Ruta mas corta desde Bomberos (E) hasta Escuela (D):");
        System.out.println(grafo.rutaMasCorta("E", "D"));

        System.out.println("\n2) Emergencias con cola de prioridad:");
        emergencias.registrarEmergencia("Choque leve", "C", 1, 10);
        emergencias.registrarEmergencia("Incendio", "D", 3, 11);
        emergencias.registrarEmergencia("Accidente con heridos", "B", 2, 12);
        System.out.println("Pendientes ordenadas por prioridad:");
        System.out.println(emergencias.mostrarPendientes());
        System.out.println(emergencias.atenderSiguiente(grafo, "E"));

        System.out.println("\n3) AVL de dispositivos:");
        System.out.println(dispositivos.mostrarInorden());
        System.out.println("Cambio de estado del semaforo 101 a ROJO");
        dispositivos.modificarEstado(101, "ROJO", 0);
        System.out.println(dispositivos.buscar(101));

        System.out.println("\n4) Reporte territorial:");
        System.out.println(territorio.reporteGeneral());

        System.out.println("\n5) Flujo vehicular FIFO:");
        ColaCircularVehiculos demo = new ColaCircularVehiculos(5);
        demo.encolar(new Vehiculo("AA111AA", "auto", 1));
        demo.encolar(new Vehiculo("BB222BB", "moto", 2));
        demo.encolar(new Vehiculo("CC333CC", "camioneta", 3));
        System.out.println("Cola antes de liberar: " + demo.mostrar());
        System.out.println("Sale primero: " + demo.desencolar());
        System.out.println("Cola despues: " + demo.mostrar());
    }

    private static void cargarDatosIniciales() {
        grafo = new GrafoCiudad();
        grafo.agregarInterseccion("A", "Hospital Central");
        grafo.agregarInterseccion("B", "Av. Norte y San Martin");
        grafo.agregarInterseccion("C", "Plaza Principal");
        grafo.agregarInterseccion("D", "Escuela Tecnica");
        grafo.agregarInterseccion("E", "Cuartel de Bomberos");
        grafo.agregarInterseccion("F", "Terminal");

        grafo.conectarBidireccional("A", "B", "Av. Salud", 4);
        grafo.conectarBidireccional("B", "C", "San Martin", 3);
        grafo.conectarBidireccional("C", "D", "Belgrano", 5);
        grafo.conectarBidireccional("B", "D", "Av. Norte", 8);
        grafo.conectarBidireccional("E", "B", "Ruta Bomberos", 6);
        grafo.conectarBidireccional("E", "F", "Colectora", 4);
        grafo.conectarBidireccional("F", "D", "Acceso Sur", 7);
        grafo.conectarBidireccional("A", "E", "Guardia", 9);

        emergencias = new SistemaEmergencias();

        dispositivos = new ArbolAVLDispositivos();
        dispositivos.insertar(new Dispositivo(101, "Semaforo", "Interseccion B", "VERDE", 0));
        dispositivos.insertar(new Dispositivo(205, "Camara", "Plaza C", "ACTIVA", 82));
        dispositivos.insertar(new Dispositivo(150, "Semaforo", "Hospital A", "AMARILLO", 0));
        dispositivos.insertar(new Dispositivo(310, "Camara", "Terminal F", "ACTIVA", 76));
        dispositivos.insertar(new Dispositivo(120, "Sensor", "Escuela D", "ACTIVO", 30));

        territorio = new OrganizacionTerritorial();
        territorio.agregarZona("Zona Norte");
        territorio.agregarBarrio("Zona Norte", "Centro");
        territorio.agregarBarrio("Zona Norte", "Hospitalario");
        territorio.agregarManzana("Zona Norte", "Centro", "M1", 34);
        territorio.agregarManzana("Zona Norte", "Centro", "M2", 28);
        territorio.agregarManzana("Zona Norte", "Hospitalario", "M3", 18);
        territorio.registrarIncidente("Zona Norte", "Centro", "M1");
        territorio.registrarIncidente("Zona Norte", "Centro", "M1");
        territorio.registrarIncidente("Zona Norte", "Hospitalario", "M3");

        territorio.agregarZona("Zona Sur");
        territorio.agregarBarrio("Zona Sur", "Terminal");
        territorio.agregarManzana("Zona Sur", "Terminal", "M4", 22);

        colaVehiculos = new ColaCircularVehiculos(5);
        colaVehiculos.encolar(new Vehiculo("AB123CD", "auto", 1));
        colaVehiculos.encolar(new Vehiculo("EF456GH", "moto", 2));
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    private static String leerTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}

# 2026-06-03T21:57:05
# 2026-06-03T21:57:05
# 2026-06-11T21:57:06
# 2026-06-11T21:58:05
# 2026-06-03T22:01:26
# 2026-06-11T22:12:29
# 2026-06-12T22:12:30
# 2026-05-29T22:14:35
# 2026-06-10T22:14:38
# 2026-06-12T22:14:39
# 2026-06-04T22:15:00
# 2026-06-04T22:15:00
# 2026-06-10T22:15:02
# 2026-06-07T22:18:02
# 2026-06-01T22:20:25
# 2026-06-09T22:20:29