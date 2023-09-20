/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Usuario
 */
import java.util.*;

public class TPS {

    // Función para calcular la distancia euclidiana entre dos puntos
    public static double distancia(int[] ciudad1, int[] ciudad2) {
        int dx = ciudad1[0] - ciudad2[0];
        int dy = ciudad1[1] - ciudad2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Algoritmo del Vecino Más Cercano
    public static List<Integer> vecinoMasCercano(int[][] ciudades) {
        int numCiudades = ciudades.length;
        List<Integer> camino = new ArrayList<>();
        boolean[] visitado = new boolean[numCiudades];
        
        // Empezar desde la primera ciudad
        int ciudadActual = 0;
        camino.add(ciudadActual);
        visitado[ciudadActual] = true;
        
        for (int i = 0; i < numCiudades - 1; i++) {
            double distanciaMinima = Double.MAX_VALUE;
            int ciudadCercana = -1;
            
            for (int j = 0; j < numCiudades; j++) {
                if (!visitado[j] && j != ciudadActual) {
                    double d = distancia(ciudades[ciudadActual], ciudades[j]);
                    if (d < distanciaMinima) {
                        distanciaMinima = d;
                        ciudadCercana = j;
                    }
                }
            }
            
            camino.add(ciudadCercana);
            visitado[ciudadCercana] = true;
            ciudadActual = ciudadCercana;
        }
        
        // Volver a la primera ciudad para completar el ciclo
        camino.add(0);
        
        return camino;
    }
    
    public String imprimirCamino(){
        int[][] ciudades = {
            {0, 0}, // Ciudad 0
            {1, 3}, // Ciudad 1
            {4, 2}, // Ciudad 2
            {3, 1}  // Ciudad 3
        };

        List<Integer> camino = vecinoMasCercano(ciudades);

        String resultado = "El camino más corto es:\n";
        for (int ciudad : camino) {
            resultado += "Ciudad " + ciudad + " -> ";
        }
        resultado += "Ciudad 0"; // Regresar a la ciudad de inicio
        
        
        return resultado;
    }

    
}

