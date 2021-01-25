import Contribuyente.imprimeDatos

object AnalisisExploratorio extends Analizador {

  val dataset = Utilidades.readFile(fichero = "dataset/adult.data.clean.csv")

  // Implementa la función
  // ejercicio-1:
  // Número total de registros en el dataset.
  def totalDeRegistros(c: Seq[Contribuyente]): Int = c.length

  // Implementa la función
  // ejercicio-2:
  // Calcular la media de edad de todos los contribuyentes
  def calculaEdadMedia(c: Seq[Contribuyente]): Double = {
    var edad: Double = 0
    for (i <- c) {
      edad = edad + i.age
    }
    edad / totalDeRegistros(c: Seq[Contribuyente]).toDouble
  }

  // Implementa la función
  // ejercicio-3:
  // Calcular la media de edad de todos los contribuyentes sin contar aquellos cuya edad sea 0
  def calculaEdadMediaNoZeros(c: Seq[Contribuyente]): Double = {
    var Mediasincero = Seq[Contribuyente]()
    for (i <- c) {
      if (i.age != 0) Mediasincero = Mediasincero :+ i
    }
    calculaEdadMedia(c = Mediasincero)
  }

  // Implementa la función
  // ejercicio-4:
  // Descubrir de cuántos países distintos provienen los contribuyentes
  def paisesOrigenUnicos(c: Seq[Contribuyente]): Seq[String] = {
    var countries = Seq[String]()
    for (i <- c) {
      val country = i.nativeCountry
      if (countries.contains(country) || country == "") {
        countries = countries
      } else {
        countries = countries :+ country

      }
    }
    countries
  }

  // Implementa la función
  // ejercicio-5:
  // De todos los contribuyentes, ¿cómo se distribuye por género?. Devuelve el porcentaje de hombres
  // y el de mujeres en ese orden, (porcentajeDeHombres, porcentajeDeMujeres)
  def distribucionPorGeneros(c: Seq[Contribuyente]): (Double, Double) = {
    var men = 0: Int
    var women = 0: Int
    for (i <- c) {
      val sex = i.sex
      if (sex == "Male") {
        men = men + 1
      } else {
        women = women + 1
      }
    }
    val total = men + women
    (100 * men.toDouble / total.toDouble, 100 * women.toDouble / total.toDouble)
  }

  // Implementa la función
  // ejercicio-6:
  // Cuál es el tipo de trabajo (workclass) cuyos ingresos son mayoritariamente superiores a ">50K
  def trabajoMejorRemunerado(c: Seq[Contribuyente]): String = {
    var jobs = Seq[String]()
    for (i <- c) {
      val job = i.workclass
      if (i.income == ">50K") {
        jobs = jobs :+ job
      }
    }
    val workclass = jobs.groupBy(identity).maxBy(_._2.size)._1
    workclass
  }

  // Implementa la función
  // ejercicio-7:
  // Cuál es la media de años de educación (education-num) de aquellos contribuyentes cuyo país de origen no es
  // United-States
  def aniosEstudiosMedio(c: Seq[Contribuyente]): Double = {
    var years = Seq[Int]()
    for (i <- c) {
      if (i.nativeCountry != "United-States") {
        years = years :+ i.educationNum
      }
    }
    val averageyears = years.sum.toDouble / years.length.toDouble
    averageyears
  }

  println(s" -> (1)El numero total de registros del dataset es: ${totalDeRegistros(c = dataset)}")
  println(s" -> (2)En el dataset, los contribuyentes tienen una edad media: ${calculaEdadMedia(c = dataset)}")
  println(s" -> (3)En el dataset, los contribuyentes tienen una edad media (sin contar aquellos con valor 0):" +
    s" ${calculaEdadMediaNoZeros(c = dataset)}")
  println(s" -> (4)Los contribuyentes provienen de ${paisesOrigenUnicos(c = dataset).length} paises diferentes, " +
    s"que son: ${paisesOrigenUnicos(c = dataset)}")
  println(s" -> (5)Los contribuyentes se distribuyen en (%hombres,%mujeres): ${distribucionPorGeneros(c = dataset)}")
  println(s" -> (6)El tipo de trabajo mejor remunerado en el dataset es: ${trabajoMejorRemunerado(c = dataset)}")
  println(s" -> (7)La media de años de estudio de los contribuyenes de origen distinto a United States es: " +
    s"${aniosEstudiosMedio(c = dataset)}")
  println("A continuación, creo un Contribuyente vacío, como se pide en el ejericio 7, y lo muestro por pantalla:")
  val ejemplo = Contribuyente.apply()
  println(s" -> (8) Contribuyente vacío de ejemplo: $ejemplo")
  // ejercicio-11
  // llama a la función impimeContribuyentes
  println(s" -> (9) Representación de los datos (descomentar la siguiente linea):")
  // imprimeContribuyentes(c = dataset)
}