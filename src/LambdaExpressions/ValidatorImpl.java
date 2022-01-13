package LambdaExpressions;

public class ValidatorImpl implements Validator{    //(1)
    @Override
    public boolean validate(int value) {
        return value >= 60;
    }
}
