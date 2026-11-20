public final class EBook extends BaseProduct {
    private double fileSizeMb;

    public EBook(String title, Author author, double size) {
        super(title, author);
        this.fileSizeMb = size;
        System.out.println("EBook конструктор: " + getTitle());
    }

    @Override
    public String getFormat() { return "Электронная"; }

    @Override
    public String describe() {
        return "Электронная книга \"" + getTitle() + "\" | Размер: " + fileSizeMb + " МБ";
    }

    @Override
    public BaseProduct cloneProduct() {
        return new EBook(this.getTitle(), this.author, this.fileSizeMb);
    }
}
