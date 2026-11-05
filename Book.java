public class Book {
    private final String title;
    private final String author;
    private final String genre;
    private int rating;
    private int stock;
    private boolean isAvailable;

    public Book(String title, String author, String genre, int stock) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.stock = Math.max(0, stock);
        this.isAvailable = true;
        this.rating = 0;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Ошибка: оценка " + rating + " вне диапазона 1..5");
            return false;
        }
        this.rating = rating;
        return true;
    }

    public void withdrawFromSale() {
        this.isAvailable = false;
        System.out.println("Книга \"" + title + "\" снята с продажи.");
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getRating() { return rating; }
    public int getStock() { return stock; }
    public boolean isAvailable() { return isAvailable; }

    @Override
    public String toString() {
        String ratingStr = (rating == 0) ? "нет" : String.valueOf(rating);
        return "Книга: \"" + title + "\" | Автор: " + author + " | Жанр: " + genre + 
               " | Рейтинг: " + ratingStr + " | Наличие: " + stock + " | Доступна: " + (isAvailable ? "да" : "нет");
    }
}
