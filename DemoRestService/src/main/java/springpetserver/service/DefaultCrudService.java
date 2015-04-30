package springpetserver.service;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import org.slf4j.Logger;
import springpetserver.bo.BusinessObject;
import springpetserver.bo.entity.converter.BOtoModelConverter;
import springpetserver.bo.entity.provider.BOProvider;
import springpetserver.bo.entity.validator.BOValidator;
import springpetserver.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public interface DefaultCrudService<M, ID extends Serializable, BO extends BusinessObject<M, ID>> {
    BaseRepository<M, ID> getRepository();

    BOtoModelConverter<M, ID, BO> getConverter();
    BOValidator<M, ID, BO> getBOValidator();
    BOProvider<M, ID, BO> getBOProvider();
    Logger getLogger();

    BO get(ID id);

    List<BO> getAll();

    List<BO> getAll(Predicate predicate);

    List<BO> getAll(Predicate predicate, OrderSpecifier<?> orderSpecifier);

    BO createOrModify(BO businessObject);

    List<BO> createOrModifyAll(List<BO> businessObjects);

    String delete(ID id);

    String delete(BO businessObject);
}
