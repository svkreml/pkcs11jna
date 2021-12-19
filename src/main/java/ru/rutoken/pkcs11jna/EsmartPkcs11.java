/*
 *  Copyright (c) 2021, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 *  All Rights Reserved.
 *
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;

public interface EsmartPkcs11 extends Pkcs11 {
    /**
     * @param slotID     ID слота/считывателя смарт-карт;
     * @param pPin       значение SO PIN;
     * @param ulPinLen   длина pPin;
     * @param pLabel     метка токена;
     * @param bSoPinRc   число попыток ввода неверного SO PIN подряд. Фиксированное значение, равное 10 попыткам, задавать значения бесполезно
     * @param bUserPinRc число попыток ввода неверного User PIN подряд. Значение должно быть в
     *                   диапазоне >0 и <= 254. Таким образом, максимальное значение количества попыток равно 254.
     *                   Полностью снять ограничение на количество попыток ввода неверного
     *                   ПИН-кода пользователя подряд невозможно.
     * @return CKR_OK – функция выполнена успешно.
     */
    NativeLong C_ISBC_InitToken
    (
            NativeLong /*CK_SLOT_ID*/ slotID,
            byte[] /*CK_UTF8CHAR_PTR*/ pPin,
            NativeLong /*CK_ULONG*/ ulPinLen,
            byte[] /*CK_UTF8CHAR_PTR*/ pLabel,
            byte /*CK_BYTE*/ bSoPinRc,
            byte /*CK_BYTE*/ bUserPinRc
    );


}
