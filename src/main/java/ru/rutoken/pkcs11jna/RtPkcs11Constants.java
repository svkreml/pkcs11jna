/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;

/* Derived from rtpkcs11t.h include file for PKCS #11. */

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */
@SuppressWarnings("unused")
public final class RtPkcs11Constants {

    public static final long CKR_CORRUPTED_MAPFILE = Pkcs11Constants.CKR_VENDOR_DEFINED + 1L;


    /*-----------------------------------------------------------------*/
    /* Расширенные коды ошибок                                         */
    /*-----------------------------------------------------------------*/
    public static final long CKR_WRONG_VERSION_FIELD = Pkcs11Constants.CKR_VENDOR_DEFINED + 2L;
    public static final long CKR_WRONG_PKCS1_ENCODING = Pkcs11Constants.CKR_VENDOR_DEFINED + 3L;
    public static final long CKR_RTPKCS11_DATA_CORRUPTED = Pkcs11Constants.CKR_VENDOR_DEFINED + 4L;
    public static final long CKR_RTPKCS11_RSF_DATA_CORRUPTED = Pkcs11Constants.CKR_VENDOR_DEFINED + 5L;
    public static final long CKR_SM_PASSWORD_INVALID = Pkcs11Constants.CKR_VENDOR_DEFINED + 6L;
    public static final long CKR_LICENSE_READ_ONLY = Pkcs11Constants.CKR_VENDOR_DEFINED + 7L;
    public static final long CKR_CERT_CHAIN_NOT_VERIFIED = Pkcs11Constants.CKR_VENDOR_DEFINED + 9L;
    public static final long NSSCK_VENDOR_PKCS11_RU_TEAM = (Pkcs11Constants.CKR_VENDOR_DEFINED | 0x54321000L);

    /*-----------------------------------------------------------------*/
    /* Необходимые определения для работы с расширениями PKCS для ГОСТ */
    /*-----------------------------------------------------------------*/
    public static final long CK_VENDOR_PKCS11_RU_TEAM_TK26 = NSSCK_VENDOR_PKCS11_RU_TEAM;
    /* GOST KEY TYPES */
    public static final long CKK_GOSTR3410 = 0x00000030L;
    public static final long CKK_GOSTR3411 = 0x00000031L;
    public static final long CKK_GOST28147 = 0x00000032L;
    public static final long CKK_GOSTR3410_512 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x003L);
    /* GOST OBJECT ATTRIBUTES */
    public static final long CKA_GOSTR3410_PARAMS = 0x00000250L;
    public static final long CKA_GOSTR3411_PARAMS = 0x00000251L;
    public static final long CKA_GOST28147_PARAMS = 0x00000252L;
    /* GOST MECHANISMS */
    public static final long CKM_GOSTR3410_KEY_PAIR_GEN = 0x00001200L;
    public static final long CKM_GOSTR3410 = 0x00001201L;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411 = 0x00001202L;
    public static final long CKM_GOSTR3410_KEY_WRAP = 0x00001203L;
    public static final long CKM_GOSTR3410_DERIVE = 0x00001204L;
    public static final long CKM_GOSTR3410_512_KEY_PAIR_GEN = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x005L);
    public static final long CKM_GOSTR3410_512 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x006L);
    public static final long CKM_GOSTR3410_12_DERIVE = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x007L);
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_12_256 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x008L);
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_12_512 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x009L);
    public static final long CKM_GOSTR3411 = 0x00001210L;
    public static final long CKM_GOSTR3411_HMAC = 0x00001211L;
    public static final long CKM_GOSTR3411_12_256 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x012L);
    public static final long CKM_GOSTR3411_12_512 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x013L);
    public static final long CKM_GOSTR3411_12_256_HMAC = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x014L);
    public static final long CKM_GOSTR3411_12_512_HMAC = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x015L);
    public static final long CKM_GOST28147_KEY_GEN = 0x00001220L;
    public static final long CKM_GOST28147_ECB = 0x00001221L;
    public static final long CKM_GOST28147 = 0x00001222L;
    public static final long CKM_GOST28147_MAC = 0x00001223L;
    public static final long CKM_GOST28147_KEY_WRAP = 0x00001224L;
    public static final long CKM_KDF_4357 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x025L);
    public static final long CKM_KDF_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TK26 | 0x026L);
    public static final long CKD_CPDIVERSIFY_KDF = 0x00000009L;
    public static final long CKP_PKCS5_PBKD2_HMAC_GOSTR3411 = 0x00000002L;
    /* Token flags (field "flags" from CK_TOKEN_INFO_EXTENDED +
     * field "ChangeUserPINPolicy" from CK_RUTOKEN_INIT_PARAM) */
    /* TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN - if it is set, that
     * means that Administrator (SO) can change User PIN
     */
    public static final long TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN = 0x00000001L;
    /* TOKEN_FLAGS_USER_CHANGE_USER_PIN - if it is set, that
     * means that User can change User PIN
     */
    public static final long TOKEN_FLAGS_USER_CHANGE_USER_PIN = 0x00000002L;
    /* TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT - if it is set, that
     * means that current Administrator (SO) PIN is not default
     */
    public static final long TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT = 0x00000004L;
    /* TOKEN_FLAGS_USER_PIN_NOT_DEFAULT - if it is set, that
     * means that current User PIN is not default
     */
    public static final long TOKEN_FLAGS_USER_PIN_NOT_DEFAULT = 0x00000008L;
    /* TOKEN_FLAGS_SUPPORT_FKN - if it is set, that
     * means that token support CryptoPro FKN
     */
    public static final long TOKEN_FLAGS_SUPPORT_FKN = 0x00000010L;
    /* TOKEN_FLAGS_SUPPORT_SM - if it is set, that
     * means that token supports Secure Messaging.
     * DEPRECATED: use TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING instead.
     */
    public static final long TOKEN_FLAGS_SUPPORT_SM = 0x00000040L;
    /* TOKEN_FLAGS_HAS_FLASH_DRIVE - if it is set, that means
     * that token has Flash Drive
     */
    public static final long TOKEN_FLAGS_HAS_FLASH_DRIVE = 0x00000080L;
    /* TOKEN_FLAGS_CAN_CHANGE_SM_MODE - if it is set, that means
     * that token can be formatted to support SM. This flag
     * is deprecated, use TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING
     * instead.
     */
    public static final long TOKEN_FLAGS_CAN_CHANGE_SM_MODE = 0x00000100L;
    /* TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING - if it is set, that
     * means that token supports Secure Messaging
     */
    public static final long TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING = 0x00000100L;
    /* TOKEN_FLAGS_HAS_BUTTON - if it is set, that means
     * that token is Rutoken Touch
     */
    public static final long TOKEN_FLAGS_HAS_BUTTON = 0x00000200L;
    /* TOKEN_FLAGS_SUPPORT_JOURNAL - if it is set, that means
     * that token supports journal
     */
    public static final long TOKEN_FLAGS_SUPPORT_JOURNAL = 0x00000400L;
    /* TOKEN_FLAGS_USER_PIN_UTF8 - if it is set, that means
     * that user PIN in UTF-8
     */
    public static final long TOKEN_FLAGS_USER_PIN_UTF8 = 0x00000800L;
    /* TOKEN_FLAGS_ADMIN_PIN_UTF8 - if it is set, that means
     * that admin PIN in UTF-8
     */
    public static final long TOKEN_FLAGS_ADMIN_PIN_UTF8 = 0x00001000L;
    /* TOKEN_FLAGS_FW_CHECKSUM_UNAVAILIBLE - if it is set, that
     * means Token does not support firmware checksum request
     * and 'ulFirmwareChecksum' can not be used
     */
    public static final long TOKEN_FLAGS_FW_CHECKSUM_UNAVAILIBLE = 0x40000000L;
    /* TOKEN_FLAGS_FW_CHECKSUM_INVALID - if it is set, that
     * means that 'ulFirmwareChecksum' field contains different
     * from the reference (stored at Token) firmware checksum
     */
    public static final long TOKEN_FLAGS_FW_CHECKSUM_INVALID = 0x80000000L;
    /*
     * Token types (CK_TOKEN_INFO_EXTENDED field "ulTokenType")
     * CK_TOKEN_INFO_EXTENDED's field ulTokenType is deprecated.
     */
    public static final long TOKEN_TYPE_UNKNOWN = 0xFFL;
    public static final long TOKEN_TYPE_RUTOKEN_ECP = 0x01L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE = 0x02L;
    public static final long TOKEN_TYPE_RUTOKEN = 0x03L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_USB = 0x09L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_BT = 0x69L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_UART = 0xA9L;
    public static final long TOKEN_TYPE_RUTOKEN_SC_JC = 0x41L;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_SC = TOKEN_TYPE_RUTOKEN_SC_JC;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_NFC = 0xC1L;
    public static final long TOKEN_TYPE_RUTOKEN_SCDUAL = 0x49L;
    public static final long TOKEN_TYPE_RUTOKEN_SCDUAL_NFC = 0xC9L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE_SC_JC = 0x42L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON = 0x05L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SC = 0x45L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SCDUAL = 0x4DL;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SCDUAL_NFC = 0xCDL;
    public static final long TOKEN_TYPE_RUTOKEN_PINPAD_FAMILY = 0x04L;
    public static final long TOKEN_TYPE_RUTOKEN_WEB = 0x23L;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_SD = 0x81L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE_SD = 0x82L;
    /*
     * Token class (CK_TOKEN_INFO_EXTENDED field "ulTokenClass")
     */
    public static final long TOKEN_CLASS_UNKNOWN = 0xFFFFFFFFL;
    public static final long TOKEN_CLASS_S = 0x00L;
    public static final long TOKEN_CLASS_ECP = 0x01L;
    public static final long TOKEN_CLASS_LITE = 0x02L;
    public static final long TOKEN_CLASS_ECP_BT = 0x09L;
    /* Deprecated */
    public static final long TOKEN_CLASS_WEB = 0x03L;
    public static final long TOKEN_CLASS_PINPAD = 0x04L;
    public static final long TOKEN_CLASS_ECPDUAL = TOKEN_CLASS_ECP_BT;
    /* Body color of the token */
    public static final long TOKEN_BODY_COLOR_UNKNOWN = 0L;
    public static final long TOKEN_BODY_COLOR_WHITE = 1L;
    public static final long TOKEN_BODY_COLOR_BLACK = 2L;
    /* Access modes for TM2 */
    public static final long ACCESS_MODE_HIDDEN = 0x00000000L;
    public static final long ACCESS_MODE_RO = 0x00000001L;
    public static final long ACCESS_MODE_RW = 0x00000003L;
    public static final long ACCESS_MODE_CD = 0x00000005L;
    /* PKCS7 constants */
    public static final long CKF_VENDOR_DO_NOT_USE_INTERNAL_CMS_CERTS = 0x00000001L;
    public static final long CKF_VENDOR_ALLOW_PARTIAL_CHAINS = 0x00000002L;
    public static final long OPTIONAL_CRL_CHECK = 0x00000000L;
    public static final long LEAF_CRL_CHECK = 0x00000001L;
    public static final long ALL_CRL_CHECK = 0x00000002L;

    private RtPkcs11Constants() {
    }

    /**
     * Функция для сравнения констант с возвращаемым из pkcs значением
     */
    public static boolean equalsPkcsRV(long l, NativeLong pkcsRV) {
        return NativeComparator.isRawUnsignedNativeLongEqualsLong(pkcsRV, l);
    }
}
