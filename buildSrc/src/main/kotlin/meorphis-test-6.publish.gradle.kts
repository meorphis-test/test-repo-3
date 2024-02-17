import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

plugins {
    `maven-publish`
    `signing`
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Acme Developer API")
                description.set("The Acme Developer API is designed to provide a predictable programmatic\ninterface for accessing your Acme account through an API and transaction\nwebhooks. Note that your API key is a secret and should be treated as such.\nDon't share it with anyone, including us. We will never ask you for it.")
                url.set("https://docs.meorphis-test-6.com")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Meorphis Test 6")
                        email.set("support@acme.comm")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/meorphis-test/meorphis-test-6-java.git")
                    developerConnection.set("scm:git:git://github.com/meorphis-test/meorphis-test-6-java.git")
                    url.set("https://github.com/meorphis-test/meorphis-test-6-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.publish {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
