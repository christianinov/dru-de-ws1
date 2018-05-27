import java.time.{LocalDate, LocalTime}

package object model {

  case class Company(id: Int, name: String)

  case class Passenger(id: Int, name: String)

  case class PassengerInTrip(tripId: Int, passengerId: Int, date: LocalDate, place: String)

  case class Trip(trip_no: Int, ID_comp: Int, plane: String, townFrom: String, townTo: String, timeOut: LocalTime, timeIn: LocalTime)

}
