package fun.xruo.lle.common;

import lombok.Data;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 17:13
 */
@Data
public class RestResponse {
    private String code;
    private String message;
    private Object data;
}
