/* Generated File */
package models.task

import java.util.UUID
import models.graphql.{GraphQLContext, GraphQLSchemaHelper}
import models.graphql.CommonSchema._
import models.graphql.DateTimeSchema._
import models.note.NoteSchema
import models.result.data.DataFieldSchema
import models.result.filter.FilterSchema._
import models.result.orderBy.OrderBySchema._
import models.result.paging.PagingSchema.pagingOptionsType
import sangria.execution.deferred.{Fetcher, HasId}
import sangria.macros.derive._
import sangria.schema._
import scala.concurrent.Future
import util.FutureUtils.graphQlContext

object ScheduledTaskRunSchema extends GraphQLSchemaHelper("scheduledTaskRun") {
  implicit val scheduledTaskRunPrimaryKeyId: HasId[ScheduledTaskRun, UUID] = HasId[ScheduledTaskRun, UUID](_.id)
  private[this] def getByPrimaryKeySeq(c: GraphQLContext, idSeq: Seq[UUID]) = {
    c.services.taskServices.scheduledTaskRunService.getByPrimaryKeySeq(c.creds, idSeq)(c.trace)
  }
  val scheduledTaskRunByPrimaryKeyFetcher = Fetcher(getByPrimaryKeySeq)

  val scheduledTaskRunIdArg = Argument("id", uuidType)
  val scheduledTaskRunIdSeqArg = Argument("ids", ListInputType(uuidType))

  val scheduledTaskRunTaskArg = Argument("task", StringType)
  val scheduledTaskRunTaskSeqArg = Argument("tasks", ListInputType(StringType))
  val scheduledTaskRunStatusArg = Argument("status", StringType)
  val scheduledTaskRunStatusSeqArg = Argument("statuss", ListInputType(StringType))
  val scheduledTaskRunStartedArg = Argument("started", localDateTimeType)
  val scheduledTaskRunStartedSeqArg = Argument("starteds", ListInputType(localDateTimeType))

  implicit lazy val scheduledTaskRunType: ObjectType[GraphQLContext, ScheduledTaskRun] = deriveObjectType()

  implicit lazy val scheduledTaskRunResultType: ObjectType[GraphQLContext, ScheduledTaskRunResult] = deriveObjectType()

  val queryFields = fields(
    unitField(name = "scheduledTaskRun", desc = None, t = OptionType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByPrimaryKey(c.ctx.creds, c.arg(scheduledTaskRunIdArg))(td)
    }, scheduledTaskRunIdArg),
    unitField(name = "scheduledTaskRunSeq", desc = None, t = ListType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByPrimaryKeySeq(c.ctx.creds, c.arg(scheduledTaskRunIdSeqArg))(td)
    }, scheduledTaskRunIdSeqArg),
    unitField(name = "scheduledTaskRunSearch", desc = None, t = scheduledTaskRunResultType, f = (c, td) => {
      runSearch(c.ctx.services.taskServices.scheduledTaskRunService, c, td).map(toResult)
    }, queryArg, reportFiltersArg, orderBysArg, limitArg, offsetArg),
    unitField(name = "scheduledTaskRunsByTask", desc = None, t = ListType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByTask(c.ctx.creds, c.arg(scheduledTaskRunTaskArg))(td)
    }, scheduledTaskRunTaskArg),
    unitField(name = "scheduledTaskRunsByTaskSeq", desc = None, t = ListType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByTaskSeq(c.ctx.creds, c.arg(scheduledTaskRunTaskSeqArg))(td)
    }, scheduledTaskRunTaskSeqArg),
    unitField(name = "scheduledTaskRunsByStatus", desc = None, t = ListType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByStatus(c.ctx.creds, c.arg(scheduledTaskRunStatusArg))(td)
    }, scheduledTaskRunStatusArg),
    unitField(name = "scheduledTaskRunsByStatusSeq", desc = None, t = ListType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByStatusSeq(c.ctx.creds, c.arg(scheduledTaskRunStatusSeqArg))(td)
    }, scheduledTaskRunStatusSeqArg),
    unitField(name = "scheduledTaskRunsByStarted", desc = None, t = ListType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByStarted(c.ctx.creds, c.arg(scheduledTaskRunStartedArg))(td)
    }, scheduledTaskRunStartedArg),
    unitField(name = "scheduledTaskRunsByStartedSeq", desc = None, t = ListType(scheduledTaskRunType), f = (c, td) => {
      c.ctx.services.taskServices.scheduledTaskRunService.getByStartedSeq(c.ctx.creds, c.arg(scheduledTaskRunStartedSeqArg))(td)
    }, scheduledTaskRunStartedSeqArg)
  )

  val scheduledTaskRunMutationType = ObjectType(
    name = "ScheduledTaskRunMutations",
    fields = fields(
      unitField(name = "create", desc = None, t = OptionType(scheduledTaskRunType), f = (c, td) => {
        c.ctx.services.taskServices.scheduledTaskRunService.create(c.ctx.creds, c.arg(DataFieldSchema.dataFieldsArg))(td)
      }, DataFieldSchema.dataFieldsArg),
      unitField(name = "update", desc = None, t = OptionType(scheduledTaskRunType), f = (c, td) => {
        c.ctx.services.taskServices.scheduledTaskRunService.update(c.ctx.creds, c.arg(scheduledTaskRunIdArg), c.arg(DataFieldSchema.dataFieldsArg))(td).map(_._1)
      }, scheduledTaskRunIdArg, DataFieldSchema.dataFieldsArg),
      unitField(name = "remove", desc = None, t = scheduledTaskRunType, f = (c, td) => {
        c.ctx.services.taskServices.scheduledTaskRunService.remove(c.ctx.creds, c.arg(scheduledTaskRunIdArg))(td)
      }, scheduledTaskRunIdArg)
    )
  )

  val mutationFields = fields(unitField(name = "scheduledTaskRun", desc = None, t = scheduledTaskRunMutationType, f = (c, td) => Future.successful(())))

  private[this] def toResult(r: GraphQLSchemaHelper.SearchResult[ScheduledTaskRun]) = {
    ScheduledTaskRunResult(paging = r.paging, filters = r.args.filters, orderBys = r.args.orderBys, totalCount = r.count, results = r.results, durationMs = r.dur)
  }
}
