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
			System.out.print("��ɾ �Է��ϼ��� : ");
			cmd = sc.nextLine();
			if (cmd.equals("exit")) {
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				break;
			}
			if (cmd.equals("help")) {
				System.out.println("add    : �߰�");
				System.out.println("list   : ����Ʈ");
				System.out.println("search : �˻�");
				System.out.println("detail : �󼼺���");
				System.out.println("update : ����");
				System.out.println("delete : ����");
			}

			if (cmd.equals("add")) {
				Article article = new Article();
				article.id = id;
				id++;
				System.out.print("���� �Է� : ");
				String title = sc.nextLine();
				article.title = title;
				System.out.print("���� �Է� : ");
				String body = sc.nextLine();
				article.body = body;

				articles.add(article);
				article.regdata = Util.getCurrentDate();

				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}
			if (cmd.equals("read")) {
				print_articles(articles);
			}
			if (cmd.equals("delete")) {
				System.out.println("������ ��ȣ �����ϼ��� : ");
				int delNo = Integer.parseInt(sc.nextLine());
				Article targetNo = get_article_by_id(delNo);
				if (targetNo != null) {
					articles.remove(delNo);
					System.out.println("�Խù��� �����Ǿ����ϴ�.");
				} else {
					System.out.println("���� �Խù��Դϴ�.");
				}

			}
			if (cmd.equals("update")) {
				System.out.println("������ ��ȣ �����ϼ��� : ");
				int change = Integer.parseInt(sc.nextLine());
				Article changeNo = get_article_by_id(change);
				if (changeNo != null) {
					System.out.print("������ ���� : ");
					String titleUp = sc.nextLine();
					changeNo.title = titleUp;
					System.out.print("������ ���� : ");
					String bodyUp = sc.nextLine();
					changeNo.body = bodyUp;
				} else {
					System.out.println("���� �Խù��Դϴ�.");
				}
			}
			if (cmd.equals("search")) {
				System.out.print("�˻� ��ȣ ���� (1. ���� / 2. ����");
				int searchNo = Integer.parseInt(sc.nextLine());
				System.out.print("�˻��� ������ �Է��� �ּ��� : ");
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
					System.out.println("���� �Խù��Դϴ�.");
				}
				print_articles(targeting);
			}
			if (cmd.equals("detail")) {
				System.out.println("�󼼺��� �Խù��� �������ּ��� : ");
				int detailNo = Integer.parseInt(sc.nextLine());
				Article detail = get_article_by_id(detailNo);
				if (detail == null) {
					System.out.println("���� �Խù��Դϴ�.");
				} else {
					detail.hit++;
					print_article(detail);
				}
			}

		}

	}

	public void print_article(Article article) {
		System.out.println("=========�Խù� ���=========");
		System.out.println("��ȣ    : " + article.id);
		System.out.println("����    : " + article.title);
		System.out.println("����    : " + article.body);
		System.out.println("��ȸ�� : " + article.hit);

	}

	public void print_articles(ArrayList<Article> articles) {
		System.out.println("=========�Խù� ���=========");
		for (int i = 0; i < articles.size(); i++) {
			System.out.println("��ȣ : " + articles.get(i).id);
			System.out.println("���� : " + articles.get(i).title);
			System.out.println("���� : " + articles.get(i).body);
			System.out.println("��ȸ�� : " + articles.get(i).hit);

			String str = articles.get(i).regdata;
			String[] array = str.split(" ");
			System.out.println("�ۼ��� : " + array[0]);
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
