package by.kiselevich.busstop.exception;

public class NoFilenameException extends RuntimeException {
    public NoFilenameException() {
    }

    public NoFilenameException(String message) {
        super(message);
    }

    public NoFilenameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFilenameException(Throwable cause) {
        super(cause);
    }

    public NoFilenameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
