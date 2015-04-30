package springpetserver.bo.entity.converter;

import org.springframework.stereotype.Component;
import springpetserver.bo.entity.HelloWorldBO;
import springpetserver.entity.HelloWorldEntity;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Component
public class HelloWorldConverter implements BOtoModelConverter<HelloWorldEntity, Long, HelloWorldBO> {
    @Override
    public HelloWorldEntity convert(HelloWorldBO helloWorldBO, HelloWorldEntity helloWorldEntity) {
        helloWorldEntity.setId(helloWorldBO.getId());
        helloWorldEntity.setName(helloWorldBO.getName());
        return helloWorldEntity;
    }
}
