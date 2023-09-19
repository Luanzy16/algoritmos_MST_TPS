/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
// Algoritmo de Prim en Java

import java.util.Arrays;

class Prim {

  public void prim(int G[][], int V) {

    int INF = 9999999;

    int no_edge; // número de aristas

    // crear un arreglo para rastrear los vértices seleccionados
    // seleccionado será verdadero (true) o falso (false)
    boolean[] seleccionado = new boolean[V];

    // inicializar seleccionado como falso (false) inicialmente
    Arrays.fill(seleccionado, false);

    // inicializar el número de aristas en 0
    no_edge = 0;

    // el número de aristas en el árbol de expansión mínima siempre será
    // menor que (V - 1), donde V es el número de vértices en el grafo

    // elegir el vértice 0 y marcarlo como seleccionado
    seleccionado[0] = true;

    // imprimir para arista y peso
    System.out.println("Arista : Peso");

    while (no_edge < V - 1) {
      // Para cada vértice en el conjunto S, encontrar todos los vértices adyacentes
      // , calcular la distancia desde el vértice seleccionado en el paso 1.
      // si el vértice ya está en el conjunto S, descartarlo, de lo contrario
      // elegir otro vértice más cercano al vértice seleccionado en el paso 1.

      int min = INF;
      int x = 0; // número de fila
      int y = 0; // número de columna

      for (int i = 0; i < V; i++) {
        if (seleccionado[i] == true) {
          for (int j = 0; j < V; j++) {
            // no está seleccionado y hay una arista
            if (!seleccionado[j] && G[i][j] != 0) {
              if (min > G[i][j]) {
                min = G[i][j];
                x = i;
                y = j;
              }
            }
          }
        }
      }
      System.out.println(x + " - " + y + " : " + G[x][y]);
      seleccionado[y] = true;
      no_edge++;
    }
  }

  public static void main(String[] args) {
    Prim g = new Prim();

    // número de vértices en el grafo
    int V = 5;

    // crear una matriz 2D de tamaño 5x5
    // para la matriz de adyacencia que representa el grafo
    int[][] G = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
        { 0, 42, 66, 31, 0 } };

    g.prim(G, V);
  }
}
