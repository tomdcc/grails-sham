grails.project.work.dir = 'target'
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.plugin.location.sham = "../../.."

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
		mavenLocal()
		mavenCentral()
        grailsPlugins()
        grailsHome()
        grailsCentral()

		// here to allow testing against snapshot sham code
		mavenRepo 'https://oss.sonatype.org/content/repositories/snapshots'
    }
    dependencies {
		def webdriverVersion = '2.35.0'
		test "org.seleniumhq.selenium:selenium-firefox-driver:$webdriverVersion"
		test "org.gebish:geb-spock:0.9.0"

		test('org.codehaus.groovy.modules.http-builder:http-builder:0.5.1') {
			excludes "xml-apis", 'groovy'
		}
    }
	
	plugins {
		compile ':hibernate:2.1.5'
		compile ':tomcat:2.1.5'

		compile ':build-test-data:1.1.2'

		runtime ':fixtures:1.2'

		test ":spock:0.7"
		test ":geb:0.9.0"
	}
}
