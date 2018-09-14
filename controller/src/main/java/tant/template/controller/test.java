package tant.template.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tant.template.entity.po.Test;
import java.util.List;
import java.util.Map;

@Api(tags ="测试")
@Controller
@RequestMapping("/test")
@Slf4j
public class test  {
    @Autowired()
    tant.template.service.test test;

    @GetMapping("/pebble")
    public String testpebble(Map<String, Object> model) {
        model.put("data",test.gettestlist());
        model.put("name","pebble");
        model.put("title","标题");
        return "pebble";
    }
    @ApiOperation(value = "mysql数据库测试")
    @GetMapping("/mysql")
    @ResponseBody
    public List<Test> testmysql() {
        return test.getTestListFromMysql();

    }

}
