package tax.szz.common.entity.exception;

import java.io.Serial;

public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3068309479435395323L;

    /**
     * 实例化一个业务异常
     */
    public BusinessException(final Throwable throwable) {
        super(throwable);
    }

    /**
     * 实例化一个业务异常
     */
    public BusinessException(final String message) {
        super(message);
    }

    /**
     * 实例化一个业务异常
     */
    public BusinessException(final Throwable throwable, final String message) {
        super(message, throwable);
    }
}
