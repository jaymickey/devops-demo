package DevOpsMeetupDemo

import DevOpsMeetupDemo.buildTypes.*
import DevOpsMeetupDemo.vcsRoots.*
import DevOpsMeetupDemo.vcsRoots.DevOpsMeetupDemo_GitHubJaymickeyDevOpsDemo
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "396dcc94-37cf-4cd9-86d9-f3bf68ae17e5"
    extId = "DevOpsMeetupDemo"
    parentId = "_Root"
    name = "DevOps Meetup Demo"

    vcsRoot(DevOpsMeetupDemo_GitHubJaymickeyDevOpsDemo)

    buildType(DevopsDemo_BuildDemo)

    params {
        password("Octopus.ApiKey", "credentialsJSON:de5a9aae-1202-4e15-8192-60b8b97aabef", description = "Octopus API key for pushing packages", display = ParameterDisplay.HIDDEN)
    }

    features {
        versionedSettings {
            id = "PROJECT_EXT_3"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = DevOpsMeetupDemo_GitHubJaymickeyDevOpsDemo.extId
            showChanges = true
            settingsFormat = VersionedSettings.Format.KOTLIN
            param("credentialsStorageType", "credentialsJSON")
        }
    }
})
