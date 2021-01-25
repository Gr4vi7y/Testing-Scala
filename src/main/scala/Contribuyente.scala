case class Contribuyente(
                          age: Int,
                          workclass: String,
                          education: String,
                          educationNum: Int,
                          maritalStatus: String,
                          occupation: String,
                          relationship: String,
                          race: String,
                          sex: String,
                          capitalGain: Int,
                          capitalLoss: Int,
                          hoursPerWeek: Int,
                          nativeCountry: String,
                          income: String
                        )

// Implementa el companion object
// ejercicio-7:
// Dada la clase 'Contribuyente' y es a la que se mapea cada fila del csv, se pide que se cree su companion object y
// defina la función:
//  - imprimeDatos que muestre por consola el siguiente formato: "$workclass - $occupation - $nativeCountry - $income"
//  - apply, que no reciba ningún parámetro y que devolverá una instancia de la clase Contribuyente con aquellos campos que sean:
//     del tipo Int inicializados a -1
//     del tipo String inicializado a “desconocido

object Contribuyente {
  def imprimeDatos (c: Seq[Contribuyente]): Unit = {
    for (i <- c) {
      val workclass = i.workclass
      val occupation = i.occupation
      val nativeCountry = i.nativeCountry
      val income = i.income
      println(s"$workclass - $occupation - $nativeCountry - $income")
    }
  }

  def apply(age: Int = -1, workclass: String = "desconocido", education: String = "desconocido", educationNum: Int = -1,
            maritalStatus: String = "desconocido", occupation: String = "desconocido", relationship: String = "desconocido",
            race: String = "desconocido", sex: String = "desconocido", capitalGain: Int = -1, capitalLoss: Int = -1,
            hoursPerWeek: Int = -1, nativeCountry: String = "desconocido", income: String = "desconocido"): Contribuyente =
    new Contribuyente(age, workclass, education, educationNum, maritalStatus, occupation, relationship, race, sex,
      capitalGain, capitalLoss, hoursPerWeek, nativeCountry, income)
}

