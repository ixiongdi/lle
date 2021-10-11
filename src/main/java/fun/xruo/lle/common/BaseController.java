package fun.xruo.lle.common;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 17:12
 */
public class BaseController {

    public Object ok() {
        return RestBody.ok();
    }

    public Object ok(Object o) {
        return RestBody.ok(o);
    }

}
