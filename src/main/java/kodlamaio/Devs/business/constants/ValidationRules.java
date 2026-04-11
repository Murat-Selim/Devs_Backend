package kodlamaio.Devs.business.constants;

public final class ValidationRules {

    private ValidationRules() {}

    // Name constraints
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 50;

    // Username constraints
    public static final int USERNAME_MIN_LENGTH = 3;
    public static final int USERNAME_MAX_LENGTH = 50;

    // Password constraints
    public static final int PASSWORD_MIN_LENGTH = 6;
    public static final int PASSWORD_MAX_LENGTH = 100;

    // ID constraints
    public static final int MIN_ID_VALUE = 1;
}
