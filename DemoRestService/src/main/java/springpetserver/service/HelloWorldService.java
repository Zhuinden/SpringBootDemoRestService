package springpetserver.service;

import org.springframework.stereotype.Service;
import springpetserver.bo.entity.HelloWorldBO;
import springpetserver.entity.HelloWorldEntity;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public interface HelloWorldService extends DefaultCrudService<HelloWorldEntity, Long, HelloWorldBO> {
}
