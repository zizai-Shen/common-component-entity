package tax.szz.common.entity.enums;

import java.io.Serializable;

/**
 * 作者：沈自在 <a href="https://www.szz.tax">Blog</a>
 *
 * @description KEY-VALUE 枚举
 * @date 2023/9/17
 */
public interface KeyValueExtEnum<CODE, DESC> extends Serializable {

    /**
     * 获取 code
     */
    CODE getCode();

    /**
     * 获取描述
     */
    DESC getDesc();
}
