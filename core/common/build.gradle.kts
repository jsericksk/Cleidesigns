plugins {
    id("cleidesigns.android.library")
    id("cleidesigns.android.library.compose")
}

android {
    namespace = "com.kproject.cleidesigns.core.commom"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
}