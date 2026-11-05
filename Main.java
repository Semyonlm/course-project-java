import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Ссылки и копии (особенности Java)");
        Book firstBook = new Book("Мастер и Маргарита", "Булгаков", "Роман", 3);
        Book secondBook = firstBook; 
        
        secondBook.setRating(5); 
        System.out.println("Оригинальный объект изменился: " + firstBook);
        System.out.println("Первая книга = вторая книга " + (firstBook == secondBook));

        System.out.println("\n2. Агрегация, Композиция и try-with-resources");
        Book witcher = new Book("Ведьмак", "Сапковский", "Фэнтези", 2);
        Book dune = new Book("Дюна", "Герберт", "Фантастика", 1);
        List<Book> candidates = Arrays.asList(witcher, dune);

        try (PurchaseSession session = new PurchaseSession("Иван")) {
            session.logAction("Начало оформления заказа");
            
            Reader reader = new Reader("Иван");
            
            reader.rateBook(witcher, 4);
            reader.buyBook(witcher);
            reader.requestRecommendations(candidates);
            
            session.logAction("Книга куплена, рекомендации сформированы");
            reader.printStatus();
            
        }

        System.out.println("\nВышли из блока try. Сессия закрыта, ресурсы освобождены");
        System.out.println("Но книга осталась(агрегация): " + witcher.getTitle());

        System.out.println("\n3. Сборщик мусора (Garbage Collector)");
        WeakReference<Book> watcher = createTemporaryBook();
        System.out.println("Временная книга жива до вызова GC? " + (watcher.get() != null));
        
        System.gc(); 
        try { Thread.sleep(100); } catch (InterruptedException e) {} 
        
        System.out.println("Временная книга жива после GC? " + (watcher.get() != null));
    }

    static WeakReference<Book> createTemporaryBook() {
        Book temp = new Book("Списанная книга", "Неизвестен", "Жанр", 1);
        return new WeakReference<>(temp);
    }
}
