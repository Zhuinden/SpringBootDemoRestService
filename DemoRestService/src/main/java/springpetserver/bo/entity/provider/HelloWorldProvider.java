package springpetserver.bo.entity.provider;

import org.springframework.stereotype.Component;
import springpetserver.bo.entity.HelloWorldBO;
import springpetserver.entity.HelloWorldEntity;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Component
public class HelloWorldProvider extends AbstractBOProvider<HelloWorldEntity, Long, HelloWorldBO> {
    @Override
    public HelloWorldBO create() {
        return new HelloWorldBO();
    }

    @Override
    public HelloWorldBO mergeWithModel(HelloWorldBO helloWorldBO, HelloWorldEntity helloWorldEntity) {
        helloWorldBO.setName(helloWorldEntity.getName());
        helloWorldBO.setId(helloWorldEntity.getId());
        return helloWorldBO;
    }
}
