package datatables

import slick.jdbc.PostgresProfile.api._

class CompanyTable (tag: Tag) extends Table[model.Company] (tag, _tableName = "Company") {

  val id = column[Int] ("ID_comp", O.PrimaryKey)
  val name = column[String] ("name")


  def * = (id, name) <> ((model.Company.apply _).tupled, model.Company.unapply)
//  def * = (id, name).mapTo[model.Company]

}

object CompanyTable{
  val table = TableQuery[CompanyTable]
}
