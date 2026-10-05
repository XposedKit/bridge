plugins {
    `maven-publish`
    alias(libs.plugins.android.application)
}

android {
    namespace = "cc.meteormc.xposedkit.bridge"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        singleVariant("release") {
            withJavadocJar()
            withSourcesJar()
        }
    }
}

dependencies {
    implementation(libs.lsposed.service)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            artifactId = "xposedkit-bridge"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}