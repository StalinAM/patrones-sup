plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
	//implementation("org.postgresql:postgresql:42.7.3")
	implementation("com.google.guava:guava:33.2.1-jre")
	implementation("org.xerial:sqlite-jdbc:3.46.0.0")
	implementation("com.zaxxer:HikariCP:5.1.0")
}

