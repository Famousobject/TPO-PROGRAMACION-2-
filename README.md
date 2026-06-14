# Sistema Inteligente de Trafico y Emergencias

### LINK DE REPOSITORIO

####### https://github.com/Famousobject/TPO-PROGRAMACION-2-.git

## Integrantes
- Tomas Lomonaco
- Nicolas Santoro

## Alternativa elegida
**Alternativa B: Sistema Inteligente de Trafico y Emergencias**

## Descripcion del proyecto
El proyecto simula parte de un sistema de ciudad inteligente orientado a la administracion de la red vial y a la respuesta ante emergencias.


1. Gestion de la red vial.
2. Despacho de emergencias por prioridad.

El sistema permite representar intersecciones y calles de una ciudad mediante un grafo, calcular la ruta mas corta entre dos puntos y asignar asistencia a los incidentes segun su nivel de prioridad.

## Estructuras de datos utilizadas

### 1. Lista enlazada doble
Clases: `NodoDoble`, `ListaDoble`

Se utiliza como estructura dinamica base del proyecto.

Usos principales:
- almacenar las intersecciones cargadas en el grafo;
- almacenar las calles adyacentes de cada interseccion;
- guardar el historial cronologico de emergencias registradas.

Operaciones implementadas:
- insertar al inicio;
- insertar al final;
- eliminar al inicio;
- eliminar al final;
- buscar;
- obtener por posicion;
- modificar;
- eliminar por valor;
- mostrar hacia adelante;
- mostrar hacia atras;
- consultar cantidad de elementos.

### 2. Grafo con lista de adyacencia
Clases: `GrafoCiudad`, `Interseccion`, `Calle`, `Ruta`

Se utiliza para representar el mapa vial de la ciudad.

Cada interseccion funciona como un vertice del grafo y cada calle funciona como una arista que conecta dos intersecciones. Las calles tienen un tiempo estimado de recorrido, expresado en minutos.

Funcionalidades implementadas:
- agregar intersecciones;
- conectar intersecciones mediante calles;
- mostrar el mapa de la ciudad;
- calcular la ruta mas corta entre dos intersecciones;
- habilitar o cortar una calle para modificar el recorrido disponible.

### 3. Cola con prioridad
Clases: `ColaPrioridadEmergencias`, `Emergencia`, `SistemaEmergencias`

Se utiliza para administrar el orden de atencion de las emergencias registradas.

Criterio de prioridad:
1. se atiende primero la emergencia con mayor prioridad;
2. si dos emergencias tienen la misma prioridad, se atiende primero la que fue registrada antes;
3. si tambien coinciden en el minuto de registro, se prioriza el menor numero de identificacion.

## Funcionalidades implementadas en esta segunda etapa

### 1. Gestion de la red vial
La ciudad se modela como un grafo de intersecciones y calles.

El sistema permite:
- cargar intersecciones;
- conectar intersecciones mediante calles con tiempo de recorrido;
- mostrar las conexiones existentes;
- calcular el camino mas corto entre dos puntos.

Esta funcionalidad permite resolver consultas como: cual es la ruta mas rapida desde una interseccion origen hasta una interseccion destino.

### 2. Despacho de emergencias
El sistema permite registrar emergencias con los siguientes datos:
- descripcion;
- codigo de interseccion donde ocurre el incidente;
- prioridad;
- minuto de registro.

Las emergencias pendientes se organizan con una cola con prioridad. Al atender una emergencia, el sistema toma la mas urgente y calcula la ruta mas corta desde la base de asistencia hasta la ubicacion del incidente.

El sistema permite:
- registrar una nueva emergencia;
- listar emergencias pendientes ordenadas por prioridad;
- atender la siguiente emergencia;
- consultar el historial cronologico de emergencias registradas.

## Menu de prueba
El proyecto incluye una clase `Main` con un menu simple para demostrar las funcionalidades implementadas.

Opciones disponibles:

```text
1. Gestion de red vial y ruta mas corta
2. Despacho de emergencias por prioridad
0. Salir
```

## Como ejecutar el proyecto
Desde la carpeta del proyecto, ejecutar:

```bash
javac src/*.java
java -cp src Main
```

## Archivos principales

- `Main.java`: menu de prueba del sistema.
- `GrafoCiudad.java`: administra el grafo de la ciudad y calcula rutas.
- `Interseccion.java`: representa un vertice del grafo.
- `Calle.java`: representa una conexion entre intersecciones.
- `Ruta.java`: representa el resultado de una busqueda de camino.
- `SistemaEmergencias.java`: registra y atiende emergencias.
- `Emergencia.java`: contiene los datos de cada incidente.
- `ColaPrioridadEmergencias.java`: organiza las emergencias segun prioridad.
- `ListaDoble.java`: estructura dinamica utilizada por el sistema.
- `NodoDoble.java`: nodo utilizado por la lista doble.

## Actividades realizadas por integrante

### Tomas Lomonaco
- Implementacion de la lista enlazada doble.
- Implementacion del grafo de ciudad.
- Carga inicial de intersecciones y calles.
- Implementacion del calculo de ruta mas corta.
- Integracion de la gestion de red vial en el menu principal.

### Nicolas Santoro
- Implementacion de la clase `Emergencia`.
- Implementacion de la cola con prioridad para incidentes.
- Implementacion del sistema de despacho de emergencias.
- Integracion del despacho de emergencias con el grafo de ciudad.
- Redaccion y actualizacion de la documentacion del proyecto.
