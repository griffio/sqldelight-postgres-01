pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "sqldelight-postgres-01"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val vSqlDelight = "2.1.0-SNAPSHOT"
            plugin("kotlin", "org.jetbrains.kotlin.jvm").version("1.9.20")
            plugin("sqldelight", "app.cash.sqldelight").version(vSqlDelight)
            plugin("flyway", "org.flywaydb.flyway").version("10.1.0")
            library("sqldelight-jdbc-driver", "app.cash.sqldelight:jdbc-driver:$vSqlDelight")
            library("sqldelight-postgresql-dialect", "app.cash.sqldelight:postgresql-dialect:$vSqlDelight")
            library("postgresql-jdbc-driver", "org.postgresql:postgresql:42.5.4")
            library("flyway-database-postgresql", "org.flywaydb:flyway-database-postgresql:10.1.0")
        }
    }
}
