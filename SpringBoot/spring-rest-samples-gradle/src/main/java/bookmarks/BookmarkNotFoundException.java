package bookmarks;

class BookmarkNotFoundException extends RuntimeException {

    public BookmarkNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }
}