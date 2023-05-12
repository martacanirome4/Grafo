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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    Graph<Integer> myGraph;
    Graph<Integer> myEdge;

    @Before
    public void setup(){
        myGraph = new Graph<>();
        myEdge = new Graph<>();
    }

    @Test
    public void testAddVertex() {
        assertTrue(myGraph.addVertex(1));
        assertFalse(myGraph.addVertex(1));
    }

    @Test
    public void addVertex() {
        assertTrue(myGraph.addVertex(1));
        assertTrue(myGraph.containsVertex(1));
        assertFalse(myGraph.addVertex(1));
        assertFalse(myGraph.containsVertex(2));
    }

    @Test
    public void addVertexFalse() {
        assertTrue(myGraph.addVertex(1));
        assertFalse(myGraph.containsVertex(2));
    }

    @Test
    public void testAddEdge() {
        assertTrue(myGraph.addEdge(1, 2));
        assertTrue(myGraph.addEdge(1, 3));
        assertFalse(myGraph.addEdge(1, 2));
        assertFalse(myGraph.addEdge(2, 1));
        assertFalse(myGraph.addEdge(3, 4));
        assertTrue(myGraph.containsVertex(1));
        assertTrue(myGraph.containsVertex(2));
        assertTrue(myGraph.containsVertex(3));
        assertFalse(myGraph.containsVertex(4));
    }

    @Test
    public void addEdge() {
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        assertTrue(myGraph.addEdge(1, 2));
    }

    @Test
    public void addEdgeFalse() {
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        assertTrue(myGraph.addEdge(1, 2));
        assertFalse(myGraph.addEdge(1, 2));
    }

    @Test
    public void testObtainAdjacents() throws Exception {
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(2, 4);
        assertEquals(2, myGraph.obtainAdjacents(1).size());
        assertTrue(myGraph.obtainAdjacents(1).contains(2));
        assertTrue(myGraph.obtainAdjacents(1).contains(3));
        assertEquals(2, myGraph.obtainAdjacents(2).size());
        assertTrue(myGraph.obtainAdjacents(2).contains(3));
        assertTrue(myGraph.obtainAdjacents(2).contains(4));
        assertThrows(Exception.class, () -> myGraph.obtainAdjacents(5));
    }

    @Test
    public void obtainAdjacents() throws Exception {
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addEdge(1, 2);
        Set<Integer> adjacents = myGraph.obtainAdjacents(1);
        assertEquals(adjacents.size(), 1);
        assertTrue(adjacents.contains(2));
    }

    @Test
    public void obtainAdjacentsFalse() throws Exception {
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addEdge(1, 2);
        Set<Integer> adjacents = myGraph.obtainAdjacents(1);
        assertFalse(adjacents.contains(3));
    }

    @Test
    public void testContainsVertex() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.containsVertex("A"));
        assertTrue(graph.containsVertex("B"));
        assertFalse(graph.containsVertex("C"));
    }

    @Test
    public void containsVertex() {
        assertFalse(myGraph.containsVertex(1));
        myGraph.addVertex(1);
        assertTrue(myGraph.containsVertex(1));
    }

    @Test
    public void containsVertexFalse() {
        myGraph.addVertex(1);
        assertTrue(myGraph.containsVertex(1));
        assertFalse(myGraph.containsVertex(3));
        assertFalse(myGraph.addVertex(1));

    }

    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘
     * encuentra un camino entre ‘v1‘ y ‘v2‘ cuando existe.
     */
    @Test
    public void onePathFindsAPath(){
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");
        // Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        // Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
        //Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }

    @Test
    public void testToString() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        String expected = "A: B, C\nB: C, D\nC: \nD: \n";
        assertEquals(expected, graph.toString());
    }


}
