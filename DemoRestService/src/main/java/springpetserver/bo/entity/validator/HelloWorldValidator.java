package springpetserver.bo.entity.validator;

import org.springframework.stereotype.Component;
import springpetserver.bo.entity.HelloWorldBO;
import springpetserver.entity.HelloWorldEntity;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Component
public class HelloWorldValidator implements BOValidator<HelloWorldEntity, Long, HelloWorldBO> {
    @Override
    public void validate(HelloWorldBO businessObject) {
    }
}
