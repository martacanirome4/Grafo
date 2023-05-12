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

    Graph<String> myGraph;
    Graph<String> myEdge;

    @Before
    public void setup(){
        myGraph = new Graph<>();
        myEdge = new Graph<>();
    }

    @Test
    public void addVertex() {
        assertTrue(myGraph.addVertex("A"));
        assertTrue(myGraph.containsVertex("A"));
        assertFalse(myGraph.addVertex("A"));
        assertFalse(myGraph.containsVertex("B"));
    }

    @Test
    public void addVertexFalse() {
        assertTrue(myGraph.addVertex("A"));
        assertFalse(myGraph.containsVertex("B"));
    }

    @Test
    public void addEdge() {
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        assertTrue(myGraph.addEdge("A", "B"));
    }

    @Test
    public void addEdgeFalse() {
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        assertTrue(myGraph.addEdge("A", "B"));
        assertFalse(myGraph.addEdge("A", "B"));
    }

    @Test
    public void obtainAdjacents() throws Exception {
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addEdge("A", "B");
        Set<String> adjacents = myGraph.obtainAdjacents("A");
        assertEquals(adjacents.size(), 1);
        assertTrue(adjacents.contains("B"));
    }

    @Test
    public void obtainAdjacentsFalse() throws Exception {
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addEdge("A", "B");
        Set<String> adjacents = myGraph.obtainAdjacents("A");
        assertFalse(adjacents.contains("C"));
    }

    @Test
    public void containsVertex() {
        assertFalse(myGraph.containsVertex("A"));
        myGraph.addVertex("A");
        assertTrue(myGraph.containsVertex("A"));
    }

    @Test
    public void containsVertexFalse() {
        myGraph.addVertex("A");
        assertTrue(myGraph.containsVertex("A"));
        assertFalse(myGraph.containsVertex("C"));
        assertFalse(myGraph.addVertex("A"));

    }

    @Test
    public void OnePath() {
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addEdge("A", "B");
        myGraph.addEdge("B", "C");
        myGraph.addEdge("C", "D");
        myGraph.addEdge("A", "D");
        List<String> path = myGraph.onePath("A", "D");
        assertEquals(path.size(), 2);
        assertEquals(path.get(0), "A");
        assertEquals(path.get(1), "D");
        assertNull(myGraph.onePath("B", "A"));
    }

    @Test
    public void testToString() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");

        String expected = "A: B, C, \n" +
                "B: D, \n" +
                "C: D, E, \n" +
                "D: E, \n" +
                "E: \n";
        assertEquals(expected, graph.toString());
    }


}
