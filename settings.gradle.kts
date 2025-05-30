pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application1"
include(":app")
include(":ch06_view")
include(":ch07_layout")
include(":ch09_resource")
include(":ch08_event")
include(":study")
include(":ch10_dialog")
include(":study2")
include(":ch13_intent")
include(":ch13_activity")
include(":study3")
include(":study4")
include(":ch11_jetpack")
include(":ch18_network")
include(":ch20_firebase")
