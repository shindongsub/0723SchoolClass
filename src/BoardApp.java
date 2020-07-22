import java.util.ArrayList;
import java.util.Scanner;
import Util.Util;

public class BoardApp {
	ArrayList<Article> articles = new ArrayList<Article>();

	void start() {
		Scanner sc = new Scanner(System.in);
		String cmd = "";
		int id = 1;
		while (true) {
			System.out.print("명령어를 입력하세요 : ");
			cmd = sc.nextLine();
			if (cmd.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			if (cmd.equals("help")) {
				System.out.println("add    : 추가");
				System.out.println("list   : 리스트");
				System.out.println("search : 검색");
				System.out.println("detail : 상세보기");
				System.out.println("update : 수정");
				System.out.println("delete : 삭제");
			}

			if (cmd.equals("add")) {
				Article article = new Article();
				article.id = id;
				id++;
				System.out.print("제목 입력 : ");
				String title = sc.nextLine();
				article.title = title;
				System.out.print("내용 입력 : ");
				String body = sc.nextLine();
				article.body = body;

				articles.add(article);
				article.regdata = Util.getCurrentDate();

				System.out.println("저장이 완료되었습니다.");
			}
			if (cmd.equals("read")) {
				print_articles(articles);
			}
			if (cmd.equals("delete")) {
				System.out.println("삭제할 번호 선택하세요 : ");
				int delNo = Integer.parseInt(sc.nextLine());
				Article targetNo = get_article_by_id(delNo);
				if (targetNo != null) {
					articles.remove(delNo);
					System.out.println("게시물이 삭제되었습니다.");
				} else {
					System.out.println("없는 게시물입니다.");
				}

			}
			if (cmd.equals("update")) {
				System.out.println("수정할 번호 선택하세요 : ");
				int change = Integer.parseInt(sc.nextLine());
				Article changeNo = get_article_by_id(change);
				if (changeNo != null) {
					System.out.print("수정할 제목 : ");
					String titleUp = sc.nextLine();
					changeNo.title = titleUp;
					System.out.print("수정할 내용 : ");
					String bodyUp = sc.nextLine();
					changeNo.body = bodyUp;
				} else {
					System.out.println("없는 게시물입니다.");
				}
			}
			if (cmd.equals("search")) {
				System.out.print("검색 번호 선택 (1. 제목 / 2. 내용");
				int searchNo = Integer.parseInt(sc.nextLine());
				System.out.print("검색할 내용을 입력해 주세요 : ");
				String keyNo = sc.nextLine();
				ArrayList<Article> targeting = new ArrayList<Article>();
				if (searchNo == 1) {
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).title.contains(keyNo)) {
							targeting.add(articles.get(i));
						}
					}

				} else if (searchNo == 2) {
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).body.contains(keyNo)) {
							targeting.add(articles.get(i));
						}
					}

				} else {
					System.out.println("없는 게시물입니다.");
				}
				print_articles(targeting);
			}
			if (cmd.equals("detail")) {
				System.out.println("상세보기 게시물을 선택해주세요 : ");
				int detailNo = Integer.parseInt(sc.nextLine());
				Article detail = get_article_by_id(detailNo);
				if (detail == null) {
					System.out.println("없는 게시물입니다.");
				} else {
					detail.hit++;
					print_article(detail);
				}
			}

		}

	}

	public void print_article(Article article) {
		System.out.println("=========게시물 목록=========");
		System.out.println("번호    : " + article.id);
		System.out.println("제목    : " + article.title);
		System.out.println("내용    : " + article.body);
		System.out.println("조회수 : " + article.hit);

	}

	public void print_articles(ArrayList<Article> articles) {
		System.out.println("=========게시물 목록=========");
		for (int i = 0; i < articles.size(); i++) {
			System.out.println("번호 : " + articles.get(i).id);
			System.out.println("제목 : " + articles.get(i).title);
			System.out.println("내용 : " + articles.get(i).body);
			System.out.println("조회수 : " + articles.get(i).hit);

			String str = articles.get(i).regdata;
			String[] array = str.split(" ");
			System.out.println("작성일 : " + array[0]);
		}

	}

	public Article get_article_by_id(int id) {
		Article article = null;
		for (int i = 0; i < articles.size(); i++) {
			Article target = articles.get(i);
			if (target.id == id) {
				article = target;
				break;
			}

		}
		return article;
	}

}
