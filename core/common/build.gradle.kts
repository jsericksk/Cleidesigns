plugins {
    id("cleidesigns.android.library")
}

android {
    namespace = "com.kproject.cleidesigns.core.commom"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
}