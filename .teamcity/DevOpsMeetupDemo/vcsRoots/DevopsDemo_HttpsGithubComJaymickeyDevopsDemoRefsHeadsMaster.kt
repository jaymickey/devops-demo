package DevOpsMeetupDemo.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object DevopsDemo_HttpsGithubComJaymickeyDevopsDemoRefsHeadsMaster : GitVcsRoot({
    uuid = "504abdaa-fa3c-41c2-8965-d0e14fdc14d1"
    extId = "DevopsDemo_HttpsGithubComJaymickeyDevopsDemoRefsHeadsMaster"
    name = "https://github.com/jaymickey/devops-demo#refs/heads/master"
    url = "https://github.com/jaymickey/devops-demo"
    authMethod = password {
        userName = "jaymickey"
        password = "zxx7afdf1137faaab5c73b4bce4cd1eef67207c682e8fb5c12f49f63b6f8dd0257ceb09256422291063775d03cbe80d301b"
    }
})
