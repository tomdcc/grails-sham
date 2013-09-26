grails.project.work.dir = 'target'
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

		// here to allow testing against snapshot sham code
		if(System.getenv("SHAM_CI") == 'true' && appVersion.endsWith("-SNAPSHOT")) {
			println "Using Sonatype OSS snapshot repository. If you are reading this anywhere other than the sham plugin travis CI build, something probably went wrong"
			mavenRepo 'https://oss.sonatype.org/content/repositories/snapshots'
		}

	}
    dependencies {
		compile 'org.shamdata:sham-core:0.4-SNAPSHOT'

    }

    plugins {
		build(':release:2.2.0') {
			export = false
		}
        // since the above seems to add this to my application.properties without asking anyway...
		build(':rest-client-builder:1.0.3') {
			export = false
		}

        test(":spock:0.7") {
			export = false
		}
    }
}

grails.project.repos.grailsCentral.username = System.getenv("GRAILS_CENTRAL_USERNAME")
grails.project.repos.grailsCentral.password = System.getenv("GRAILS_CENTRAL_PASSWORD")
