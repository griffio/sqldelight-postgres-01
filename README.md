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
* rename table
* add check constraint
* drop identity - issue if column was renamed previously

To find bugs/issues that need to be fixed/implemented

*Issues*
* rename column - error with validation https://github.com/cashapp/sqldelight/pull/4880
* alter table ... alter column ... drop identity - support but need fixing refers to old column if column was renamed


*Not supported*
* alter/drop sequence
* alter table ... add constraint primary key ... (doesn't update data class property to non-nullable type)
* add constraint check, foreign key `valid` and `not valid` clauses

*Bugs*
* data class `import` missing in generated queries source when using star `INSERT INTO City (city_name) VALUES (?) RETURNING *;`
  * https://github.com/cashapp/sqldelight/issues/4448

----

```shell
./gradlew build
./gradlew flywayMigrate
```

Flyway db migrations
https://documentation.red-gate.com/fd/gradle-task-184127407.html
