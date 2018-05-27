import java.time.{Instant, LocalDate, LocalTime}

import slick.jdbc.JdbcType
import slick.jdbc.PostgresProfile.api._

package object datatables {

  implicit val localDateToDateMapper: JdbcType[LocalDate] =
    MappedColumnType.base[LocalDate, java.sql.Date] (
      l => java.sql.Date.valueOf(l),
      d => d.toLocalDate
    )

  implicit val localTimeToDateMapper: JdbcType[LocalTime] =
    MappedColumnType.base[LocalTime, java.sql.Time] (
      l => java.sql.Time.valueOf(l),
      d => d.toLocalTime
    )

}
