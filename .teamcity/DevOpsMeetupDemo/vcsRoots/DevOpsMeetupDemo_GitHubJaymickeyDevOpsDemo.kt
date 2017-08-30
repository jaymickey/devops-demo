package DevOpsMeetupDemo.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object DevOpsMeetupDemo_GitHubJaymickeyDevOpsDemo : GitVcsRoot({
    uuid = "504abdaa-fa3c-41c2-8965-d0e14fdc14d1"
    extId = "DevOpsMeetupDemo_GitHubJaymickeyDevOpsDemo"
    name = "GitHub Jaymickey DevOps Demo"
    url = "https://github.com/jaymickey/devops-demo"
    authMethod = password {
        userName = "jaymickey"
        password = "credentialsJSON:4a6f27fb-8bf2-4dd0-a014-e451d8b7a44d"
    }
})
