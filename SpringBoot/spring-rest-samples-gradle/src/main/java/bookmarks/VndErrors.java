package bookmarks;

public class VndErrors  extends RuntimeException {
    public VndErrors(String error, String message) {
        super(message);
    }
}
