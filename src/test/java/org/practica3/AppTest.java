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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


class GraphTest {

    Graph<Integer> myGraph;
    Graph<Integer> myEdge;

    @Before
    public void setup(){
        myGraph = new Graph<Integer>();
        myEdge = new Graph<Integer>();
    }

    @Test
    void addVertex() {
    }

    @Test
    void addEdge() {
    }

    @Test
    void obtainAdjacents() {
    }

    @Test
    void depthFirstSearch() {
    }

    @Test
    void breadthFirstSearch() {
    }

}
