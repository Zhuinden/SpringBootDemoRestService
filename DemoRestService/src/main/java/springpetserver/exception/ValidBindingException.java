package springpetserver.exception;

import org.springframework.validation.BindingResult;

/**
 * Created by Zhuinden on 2015.04.30..
 */
public class ValidBindingException extends RuntimeException {
    private BindingResult bindingResult;

    public ValidBindingException() {

    }

    public ValidBindingException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
