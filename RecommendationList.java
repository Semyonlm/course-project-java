import java.util.ArrayList;
import java.util.List;

public class RecommendationList {
    private final String ownerName;
    private final List<Book> books;
    private static final int MAX_SIZE = 5;

    public RecommendationList(String ownerName) {
        this.ownerName = ownerName;
        this.books = new ArrayList<>();
        System.out.println("Рекомендательный список создан (владелец: " + ownerName + ")");
    }

    public boolean addBook(Book book) {
        if (book == null) return false;
        if (books.size() >= MAX_SIZE) {
            System.out.println("Ошибка: список заполнен.");
            return false;
        }
        if (books.contains(book)) return false;
        if (!book.isAvailable()) {
            System.out.println("Ошибка: книга \"" + book.getTitle() + "\" снята с продажи.");
            return false;
        }
        books.add(book);
        return true;
    }

    public void clear() { books.clear(); }
    public int getSize() { return books.size(); }

    public void print() {
        if (books.isEmpty()) {
            System.out.println("  (рекомендаций нет)");
            return;
        }
        for (Book book : books) {
            System.out.println("  - " + book.getTitle() + " (" + book.getGenre() + ")");
        }
    }
}
