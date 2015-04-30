package springpetserver.service.impl;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import org.slf4j.Logger;
import springpetserver.bo.BusinessObject;
import springpetserver.bo.entity.converter.BOtoModelConverter;
import springpetserver.bo.entity.provider.BOProvider;
import springpetserver.bo.entity.validator.BOValidator;
import springpetserver.repository.BaseRepository;
import springpetserver.rest.methods.DefaultControllerMethods;
import springpetserver.service.DefaultCrudService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public abstract class DefaultCrudServiceImpl<M, ID extends Serializable, BO extends BusinessObject<M, ID>>
    implements DefaultCrudService<M, ID, BO> {
    protected abstract DefaultControllerMethods getMethods();

    @Override
    public BO get(ID id) {
        return getMethods().get(id, this);
    }

    @Override
    public List<BO> getAll() {
        return getMethods().getAll(this);
    }

    @Override
    public List<BO> getAll(Predicate predicate) {
        return getMethods().getAll(this, predicate);
    }

    @Override
    public List<BO> getAll(Predicate predicate, OrderSpecifier<?> orderSpecifier) {
        return getMethods().getAll(this, predicate, orderSpecifier);
    }

    @Override
    public BO createOrModify(BO businessObject) {
        return getMethods().createOrModify(businessObject, this);
    }

    @Override
    public List<BO> createOrModifyAll(List<BO> businessObjects) {
        return getMethods().createOrModifyAll(businessObjects, this);
    }

    @Override
    public String delete(ID id) {
        return getMethods().delete(id, this);
    }

    @Override
    public String delete(BO businessObject) {
        return getMethods().delete(businessObject, this);
    }
}
