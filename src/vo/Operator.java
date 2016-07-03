package vo;

public enum Operator {
    PLUS("+") {
        @Override
        public String operate(String a, String b) {
            return Float.toString(Float.parseFloat(a) + Float.parseFloat(b));
        }
    },
    MINUS("-") {
        @Override
        public String operate(String a, String b) {
            return Float.toString(Float.parseFloat(a) - Float.parseFloat(b));
        }
    },
    MULTIPLY("*") {
        @Override
        public String operate(String a, String b) {
            return Float.toString(Float.parseFloat(a) * Float.parseFloat(b));
        }
    },
    DIVIDE("/") {
        @Override
        public String operate(String a, String b) {
            return Float.toString(Float.parseFloat(a) / Float.parseFloat(b));
        }
    };

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract String operate(String a, String b);

    public static Operator getOperator(String s) {
        for (Operator o : Operator.values()) {
            if (o.operator.equals(s))
                return o;
        }
        throw new IllegalArgumentException("Not a valid operator: "+s);
    }

    public static boolean isOperator(String s) {
        for (Operator o : Operator.values()) {
            if (o.operator.equals(s))
                return true;
        }
        return false;
    }
}
