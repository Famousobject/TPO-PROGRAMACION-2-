# Sistema Inteligente de Trafico y Emergencias

## Integrantes
- Tomas Lomonaco
- Nicolas Santoro

## Alternativa elegida
**Alternativa B: Sistema Inteligente de Trafico y Emergencias**

## Descripcion del proyecto
El sistema administra una ciudad inteligente con intersecciones, calles, dispositivos viales, emergencias, zonas territoriales y flujo vehicular.

El objetivo es aplicar estructuras de datos vistas en Programacion II para resolver una problematica real de trafico y respuesta ante incidentes.

## Estructuras de datos utilizadas

### 1. Lista enlazada doble
Clases: `NodoDoble`, `ListaDoble`

Se usa para almacenar colecciones dinamicas, por ejemplo:
- intersecciones del grafo;
- calles adyacentes de cada interseccion;
- historial cronologico de emergencias;
- zonas, barrios y manzanas.

Operaciones implementadas:
- insertar al inicio;
- insertar al final;
- eliminar al inicio;
- eliminar al final;
- buscar;
- obtener por posicion;
- modificar;
- mostrar hacia adelante;
- mostrar hacia atras.

### 2. Grafo con lista de adyacencia
Clases: `GrafoCiudad`, `Interseccion`, `Calle`, `Ruta`

Representa el mapa vial de la ciudad.

Cada interseccion es un vertice y cada calle es una arista con un costo expresado en minutos.

Funcionalidades:
- agregar intersecciones;
- conectar intersecciones con calles;
- mostrar el mapa;
- cortar o habilitar calles;
- calcular ruta mas corta entre dos puntos.

### 3. Cola con prioridad
Clases: `ColaPrioridadEmergencias`, `Emergencia`, `SistemaEmergencias`

Se usa para administrar incidentes y despachar primero los casos mas urgentes.

Criterio de orden:
1. mayor prioridad;
2. si tienen igual prioridad, primero el reporte mas antiguo.

### 4. Arbol AVL
Clases: `ArbolAVLDispositivos`, `Dispositivo`

Se usa como indice de dispositivos viales por codigo.

Funcionalidades:
- insertar dispositivo;
- buscar por codigo;
- modificar estado;
- mostrar en recorrido inorden;
- mantener balanceo mediante rotaciones.

### 5. Cola circular
Clases: `ColaCircularVehiculos`, `Vehiculo`

Se usa para simular el flujo vehicular de una interseccion.

Los vehiculos salen en el mismo orden en que llegaron, respetando FIFO.

### 6. Contenedores anidados
Clases: `OrganizacionTerritorial`, `Zona`, `Barrio`, `Manzana`

Representan la organizacion territorial:

Ciudad -> Zonas -> Barrios -> Manzanas

Permite generar reportes por zona, barrio y manzana.

## Funcionalidades implementadas en esta segunda etapa

1. **Modelado de la ciudad**
   - La ciudad se representa con un grafo.
   - Se pueden cargar intersecciones y calles.
   - Se calcula la ruta mas corta entre dos puntos.

2. **Despacho de emergencias**
   - Se registran emergencias con prioridad.
   - El sistema atiende primero la emergencia mas grave.
   - Se mantiene un reporte cronologico de registros.

3. **Indexacion de dispositivos**
   - Semaforos, camaras y sensores se almacenan en un AVL.
   - Se pueden buscar y actualizar por codigo.

4. **Organizacion territorial**
   - La ciudad se divide en zonas, barrios y manzanas.
   - El sistema muestra un reporte territorial con incidentes.

5. **Flujo vehicular**
   - Los vehiculos se administran mediante cola circular.
   - Se libera primero el vehiculo que llego primero.

## Como ejecutar

Desde la carpeta del proyecto:

```bash
javac src/*.java
java -cp src Main
```

En el menu principal, elegir la opcion `6` para ejecutar una demostracion completa.

## Link del repositorio
PENDIENTE: agregar el link de GitHub despues de subir el proyecto.

## Actividades realizadas por integrante

### Tomas Lomonaco
- Implementacion de la lista enlazada doble.
- Implementacion del grafo de ciudad.
- Carga de intersecciones y calles.
- Calculo de ruta mas corta.
- Implementacion de cola circular para flujo vehicular.
- Integracion en el menu de prueba.

### Nicolas Santoro
- Implementacion de cola con prioridad para emergencias.
- Implementacion del sistema de despacho de emergencias.
- Implementacion del arbol AVL para dispositivos.
- Implementacion de organizacion territorial por zonas, barrios y manzanas.
- Redaccion del README y documentacion de funcionalidades.

## Archivos principales

- `Main.java`: menu de prueba y demo completa.
- `GrafoCiudad.java`: mapa vial y rutas.
- `ListaDoble.java`: estructura dinamica base.
- `ColaPrioridadEmergencias.java`: atencion de incidentes por prioridad.
- `ArbolAVLDispositivos.java`: indice de semaforos, camaras y sensores.
- `ColaCircularVehiculos.java`: orden de salida de vehiculos.
- `OrganizacionTerritorial.java`: estructura zona-barrio-manzana.
