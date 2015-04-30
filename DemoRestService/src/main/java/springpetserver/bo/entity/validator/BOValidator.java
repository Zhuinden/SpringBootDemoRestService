package springpetserver.bo.entity.validator;

import springpetserver.bo.BusinessObject;

import java.io.Serializable;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public interface BOValidator<M, ID extends Serializable, BO extends BusinessObject<M, ID>> {
    void validate(BO businessObject);
}
