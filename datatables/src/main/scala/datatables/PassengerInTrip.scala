package datatables

import java.time.LocalDate

import slick.jdbc.PostgresProfile.api._

class PassengerInTripTable (tag: Tag) extends Table[model.PassengerInTrip] (tag, _tableName = "PassengerInTrip") {

  val tripId = column[Int] ("trip_no", O.PrimaryKey)
  val passengerId = column[Int] ("ID_psg", O.PrimaryKey)
  val date = column[LocalDate] ("date", O.PrimaryKey)
  val place = column[String] ("place")

  val tripIdForeingKey = foreignKey("trip_id_fk", tripId, TripTable.table) (
    _.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade
  )

  val passengerIdForeingKey = foreignKey("passenger_id_fk", passengerId, PassengerTable.table) (
    _.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade
  )

  def * = (tripId, passengerId, date, place) <> ((model.PassengerInTrip.apply _).tupled, model.PassengerInTrip.unapply)
//  def * = (tripId, date, passengerId, place).mapTo[model.PassengerInTrip]

}

object PassengerInTripTable{
  val table = TableQuery[PassengerInTripTable]
}