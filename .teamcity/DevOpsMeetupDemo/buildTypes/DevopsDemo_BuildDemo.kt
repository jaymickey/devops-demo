package DevOpsMeetupDemo.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.BuildStep
import jetbrains.buildServer.configs.kotlin.v10.BuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.MSBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.MSBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.msBuild
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object DevopsDemo_BuildDemo : BuildType({
    uuid = "54ac1b9c-87fd-4c24-885d-68e913976c21"
    extId = "DevopsDemo_BuildDemo"
    name = "Build and Push"

    buildNumberPattern = "0.0.%build.counter%"

    vcs {
        root(DevOpsMeetupDemo.vcsRoots.DevOpsMeetupDemo_GitHubJaymickeyDevOpsDemo)

    }

    steps {
        step {
            name = "Restore NuGet Packages"
            type = "jb.nuget.installer"
            param("nuget.path", "%teamcity.tool.NuGet.CommandLine.DEFAULT%")
            param("nuget.updatePackages.mode", "sln")
            param("sln.path", "src/ToDo.Web.Mvc.sln")
        }
        msBuild {
            name = "Build Solution"
            path = "src/ToDo.Web.Mvc.sln"
            toolsVersion = MSBuildStep.MSBuildToolsVersion.V15_0
            platform = MSBuildStep.Platform.x64
            args = """
                /maxcpucount
                /p:OctoPackNuGetArguments="-exclude **\*.pdb"
            """.trimIndent()
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
            param("octopus_octopack_package_version", "%build.number%")
            param("octopus_run_octopack", "true")
        }
        step {
            name = "Push Packages to Octopus"
            type = "octopus.push.package"
            param("octopus_host", "http://192.168.137.2:8080")
            param("octopus_packagepaths", "**\*.%build.number%.nupkg")
            param("secure:octopus_apikey", "credentialsJSON:de5a9aae-1202-4e15-8192-60b8b97aabef")
        }
    }

    triggers {
        vcs {
            triggerRules = "+:root=DevOpsMeetupDemo_GitHubJaymickeyDevOpsDemo:src/**"
        }
    }
})
