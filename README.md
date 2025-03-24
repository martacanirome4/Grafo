# 🕸️ Implementación de Grafo con HashMap en Java

![Java](https://img.shields.io/badge/language-Java-orange)
![License](https://img.shields.io/badge/license-Apache_2.0-lightgrey)
![Maven](https://img.shields.io/badge/build-Maven-blue)

### 🚀 Este proyecto implementa un **grafo eficiente** con un `HashMap`, permitiendo operaciones como añadir/borrar vértices y aristas, y hallar caminos con **BFS** (Breadth First Search).

---

## 📖 ¿Qué es un Grafo?

Un **grafo** es una estructura compuesta por **vértices (nodos)** y **aristas (conexiones)**.  
Representa relaciones entre entidades, y es usado en informática, redes, IA, mapas, etc.

> Ejemplo: redes sociales, rutas de navegación, circuitos.

---

## 🗂️ Estructura de Datos - HashMap

- Cada **vértice** es una **clave** en un `HashMap`.
- El **valor** asociado es una lista de **vértices adyacentes**.
- Permite acceso rápido a vecinos y eficiente manejo de operaciones.

```java
Map<Vertex, List<Vertex>> graph = new HashMap<>();
```

---

## 🔍 Funcionalidad Clave

### 🔄 BFS – Búsqueda en Anchura

Método: `findPath(vertex1, vertex2)`  
- Encuentra el **camino más corto** entre dos vértices.
- Usa **cola** para explorar niveles progresivos del grafo.
- Ideal para grafos no ponderados.

---

## 🖼️ Visual del Grafo

![graph](https://github.com/martacanirome4/Grafo/assets/50625677/42bb545d-ffa2-45ae-8595-2a83b8cc08d6)

> Fuente: [Java Graph Tutorial](https://www.softwaretestinghelp.com/java-graph-tutorial/)

---

## ⚙️ Compilar y Ejecutar (Maven)

1. Clona este repositorio:
   ```bash
   git clone <repo-url>
   cd Grafo/
   ```

2. Compila y ejecuta los tests:
   ```bash
   mvn test
   ```

3. Genera documentación Javadoc:
   ```bash
   mvn javadoc:javadoc
   ```

📋 Los resultados de los tests se mostrarán en terminal.  
📁 Documentación HTML disponible en `/target/site/apidocs`.

---

## 📚 Recursos Adicionales

- 📊 Diagrama UML → `graphDiagram.png`, `graph.uml`
- 📝 Análisis de complejidad → Comentarios en código
- 📂 Javadoc → Documentación completa del proyecto

> Explora la arquitectura interna del grafo con visualizaciones y documentación.

---

## 👩‍💻 Autora

Marta Canino Romero – 2023  
[GitHub](https://github.com/martacanirome4)

---

## 📄 Licencia

Licensed under the Apache License 2.0 – [Ver licencia](http://www.apache.org/licenses/LICENSE-2.0)
