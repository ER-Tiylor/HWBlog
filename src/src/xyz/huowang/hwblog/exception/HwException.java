package src.xyz.huowang.hwblog.exception;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:31
 * @description：TODO
 * @version: 1.0
 */
public class HwException extends Exception {

    public HwException() {
    }

    public HwException(String message) {
        super(message);
    }

    public HwException(String message, Throwable cause) {
        super(message, cause);
    }

    public HwException(Throwable cause) {
        super(cause);
    }

    public HwException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
