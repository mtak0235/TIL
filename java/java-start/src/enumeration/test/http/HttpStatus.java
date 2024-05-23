package enumeration.test.http;

public enum HttpStatus {
    OK(200, "OK"),BAD_REQUEST(400, "Bad Request"), NOT_FOUND(404, "Not Found"), INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    int code;
    String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static HttpStatus findByCode(int httpCodeInput) {
        HttpStatus[] values = values();
        for (HttpStatus value : values) {
            if (value.code == httpCodeInput) {
                return value;
            }
        }
        return null;
    }

    public boolean isSuccess() {
        return this.code >= 200 && this.code < 299;
    }
}
