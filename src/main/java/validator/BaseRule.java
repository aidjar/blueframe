package validator;

import java.util.List;

public abstract class BaseRule <T,S> implements Rule{

    T objectToCheck;
    List<S> objectToCompare;

    public BaseRule(T objectToCheck, List<S> objectToCompare) {
        this.objectToCheck = objectToCheck;
        this.objectToCompare = objectToCompare;
    }
}
