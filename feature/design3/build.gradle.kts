plugins {
    id("cleidesigns.android.library")
    id("cleidesigns.android.library.compose")
    id("cleidesigns.android.feature")
}

android {
    namespace = "com.kproject.cleidesigns.feature.design3"
}

dependencies {
    implementation(libs.mp.android.chart)
}