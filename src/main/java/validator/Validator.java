package validator;

public abstract class Validator<T extends Rule> {

    T rule;
    Validator<T> next;

    public void validate() {
        if (next != null) {
            validate();
        }
        rule.check();
    }

    public Validator<T> linkWith(Validator<T> next) {
        if (this.next == null) {
            this.next = next;
            return this;
        }
        Validator<T> leaf = this.next;
        while (leaf.next != null) {
            leaf = leaf.next;
        }
        leaf.next = next;
        return this;
    }

}
