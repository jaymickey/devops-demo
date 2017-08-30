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
        root(DevOpsMeetupDemo.vcsRoots.DevopsDemo_HttpsGithubComJaymickeyDevopsDemoRefsHeadsMaster)

    }

    steps {
        step {
            name = "Restore NuGet Packages"
            type = "jb.nuget.installer"
            param("nuget.path", "%teamcity.tool.NuGet.CommandLine.DEFAULT%")
            param("nuget.updatePackages.mode", "sln")
            param("sln.path", "DemoApp.sln")
        }
        msBuild {
            name = "Build Solution"
            path = "DemoApp.sln"
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
            param("octopus_additionalcommandlinearguments", "--apiKey %Octopus.ApiKey%")
            param("octopus_host", "http://192.168.137.2:8080")
            param("octopus_packagepaths", "*.%build.number%.nupkg")
            param("secure:octopus_apikey", "zxx4469c7c25073dd9f")
        }
    }

    triggers {
        vcs {
        }
    }
})
