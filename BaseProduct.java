public abstract class BaseProduct {
    private static int nextId = 1;
    
    private final int id;
    private String title;
    protected Author author;

    protected BaseProduct(String title, Author author) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        System.out.println("BaseProduct конструктор: " + this.title);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }

    protected String header() {
        return "Товар #" + id + ": \"" + title + "\" (Автор: " + author.name + ")";
    }

    public abstract String getFormat();
    public abstract BaseProduct cloneProduct();

    public String describe() {
        return header() + " | Формат: " + getFormat();
    }
}
