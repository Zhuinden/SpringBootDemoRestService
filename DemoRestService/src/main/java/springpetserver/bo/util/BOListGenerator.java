package springpetserver.bo.util;

import springpetserver.bo.BusinessObject;
import springpetserver.bo.entity.provider.BOProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public class BOListGenerator {
    public static <M, BO extends BusinessObject<M, ID>, ID extends Serializable> List<BO> createBOList(Iterable<M> modelList, BOProvider<M, ID, BO> boProvider) {
        List<BO> boList = new ArrayList<>();
        for (M model : modelList) {
            boList.add(boProvider.createFromModel(model));
        }
        return boList;
    }
}