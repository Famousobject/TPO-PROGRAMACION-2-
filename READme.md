# Sistema Inteligente de Tráfico y Emergencias

## Integrantes del grupo

- Tomás Lomonaco
- Nicolás Santoro

## Alternativa elegida

**Alternativa B: Sistema Inteligente de Tráfico y Emergencias**

## Descripción del proyecto

Este proyecto implementa un sistema de gestión para una ciudad inteligente, orientado al control del tráfico urbano y la atención de emergencias.

El sistema permite representar intersecciones, calles, dispositivos viales, emergencias, zonas territoriales y flujo vehicular. Para resolver estos problemas se aplican distintos Tipos Abstractos de Datos vistos en Programación II, implementados desde cero sin utilizar colecciones nativas de Java.

## Estructuras de datos utilizadas

### Lista doblemente enlazada

Se utiliza como estructura dinámica base para almacenar elementos relacionados con el sistema, como intersecciones, calles adyacentes, zonas, barrios, manzanas e historiales.

Operaciones principales:

- Insertar al inicio.
- Insertar al final.
- Eliminar elementos.
- Buscar elementos.
- Recorrer hacia adelante.
- Recorrer hacia atrás.

### Grafo con lista de adyacencia

Se utiliza para representar el mapa vial de la ciudad.

Cada intersección representa un vértice y cada calle representa una arista con un costo asociado, por ejemplo, el tiempo estimado de recorrido.

Funcionalidades asociadas:

- Agregar intersecciones.
- Conectar intersecciones mediante calles.
- Mostrar el mapa de la ciudad.
- Cortar o habilitar calles.
- Calcular rutas entre puntos de la ciudad.

### Cola con prioridad

Se utiliza para administrar emergencias, de forma que los incidentes más urgentes sean atendidos primero.

Criterio de atención:

1. Mayor prioridad.
2. En caso de igual prioridad, se atiende primero la emergencia registrada anteriormente.

### Árbol AVL

Se utiliza para indexar dispositivos viales, como semáforos, cámaras o sensores, manteniendo los datos ordenados y balanceados.

Funcionalidades asociadas:

- Insertar dispositivos.
- Buscar dispositivos por código.
- Modificar el estado de un dispositivo.
- Recorrer los dispositivos en orden.
- Mantener el balanceo mediante rotaciones.

### Tabla Hash / Diccionario de dispositivos

Se implementa un diccionario de dispositivos mediante una tabla hash desarrollada desde cero.

La finalidad es permitir el acceso eficiente a semáforos y cámaras mediante un código único.

Funcionalidades asociadas:

- Insertar dispositivos.
- Recuperar dispositivos por código.
- Modificar dispositivos existentes.
- Resolver colisiones mediante encadenamiento con nodos propios.

### Árbol N-ario territorial

Se utiliza para representar la organización territorial de la ciudad.

La estructura permite modelar contenedores anidados:

Ciudad -> Zonas -> Barrios -> Manzanas

Como cada territorio puede tener múltiples subterritorios, se implementa un árbol N-ario. Los hijos de cada nodo se almacenan utilizando una lista doblemente enlazada propia.

Funcionalidades asociadas:

- Insertar zonas en la ciudad.
- Insertar barrios dentro de una zona.
- Insertar manzanas dentro de un barrio.
- Mostrar la estructura territorial completa.

### Cola simple FIFO de vehículos

Se utiliza para administrar el flujo vehicular en una intersección.

La política utilizada es FIFO, es decir, el primer vehículo que llega es el primero en ser liberado.

Funcionalidades asociadas:

- Encolar vehículos.
- Desencolar vehículos.
- Consultar el vehículo del frente.
- Mostrar los vehículos en espera.

## Funcionalidades implementadas en la segunda etapa

En esta segunda etapa se implementaron las siguientes funcionalidades principales:

1. **Modelado de la ciudad mediante grafo**
   - Carga de intersecciones.
   - Carga de calles entre intersecciones.
   - Representación de conexiones viales mediante listas de adyacencia.
   - Cálculo de rutas dentro de la ciudad.

2. **Gestión de emergencias**
   - Registro de emergencias.
   - Asignación de prioridades.
   - Atención de emergencias según prioridad.
   - Mantenimiento de un historial cronológico.

3. **Indexación de dispositivos viales**
   - Administración de semáforos, cámaras y sensores.
   - Búsqueda de dispositivos por código.
   - Modificación del estado de dispositivos.
   - Implementación mediante árbol AVL y diccionario hash.

4. **Organización territorial**
   - Representación de la ciudad en zonas, barrios y manzanas.
   - Implementación de contenedores anidados mediante árbol N-ario.
   - Visualización de la estructura territorial.

5. **Flujo vehicular**
   - Administración de vehículos en una intersección.
   - Implementación de cola FIFO.
   - Liberación de vehículos en el mismo orden en que llegaron.

6. **Integración general del sistema**
   - Menú principal de prueba.
   - Demostración de las estructuras implementadas.
   - Ejecución de funcionalidades principales desde la clase `Main`.

## Link del repositorio

https://github.com/Famousobject/TPO-PROGRAMACION-2-

## Actividades realizadas por cada integrante

### Tomás Lomonaco

- Implementación de la lista doblemente enlazada.
- Implementación del grafo de ciudad.
- Carga de intersecciones y calles.
- Cálculo de rutas dentro del mapa vial.
- Implementación del flujo vehicular mediante cola FIFO.
- Integración de funcionalidades en el menú principal.

### Nicolás Santoro

- Implementación de la cola con prioridad para emergencias.
- Implementación del sistema de despacho de emergencias.
- Implementación del diccionario hash de dispositivos.
- Implementación de la organización territorial mediante árbol N-ario.
- Redacción y organización de documentación del proyecto.
