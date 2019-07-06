package cn.wbw.httpbootrest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 接口
 *
 * @author wbw
 * @date 2019/7/6 10:52
 */
@RestController
public class TestBoot {

    @RequestMapping("/boot")
    public String boot() {
        return "boot";
    }
}
