package fun.xruo.lle.common;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 17:12
 */
public abstract class BaseController {

    protected RestResponse ok() {
        RestResponse response = new RestResponse();
        response.setCode("00000");
        response.setMessage("一切ok");
        return response;
    }

    protected RestResponse ok(Object o) {
        RestResponse response = ok();
        response.setData(o);
        return response;
    }
}
