package tax.szz.common.entity.enums;

import io.micrometer.common.util.StringUtils;

import java.util.stream.Stream;

/**
 * 作者：沈自在 <a href="https://www.szz.tax">Blog</a>
 *
 * @description 内部错误枚举
 * @date 2023/9/17
 */
public enum InternalErrorEnum implements KeyValueExtEnum<String, String> {

    /**
     * 成功
     */
    SUCCESS("SUCCESS", "success"),

    /**
     * 内部错误
     */
    FAILED("SYSTEM_ERROR", "internal error"),

    /**
     * 参数缺失
     */
    PARAMETER_MISSING("PARAMETER_MISSING", "this param is necessary");


    private final String code;

    private final String desc;

    InternalErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    public static InternalErrorEnum value(String code) {
        return StringUtils.isBlank(code) ? null :
                Stream.of(values())
                        .filter((i) -> i.getCode().equals(code))
                        .findAny()
                        .orElse(null);
    }
}
