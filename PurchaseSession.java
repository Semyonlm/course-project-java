public class PurchaseSession implements AutoCloseable {
    private final String readerName;

    public PurchaseSession(String readerName) {
        this.readerName = readerName;
        System.out.println("[+] Сессия покупки открыта для читателя: " + readerName);
    }

    public void logAction(String action) {
        System.out.println("    [Чек] " + action);
    }

    @Override
    public void close() {
        System.out.println("[-] Сессия покупки закрыта. Ресурсы освобождены. (Читатель: " + readerName + ")");
    }
}
