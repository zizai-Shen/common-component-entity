package tax.szz.common.entity.valueobject.res;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：沈自在 <a href="https://www.szz.tax">Blog</a>
 *
 * @description 通用返回结果
 * @date 2023/9/17
 */
public class Result<T> extends BaseResult {


    private T value;

    private Map<String, Object> additionalInfo;

    public Result() {
        this.additionalInfo = new HashMap<>(1);
    }

    public Result(String message, String code) {
        this(false, message, code);
    }

    public Result(boolean success, String message, String code) {
        this.additionalInfo = new HashMap<>(1);
        this.isSuccess = success;
        this.message = message;
        this.code = code;
    }


    /**
     * 成功
     */
    public Result<T> success(T data) {
        this.setSuccess(true);
        this.setValue(data);
        return this;
    }

    /**
     * 失败
     */
    public Result<T> fail(String code) {
        this.setSuccess(false);
        this.setCode(code);
        return this;
    }

    public Result<T> fail(String code, String... msg) {
        this.fail(code);
        if (msg != null)
            this.setMessage(StringUtils.join(List.of(msg), '|'));
        return this;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Map<String, Object> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setAdditionalInfo(String codeTemp, String msgTemp) {
        this.additionalInfo.put(codeTemp, msgTemp);
    }
}

