plugins {
    id("java")
}

group = "com.mentalfrostbyte"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.9.0")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("org.json:json:20231013")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveBaseName.set("SigmaRebaseInstaller")
    archiveVersion.set("")
}