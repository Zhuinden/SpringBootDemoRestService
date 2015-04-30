package springpetserver.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springpetserver.bo.entity.HelloWorldBO;
import springpetserver.bo.entity.converter.BOtoModelConverter;
import springpetserver.bo.entity.converter.HelloWorldConverter;
import springpetserver.bo.entity.provider.BOProvider;
import springpetserver.bo.entity.provider.HelloWorldProvider;
import springpetserver.bo.entity.validator.BOValidator;
import springpetserver.bo.entity.validator.HelloWorldValidator;
import springpetserver.entity.HelloWorldEntity;
import springpetserver.repository.BaseRepository;
import springpetserver.repository.HelloWorldRepository;
import springpetserver.rest.methods.DefaultControllerMethods;
import springpetserver.service.HelloWorldService;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Service
public class HelloWorldServiceImpl
    extends DefaultCrudServiceImpl<HelloWorldEntity, Long, HelloWorldBO>
    implements HelloWorldService {
    private final static Logger logger = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Autowired
    private DefaultControllerMethods defaultControllerMethods;

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @Autowired
    private HelloWorldConverter helloWorldConverter;

    @Autowired
    private HelloWorldValidator helloWorldValidator;

    @Autowired
    private HelloWorldProvider helloWorldProvider;

    @Override
    protected DefaultControllerMethods getMethods() {
        return defaultControllerMethods;
    }

    @Override
    public BaseRepository<HelloWorldEntity, Long> getRepository() {
        return helloWorldRepository;
    }

    @Override
    public BOtoModelConverter<HelloWorldEntity, Long, HelloWorldBO> getConverter() {
        return helloWorldConverter;
    }

    @Override
    public BOValidator<HelloWorldEntity, Long, HelloWorldBO> getBOValidator() {
        return helloWorldValidator;
    }

    @Override
    public BOProvider<HelloWorldEntity, Long, HelloWorldBO> getBOProvider() {
        return helloWorldProvider;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
