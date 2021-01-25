# **Testing Scala** 
### _**(Scala exercise of the Master Big Data)**_

### **Introducción:**

Queremos realizar un análisis exploratorio de un dataset en formato csv. Este dataset suele ser usado para procesos de ML en el que se intenta predecir si los ingresos de una persona serán superiores a los 50K anuales.

### **Descripción:**

Se solicita implementar un programa en Scala que sea capaz de hacer un análisis exploratorio básico y sacar algunas conclusiones del dataset. Para ello se hará un uso de las funciones que provee la API de las colecciones de Scala.

También se pedirá en algún apartado que se defina un companion object para poder disponer de funciones de utilidades.

El código fuente está formado por 4 ficheros .scala y 1 fichero .csv y tiene la siguiente estructura:

```
dataset
  └──dat adult.data.clean.csv    
src     
  └── main    
  │    └── scala    
  │        ├── AnalisisExploratorio.scala    
  │        ├── Analizador.scala    
  │        ├── Contribuyente.scala    
  │        └── Utilidades.scala   
  └── test  
```

-**AnalisisExploratorio.scala** -> Es el fichero del programa principal

-**Analizador.scala** -> Contiene la definición de un trait que se deberá usar para completar una de los ejercicios.

-**Contribuyente.scala** -> Definición de la clase Contribuyente a la que se mapea cada fila del fichero.csv
 
-**Utilidades.scala** -> Definición de un objeto que tiene implementada la función de lectura del csv y devuelve una secuencia de instancias de la clase Contribuyente: Seq[Contribuyente]

-**adult.data.clean.csv** -> dataset que tiene la siguientes columnas:

    age: int.    
    workclass: string   
    education: String    
    education-num: int    
    marital-status: string    
    occupation: string    
    relationship: string    
    race: string    
    sex: string    
    capital-gain: string    
    capital-loss: string    
    hours-per-week: string    
    native-country: string    
    income: string    
