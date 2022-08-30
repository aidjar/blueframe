package validator;

public interface Validator {
    void validate();
    Validator linkWith(Validator next);
    Validator clearLinks();
    Validator addRule(Rule rule);
    Validator clearRules();

}
