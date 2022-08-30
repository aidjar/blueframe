package validator;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseValidator implements Validator {

    private List<Rule> rules;
    private BaseValidator next;


    public void validate() {
        doValidate();
        if (next != null) {
            validate();
        }
        clearRules();
        clearLinks();
    }

    public BaseValidator linkWith(BaseValidator next) {
        if (this.next == null) {
            this.next = (BaseValidator) next;
            return this;
        }
        BaseValidator leaf = this.next;
        while (leaf.next != null) {
            leaf = leaf.next;
        }
        leaf.next = (BaseValidator) next;
        return this;
    }

    public BaseValidator clearLinks() {
        next = null;
        return this;
    }

    public BaseValidator addRule(Rule rule) {
        if (rules == null) {
            rules = new ArrayList<>();
        }
        rules.add(rule);
        return this;
    }

    public BaseValidator clearRules() {
        if (rules == null) {
            rules = new ArrayList<>();
        } else {
            rules.clear();
        }
        return this;
    }

    private void doValidate() {
        if (rules != null && !rules.isEmpty()) {
            rules.forEach(r -> r.check());
        }
    }

}
