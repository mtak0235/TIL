package nested.test;

public class Library {

	private Book[] books;
	private int lastIndex;

	public Library(int cnt) {
		books = new Book[cnt];
	}

	public void addBook(String title, String author) {
		if (lastIndex == books.length) {
			System.out.println("도서관 저장 공간이 부족합니다.");
			return;
		}
		books[lastIndex++] = new Book(title, author);
	}

	public void showBooks() {
		System.out.println("== 책 목록 출력 ==");
		for (Book book : books) {
			System.out.printf("도서 제목:\t%s,\t저자:\t%s%n", book.title, book.author);
		}
	}

	private static class Book {
		private String title;
		private String author;

		public Book(String title, String author) {
			this.title = title;
			this.author = author;
		}
	}
}
