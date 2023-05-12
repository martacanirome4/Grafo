# Grafo

En este proyecto se ha implementado una estructura de datos Grafo usando un HashMap como estructura de datos subyacente.
Esta implementación permite agregar y eliminar vértices y bordes de manera eficiente, y también permite encontrar 
el camino entre dos vértices mediante búsqueda en amplitud (Breadth First Search) (BFS).

##¿Qué es un grafo?
Un grafo es una estructura de datos que consta de un conjunto de vértices (o nodos) y un conjunto de aristas que 
conectan esos vértices. Los grafos se usan para representar relaciones entre objetos o entidades, y se usan comúnmente 
en informática y muchos otros campos.

##¿Qué es un HashMap?
Un HashMap es una estructura de datos que permite almacenar y recuperar pares clave-valor. 
Proporciona un rendimiento de tiempo constante para la mayoría de las operaciones, lo que la convierte en una estructura
de datos muy eficiente para muchos casos de uso.

## Detalles de implementación
Cada vértice se representa como una clave en HashMap, y el valor asociado con cada clave es una lista de vértices
adyacentes. Esto nos permite agregar y eliminar vértices y aristas de manera eficiente, y también encontrar rápidamente
los vecinos de un vértice dado.

El método principal implementado en este proyecto es el método findPath. 
Este método toma dos vértices como entrada y devuelve el camino más corto entre ellos usando BFS. 
BFS es un algoritmo de recorrido de gráficos que explora todos los vértices en el mismo nivel antes de pasar al siguiente.


## Compilar y ejecutar el proyecto

Para compilar y ejecutar el proyecto, y al tratarse de un proyecto 'Maven' será necesario:

1. Clonar el repositorio en el sistema local
2. Abrir una nueva ventana en la terminal y navegar hasta el directorio del proyecto
3. Ejecutar el comando 'mvn test'
4. Ejecutar el comando 'mvn javadoc:javadoc'

Automáticamente, el proyecto será compilado y los tests serán ejecutados, mostrando por pantalla aquellos que hayan sido pasados con éxito, y los que no.

## Documentación adicional
Además de la implementación del proyecto, dentro del fichero se encuentran una serie de archivos de apoyo, los cuales son:
- Diagrama UML de la estructura de clases y funciones, en los archivos:
  - graph.uml
  - graphDiagram.png
  - graphPlantUML
- Javadoc con la documentación de la APIs en formato HTML del proyecto, en la ruta:
  - /target/site/apidocs
  

### Autor
Marta Canino Romero, @martacanirome4 - GitHub 2023

### Licencia
Copyright 2023 Marta Canino Romero
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
