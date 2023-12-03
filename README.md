# SqlDelight 2.1.x Postgresql

https://github.com/cashapp/sqldelight

Some examples of newer postgresql support in sqldelight 2.1.x

Migrations performed
* create sequence
* add constraint foreign key
* set not null
* drop not null
* drop column
* rename column

To find bugs/issues that need to be fixed/implemented

not supported
* alter/drop sequence
* alter table ... add constraint primary key ... (doesn't update data class property to non-nullable type)
----

```shell
./gradlew build
./gradlew flywayMigrate
```

Flyway db migrations
https://documentation.red-gate.com/fd/gradle-task-184127407.html
