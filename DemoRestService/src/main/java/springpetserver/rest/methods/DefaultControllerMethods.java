package springpetserver.rest.methods;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springpetserver.bo.BusinessObject;
import springpetserver.bo.response.component.ErrorResponse;
import springpetserver.bo.util.BOListGenerator;
import springpetserver.service.DefaultCrudService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhuinden on 2015.04.30..
 */
@Component
public class DefaultControllerMethods {
    private static final Logger log = LoggerFactory.getLogger(DefaultControllerMethods.class);

    public <M, BO extends BusinessObject<M, ID>, ID extends Serializable> BO save(M model, BO businessObject, DefaultCrudService<M, ID, BO> service) {
        model = service.getConverter().convert(businessObject, model);
        try {
            model = service.getRepository().saveAndFlush(model);
        } catch (Exception e) {
            log.error("An exception occurred while saving entity " + businessObject.returnModelClassName(), e);
            String errMsg = "Exception while trying to save entity " +
                businessObject.returnModelClassName() + " with reason " + e.getMessage();
            throw new RuntimeException(errMsg);
        }
        BO normBO = service.getBOProvider().createFromModel(model);
        return normBO;
    }

    public final <M, ID extends Serializable, BO extends BusinessObject<M, ID>> BO get(ID id, DefaultCrudService<M, ID, BO> service) {
        M model = service.getRepository().findOne(id);
        BO newBusinessObject = service.getBOProvider().createFromModel(model);
        return newBusinessObject;
    }

    public final <M, ID extends Serializable, BO extends BusinessObject<M, ID>> List<BO> getAll(DefaultCrudService<M, ID, BO> service) {
        List<M> modelList = service.getRepository().findAll();
        List<BO> boList = BOListGenerator.createBOList(modelList, service.getBOProvider());
        return boList;
    }

    public final <M, BO extends BusinessObject<M, ID>, ID extends Serializable> List<BO> getAll(DefaultCrudService<M, ID, BO> service, Predicate predicate) {
        Iterable<M> modelList = service.getRepository().findAll(predicate);
        List<BO> boList = BOListGenerator.createBOList(modelList, service.getBOProvider());
        return boList;
    }

    public final <M, BO extends BusinessObject<M, ID>, ID extends Serializable> List<BO> getAll(DefaultCrudService<M, ID, BO> service, Predicate predicate, OrderSpecifier<?> orderSpecifier) {
        Iterable<M> modelList = service.getRepository().findAll(predicate, orderSpecifier);
        List<BO> boList = BOListGenerator.createBOList(modelList, service.getBOProvider());
        return boList;
    }

    @Transactional
    public final <M, BO extends BusinessObject<M, ID>, ID extends Serializable> BO createOrModify(BO businessObject, DefaultCrudService<M, ID, BO> service) {
        if (service.getBOValidator() != null) {
            service.getBOValidator().validate(businessObject);
        }
        M model;
        if (businessObject.getId() != null) {
            model = service.getRepository().findOne(businessObject.getId());
        } else {
            model = businessObject.createNewModelEntity();
        }
        return save(model, businessObject, service);
    }

    @Transactional
    public final <M, BO extends BusinessObject<M, ID>, ID extends Serializable> List<BO> createOrModifyAll(List<BO> businessObjects, DefaultCrudService<M, ID, BO> service) {
        List<BO> responseBOs = new ArrayList<>();
        for (BO businessObject : businessObjects) {
            if (service.getBOValidator() != null) {
                service.getBOValidator().validate(businessObject);
            }
            M model;
            if (businessObject.getId() != null) {
                model = service.getRepository().findOne(businessObject.getId());
            } else {
                model = businessObject.createNewModelEntity();
            }
            model = service.getConverter().convert(businessObject, model);
            try {
                model = service.getRepository().save(model);
            } catch (Exception e) {
                log.error("An exception occurred while saving entity " + businessObject.returnModelClassName(), e);
                String errMsg = "Exception while trying to save entity " +
                    businessObject.returnModelClassName() + " with reason " + e.getMessage();
                throw new RuntimeException(errMsg);
            }
            BO normBO = service.getBOProvider().createFromModel(model);
            responseBOs.add(normBO);
        }
        service.getRepository().flush();
        return responseBOs;
    }

    public final <M, ID extends Serializable, BO extends BusinessObject<M, ID>> String delete(ID id, DefaultCrudService<M, ID, BO> service) {
        M model = service.getRepository().findOne(id);
        service.getRepository().delete(model);
        return "OK";
    }

    @Transactional
    public final <M, ID extends Serializable, BO extends BusinessObject<M, ID>> String delete(BO businessObject, DefaultCrudService<M, ID, BO> service) {
        M model;
        if (businessObject.getId() == null) {
            String errMsg = "Cannot delete entity without id - " + businessObject.returnModelClassName();
            log.error(errMsg);
            throw new RuntimeException(errMsg);
        }
        try {
            model = service.getRepository().findOne(businessObject.getId());
            service.getRepository().delete(model);
        } catch (Exception e) {
            log.error("An exception occurred while delete entity " + businessObject.returnModelClassName(), e);
            String errMsg = "Exception while trying to delete entity " +
                businessObject.returnModelClassName() + " with reason " + e.getMessage();
            throw new RuntimeException(errMsg);
        }
        return "OK";
    }

}
