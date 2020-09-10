package xyz.huowang.hwblog.exception;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:37
 * @description：TODO
 * @version: 1.0
 */
public class UserExistException extends HwException {
    public UserExistException() {
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }

    public UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
