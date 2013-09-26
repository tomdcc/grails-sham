package sham.grails.plugin.driver

class Article {
	
	String headline
	String teaser
	String text
	String author
	String authorEmail
	String authorAvatar
	String imageUri

	Date datePublished
	Date dateCreated
	Date lastUpdated

    static constraints = {
		text maxSize: 10240
		teaser nullable: true, maxSize: 2048
		imageUri nullable: true
		datePublished nullable: true
    }
	
	static transients = ['firstParagraph']
	
	String getFirstParagraph() {
		if(!text) return null;
		
		int endParaPlace = text.indexOf('</p>')
		if(endParaPlace != -1) {
			text.substring(0, endParaPlace + 4)
		} else {
			text
		}
	}
}
