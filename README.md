# SqlDelight 2.3.x PostgreSql migrations with Flyway 

see https://github.com/griffio/sqldelight-postgres-02 for Liquibase migrations

see https://github.com/griffio/sqldelight-pg-migration for "simple" migrations

https://github.com/cashapp/sqldelight

Examples of newer PostgreSql support in SqlDelight SNAPSHOT build from https://central.sonatype.com/repository/maven-snapshots

*Migrations performed*
* create sequence
* alter sequence
* add constraint foreign key
* set default - 
* set not null
* drop not null
* drop column
* rename column - 
* rename table
* add check constraint
* drop identity 
* alter identity 
* alter index

To find bugs/issues that need to be fixed/implemented

*Issues*
* Add PostgreSql Dialect ANY operator
  * IN PROGRESS https://github.com/sqldelight/sqldelight/pull/6253
* Add PostgreSql ALTER INDEX support to grammar
  * MERGED https://github.com/sqldelight/sqldelight/pull/6224
----

```shell
./gradlew build &&
./gradlew flywayMigrate
```

Flyway db migrations
https://documentation.red-gate.com/fd/gradle-task-184127407.html
