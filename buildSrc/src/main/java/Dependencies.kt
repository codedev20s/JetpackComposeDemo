object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

/**
 * To define dependencies
 */
object Deps {
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.jUnit}" }

    val jUnitTest by lazy { "androidx.test.ext:junit-ktx:${Version.JUnitTest}"}



}

object Version {

    // AndroidX--------------------------------------------------------------
    const val AppCompat = "1.3.1"
    const val CoreKtx = "1.7.0"
    const val ConstraintLayout = "2.1.3"
    const val TestExtJunit = "1.1.2"
    const val TestEspresso = "3.3.0"
    const val ActivityKtx = "1.4.0"
    const val FragmentKtx = "1.4.1"
    const val MultiDex = "2.0.1"

    const val JUnitTest = "1.1.5"

    // Android---------------------------------------------------------------
    const val Junit = "4.13"
    const val Material = "1.2.0"

    // Kotlin----------------------------------------------------------------
    const val Kotlin = "1.6.21"
    const val Coroutines = "1.6.1"

    // JetPack---------------------------------------------------------------
    const val Lifecycle = "2.4.1"
    const val Hilt = "2.45"
    const val ComposeNavigation = "2.5.3"
    const val DataStore = "1.0.0"
    const val jetpackCompose = "1.7.1"
    const val jetpackCompseBom = "2023.05.01"
    const val jetpackComposeTooling = "1.4.2"
    const val jetpackComposeMaterial3 = "1.0.0-beta02"


    // GitHub----------------------------------------------------------------
    const val OkHttp = "4.9.0"
    const val OkHttpInterceptorLogging = "4.9.1"
    const val Retrofit = "2.9.0"                        // Retrofit
    const val RetrofitConverterGson = "2.9.0"           // Retrofit Gson
    const val Gson = "2.8.7"                            // Gson
    const val MMKV = "1.2.9"
    const val AutoSize = "1.2.1"
    const val ARoute = "1.5.1"
    const val ARouteCompiler = "1.5.1"
    const val RecyclerViewAdapter = "3.0.4"             // RecyclerViewAdapter
    const val EventBus = "3.2.0"
    const val PermissionX = "1.4.0"
    const val LeakCanary = "2.7"
    const val AutoService = "1.0"
    const val Coil = "1.3.0"

    // SDK--------------------------------------------------------------
    const val TencentBugly = "3.3.9"
    const val TencentBuglyNative = "3.8.0"
    const val TencentTBSX5 = "43939"
}

object AndroidX {
    const val AndroidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val AppCompat = "androidx.appcompat:appcompat:${Version.AppCompat}"
    const val CoreKtx = "androidx.core:core-ktx:${Version.CoreKtx}"
    const val ConstraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}"
    const val TestExtJunit = "androidx.test.ext:junit:${Version.TestExtJunit}"
    const val TestEspresso = "androidx.test.espresso:espresso-core:${Version.TestEspresso}"
    const val ActivityKtx = "androidx.activity:activity-ktx:${Version.ActivityKtx}"
    const val FragmentKtx = "androidx.fragment:fragment-ktx:${Version.FragmentKtx}"
    const val MultiDex = "androidx.multidex:multidex:${Version.MultiDex}"
}

object Android {
    const val Junit = "junit:junit:${Version.Junit}"
    const val Material = "com.google.android.material:material:${Version.Material}"
}

object JetPack {
    const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle}"
    const val ViewModelComposeUtility = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.Lifecycle}"
    const val ViewModelSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Lifecycle}"
    const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle}"
    const val Lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle}"
    const val LifecycleCompilerAPT =
        "androidx.lifecycle:lifecycle-compiler:${Version.Lifecycle}"
    const val HiltCore = "com.google.dagger:hilt-android:${Version.Hilt}"
    const val HiltApt = "com.google.dagger:hilt-android-compiler:${Version.Hilt}"
    const val HiltCompiler = "com.google.dagger:hilt-compiler:${Version.Hilt}"

    const val HiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"

    const val NavigationCompose = "androidx.navigation:navigation-compose:${Version.ComposeNavigation}"


    const val DtatStore = "androidx.datastore:datastore-preferences:${Version.DataStore}"

    val jetpackCompose by lazy { "androidx.activity:activity-compose:${Version.jetpackCompose}" }
    val jetpackComposeBom by lazy { "androidx.compose:compose-bom:${Version.jetpackCompseBom}" }
    val jetpackComposeUi by lazy { "androidx.compose.ui:ui" }
    val jetpackCompseGraphics by lazy { "androidx.compose.ui:ui-graphics"}
    val jetpackComposeToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Version.jetpackComposeTooling}"}
    val jetpackCompseTooling by lazy { "androidx.compose.ui:ui-tooling"}
    val jetpaUiCoposeTestManifest by lazy {"androidx.compose.ui:ui-test-manifest"}

    val jetpackCompseMaterial3 by lazy { "androidx.compose.material3:material3:${Version.jetpackComposeMaterial3}" }

}

object Kotlin {
    const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin}"
    const val CoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
    const val CoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"
}

object GitHub {
    const val OkHttp = "com.squareup.okhttp3:okhttp:${Version.OkHttp}"
    const val OkHttpInterceptorLogging =
        "com.squareup.okhttp3:logging-interceptor:${Version.OkHttpInterceptorLogging}"
    const val Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
    const val RetrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Version.RetrofitConverterGson}"
    const val Gson = "com.google.code.gson:gson:${Version.Gson}"
    const val MMKV = "com.tencent:mmkv-static:${Version.MMKV}"
    const val AutoSize = "me.jessyan:autosize:${Version.AutoSize}"
    const val ARoute = "com.alibaba:arouter-api:${Version.ARoute}"
    const val ARouteCompiler = "com.alibaba:arouter-compiler:${Version.ARouteCompiler}"
    const val RecyclerViewAdapter =
        "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Version.RecyclerViewAdapter}"
    const val EventBus = "org.greenrobot:eventbus:${Version.EventBus}"
    const val EventBusAPT = "org.greenrobot:eventbus-annotation-processor:${Version.EventBus}"
    const val PermissionX = "com.permissionx.guolindev:permissionx:${Version.PermissionX}"
    const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.LeakCanary}"
    const val AutoService = "com.google.auto.service:auto-service:${Version.AutoService}"
    const val AutoServiceAnnotations =
        "com.google.auto.service:auto-service-annotations:${Version.AutoService}"
    const val Coil = "io.coil-kt:coil:${Version.Coil}"
    const val CoilGIF = "io.coil-kt:coil-gif:${Version.Coil}"
    const val CoilSVG = "io.coil-kt:coil-svg:${Version.Coil}"
    const val CoilVideo = "io.coil-kt:coil-video:${Version.Coil}"
}

object SDK {
    const val TencentBugly = "com.tencent.bugly:crashreport:${Version.TencentBugly}"
    const val TencentBuglyNative =
        "com.tencent.bugly:nativecrashreport:${Version.TencentBuglyNative}"
    const val TencentTBSX5 = "com.tencent.tbs.tbssdk:sdk:${Version.TencentTBSX5}"
}