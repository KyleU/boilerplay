/* Generated File */
package services.address

import com.kyleu.projectile.models.result.data.DataField
import com.kyleu.projectile.models.result.filter.Filter
import com.kyleu.projectile.models.result.orderBy.OrderBy
import com.kyleu.projectile.services.ModelServiceHelper
import com.kyleu.projectile.services.database.JdbcDatabase
import com.kyleu.projectile.util.{Credentials, CsvUtils}
import com.kyleu.projectile.util.tracing.{TraceData, TracingService}
import java.sql.Connection
import java.time.ZonedDateTime
import models.address.CityRow
import models.queries.address.CityRowQueries
import scala.concurrent.{ExecutionContext, Future}

@javax.inject.Singleton
class CityRowService @javax.inject.Inject() (val db: JdbcDatabase, override val tracing: TracingService)(implicit ec: ExecutionContext) extends ModelServiceHelper[CityRow]("cityRow", "address" -> "CityRow") {
  def getByPrimaryKey(creds: Credentials, cityId: Int, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.primary.key")(td => db.queryF(CityRowQueries.getByPrimaryKey(cityId), conn)(td))
  }
  def getByPrimaryKeyRequired(creds: Credentials, cityId: Int, conn: Option[Connection] = None)(implicit trace: TraceData) = getByPrimaryKey(creds, cityId, conn).map { opt =>
    opt.getOrElse(throw new IllegalStateException(s"Cannot load cityRow with cityId [$cityId]"))
  }
  def getByPrimaryKeySeq(creds: Credentials, cityIdSeq: Seq[Int], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (cityIdSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.primary.key.seq")(td => db.queryF(CityRowQueries.getByPrimaryKeySeq(cityIdSeq), conn)(td))
    }
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.all.count")(td => db.queryF(CityRowQueries.countAll(filters), conn)(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.all")(td => db.queryF(CityRowQueries.getAll(filters, orderBys, limit, offset), conn)(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("search.count")(td => db.queryF(CityRowQueries.searchCount(q, filters), conn)(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None
  )(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("search")(td => db.queryF(CityRowQueries.search(q, filters, orderBys, limit, offset), conn)(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None
  )(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("search.exact")(td => db.queryF(CityRowQueries.searchExact(q, orderBys, limit, offset), conn)(td))
  }

  def countByCity(creds: Credentials, city: String, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("count.by.city")(td => db.queryF(CityRowQueries.CountByCity(city), conn)(td))
  }
  def getByCity(creds: Credentials, city: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.city")(td => db.queryF(CityRowQueries.GetByCity(city, orderBys, limit, offset), conn)(td))
  }
  def getByCitySeq(creds: Credentials, citySeq: Seq[String], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (citySeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.city.seq") { td =>
        db.queryF(CityRowQueries.GetByCitySeq(citySeq), conn)(td)
      }
    }
  }

  def countByCityId(creds: Credentials, cityId: Int, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("count.by.cityId")(td => db.queryF(CityRowQueries.CountByCityId(cityId), conn)(td))
  }
  def getByCityId(creds: Credentials, cityId: Int, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.cityId")(td => db.queryF(CityRowQueries.GetByCityId(cityId, orderBys, limit, offset), conn)(td))
  }
  def getByCityIdSeq(creds: Credentials, cityIdSeq: Seq[Int], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (cityIdSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.cityId.seq") { td =>
        db.queryF(CityRowQueries.GetByCityIdSeq(cityIdSeq), conn)(td)
      }
    }
  }

  def countByCountryId(creds: Credentials, countryId: Int, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("count.by.countryId")(td => db.queryF(CityRowQueries.CountByCountryId(countryId), conn)(td))
  }
  def getByCountryId(creds: Credentials, countryId: Int, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.countryId")(td => db.queryF(CityRowQueries.GetByCountryId(countryId, orderBys, limit, offset), conn)(td))
  }
  def getByCountryIdSeq(creds: Credentials, countryIdSeq: Seq[Int], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (countryIdSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.countryId.seq") { td =>
        db.queryF(CityRowQueries.GetByCountryIdSeq(countryIdSeq), conn)(td)
      }
    }
  }

  def countByLastUpdate(creds: Credentials, lastUpdate: ZonedDateTime, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("count.by.lastUpdate")(td => db.queryF(CityRowQueries.CountByLastUpdate(lastUpdate), conn)(td))
  }
  def getByLastUpdate(creds: Credentials, lastUpdate: ZonedDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.lastUpdate")(td => db.queryF(CityRowQueries.GetByLastUpdate(lastUpdate, orderBys, limit, offset), conn)(td))
  }
  def getByLastUpdateSeq(creds: Credentials, lastUpdateSeq: Seq[ZonedDateTime], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (lastUpdateSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.lastUpdate.seq") { td =>
        db.queryF(CityRowQueries.GetByLastUpdateSeq(lastUpdateSeq), conn)(td)
      }
    }
  }

  // Mutations
  def insert(creds: Credentials, model: CityRow, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("insert")(td => db.executeF(CityRowQueries.insert(model), conn)(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.cityId, conn)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted City")
    })
  }
  def insertBatch(creds: Credentials, models: Seq[CityRow], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("insertBatch")(td => if (models.isEmpty) {
      Future.successful(0)
    } else {
      db.executeF(CityRowQueries.insertBatch(models), conn)(td)
    })
  }
  def create(creds: Credentials, fields: Seq[DataField], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("create")(td => db.executeF(CityRowQueries.create(fields), conn)(td).flatMap { _ =>
      getByPrimaryKey(creds, fieldVal(fields, "cityId").toInt, conn)
    })
  }

  def remove(creds: Credentials, cityId: Int, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("remove")(td => getByPrimaryKey(creds, cityId, conn)(td).flatMap {
      case Some(current) =>
        db.executeF(CityRowQueries.removeByPrimaryKey(cityId), conn)(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find CityRow matching [$cityId]")
    })
  }

  def update(creds: Credentials, cityId: Int, fields: Seq[DataField], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("update")(td => getByPrimaryKey(creds, cityId, conn)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for City [$cityId]")
      case Some(_) => db.executeF(CityRowQueries.update(cityId, fields), conn)(td).flatMap { _ =>
        getByPrimaryKey(creds, fields.find(_.k == "cityId").flatMap(_.v).map(s => s.toInt).getOrElse(cityId), conn)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of City [$cityId]"
          case None => throw new IllegalStateException(s"Cannot find CityRow matching [$cityId]")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find CityRow matching [$cityId]")
    })
  }

  def updateBulk(creds: Credentials, pks: Seq[Int], fields: Seq[DataField], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    Future.sequence(pks.map(pk => update(creds, pk, fields, conn))).map { x =>
      s"Updated [${fields.size}] fields for [${x.size} of ${pks.size}] CityRow"
    }
  }

  def csvFor(totalCount: Int, rows: Seq[CityRow])(implicit trace: TraceData) = {
    traceB("export.csv")(td => CsvUtils.csvFor(Some(key), totalCount, rows, CityRowQueries.fields)(td))
  }
}
