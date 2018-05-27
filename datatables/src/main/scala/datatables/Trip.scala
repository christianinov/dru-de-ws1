package datatables

import java.time.LocalTime

import slick.jdbc.PostgresProfile.api._

class TripTable(tag: Tag) extends Table[model.Trip] (tag, _tableName = "Trip") {

  val id = column[Int] ("trip_no", O.PrimaryKey)
  val companyId = column[Int] ("ID_comp")
  val plane = column[String] ("plane")
  val townFrom = column[String] ("town_from")
  val townTo = column[String] ("town_to")
  val timeOut = column[LocalTime] ("time_out")
  val timeIn = column[LocalTime] ("time_in")

  val companyIdForeingKey = foreignKey("company_id_fk", companyId, CompanyTable.table) (
    _.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade
  )

  def * = (id, companyId, plane, townFrom, townTo, timeOut, timeIn) <> ((model.Trip.apply _).tupled, model.Trip.unapply)

}

object TripTable{
  val table = TableQuery[TripTable]
}
