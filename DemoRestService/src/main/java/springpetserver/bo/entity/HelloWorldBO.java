package springpetserver.bo.entity;

import springpetserver.bo.BusinessObject;
import springpetserver.entity.HelloWorldEntity;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public class HelloWorldBO
    implements BusinessObject<HelloWorldEntity, Long> {
    private Long id;
    private String name;

    public HelloWorldBO() {

    }

    public HelloWorldBO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String returnModelClassName() {
        return HelloWorldEntity.class.getSimpleName();
    }

    @Override
    public HelloWorldEntity createNewModelEntity() {
        return new HelloWorldEntity();
    }
}
