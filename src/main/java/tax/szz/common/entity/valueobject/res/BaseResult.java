package tax.szz.common.entity.valueobject.res;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import tax.szz.common.entity.enums.InternalErrorEnum;

import java.io.Serializable;

/**
 * 作者：沈自在 <a href="https://www.szz.tax">Blog</a>
 *
 * @description 通用返回基类
 * @date 2023/9/17
 */
public class BaseResult implements Serializable {

    /**
     * 是否成功
     */
    protected boolean isSuccess;

    /**
     * 结果码
     */
    protected String code;

    /**
     * 描述
     */
    protected String message;

    public BaseResult() {
    }

    public <E extends Throwable> BaseResult(InternalErrorEnum codeEnum, E e) {
        Assert.notNull(codeEnum, "codeEnum must be not null");
        this.isSuccess = (codeEnum == InternalErrorEnum.SUCCESS);
        this.message = codeEnum.getDesc() + (e == null ? "" : e.getLocalizedMessage());
        this.code = codeEnum.getCode();
    }

    public BaseResult message(String message) {
        if (StringUtils.hasText(message))
            this.message = this.message + "\t" + message;
        return this;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
