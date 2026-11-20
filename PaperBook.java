public class PaperBook extends BaseProduct {
    private int stock;

    public PaperBook(String title, Author author, int stock) {
        super(title, author);
        this.stock = stock;
        System.out.println("PaperBook конструктор: " + getTitle());
    }

    public PaperBook(PaperBook other) {
        super(other.getTitle(), new Author(other.author.name)); 
        this.stock = other.stock;
        System.out.println("PaperBook конструктор копирования: " + getTitle());
    }

    @Override
    public String getFormat() { return "Печатная"; }

    @Override
    public String describe() {
        return super.describe() + " | Наличие на складе: " + stock + " шт.";
    }

    @Override
    public BaseProduct cloneProduct() {
        return new PaperBook(this);
    }
}
