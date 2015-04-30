package springpetserver.bo.entity.provider;

import springpetserver.bo.BusinessObject;

import java.io.Serializable;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public abstract class AbstractBOProvider<M, ID extends Serializable, BO extends BusinessObject<M,ID>> implements BOProvider<M, ID, BO> {
    @Override
    public BO createFromModel(M m) {
        BO bo = create();
        return mergeWithModel(bo, m);
    }
}
