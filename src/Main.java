import java.util.Scanner;

public class Main {
    private static GrafoCiudad grafo;
    private static SistemaEmergencias emergencias;

    private static DiccionarioDispositivos diccionarioDispositivos;
    private static ArbolTerritorio arbolTerritorio;

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
                    menuRedVial(scanner);
                    break;
                case 2:
                    menuEmergencias(scanner);
                    break;
                case 3:
                    menuFuncionalidadesFinales(scanner);
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
        System.out.println("1. Gestion de red vial y ruta mas corta");
        System.out.println("2. Despacho de emergencias por prioridad");
        System.out.println("3. Funcionalidades finales");
        System.out.println("0. Salir");
    }

    private static void menuRedVial(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--- Gestion de red vial ---");
            System.out.println("1. Mostrar mapa de intersecciones y calles");
            System.out.println("2. Consultar ruta mas corta");
            System.out.println("3. Cortar una calle");
            System.out.println("4. Habilitar una calle");
            System.out.println("0. Volver");
            opcion = leerEntero(scanner, "Opcion: ");

            switch (opcion) {
                case 1:
                    System.out.println(grafo.mostrarGrafo());
                    break;
                case 2:
                    String origen = leerTexto(scanner, "Codigo origen: ");
                    String destino = leerTexto(scanner, "Codigo destino: ");
                    System.out.println(grafo.rutaMasCorta(origen, destino));
                    break;
                case 3:
                    String origenCorte = leerTexto(scanner, "Codigo origen de la calle: ");
                    String destinoCorte = leerTexto(scanner, "Codigo destino de la calle: ");
                    boolean cortada = grafo.cortarCalle(origenCorte, destinoCorte);
                    System.out.println(cortada ? "Calle cortada correctamente." : "No se encontro la calle.");
                    break;
                case 4:
                    String origenHab = leerTexto(scanner, "Codigo origen de la calle: ");
                    String destinoHab = leerTexto(scanner, "Codigo destino de la calle: ");
                    boolean habilitada = grafo.habilitarCalle(origenHab, destinoHab);
                    System.out.println(habilitada ? "Calle habilitada correctamente." : "No se encontro la calle.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void menuEmergencias(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--- Despacho de emergencias ---");
            System.out.println("1. Registrar emergencia");
            System.out.println("2. Ver emergencias pendientes por prioridad");
            System.out.println("3. Atender siguiente emergencia desde base E");
            System.out.println("0. Volver");
            opcion = leerEntero(scanner, "Opcion: ");

            switch (opcion) {
                case 1:
                    String descripcion = leerTexto(scanner, "Descripcion: ");
                    String interseccion = leerTexto(scanner, "Codigo de interseccion: ");
                    int prioridad = leerEntero(scanner, "Prioridad 1=baja, 2=media, 3=alta: ");
                    int minuto = leerEntero(scanner, "Minuto de reporte: ");
                    Emergencia nueva = emergencias.registrarEmergencia(descripcion, interseccion, prioridad, minuto);
                    System.out.println("Registrada: " + nueva);
                    break;
                case 2:
                    System.out.println(emergencias.mostrarPendientes());
                    break;
                case 3:
                    System.out.println(emergencias.atenderSiguiente(grafo, "E"));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void menuFuncionalidadesFinales(Scanner scanner) {
        int opcion;
        do {
            System.out.println("--- Funcionalidades finales ---");
            System.out.println("1. Probar diccionario de dispositivos");
            System.out.println("2. Probar arbol territorial");
            System.out.println("3. Probar cola vehicular FIFO");
            System.out.println("4. Ejecutar demostracion completa");
            System.out.println("0. Volver");
            opcion = leerEntero(scanner, "Opcion: ");

            switch (opcion) {
                case 1:
                    probarDiccionarioDispositivos();
                    break;
                case 2:
                    probarArbolTerritorio();
                    break;
                case 3:
                    probarColaVehiculos();
                    break;
                case 4:
                    probarFuncionalidadesFinales();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

            System.out.println();
        } while (opcion != 0);
    }

    private static void probarFuncionalidadesFinales() {
        System.out.println("=== PRUEBA DE FUNCIONALIDADES FINALES ===");

        probarDiccionarioDispositivos();
        probarArbolTerritorio();
        probarColaVehiculos();
    }

    private static void probarDiccionarioDispositivos() {
        System.out.println();
        System.out.println("--- Diccionario de Dispositivos ---");

        Dispositivo semaforo = new Dispositivo("SEM-001", "Semaforo", "Activo");
        Dispositivo camara = new Dispositivo("CAM-010", "Camara", "Activa");
        Dispositivo sensor = new Dispositivo("SEN-020", "Sensor", "Activo");

        diccionarioDispositivos.insertar(semaforo.getCodigo(), semaforo);
        diccionarioDispositivos.insertar(camara.getCodigo(), camara);
        diccionarioDispositivos.insertar(sensor.getCodigo(), sensor);

        System.out.println("Dispositivo recuperado por codigo SEM-001:");
        System.out.println(diccionarioDispositivos.recuperar("SEM-001"));

        Dispositivo semaforoModificado = new Dispositivo("SEM-001", "Semaforo", "En mantenimiento");
        boolean modificado = diccionarioDispositivos.modificar("SEM-001", semaforoModificado);

        System.out.println("Modificacion realizada: " + modificado);
        System.out.println("Dispositivo luego de modificar:");
        System.out.println(diccionarioDispositivos.recuperar("SEM-001"));

        diccionarioDispositivos.mostrar();
    }

    private static void probarArbolTerritorio() {
        System.out.println();
        System.out.println("--- Arbol Territorial N-ario ---");

        arbolTerritorio = new ArbolTerritorio("Ciudad Inteligente");

        arbolTerritorio.insertarZona("Zona Norte");
        arbolTerritorio.insertarZona("Zona Sur");

        arbolTerritorio.insertarBarrio("Zona Norte", "Barrio Centro");
        arbolTerritorio.insertarBarrio("Zona Norte", "Barrio Estacion");
        arbolTerritorio.insertarBarrio("Zona Sur", "Barrio Industrial");

        arbolTerritorio.insertarManzana("Zona Norte", "Barrio Centro", "Manzana 1");
        arbolTerritorio.insertarManzana("Zona Norte", "Barrio Centro", "Manzana 2");
        arbolTerritorio.insertarManzana("Zona Norte", "Barrio Estacion", "Manzana 3");
        arbolTerritorio.insertarManzana("Zona Sur", "Barrio Industrial", "Manzana 4");

        arbolTerritorio.mostrar();
    }

    private static void probarColaVehiculos() {
        System.out.println();
        System.out.println("--- Cola Vehicular FIFO ---");

        Interseccion interseccion = new Interseccion("X", "Av. Principal y Calle 10");

        Vehiculo v1 = new Vehiculo("ABC123", "Auto");
        Vehiculo v2 = new Vehiculo("XYZ789", "Moto");
        Vehiculo v3 = new Vehiculo("KLM456", "Camioneta");

        interseccion.recibirVehiculo(v1);
        interseccion.recibirVehiculo(v2);
        interseccion.recibirVehiculo(v3);

        System.out.println("Vehiculos esperando:");
        interseccion.mostrarColaVehiculos();

        System.out.println("Liberando vehiculos en orden FIFO:");
        System.out.println(interseccion.liberarVehiculo());
        System.out.println(interseccion.liberarVehiculo());
        System.out.println(interseccion.liberarVehiculo());
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

        diccionarioDispositivos = new DiccionarioDispositivos();
        arbolTerritorio = new ArbolTerritorio("Ciudad Inteligente");
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
