import BuildPlugins.android

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
    id("com.google.dagger.hilt.android")

}

android {

    namespace ="com.android.jetpackcomposedemo"
    compileSdk =33

    defaultConfig {
        applicationId ="com.android.jetpackcomposedemo"
        minSdk =24
        targetSdk =33
        versionCode =2
        versionName ="1.0"

        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary= true
        }
    }



    signingConfigs {
        create("signingConfigRelease") {
            /* storeFile = file(KeyHelper.getValue(KeyHelper.KEY_STORE_FILE))
             storePassword = KeyHelper.getValue(KeyHelper.KEY_STORE_PASS)
             keyAlias = KeyHelper.getValue(KeyHelper.KEY_ALIAS)
             keyPassword = KeyHelper.getValue(KeyHelper.KEY_PASS)*/
        }
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility =JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    buildFeatures {
        compose= true
    }


    composeOptions {
        kotlinCompilerExtensionVersion ="1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }

    //implementation("androidx.activity:activity-compose:1.7.1")
    implementation(JetPack.jetpackCompose)
    implementation(AndroidX.CoreKtx)
    implementation(JetPack.Lifecycle)
    implementation(JetPack.jetpackComposeBom)
    implementation(JetPack.jetpackComposeUi)
    implementation(JetPack.jetpackCompseGraphics)
    implementation(JetPack.jetpackComposeToolingPreview)
    implementation(JetPack.jetpackCompseTooling)
    implementation(JetPack.jetpaUiCoposeTestManifest)
    implementation(Deps.jUnitTest)
    implementation(JetPack.jetpackCompseMaterial3)

    implementation(JetPack.ViewModel)
    implementation(JetPack.ViewModelComposeUtility)
    implementation(JetPack.HiltCore)
    kapt(JetPack.HiltApt)
    kapt(JetPack.HiltCompiler)
     implementation(JetPack.HiltNavigationCompose)


    implementation("io.ktor:ktor-client-android:1.5.0")
    implementation("io.ktor:ktor-client-serialization:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
    implementation("io.ktor:ktor-client-logging-jvm:1.5.0")

    implementation("org.jetbrains.kotlinx: kotlinx-serialization-json:1.0.1")

    implementation("com.squareup.retrofit2: retrofit:2.6.0")
    implementation("com.squareup.okhttp3: Logging-interceptor:4.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")

}


