package fun.xruo.lle.common;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 17:13
 */
@Data
public class RestBody<T> {
    private String code;
    private String message;
    private T data;

    public static RestBody ok() {
        RestBody response = new RestBody();
        response.setCode("00000");
        response.setMessage("一切ok");
        return response;
    }

    public static RestBody ok(Object o) {
        RestBody response = ok();
        response.setData(o);
        return response;
    }

    public static RestBody failure(Exception e) {
        RestBody response = new RestBody();
        response.setCode("B0001");
        response.setMessage(e.getMessage());
        return response;
    }
}
