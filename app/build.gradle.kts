


// Module (application-level) Gradle file (project/app/build.gradle.kts)
plugins {
    id("com.android.application")
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
}

dependencies {
    // Import the Firebase BoM (Bill of Materials)
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))

    // Add the dependencies for Firebase products you want to use
    implementation("com.google.firebase:firebase-analytics")
    // Add the dependencies for any other desired Firebase products
    // For example:
    // implementation("com.google.firebase:firebase-auth")
    // implementation("com.google.firebase:firebase-database")
}



android {
    namespace = "com.example.projet"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.projet"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    viewBinding {
        enable = true
    }
/*
// Add the signingReport task
    tasks.register("signingReport") {
        val signingConfig = signingConfigs.getByName("debug")
        val keystoreFile = signingConfig.storeFile
        val keystorePassword = signingConfig.storePassword
        val keystoreAlias = signingConfig.keyAlias
        val keystoreAliasPassword = signingConfig.keyPassword

        val command =
            "keytool -list -v -keystore \"$keystoreFile\" -alias \"$keystoreAlias\" -storepass \"$keystorePassword\" -keypass \"$keystoreAliasPassword\""
        commandLine(command)
    }
*/

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.car.ui:car-ui-lib:2.6.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.google.firebase:firebase-database:20.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation ("androidx.sqlite:sqlite:2.1.0")
}