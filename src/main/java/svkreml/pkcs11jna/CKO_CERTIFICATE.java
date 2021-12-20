/*
 *  Copyright (c) 2021, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 *  All Rights Reserved.
 *
 */

package svkreml.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;
import ru.rutoken.pkcs11jna.CK_DATE;
import ru.rutoken.pkcs11jna.Pkcs11Structure;


@SuppressWarnings("unused")
@Structure.FieldOrder({"CKA_CERTIFICATE_TYPE", "CKA_TRUSTED", "CKA_CERTIFICATE_CATEGORY", "CKA_CHECK_VALUE",
        "CKA_START_DATE", "CKA_END_DATE", "CKA_SUBJECT", "CKA_ID", "CKA_ISSUER", "CKA_SERIAL_NUMBER", "CKA_VALUE"})
public class CKO_CERTIFICATE extends Pkcs11Structure {
    /**
     * CK_CERTIFICATE_TYPE
     * Тип сертификата (CKC_X_509)
     */
    public NativeLong CKA_CERTIFICATE_TYPE;
    /**
     * CK_BBOOL
     * Сертификат является доверенным для приложения, которым был создан. Создание сертификата с атрибутом
     * CKA_TRUSTED требует SO PIN
     */
    public boolean CKA_TRUSTED;
    /**
     * CK_ULONG
     * Значение атрибута будет возвращаться при чтении, только если атрибут был задан при создании объекта.
     * Если при создании объекта атрибут не был задан, при попытке его чтения возвращается ошибка CKR_ATTRIBUTE_INVALID
     */
    public NativeLong CKA_CERTIFICATE_CATEGORY;
    /**
     * Byte array
     * Контрольная сумма
     */
    public byte[] CKA_CHECK_VALUE;
    /**
     * CK_DATE
     * Дата начала действия (по умолчанию пусто)
     */
    public CK_DATE CKA_START_DATE;
    /**
     * CK_DATE
     * Дата окончания действия (по умолчанию пусто)
     */
    public CK_DATE CKA_END_DATE;
    /**
     * Byte Array
     * Имя Subject сертификата в кодировке DER
     * Переданные значения атрибутов CKA_SUBJECT при создании
     * игнорируются и подставляются автоматически из переданного сертификата.
     */
    public byte[] CKA_SUBJECT;
    /**
     * Byte array
     * Идентификатор ключевой пары (по умолчанию пусто)
     */
    public byte[] CKA_ID;
    /**
     * Byte array
     * Имя издателя сертификата в кодировке DER
     * Переданные значения атрибутов CKA_ISSUER при создании
     * игнорируются и подставляются автоматически из переданного сертификата.
     */
    public byte[] CKA_ISSUER;
    /**
     * Byte array
     * Серийный номер сертификата в кодировке DER
     * Переданные значения атрибутовCKA_SERIAL_NUMBER при создании
     * игнорируются и подставляются автоматически из переданного сертификата.
     */
    public byte[] CKA_SERIAL_NUMBER;
    /**
     * Byte array
     * Значение в кодировке BER
     */
    public byte[] CKA_VALUE;


    public CKO_CERTIFICATE() {
    }

    public CKO_CERTIFICATE(
            NativeLong CKA_CERTIFICATE_TYPE,
            boolean CKA_TRUSTED,
            NativeLong CKA_CERTIFICATE_CATEGORY,
            byte[] CKA_CHECK_VALUE,
            CK_DATE CKA_START_DATE,
            CK_DATE CKA_END_DATE,
            byte[] CKA_SUBJECT,
            byte[] CKA_ID,
            byte[] CKA_ISSUER,
            byte[] CKA_SERIAL_NUMBER,
            byte[] CKA_VALUE) {
        this.CKA_CERTIFICATE_TYPE = CKA_CERTIFICATE_TYPE;
        this.CKA_TRUSTED = CKA_TRUSTED;
        this.CKA_CERTIFICATE_CATEGORY = CKA_CERTIFICATE_CATEGORY;
        this.CKA_CHECK_VALUE = CKA_CHECK_VALUE;
        this.CKA_START_DATE = CKA_START_DATE;
        this.CKA_END_DATE = CKA_END_DATE;
        this.CKA_SUBJECT = CKA_SUBJECT;
        this.CKA_ID = CKA_ID;
        this.CKA_ISSUER = CKA_ISSUER;
        this.CKA_SERIAL_NUMBER = CKA_SERIAL_NUMBER;
        this.CKA_VALUE = CKA_VALUE;
    }
}
