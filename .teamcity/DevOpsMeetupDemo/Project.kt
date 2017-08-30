package DevOpsMeetupDemo

import DevOpsMeetupDemo.buildTypes.*
import DevOpsMeetupDemo.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project

object Project : Project({
    uuid = "396dcc94-37cf-4cd9-86d9-f3bf68ae17e5"
    extId = "DevOpsMeetupDemo"
    parentId = "_Root"
    name = "DevOps Meetup Demo"

    vcsRoot(DevopsDemo_HttpsGithubComJaymickeyDevopsDemoRefsHeadsMaster)

    buildType(DevopsDemo_BuildDemo)

    params {
        password("Octopus.ApiKey", "zxxe0085289d22834dfceb8350f6756d8dc5739afbba584e34e82f519ae0a9acbf8", description = "Octopus API key for pushing packages", display = ParameterDisplay.HIDDEN)
    }
})
