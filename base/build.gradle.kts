plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.android.base"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(JetPack.jetpackCompose)
    implementation(JetPack.DtatStore)
    implementation(AndroidX.CoreKtx)
    implementation(JetPack.Lifecycle)
    implementation(JetPack.jetpackComposeBom)
    implementation(JetPack.jetpackCompseMaterial3)
    implementation(JetPack.jetpackComposeUi)
    implementation(JetPack.jetpackCompseGraphics)
    implementation(JetPack.jetpackComposeToolingPreview)
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.27.0")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}