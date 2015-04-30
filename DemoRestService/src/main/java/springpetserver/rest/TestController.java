package springpetserver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springpetserver.bo.entity.HelloWorldBO;
import springpetserver.bo.response.Response;
import springpetserver.entity.HelloWorldEntity;
import springpetserver.service.HelloWorldService;

import java.util.List;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Controller
@RequestMapping("api/test")
public class TestController {
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("ping")
    @ResponseBody
    public Response<String> ping() {
        return Response.createOKResponse("Hello!");
    }

    @RequestMapping("hello")
    @ResponseBody
    public Response<List<HelloWorldBO>> hello() {
        /*HelloWorldEntity helloWorldEntity = new HelloWorldEntity();
        helloWorldEntity.setId(2L);
        helloWorldEntity.setName("Hello world!");
        return Response.createOKResponse(helloWorldEntity);*/
        return Response.createOKResponse(helloWorldService.getAll());
    }
}
