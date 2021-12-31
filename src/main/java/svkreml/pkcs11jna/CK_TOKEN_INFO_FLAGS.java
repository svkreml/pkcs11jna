package svkreml.pkcs11jna;

/**
 * https://www.cryptsoft.com/pkcs11doc/v220/structCK__TOKEN__INFO.html
 */
public class CK_TOKEN_INFO_FLAGS {
    /**
     * True if the token has its own random number generator
     */
    public static final long CKF_RNG = 0x00000001;
    /**
     * True if the token is write-protected (see below)
     */
    public static final long CKF_WRITE_PROTECTED = 0x00000002;
    /**
     * True if there are some cryptographic functions that a user must be logged in to perform
     */
    public static final long CKF_LOGIN_REQUIRED = 0x00000004;
    /**
     * True if the normal user's PIN has been initialized
     */
    public static final long CKF_USER_PIN_INITIALIZED = 0x00000008;
    /**
     * True if a successful save of a session's cryptographic operations state always contains all keys needed to restore the state of the session
     */
    public static final long CKF_RESTORE_KEY_NOT_NEEDED = 0x00000020;
    /**
     * True if token has its own hardware clock
     */
    public static final long CKF_CLOCK_ON_TOKEN = 0x00000040;
    /**
     * True if token has a "protected authentication path", whereby a user can log into the token without passing a PIN through the Cryptoki library
     */
    public static final long CKF_PROTECTED_AUTHENTICATION_PATH = 0x00000100;
    /**
     * True if a single session with the token can perform dual cryptographic operations (see Section 11.13)
     */
    public static final long CKF_DUAL_CRYPTO_OPERATIONS = 0x00000200;
    /**
     * True if the token has been initialized using C_InitializeToken or an equivalent mechanism outside the scope of this standard. Calling C_InitializeToken when this flag is set will cause the token to be reinitialized.
     */
    public static final long CKF_TOKEN_INITIALIZED = 0x00000400;
    /**
     * True if the token supports secondary authentication for private key objects. (Deprecated; new implementations MUST NOT set this flag)
     */
    public static final long CKF_SECONDARY_AUTHENTICATION = 0x00000800;
    /**
     * True if an incorrect user login PIN has been entered at least once since the last successful authentication.
     */
    public static final long CKF_USER_PIN_COUNT_LOW = 0x00010000;
    /**
     * True if supplying an incorrect user PIN will it to become locked.
     */
    public static final long CKF_USER_PIN_FINAL_TRY = 0x00020000;
    /**
     * True if the user PIN has been locked. User login to the token is not possible.
     */
    public static final long CKF_USER_PIN_LOCKED = 0x00040000;
    /**
     * True if the user PIN value is the default value set by token initialization or manufacturing, or the PIN has been expired by the card.
     */
    public static final long CKF_USER_PIN_TO_BE_CHANGED = 0x00080000;
    /**
     * True if an incorrect SO login PIN has been entered at least once since the last successful authentication.
     */
    public static final long CKF_SO_PIN_COUNT_LOW = 0x00100000;
    /**
     * True if supplying an incorrect SO PIN will it to become locked.
     */
    public static final long CKF_SO_PIN_FINAL_TRY = 0x00200000;
    /**
     * True if the SO PIN has been locked. User login to the token is not possible.
     */
    public static final long CKF_SO_PIN_LOCKED = 0x00400000;
    /**
     * True if the SO PIN value is the default value set by token initialization or manufacturing, or the PIN has been expired by the card.
     */
    public static final long CKF_SO_PIN_TO_BE_CHANGED = 0x00800000;
    /**
     * True if the token has its own random number generator
     */
    public final boolean ckfRng;
    /**
     * True if the token is write-protected (see below)
     */
    public final boolean ckfWriteProtected;
    /**
     * True if there are some cryptographic functions that a user must be logged in to perform
     */
    public final boolean ckfLoginRequired;
    /**
     * True if the normal user's PIN has been initialized
     */
    public final boolean ckfUserPinInitialized;
    /**
     * True if a successful save of a session's cryptographic operations state always contains all keys needed to restore the state of the session
     */
    public final boolean ckfRestoreKeyNotNeeded;
    /**
     * True if token has its own hardware clock
     */
    public final boolean ckfClockOnToken;
    /**
     * True if token has a "protected authentication path", whereby a user can log into the token without passing a PIN through the Cryptoki library
     */
    public final boolean ckfProtectedAuthenticationPath;
    /**
     * True if a single session with the token can perform dual cryptographic operations (see Section 11.13)
     */
    public final boolean ckfDualCryptoOperations;
    /**
     * True if the token has been initialized using C_InitializeToken or an equivalent mechanism outside the scope of this standard. Calling C_InitializeToken when this flag is set will cause the token to be reinitialized.
     */
    public final boolean ckfTokenInitialized;
    /**
     * True if the token supports secondary authentication for private key objects. (Deprecated; new implementations MUST NOT set this flag)
     */
    public final boolean ckfSecondaryAuthentication;
    /**
     * True if an incorrect user login PIN has been entered at least once since the last successful authentication.
     */
    public final boolean ckfUserPinCountLow;
    /**
     * True if supplying an incorrect user PIN will it to become locked.
     */
    public final boolean ckfUserPinFinalTry;
    /**
     * True if the user PIN has been locked. User login to the token is not possible.
     */
    public final boolean ckfUserPinLocked;
    /**
     * True if the user PIN value is the default value set by token initialization or manufacturing, or the PIN has been expired by the card.
     */
    public final boolean ckfUserPinToBeChanged;
    /**
     * True if an incorrect SO login PIN has been entered at least once since the last successful authentication.
     */
    public final boolean ckfSoPinCountLow;
    /**
     * True if supplying an incorrect SO PIN will it to become locked.
     */
    public final boolean ckfSoPinFinalTry;
    /**
     * True if the SO PIN has been locked. User login to the token is not possible.
     */
    public final boolean ckfSoPinLocked;
    /**
     * True if the SO PIN value is the default value set by token initialization or manufacturing, or the PIN has been expired by the card.
     */
    public final boolean ckfSoPinToBeChanged;

    public CK_TOKEN_INFO_FLAGS(long flags) {
        ckfRng = (CKF_RNG & flags) == CKF_RNG;
        ckfWriteProtected = (CKF_WRITE_PROTECTED & flags) == CKF_WRITE_PROTECTED;
        ckfLoginRequired = (CKF_LOGIN_REQUIRED & flags) == CKF_LOGIN_REQUIRED;
        ckfUserPinInitialized = (CKF_USER_PIN_INITIALIZED & flags) == CKF_USER_PIN_INITIALIZED;
        ckfRestoreKeyNotNeeded = (CKF_RESTORE_KEY_NOT_NEEDED & flags) == CKF_RESTORE_KEY_NOT_NEEDED;
        ckfClockOnToken = (CKF_CLOCK_ON_TOKEN & flags) == CKF_CLOCK_ON_TOKEN;
        ckfProtectedAuthenticationPath = (CKF_PROTECTED_AUTHENTICATION_PATH & flags) == CKF_PROTECTED_AUTHENTICATION_PATH;
        ckfDualCryptoOperations = (CKF_DUAL_CRYPTO_OPERATIONS & flags) == CKF_DUAL_CRYPTO_OPERATIONS;
        ckfTokenInitialized = (CKF_TOKEN_INITIALIZED & flags) == CKF_TOKEN_INITIALIZED;
        ckfSecondaryAuthentication = (CKF_SECONDARY_AUTHENTICATION & flags) == CKF_SECONDARY_AUTHENTICATION;
        ckfUserPinCountLow = (CKF_USER_PIN_COUNT_LOW & flags) == CKF_USER_PIN_COUNT_LOW;
        ckfUserPinFinalTry = (CKF_USER_PIN_FINAL_TRY & flags) == CKF_USER_PIN_FINAL_TRY;
        ckfUserPinLocked = (CKF_USER_PIN_LOCKED & flags) == CKF_USER_PIN_LOCKED;
        ckfUserPinToBeChanged = (CKF_USER_PIN_TO_BE_CHANGED & flags) == CKF_USER_PIN_TO_BE_CHANGED;
        ckfSoPinCountLow = (CKF_SO_PIN_COUNT_LOW & flags) == CKF_SO_PIN_COUNT_LOW;
        ckfSoPinFinalTry = (CKF_SO_PIN_FINAL_TRY & flags) == CKF_SO_PIN_FINAL_TRY;
        ckfSoPinLocked = (CKF_SO_PIN_LOCKED & flags) == CKF_SO_PIN_LOCKED;
        ckfSoPinToBeChanged = (CKF_SO_PIN_TO_BE_CHANGED & flags) == CKF_SO_PIN_TO_BE_CHANGED;
    }

    @Override
    public String toString() {
        return "CK_TOKEN_INFO_FLAGS{" +
                "ckfRng=" + ckfRng +
                ", ckfWriteProtected=" + ckfWriteProtected +
                ", ckfLoginRequired=" + ckfLoginRequired +
                ", ckfUserPinInitialized=" + ckfUserPinInitialized +
                ", ckfRestoreKeyNotNeeded=" + ckfRestoreKeyNotNeeded +
                ", ckfClockOnToken=" + ckfClockOnToken +
                ", ckfProtectedAuthenticationPath=" + ckfProtectedAuthenticationPath +
                ", ckfDualCryptoOperations=" + ckfDualCryptoOperations +
                ", ckfTokenInitialized=" + ckfTokenInitialized +
                ", ckfSecondaryAuthentication=" + ckfSecondaryAuthentication +
                ", ckfUserPinCountLow=" + ckfUserPinCountLow +
                ", ckfUserPinFinalTry=" + ckfUserPinFinalTry +
                ", ckfUserPinLocked=" + ckfUserPinLocked +
                ", ckfUserPinToBeChanged=" + ckfUserPinToBeChanged +
                ", ckfSoPinCountLow=" + ckfSoPinCountLow +
                ", ckfSoPinFinalTry=" + ckfSoPinFinalTry +
                ", ckfSoPinLocked=" + ckfSoPinLocked +
                ", ckfSoPinToBeChanged=" + ckfSoPinToBeChanged +
                '}';
    }

    public boolean isCkfRng() {
        return ckfRng;
    }

    public boolean isCkfWriteProtected() {
        return ckfWriteProtected;
    }

    public boolean isCkfLoginRequired() {
        return ckfLoginRequired;
    }

    public boolean isCkfUserPinInitialized() {
        return ckfUserPinInitialized;
    }

    public boolean isCkfRestoreKeyNotNeeded() {
        return ckfRestoreKeyNotNeeded;
    }

    public boolean isCkfClockOnToken() {
        return ckfClockOnToken;
    }

    public boolean isCkfProtectedAuthenticationPath() {
        return ckfProtectedAuthenticationPath;
    }

    public boolean isCkfDualCryptoOperations() {
        return ckfDualCryptoOperations;
    }

    public boolean isCkfTokenInitialized() {
        return ckfTokenInitialized;
    }

    public boolean isCkfSecondaryAuthentication() {
        return ckfSecondaryAuthentication;
    }

    public boolean isCkfUserPinCountLow() {
        return ckfUserPinCountLow;
    }

    public boolean isCkfUserPinFinalTry() {
        return ckfUserPinFinalTry;
    }

    public boolean isCkfUserPinLocked() {
        return ckfUserPinLocked;
    }

    public boolean isCkfUserPinToBeChanged() {
        return ckfUserPinToBeChanged;
    }

    public boolean isCkfSoPinCountLow() {
        return ckfSoPinCountLow;
    }

    public boolean isCkfSoPinFinalTry() {
        return ckfSoPinFinalTry;
    }

    public boolean isCkfSoPinLocked() {
        return ckfSoPinLocked;
    }

    public boolean isCkfSoPinToBeChanged() {
        return ckfSoPinToBeChanged;
    }


}





















