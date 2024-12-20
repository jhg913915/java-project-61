plugins {
    application
    id("java")
    checkstyle
}

application { mainClass.set("hexlet.code.App") }
group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}


tasks.test {
    useJUnitPlatform()
}