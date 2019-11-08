package fn.service.core.exception;

/**
 * Custom exception which extends RuntimeExceptio
 */
public class CustomException extends RuntimeException {
    private String message;
    private String details;
    private String hint;
    private String nextActions;
    private String support;

    protected CustomException() {
    }

    public CustomException(
            String message, String details, String hint, String nextActions, String support) {
        this.message = message;
        this.details = details;
        this.hint = hint;
        this.nextActions = nextActions;
        this.support = support;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getNextActions() {
        return nextActions;
    }

    public void setNextActions(String nextActions) {
        this.nextActions = nextActions;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }
}