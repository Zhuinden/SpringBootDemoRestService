package springpetserver.bo;

import java.io.Serializable;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public interface BusinessObject<M, ID extends Serializable> {
    public ID getId();

    public void setId(ID id);

    public String returnModelClassName();

    public M createNewModelEntity();
}
