class Article {

	int id;
	String title;
	String body;
	String regdata;
	int hit;
	// String writer; 

	Article() {

	} 

	Article(int id, String title, String body, String regdata, int hit) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regdata = regdata;
		this.hit = hit;
		// this.writer = writer;
	}

}
