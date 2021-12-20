package svkreml.pkcs11jna;


import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKR_VENDOR_DEFINED;

/*
 * по документации:
 * https://esmart.ru/upload/iblock/0c3/esmart_token_gost_developer_guide.pdf
 * https://esmart.ru/upload/iblock/765/v6.P11_RusExt_12.pdf
 *
 * https://esmart.ru/download/
 */
@SuppressWarnings("unused")
public interface EsmartPkcs11Constants {

    /**
     * Ошибка может возвращаться при создании объектов любого типа, если передано слишком много атрибутов.
     */
    long CKR_VENDOR_TOO_MANY_ATTRIBUTES = (CKR_VENDOR_DEFINED | 0x0001);

    /**
     * для индикации проблем с параметрами dn C_ISBC_CreateCSR.
     */
    long CKR_VENDOR_CREATECSR_DN = (CKR_VENDOR_DEFINED | 0x0301);

    /**
     * для индикации проблем с параметрами  attrs C_ISBC_CreateCSR.
     */
    long CKR_VENDOR_CREATECSR_ATTR = (CKR_VENDOR_DEFINED | 0x0302);

    /**
     * для индикации проблем с параметрами exts C_ISBC_CreateCSR.
     */
    long CKR_VENDOR_CREATECSR_EXT = (CKR_VENDOR_DEFINED | 0x0303);

    /**
     * в случае, когда функция C_ISBC_ScribbleRead не находит файл истории.
     */
    long CKR_VENDOR_SCRIB_NOT_FOUND = (CKR_VENDOR_DEFINED | 0x0101);

    /**
     * Срок действия сертификата, который предполагается использовать для подписи, истек. Может возвращаться функцией C_ISBC_pkcs7Sign.
     */
    long CKR_VENDOR_CERT_EXPIRED = (CKR_VENDOR_DEFINED | 0x0600);

    /**
     * Ошибка, возвращаемая функциями C_ISBC_CertVerify и C_ISBC_pkcs7VerifyEx.
     * Для функции проверки цепочки сертификатов C_ISBC_CertVerify всегда возвращается только общий код ошибки.
     * Для функции проверки электронной подписи C_ISBC_pkcs7VerifyEx, финальный код ошибки является конкатенацией кода CKR_VENDOR_VERIFY_ERR и соответствующей специфической ошибки,
     * приведенной в разделе 10.1.
     */
    long CKR_VENDOR_VERIFY_ERR = (CKR_VENDOR_DEFINED | 0x0500);

}
