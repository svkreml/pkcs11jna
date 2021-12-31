package svkreml.pkcs11jna;

/**
 * https://www.cryptsoft.com/pkcs11doc/v230/structCK__SLOT__INFO.html
 */
public class CK_SLOT_INFO_FLAGS {
    /**
     * True if a token is present in the slot (e.g., a device is in the reader)
     */
    public static final long CKF_TOKEN_PRESENT = 0x00000001;
    /**
     * True if the reader supports removable devices
     */
    public static final long CKF_REMOVABLE_DEVICE = 0x00000002;
    /**
     * True if the slot is a hardware slot, as opposed to a software slot implementing a "soft token"
     */
    public static final long CKF_HW_SLOT = 0x00000004;

    /**
     * True if a token is present in the slot (e.g., a device is in the reader)
     */
    public final boolean ckfTokenPresent;
    /**
     * True if the reader supports removable devices
     */
    public final boolean ckfRemovableDevice;
    /**
     * True if the slot is a hardware slot, as opposed to a software slot implementing a "soft token"
     */
    public final boolean ckfHwSlot;

    public CK_SLOT_INFO_FLAGS(long flags) {
        ckfTokenPresent = (CKF_TOKEN_PRESENT & flags) == CKF_TOKEN_PRESENT;
        ckfRemovableDevice = (CKF_REMOVABLE_DEVICE & flags) == CKF_REMOVABLE_DEVICE;
        ckfHwSlot = (CKF_HW_SLOT & flags) == CKF_HW_SLOT;

    }
}
