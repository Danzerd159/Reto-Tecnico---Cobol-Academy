package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    	
    	// Usamos InputStreamReader para leer el archivo CSV ubicado en el recurso del proyecto
        try (Reader reader = new InputStreamReader(Main.class.getResourceAsStream("/data.csv"));
             CSVReader csvReader = new CSVReader(reader)) {

        	// Arreglo para almacenar temporalmente cada línea del CSV
            String[] nextLine;

            // Saltamos el encabezado
            csvReader.skip(1);

            //Inicilizamos variables
            double balanceDebito = 0;
            double balanceCredito = 0;
            double totalBalance = 0;
            int debito = 0;
            int credito = 0;
            double montoMayor = 0;
            String mostrarMontoMayor = "";


            // Leemos cada línea del archivo CSV
            while ((nextLine = csvReader.readNext()) != null) {
                String id = nextLine[0];      // ID en la primera columna
                String tipo = nextLine[1];    // Tipo (Crédito o Débito) en la segunda columna
                double monto = Double.parseDouble(nextLine[2]); // Monto en la tercera columna, lo convertimos a double

                //Imprime cada linea del archivo CSV
                //System.out.println("ID: " + id + ", Tipo: " + tipo + ", Monto: " + monto);
                
                
                // Acumulamos los balances y contamos las transacciones según su tipo
                if (tipo.equalsIgnoreCase("Débito")){
                    balanceDebito += monto;
                    debito++;
                }

                if (tipo.equalsIgnoreCase("Crédito")){
                    balanceCredito += monto;
                    credito++;
                }
                
                // Verificamos si esta transacción es la de mayor monto hasta ahora
                if (monto > montoMayor){
                    montoMayor = monto;
                    mostrarMontoMayor = "ID " + id + " - "+ montoMayor;
                }


            }
            
            // Calculamos el balance final (Créditos - Débitos)
            totalBalance = balanceCredito - balanceDebito;

            //Mostramos los resultado en consola
            System.out.println("Balance Final: "+ totalBalance);
            System.out.println("Transacción de Mayor Monto: "+mostrarMontoMayor);
            System.out.println("Conteo de Transacciones: Crédito: " +credito+ " Débito: " +debito);

        } catch (IOException | CsvValidationException e) {
        	
        	//Captura y muestra errores en la lectura del archivo CSV
            e.printStackTrace();
        }
    }
}