package springpetserver.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springpetserver.bo.entity.HelloWorldBO;
import springpetserver.bo.response.Response;
import springpetserver.entity.HelloWorldEntity;
import springpetserver.exception.ValidBindingException;
import springpetserver.service.HelloWorldService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Controller
@RequestMapping("api/test")
public class TestController extends AbstractController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("ping")
    @ResponseBody
    public Response<String> ping() {
        return Response.createOKResponse("Hello!");
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @RequestMapping("getAll")
    @ResponseBody
    public Response<List<HelloWorldBO>> getAll() {
        return Response.createOKResponse(helloWorldService.getAll());
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public Response<HelloWorldBO> get(@PathVariable("id") Long id) {
        return Response.createOKResponse(helloWorldService.get(id));
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Response<HelloWorldBO> create(
        @Valid @RequestBody HelloWorldBO helloWorldBO,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidBindingException(bindingResult);
        }
        return Response.createOKResponse(helloWorldService.createOrModify(helloWorldBO));
    }

    @RequestMapping(value = "save", method = RequestMethod.PUT)
    @ResponseBody
    public Response<HelloWorldBO> update(
        @Valid @RequestBody HelloWorldBO helloWorldBO,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidBindingException(bindingResult);
        }
        return Response.createOKResponse(helloWorldService.createOrModify(helloWorldBO));
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response<String> delete(@PathVariable("id") Long id) {
        return Response.createOKResponse(helloWorldService.delete(id));
    }
}
