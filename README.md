# SqlDelight 2.1.x Postgresql migrations with Flyway 

see https://github.com/griffio/sqldelight-postgres-02 for Liquibase migrations

see https://github.com/griffio/sqldelight-pg-migration for "simple" migrations

https://github.com/cashapp/sqldelight

Some examples of newer postgresql support in sqldelight SNAPSHOT builds 2.1.x

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

To find bugs/issues that need to be fixed/implemented

*Issues*
* rename column - error with validation
  * MERGED https://github.com/cashapp/sqldelight/pull/4880
* alter table ... alter column ... drop identity - support but need fixing refers to old column if column was renamed
  * MERGED https://github.com/cashapp/sqldelight/pull/4902
* alter table ... alter column ... set default - compilation error must be specified in insert statement
  * MERGED https://github.com/cashapp/sqldelight/pull/4912
* sqm files must not have post-fix numbers e.g. `V1_create_test_1.sqm` as this breaks the ordering

*Not supported*
* alter/drop sequence
  * MERGED https://github.com/cashapp/sqldelight/pull/4920
* alter table ... add constraint primary key ... (doesn't update data class property to non-nullable type)
  * MERGED https://github.com/cashapp/sqldelight/issues/5018
* add constraint check, foreign key `valid` and `not valid` clauses
* alter column col_name add generated { always | by default } as identity { ( seq_option ) }
  * MERGED https://github.com/cashapp/sqldelight/pull/4916
* alter column column_name { set generated { always | by default } | set sequence_option | restart [ [ with ] restart ] }
  * MERGED https://github.com/cashapp/sqldelight/pull/4916
* alter table drop constraint [ if exists ] identifier [ restrict | cascade ]
  * MERGED https://github.com/cashapp/sqldelight/issues/5288 
* alter table add column [ if not exists ]
  * MERGED https://github.com/cashapp/sqldelight/issues/5309

*Bugs*
* data class `import` missing in generated queries source when using star `INSERT INTO City (city_name) VALUES (?) RETURNING *;`
  * MERGED https://github.com/cashapp/sqldelight/issues/4448
* allows unknown columns with alter table ... alter column <unknown name> - must show compiler error `No column found to alter with name <unknown name>`
  * MERGED https://github.com/cashapp/sqldelight/pull/4902
* compiler error when functions are used as DEFAULT column values
  * MERGED https://github.com/cashapp/sqldelight/pull/4934
----

```shell
./gradlew build &&
./gradlew flywayMigrate
```

Flyway db migrations
https://documentation.red-gate.com/fd/gradle-task-184127407.html
