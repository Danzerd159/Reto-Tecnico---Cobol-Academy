# Reto Técnico: Análisis de Transacciones con CSV

Este proyecto fue desarrollado como parte de un reto técnico que consistía en leer un archivo CSV, procesar datos financieros (créditos y débitos) y mostrar información relevante como balances, conteos y la transacción más alta. La lógica fue implementada en Java utilizando la librería **OpenCSV**.

---

## Instrucciones de Ejecución

###  Requisitos Previos
- Java 17
- Maven 3.8+
- IDE recomendado: IntelliJ IDEA, Eclipse o VSCode

### Instalación y Ejecución

1. Clona este repositorio:
  ´https://github.com/Danzerd159/Reto-Tecnico---Cobol-Academy´

## Enfoque y Solución
El objetivo principal del reto fue leer y procesar un archivo .csv con información de transacciones, diferenciando entre Créditos y Débitos. A partir de eso, se debía calcular:

-El balance final: Créditos - Débitos
-La transacción con el mayor monto
-El número total de transacciones por tipo (Crédito y Débito)

"Lógica Implementada"

1.Lectura del archivo CSV con OpenCSV
Se utilizó la librería OpenCSV para facilitar la lectura del archivo data.csv. Esta librería permite procesar cada línea del archivo como un arreglo de Strings, lo que simplifica la manipulación de datos.

2.Salto de la cabecera
Antes de comenzar a procesar los datos, se utilizó el método skip(1) para omitir la primera línea del archivo, correspondiente al encabezado del CSV.

3.Inicialización de variables acumuladoras
Se declararon variables para:

-Acumular los montos totales de créditos y débitos
-Contar cuántas transacciones de cada tipo se encontraron
-Calcular el balance final
-Detectar la transacción con el mayor monto registrado

4.Procesamiento línea por línea
Durante la iteración:

-Se extrajeron los valores de ID, Tipo (Crédito o Débito) y Monto.
-Se utilizó Double.parseDouble() para convertir el monto a un tipo numérico (double) para su procesamiento.
-Se evaluó el tipo de transacción usando equalsIgnoreCase para evitar errores por diferencias de mayúsculas/minúsculas.

5.Clasificación de transacciones y acumulación de datos

-Si la transacción era de tipo Débito, se sumaba al acumulador de débitos y se aumentaba el contador correspondiente.
-Si era de tipo Crédito, se hacía lo mismo con el acumulador de créditos y su contador.
-Simultáneamente, se verificaba si el monto actual era mayor que el registrado hasta el momento, y si era así, se actualizaba la variable de control para almacenar ese monto y su respectivo ID.

6.Cálculo del balance final
-Finalizado el recorrido del archivo, se realizó la resta Créditos - Débitos para obtener el balance final disponible.

7.Impresión de resultados
Se imprimió en consola:

-El balance final
-La transacción con el monto más alto
-El número de transacciones de cada tipo

8.Manejo de recursos y errores

-Se implementó try-with-resources para asegurar el cierre automático del lector de archivos, evitando fugas de memoria.
-Se manejaron excepciones de tipo IOException y CsvValidationException para capturar errores de entrada/salida o problemas al leer el archivo CSV.


## Estructura del Proyecto

Reto-Tecnico---Cobol-Academy/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── example/
│       │           └── Main.java          # Contiene toda la lógica de procesamiento
│       └── resources/
│           └── data.csv                   # Archivo con los datos de prueba
├── pom.xml                                # Archivo de configuración de Maven
└── README.md                              # Este archivo de documentación
