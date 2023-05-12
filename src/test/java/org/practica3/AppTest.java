package org.practica3;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.util.*;

import org.junit.Before;
import org.junit.Test;


class GraphTest {

    Graph<Integer> myGraph;
    Graph<Integer> myEdge;


    @Test
    void addVertex() {
        Graph<String> graph = new Graph<>();
        assertTrue(graph.addVertex("A"));
        assertTrue(graph.containsVertex("A"));
        assertFalse(graph.addVertex("A"));
    }

    @Test
    void addEdgeNonExistentVertex() {
    }

    @Test
    void addExistentEdge() {

    }

    @Test
    void addEdge() throws Exception {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B"));
        assertTrue(graph.obtainAdjacents("A").contains("B"));
        assertFalse(graph.addEdge("A", "B"));
        assertFalse(graph.addEdge("C", "D"));
    }


    @Test
    void obtainAdjacentsNonExistentVertex() {
    }

    @Test
    void obtainAdjacents() throws Exception {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        Set<String> adjacents = graph.obtainAdjacents("A");
        assertEquals(adjacents.size(), 1);
        assertTrue(adjacents.contains("B"));
    }

    @Test
    void containsVertexNonExistentVertex() {}

    @Test
    void containsVertex() {
        Graph<String> graph = new Graph<>();
        assertFalse(graph.containsVertex("A"));
        graph.addVertex("A");
        assertTrue(graph.containsVertex("A"));
    }

    @Test
    void depthFirstSearch() {
    }

    @Test
    void breadthFirstSearch() {
    }

    @Test
    public void OnePath() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("A", "D");
        List<String> path = graph.onePath("A", "D");
        assertEquals(path.size(), 2);
        assertEquals(path.get(0), "A");
        assertEquals(path.get(1), "D");
        assertNull(graph.onePath("B", "A"));
    }

}
