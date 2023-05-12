/**
 * Copyright 2023 Marta Canino Romero
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.practica3;

import java.util.*;

/**
 *
 *
 * @param <V>
 */
public class Graph<V> {

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /******************************************************************
     * Añade el vértice ‘v‘ al grafo.
     * La complejidad temporal es O(1) para insertar un vértice en adjacencyList usando el método put() TreeSet.
     * La complejidad espacial es O(1) para almacenar el vértice en la lista de adyacencia.
     *
     * @param v vértice a añadir.
     * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso contrario.
     *******************************************************************/
    public boolean addVertex(V v) {
        // el vertice no existe, lo creamos
        if (!containsVertex(v)) {
            adjacencyList.put(v, new TreeSet<>());
            return true;
        }
        // ya existía el vertice
        return false;
    }


    /******************************************************************
     * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo.
     * En caso de que no exista alguno de los vértices, lo añade también.
     * La complejidad temporal es O(log n) para agregar un arco a la lista de adyacencia de v1 usando la clase TreeSet
     * donde n es el número de vértices en la lista de adyacencia.
     * La complejidad temporal en el peor de los casos para agregar un vértice es O(n log n),
     * donde n es el número de vértices en la lista de adyacencia, si se crea un nuevo TreeSet para cada nuevo vértice
     * La complejidad espacial es O(1) para almacenar el arco en la lista de adyacencia.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return ‘true‘ si no existía el arco y ‘false‘ en caso contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        if (!adjacencyList.get(v1).contains(v2)) {
            adjacencyList.get(v1).add(v2);
            return true;
        }
        return false;
    }

    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a ‘v‘.
     * La complejidad temporal es O(1) para obtener los vértices adyacentes de un vértice usando el método get().
     * La complejidad espacial es O(1) para almacenar los vértices adyacentes en el HashSet.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!containsVertex(v)) {
            throw new Exception("Vertex not found");
        }
        return adjacencyList.get(v);
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     * La complejidad temporal es O(1) para verificar si un vértice está presente en la Lista de adyacencia usando el
     * método containsKey() de la clase HashMap.
     * La complejidad espacial es O(1).
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return ‘true‘ si ‘v‘ es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    /******************************************************************
     * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
     * La complejidad temporal es O(n^2), donde n es el número de vértices en la lista de adyacencia,
     * para construir la representación de cadena de la lista de adyacencia iterando a través de todos los vértices y
     * sus vértices adyacentes.
     * La complejidad espacial es O(n^2) para almacenar la representación de cadena de la lista de adyacencia.
     *
     * @return una cadena de caracteres con la lista de
     * adyacencia.
     ******************************************************************/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V vertex : adjacencyList.keySet()) {
            sb.append(vertex).append(": ");
            Set<V> adjacents = adjacencyList.get(vertex);
            for (V adjacent : adjacents) {
                sb.append(adjacent).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /*********************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y
     * ‘v2‘. En caso contrario, devuelve ‘null‘.
     * La complejidad temporal es O(|V|+|E|), donde |V| es el número de vértices y |E| es el número de aristas,
     * para realizar una búsqueda primero en amplitud (BFS) de v1 a v2 y construir la ruta de v1 a v2 usando HashMap.
     * La complejidad espacial es O(|V|+|E|) para almacenar la cola, el mapa y el conjunto visitado.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta
     * ‘v2‘ * pasando por arcos del grafo.
     *********************************************************/
    public List<V> onePath(V v1, V v2) {
        Queue<V> queue = new LinkedList<>();
        Map<V, V> prev = new HashMap<>();
        Set<V> visited = new HashSet<>();

        queue.offer(v1);
        prev.put(v1, null);
        visited.add(v1);

        while (!queue.isEmpty()) {
            V curr = queue.poll();
            if (curr.equals(v2)) {
                // se ha encontrado el vertice destino, construimos el camino
                List<V> path = new ArrayList<>();
                while (curr != null) {
                    path.add(curr);
                    curr = prev.get(curr);
                }
                Collections.reverse(path);
                return path;
            }
            for (V adj : adjacencyList.get(curr)) {
                if (!visited.contains(adj)) {
                    queue.offer(adj);
                    prev.put(adj, curr);
                    visited.add(adj);
                }
            }
        }
        return null; // no se ha encontrado camino
    }

}