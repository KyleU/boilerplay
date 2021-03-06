/* Generated File */
package services.store

import com.kyleu.projectile.models.result.data.DataField
import com.kyleu.projectile.models.result.filter.Filter
import com.kyleu.projectile.models.result.orderBy.OrderBy
import com.kyleu.projectile.services.ModelServiceHelper
import com.kyleu.projectile.services.database.JdbcDatabase
import com.kyleu.projectile.util.{Credentials, CsvUtils}
import com.kyleu.projectile.util.tracing.{TraceData, TracingService}
import java.sql.Connection
import models.queries.store.InventoryRowQueries
import models.store.InventoryRow
import scala.concurrent.{ExecutionContext, Future}

@javax.inject.Singleton
class InventoryRowService @javax.inject.Inject() (val db: JdbcDatabase, override val tracing: TracingService)(implicit ec: ExecutionContext) extends ModelServiceHelper[InventoryRow]("inventoryRow", "store" -> "InventoryRow") {
  def getByPrimaryKey(creds: Credentials, inventoryId: Long, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.primary.key")(td => db.queryF(InventoryRowQueries.getByPrimaryKey(inventoryId), conn)(td))
  }
  def getByPrimaryKeyRequired(creds: Credentials, inventoryId: Long, conn: Option[Connection] = None)(implicit trace: TraceData) = getByPrimaryKey(creds, inventoryId, conn).map { opt =>
    opt.getOrElse(throw new IllegalStateException(s"Cannot load inventoryRow with inventoryId [$inventoryId]"))
  }
  def getByPrimaryKeySeq(creds: Credentials, inventoryIdSeq: Seq[Long], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (inventoryIdSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.primary.key.seq")(td => db.queryF(InventoryRowQueries.getByPrimaryKeySeq(inventoryIdSeq), conn)(td))
    }
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.all.count")(td => db.queryF(InventoryRowQueries.countAll(filters), conn)(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.all")(td => db.queryF(InventoryRowQueries.getAll(filters, orderBys, limit, offset), conn)(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("search.count")(td => db.queryF(InventoryRowQueries.searchCount(q, filters), conn)(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None
  )(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("search")(td => db.queryF(InventoryRowQueries.search(q, filters, orderBys, limit, offset), conn)(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None
  )(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("search.exact")(td => db.queryF(InventoryRowQueries.searchExact(q, orderBys, limit, offset), conn)(td))
  }

  def countByFilmId(creds: Credentials, filmId: Int, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("count.by.filmId")(td => db.queryF(InventoryRowQueries.CountByFilmId(filmId), conn)(td))
  }
  def getByFilmId(creds: Credentials, filmId: Int, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.filmId")(td => db.queryF(InventoryRowQueries.GetByFilmId(filmId, orderBys, limit, offset), conn)(td))
  }
  def getByFilmIdSeq(creds: Credentials, filmIdSeq: Seq[Int], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (filmIdSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.filmId.seq") { td =>
        db.queryF(InventoryRowQueries.GetByFilmIdSeq(filmIdSeq), conn)(td)
      }
    }
  }

  def countByInventoryId(creds: Credentials, inventoryId: Long, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("count.by.inventoryId")(td => db.queryF(InventoryRowQueries.CountByInventoryId(inventoryId), conn)(td))
  }
  def getByInventoryId(creds: Credentials, inventoryId: Long, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.inventoryId")(td => db.queryF(InventoryRowQueries.GetByInventoryId(inventoryId, orderBys, limit, offset), conn)(td))
  }
  def getByInventoryIdSeq(creds: Credentials, inventoryIdSeq: Seq[Long], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (inventoryIdSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.inventoryId.seq") { td =>
        db.queryF(InventoryRowQueries.GetByInventoryIdSeq(inventoryIdSeq), conn)(td)
      }
    }
  }

  def countByStoreId(creds: Credentials, storeId: Int, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("count.by.storeId")(td => db.queryF(InventoryRowQueries.CountByStoreId(storeId), conn)(td))
  }
  def getByStoreId(creds: Credentials, storeId: Int, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    traceF("get.by.storeId")(td => db.queryF(InventoryRowQueries.GetByStoreId(storeId, orderBys, limit, offset), conn)(td))
  }
  def getByStoreIdSeq(creds: Credentials, storeIdSeq: Seq[Int], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "view") {
    if (storeIdSeq.isEmpty) {
      Future.successful(Nil)
    } else {
      traceF("get.by.storeId.seq") { td =>
        db.queryF(InventoryRowQueries.GetByStoreIdSeq(storeIdSeq), conn)(td)
      }
    }
  }

  // Mutations
  def insert(creds: Credentials, model: InventoryRow, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("insert")(td => db.executeF(InventoryRowQueries.insert(model), conn)(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.inventoryId, conn)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted Inventory")
    })
  }
  def insertBatch(creds: Credentials, models: Seq[InventoryRow], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("insertBatch")(td => if (models.isEmpty) {
      Future.successful(0)
    } else {
      db.executeF(InventoryRowQueries.insertBatch(models), conn)(td)
    })
  }
  def create(creds: Credentials, fields: Seq[DataField], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("create")(td => db.executeF(InventoryRowQueries.create(fields), conn)(td).flatMap { _ =>
      getByPrimaryKey(creds, fieldVal(fields, "inventoryId").toLong, conn)
    })
  }

  def remove(creds: Credentials, inventoryId: Long, conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("remove")(td => getByPrimaryKey(creds, inventoryId, conn)(td).flatMap {
      case Some(current) =>
        db.executeF(InventoryRowQueries.removeByPrimaryKey(inventoryId), conn)(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find InventoryRow matching [$inventoryId]")
    })
  }

  def update(creds: Credentials, inventoryId: Long, fields: Seq[DataField], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    traceF("update")(td => getByPrimaryKey(creds, inventoryId, conn)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for Inventory [$inventoryId]")
      case Some(_) => db.executeF(InventoryRowQueries.update(inventoryId, fields), conn)(td).flatMap { _ =>
        getByPrimaryKey(creds, fields.find(_.k == "inventoryId").flatMap(_.v).map(s => s.toLong).getOrElse(inventoryId), conn)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of Inventory [$inventoryId]"
          case None => throw new IllegalStateException(s"Cannot find InventoryRow matching [$inventoryId]")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find InventoryRow matching [$inventoryId]")
    })
  }

  def updateBulk(creds: Credentials, pks: Seq[Long], fields: Seq[DataField], conn: Option[Connection] = None)(implicit trace: TraceData) = checkPerm(creds, "edit") {
    Future.sequence(pks.map(pk => update(creds, pk, fields, conn))).map { x =>
      s"Updated [${fields.size}] fields for [${x.size} of ${pks.size}] InventoryRow"
    }
  }

  def csvFor(totalCount: Int, rows: Seq[InventoryRow])(implicit trace: TraceData) = {
    traceB("export.csv")(td => CsvUtils.csvFor(Some(key), totalCount, rows, InventoryRowQueries.fields)(td))
  }
}
