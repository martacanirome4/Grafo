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
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new HashSet<>());
            return true;
        }
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
        Set<V> adjacents = adjacencyList.get(v);
        if (adjacents == null) {
            throw new Exception("Vertex not found");
        }
        return adjacents;
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
     * Complejidad temporal: O(V+E), donde V es el número de vértices y E es el número de aristas del grafo.
     *
     * @return una cadena de caracteres con la lista de
     * adyacencia.
     ******************************************************************/
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Vertex:\t Connections:\n");
        for (V vertex : this.adjacencyList.keySet()){
            str.append(vertex.toString());
            str.append(adjacencyList.get(vertex).toString() + "\n");
        }
        return str.toString();
    }

    /*********************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y
     * ‘v2‘. En caso contrario, devuelve ‘null‘.
     * Este método implementa el algoritmo de búsqueda en anchura (BFS).
     * Complejidad temporal: O(V + E), donde V es el número de vértices y E es el número de aristas del grafo.
     * Mejor caso: O(1), si el vértice de origen v1 es el mismo que el vértice de destino v2.
     * Peor caso: O(V+E), donde V es el número de vértices y E es el número de aristas en el grafo.
     * En el peor de los casos, el algoritmo necesita atravesar todos los vértices y aristas del grafo.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta
     * ‘v2‘ * pasando por arcos del grafo.
     *********************************************************/
    public List<V> onePath(V v1, V v2){
        Map<V, V> parents = new HashMap<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(v1);
        parents.put(v1, null);
        while (!queue.isEmpty()) {
            V vertex = queue.remove();
            if (vertex.equals(v2)) {
                List<V> path = new ArrayList<>();
                V curr = v2;
                while (curr != null) {
                    path.add(curr);
                    curr = parents.get(curr);
                }
                Collections.reverse(path);
                return path;
            }
            for (V adj : this.adjacencyList.get(vertex)) {
                if (!parents.containsKey(adj)) {
                    queue.add(adj);
                    parents.put(adj, vertex);
                }
            }
        }
        return null; // no se ha encontrado camino
    }

}