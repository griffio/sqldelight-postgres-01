# SqlDelight 2.1.x Postgresql

https://github.com/cashapp/sqldelight

Some examples of newer postgresql support in sqldelight SNAPSHOT builds 2.1.x

*Migrations performed*
* create sequence
* add constraint foreign key
* set not null
* drop not null
* drop column
* rename column - must manually rename column in queries

To find bugs/issues that need to be fixed/implemented

*Issues*
* rename column - error with validation
```(Cause: class app.cash.sqldelight.dialects.postgresql.grammar.psi.impl.PostgreSqlAlterTableRenameColumnImpl
cannot be cast to class com.alecstrong.sql.psi.core.psi.mixins.ColumnDefMixin 
(app.cash.sqldelight.dialects.postgresql.grammar.psi.impl.PostgreSqlAlterTableRenameColumnImpl
 and com.alecstrong.sql.psi.core.psi.mixins.ColumnDefMixin are in unnamed module
  of loader org.gradle.internal.classloader.VisitableURLClassLoader )
  ```
*Not supported*
* alter/drop sequence
* alter table ... add constraint primary key ... (doesn't update data class property to non-nullable type)
bugs
* data class `import` missing in generated queries source when using star `INSERT INTO City (city_name) VALUES (?) RETURNING *;`
  * https://github.com/cashapp/sqldelight/issues/4448

----

```shell
./gradlew build
./gradlew flywayMigrate
```

Flyway db migrations
https://documentation.red-gate.com/fd/gradle-task-184127407.html
