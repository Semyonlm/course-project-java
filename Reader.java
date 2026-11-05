import java.util.ArrayList;
import java.util.List;

public class Reader implements AutoCloseable {
    private final String name;
    private final RecommendationList recommendations;
    private final List<String> purchasedTitles;
    private boolean hasActivity;

    public Reader(String name) {
        this.name = name;
        this.recommendations = new RecommendationList(name); 
        this.purchasedTitles = new ArrayList<>();
        this.hasActivity = false;
        System.out.println("Читатель создан: " + name);
    }

    public void rateBook(Book book, int rating) {
        if (book.setRating(rating)) {
            hasActivity = true;
            System.out.println("Читатель " + name + " оценил книгу \"" + book.getTitle() + "\" на " + rating);
        }
    }

    public boolean buyBook(Book book) {
        if (!book.isAvailable() || purchasedTitles.contains(book.getTitle()) || book.getStock() <= 0) {
            System.out.println("Ошибка покупки книги \"" + book.getTitle() + "\"");
            return false;
        }
        purchasedTitles.add(book.getTitle());
        hasActivity = true;
        System.out.println("Читатель " + name + " купил книгу \"" + book.getTitle() + "\".");
        return true;
    }

    public void requestRecommendations(List<Book> candidates) {
        if (!hasActivity) {
            System.out.println("Недостаточно данных для рекомендаций.");
            return;
        }
        recommendations.clear();
        for (Book book : candidates) {
            if (!purchasedTitles.contains(book.getTitle())) {
                recommendations.addBook(book);
            }
        }
    }

    public void printStatus() {
        System.out.println("Читатель: " + name);
        System.out.println("Купленные книги: " + (purchasedTitles.isEmpty() ? "нет" : purchasedTitles));
        System.out.println("Рекомендации:");
        recommendations.print();
    }

    @Override
    public void close() {
        System.out.println("[-] Сессия читателя " + name + " завершена.");
        recommendations.clear();
    }
}
