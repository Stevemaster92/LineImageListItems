package tirol.hit.android.lili.models;

public class DataError {
    private final int code;
    private final String message;

    public DataError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
