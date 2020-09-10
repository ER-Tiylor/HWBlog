package xyz.huowang.hwblog.exception;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:32
 * @description：TODO
 * @version: 1.0
 */
public class HwRuntimeException extends RuntimeException {

    public HwRuntimeException() {
    }

    public HwRuntimeException(String message) {
        super(message);
    }

    public HwRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public HwRuntimeException(Throwable cause) {
        super(cause);
    }

    public HwRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
