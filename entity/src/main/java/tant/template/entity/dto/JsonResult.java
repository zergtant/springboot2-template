package tant.template.entity.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * rest请求的响应实体类
 */
@Data
public class JsonResult {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 错误代码
     * 0：未出错
     */

    private Integer err;
    /**
     * 错误消息
     * 默认为空字符串
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;

    private JsonResult(Integer err, String msg, Object obj) {
        this.err = err;
        this.msg = msg;
        this.data = obj;
    }

    public static JsonResult OK(Object obj) {
        return new JsonResult(0, "", obj);
    }
    public static JsonResult Err(Integer err, String msg, Object obj)
    {
        return new JsonResult(err, msg, obj);
    }
}
