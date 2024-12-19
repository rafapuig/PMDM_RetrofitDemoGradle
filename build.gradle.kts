plugins {
    kotlin("jvm") version "2.1.0"
    //kotlin("plugin.serialization") version "2.0.20"
    //kotlin("kapt") version "1.3.72"
    //id("com.google.devtools.ksp") version "2.1.0-1.0.29"

}

group = "org.iesabastos.dam.ad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //testImplementation(kotlin("test"))
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    //implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.2")
    //implementation("com.squareup.moshi:moshi-adapters:1.9.2")
    implementation("com.squareup.moshi:moshi:1.15.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")

    //ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.2")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}