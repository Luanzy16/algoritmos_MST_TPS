package data;

/**
 *
 * @author Luanzy
 */
/**
 * Esta clase implementa el algoritmo de Floyd-Warshall para encontrar los caminos
 * más cortos entre todos los pares de vértices en un grafo dirigido o no dirigido
 * con ponderaciones de aristas.
 */
public class Floyd {
  final public int INF = 9999, nV = 4;
  public int matrix[][];

  /**
   * Aplica el algoritmo de Floyd-Warshall.
   *
   * @param graph La matriz de adyacencia del grafo.
   */
  public int[][] floydWarshall(int graph[][]) {
    int matrix[][] = new int[nV][nV];
    int i, j, k;

    // Inicializando la matriz de distancias con los mismos valores que el grafo original
    for (i = 0; i < nV; i++)
      for (j = 0; j < nV; j++)
        matrix[i][j] = graph[i][j];

    // Añadiendo vertices individuales y actualizando la matriz con caminos más cortos
    for (k = 0; k < nV; k++) {
      for (i = 0; i < nV; i++) {
        for (j = 0; j < nV; j++) {
          if (matrix[i][k] + matrix[k][j] < matrix[i][j])
            matrix[i][j] = matrix[i][k] + matrix[k][j];
        }
      }
    }
      return matrix;


  }

  /**
   * Imprime la matriz de distancias mínimas.
   *
   * @param matrix La matriz de distancias mínimas.
   */
  public String printMatrix(int matrix[][]) {
     String resultado = "";
     
    for (int i = 0; i < nV; ++i) {
      for (int j = 0; j < nV; ++j) {
        if (matrix[i][j] == INF)
          resultado += "INF";
        else
          resultado += matrix[i][j];
          resultado += "  ";
      }
      resultado += "\n";
    }
    
      return resultado;
  }


}

