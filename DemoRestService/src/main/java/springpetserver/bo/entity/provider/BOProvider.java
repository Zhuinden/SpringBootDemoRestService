package springpetserver.bo.entity.provider;

import springpetserver.bo.BusinessObject;

import java.io.Serializable;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public interface BOProvider<M, ID extends Serializable, BO extends BusinessObject<M, ID>> {
    BO create();
    BO createFromModel(M m);
    BO mergeWithModel(BO bo, M m);
}
