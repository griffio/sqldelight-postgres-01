# SqlDelight 2.1.x Postgresql migrations with Flyway 

see https://github.com/griffio/sqldelight-postgres-02 for Liquibase migrations

https://github.com/cashapp/sqldelight

Some examples of newer postgresql support in sqldelight SNAPSHOT builds 2.1.x

*Migrations performed*
* create sequence
* add constraint foreign key
* set default - issue that default column must be populated by insert
* set not null
* drop not null
* drop column
* rename column - must manually rename column in queries
* rename table
* add check constraint
* drop identity - issue if table and column was previously renamed

To find bugs/issues that need to be fixed/implemented

*Issues*
* rename column - error with validation
  * AWAIT MERGE https://github.com/cashapp/sqldelight/pull/4880
* alter table ... alter column ... drop identity - support but need fixing refers to old column if column was renamed
  * AWAIT FIX https://github.com/cashapp/sqldelight/pull/4902
* alter table ... alter column ... set default - compilation error must be specified in insert statement
* sqm files must not have post-fix numbers e.g. `V1_create_test_1.sqm` as this breaks the ordering

*Not supported*
* alter/drop sequence
* alter table ... add constraint primary key ... (doesn't update data class property to non-nullable type)
* add constraint check, foreign key `valid` and `not valid` clauses

*Bugs*
* data class `import` missing in generated queries source when using star `INSERT INTO City (city_name) VALUES (?) RETURNING *;`
  * FIXED https://github.com/cashapp/sqldelight/issues/4448
* allows unknown columns with alter table ... alter column <unknown name> - must show compiler error `No column found to alter with name <unknown name>`
  * AWAIT MERGE https://github.com/cashapp/sqldelight/pull/4902
----

```shell
./gradlew build
./gradlew flywayMigrate
```

Flyway db migrations
https://documentation.red-gate.com/fd/gradle-task-184127407.html
