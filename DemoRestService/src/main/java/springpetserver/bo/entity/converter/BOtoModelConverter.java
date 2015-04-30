package springpetserver.bo.entity.converter;

import springpetserver.bo.BusinessObject;

import java.io.Serializable;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public interface BOtoModelConverter<MODEL, ID extends Serializable, BO extends BusinessObject<MODEL, ID>> {
    MODEL convert(BO bo, MODEL model);
}
