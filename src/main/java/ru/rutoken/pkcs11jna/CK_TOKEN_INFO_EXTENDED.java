/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@SuppressWarnings("unused")
/* CK_TOKEN_INFO_EXTENDED provides extended information about a token */
@Structure.FieldOrder({"ulSizeofThisStructure", "ulTokenType", "ulProtocolNumber", "ulMicrocodeNumber",
        "ulOrderNumber", "flags", "ulMaxAdminPinLen", "ulMinAdminPinLen", "ulMaxUserPinLen",
        "ulMinUserPinLen", "ulMaxAdminRetryCount", "ulAdminRetryCountLeft", "ulMaxUserRetryCount",
        "ulUserRetryCountLeft", "serialNumber", "ulTotalMemory", "ulFreeMemory", "ATR", "ulATRLen",
        "ulTokenClass", "ulBatteryVoltage", "ulBodyColor"})
public class CK_TOKEN_INFO_EXTENDED extends Pkcs11Structure {

    /*
     * init this field by size of this structure [in] - size of input structure [out] - return size
     * of filled structure
     */
    public NativeLong ulSizeofThisStructure;
    /*
     * This field is deprecated in Rutoken PKCS11 library version 2.0.5.0 and above.
     * If you need to check current token connection type you should use hardware feature instead.
     */
    public NativeLong ulTokenType; /* see below */
    /* exchange protocol number */
    public NativeLong ulProtocolNumber;
    /* microcode number */
    public NativeLong ulMicrocodeNumber;
    /* order number */
    public NativeLong ulOrderNumber;
    /* information flags */
    /*
     * TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN - Administrator can change User PIN
     * TOKEN_FLAGS_USER_CHANGE_USER_PIN - User can change User PIN
     * TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT - Administrator PIN is not default
     * TOKEN_FLAGS_USER_PIN_NOT_DEFAULT - User PIN is not default
     * TOKEN_FLAGS_SUPPORT_FKN - token supports CryptoPro FKN
     */
    public NativeLong flags; /* see below */
    /* maximum and minimum PIN length */
    public NativeLong ulMaxAdminPinLen;
    public NativeLong ulMinAdminPinLen;
    public NativeLong ulMaxUserPinLen;
    public NativeLong ulMinUserPinLen;
    /* max count of unsuccessful Administrator login attempts */
    public NativeLong ulMaxAdminRetryCount;
    /*
     * count of unsuccessful login attempts left (for Administrator PIN) if field equals 0 - that means
     * that PIN is blocked
     */
    public NativeLong ulAdminRetryCountLeft;
    /* min counts of unsuccessful User login attempts */
    public NativeLong ulMaxUserRetryCount;
    /*
     * count of unsuccessful login attempts left (for User PIN) if field equals 0 - that means that PIN is
     * blocked
     */
    public NativeLong ulUserRetryCountLeft;
    /* token serial number in Big Endian format */
    public byte[] serialNumber = new byte[8];
    /* size of all memory */
    public NativeLong ulTotalMemory; /* in bytes */
    /* size of free memory */
    public NativeLong ulFreeMemory; /* in bytes */
    /* ATR of the token */
    public byte[] ATR = new byte[64];
    /* size of ATR */
    public NativeLong ulATRLen;
    /* class of token */
    public NativeLong ulTokenClass; /* see below */
    /* Battery voltage */
    public NativeLong ulBatteryVoltage; /* microvolts */

    public NativeLong ulBodyColor;

    public CK_TOKEN_INFO_EXTENDED() {
    }

    public CK_TOKEN_INFO_EXTENDED(NativeLong ulSizeofThisStructure, NativeLong ulTokenType, NativeLong ulProtocolNumber,
                                  NativeLong ulMicrocodeNumber, NativeLong ulOrderNumber, NativeLong flags, NativeLong ulMaxAdminPinLen,
                                  NativeLong ulMinAdminPinLen, NativeLong ulMaxUserPinLen, NativeLong ulMinUserPinLen,
                                  NativeLong ulMaxAdminRetryCount, NativeLong ulAdminRetryCountLeft, NativeLong ulMaxUserRetryCount,
                                  NativeLong ulUserRetryCountLeft, byte[] serialNumber, NativeLong ulTotalMemory, NativeLong ulFreeMemory,
                                  byte[] ATR, NativeLong ulATRLen, NativeLong ulTokenClass, NativeLong ulBatteryVoltage, NativeLong ulBodyColor) {
        this.ulSizeofThisStructure = ulSizeofThisStructure;
        this.ulTokenType = ulTokenType;
        this.ulProtocolNumber = ulProtocolNumber;
        this.ulMicrocodeNumber = ulMicrocodeNumber;
        this.ulOrderNumber = ulOrderNumber;
        this.flags = flags;
        this.ulMaxAdminPinLen = ulMaxAdminPinLen;
        this.ulMinAdminPinLen = ulMinAdminPinLen;
        this.ulMaxUserPinLen = ulMaxUserPinLen;
        this.ulMinUserPinLen = ulMinUserPinLen;
        this.ulMaxAdminRetryCount = ulMaxAdminRetryCount;
        this.ulAdminRetryCountLeft = ulAdminRetryCountLeft;
        this.ulMaxUserRetryCount = ulMaxUserRetryCount;
        this.ulUserRetryCountLeft = ulUserRetryCountLeft;
        this.serialNumber = serialNumber;
        this.ulTotalMemory = ulTotalMemory;
        this.ulFreeMemory = ulFreeMemory;
        this.ATR = ATR;
        this.ulATRLen = ulATRLen;
        this.ulTokenClass = ulTokenClass;
        this.ulBatteryVoltage = ulBatteryVoltage;
        this.ulBodyColor = ulBodyColor;
    }
}
