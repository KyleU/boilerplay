package models.module

import com.google.inject.Injector
import com.kyleu.projectile.graphql.GraphQLSchema
import com.kyleu.projectile.models.audit.AuditCallbackProvider
import com.kyleu.projectile.models.status.AppStatus
import com.kyleu.projectile.models.module.{AdminModule, Application}
import services.audit.AuditCallbacks
import models.graphql.Schema
import models.search.SearchHelper
import models.template.UserMenu

class ProjectileModule extends AdminModule {
  def projectName = util.Version.projectName
  override def projectVersion = util.Version.version
  def allowSignup = true
  def initialRole = "admin"
  def menuProvider = UserMenu

  override protected def onStartup(app: Application, injector: Injector) = {
    AuditCallbackProvider.init(new AuditCallbacks(injector))

    /* Start injected startup code */
    /* Projectile export section [boilerplay] */
    com.kyleu.projectile.services.auth.PermissionService.registerPackage("address", "Address", models.template.Icons.pkg_address)
    com.kyleu.projectile.services.auth.PermissionService.registerPackage("customer", "Customer", models.template.Icons.pkg_customer)
    com.kyleu.projectile.services.auth.PermissionService.registerPackage("film", "Film", models.template.Icons.pkg_film)
    com.kyleu.projectile.services.auth.PermissionService.registerPackage("payment", "Payment", models.template.Icons.pkg_payment)
    com.kyleu.projectile.services.auth.PermissionService.registerPackage("store", "Store", models.template.Icons.pkg_store)
    /* End injected startup code */
  }

  override protected def appStatus(app: Application, injector: Injector) = AppStatus(name = projectName, version = util.Version.version)
  override protected def searchProvider = new SearchHelper()
  override protected def schema: GraphQLSchema = Schema
}
