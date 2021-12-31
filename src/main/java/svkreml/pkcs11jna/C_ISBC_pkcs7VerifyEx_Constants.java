package svkreml.pkcs11jna;

import com.sun.jna.NativeLong;
import ru.rutoken.pkcs11jna.NativeComparator;

/*
 * по документации:
 * https://esmart.ru/upload/iblock/0c3/esmart_token_gost_developer_guide.pdf
 * https://esmart.ru/upload/iblock/765/v6.P11_RusExt_12.pdf
 *
 * https://esmart.ru/download/
 */
@SuppressWarnings("unused")
public interface C_ISBC_pkcs7VerifyEx_Constants {

    /**
     * Не найден сертификат издателя (корневой или промежуточный сертификат в цепочке)
     */
    long X509_V_ERR_UNABLE_TO_GET_ISSUER_CERT = 0x02;

    /**
     * Не найден список отзыва (CRL) для сертификата
     */
    long X509_V_ERR_UNABLE_TO_GET_CRL = 0x03;

    /**
     * Невозможно расшифровать подпись сертификата. Это значит, что невозможно получить
     * само значение подписи, а не то, что это значение не соответствует ожидаемому. Применяется только для алгоритма RSA
     */
    long X509_V_ERR_UNABLE_TO_DECRYPT_CERT_SIGNATURE = 0x04;

    /**
     * Невозможно расшифровать подпись CRL. Это значит, что невозможно получить само значение подписи, а не то,
     * что это значение не соответствует ожидаемому. Не используется
     */
    long X509_V_ERR_UNABLE_TO_DECRYPT_CRL_SIGNATURE = 0x05;

    /**
     * Невозможно декодировать открытый ключ издателя сертификата. Невозможно прочитать
     * параметр SubjectPublicKeyInfo
     */
    long X509_V_ERR_UNABLE_TO_DECODE_ISSUER_PUBLIC_KEY = 0x06;

    /**
     * Проверка подписи сертификата завершилась с ошибкой
     */
    long X509_V_ERR_CERT_SIGNATURE_FAILURE = 0x07;

    /**
     * Проверка подписи CRL завершилась с ошибкой
     */
    long X509_V_ERR_CRL_SIGNATURE_FAILURE = 0x08;

    /**
     * Сертификат не действителен: срок действия сертификата не вступил в силу
     */
    long X509_V_ERR_CERT_NOT_YET_VALID = 0x09;

    /**
     * Сертификат не действителен: срок действия сертификата истек
     */
    long X509_V_ERR_CERT_HAS_EXPIRED = 0x0A;

    /**
     * Список отзыва недействителен: срок действия списка (CRL) не вступил в силу
     */
    long X509_V_ERR_CRL_NOT_YET_VALID = 0x0B;

    /**
     * Список отзыва недействителен: срок действия списка (CRL) истек
     */
    long X509_V_ERR_CRL_HAS_EXPIRED = 0x0C;

    /**
     * Недопустимое значение в поле сертификата notBefore, которое определяет начальный срок
     * действия сертификата
     */
    long X509_V_ERR_ERROR_IN_CERT_NOT_BEFORE_FIELD = 0x0D;

    /**
     * Недопустимое значение в поле сертификата notAfter, которое определяет срок истечения
     * сертификата
     */
    long X509_V_ERR_ERROR_IN_CERT_NOT_AFTER_FIELD = 0x0E;

    /**
     * Недопустимое значение в поле lastUpdate, которое определяет дату и время последнего обновления списка отзыва
     */
    long X509_V_ERR_ERROR_IN_CRL_LAST_UPDATE_FIELD = 0x0F;

    /**
     * Недопустимое значение в поле nextUpdate, которое определяет дату и время следующего обновления
     */
    long X509_V_ERR_ERROR_IN_CRL_NEXT_UPDATE_FIELD = 0x10;

    /**
     * Возникла ошибка при выделении памяти. Код ошибки предусмотрен, но фактически не возвращается
     */
    long X509_V_ERR_OUT_OF_MEM = 0x11;

    /**
     * Проверка завершилась ошибкой, т.к. переданный сертификат является самоподписанным и
     * при этом не найден в списке доверенных сертификатов на карте/токене (имеющих атрибут CKA_TRUSTED)
     */
    long X509_V_ERR_DEPTH_ZERO_SELF_SIGNED_CERT = 0x12;

    /**
     * При проверке цепочки корневой сертификат не обнаружен среди доверенных сертификатов на карте/токене
     */
    long X509_V_ERR_SELF_SIGNED_CERT_IN_CHAIN = 0x13;

    /**
     * Сертификат издателя недоверенный. Вероятно, отсутствуют один или несколько промежуточных сертификатов в цепочке
     */
    long X509_V_ERR_UNABLE_TO_GET_ISSUER_CERT_LOCALLY = 0x14;

    /**
     * Подпись не может быть проверена, т.к. в цепочке присутствует только один сертификат,
     * и он не является самоподписанным (корневым)
     */
    long X509_V_ERR_UNABLE_TO_VERIFY_LEAF_SIGNATURE = 0x15;

    /**
     * Превышена максимальная длина цепочки. Ошибка предусмотрена, но фактически не возвращается
     */
    long X509_V_ERR_CERT_CHAIN_TOO_LONG = 0x16;

    /**
     * Сертификат отозван
     */
    long X509_V_ERR_CERT_REVOKED = 0x17;

    /**
     * Недопустимый сертификат удостоверяющего центра. Возможно, в сертификате нет необходимых расширений (ext)
     * для запрашиваемого способа использования сертификата
     */
    long X509_V_ERR_INVALID_CA = 0x18;

    /**
     * Превышено допустимое значение параметра длины пути basicConstraints pathlength
     */
    long X509_V_ERR_PATH_LENGTH_EXCEEDED = 0x19;

    /**
     * Проверяемый сертификат не может использоваться для указанной операции
     */
    long X509_V_ERR_INVALID_PURPOSE = 0x1A;

    /**
     * Сертификат корневого центра сертификации не помечен как доверенный для указанной операции
     */
    long X509_V_ERR_CERT_UNTRUSTED = 0x1B;

    /**
     * Сертификат корневого центра сертификации имеет запрет на использование для данной
     * операции
     */
    long X509_V_ERR_CERT_REJECTED = 0x1C;

    /**
     * Текущий сертификат издателя не прошел проверку соответствия имени издателя (subject) в данном сертификате
     * с именем издателя в проверяемом сертификате, хранящемся локально. Не считается ошибкой проверки
     */
    long X509_V_ERR_SUBJECT_ISSUER_MISMATCH = 0x1D;

    /**
     * Текущий сертификат издателя не прошел проверку соответствия идентификатора ключа
     * в данном сертификате с идентификатором ключа издателя в проверяемом сертификате,
     * хранящемся локально. Не считается ошибкой проверки
     */
    long X509_V_ERR_AKID_SKID_MISMATCH = 0x1E;

    /**
     * Текущий сертификат издателя не прошел проверку соответствия серийного номера и идентификатора ключа в данном
     * сертификате с серийным номером и идентификатором ключа издателя в проверяемом сертификате, хранящемся локально.
     * Не считается ошибкой проверки
     */
    long X509_V_ERR_AKID_ISSUER_SERIAL_MISMATCH = 0x1F;

    /**
     * Сертификат издателя был отклонен, т.к. он не содержит значений в разделе расширений
     * keyUsage extension для подписи сертификата. Не считается ошибкой проверки
     */
    long X509_V_ERR_KEYUSAGE_NO_CERTSIGN = 0x20;

    /**
     * Невозможно получить сертификат издателя списка отзывов
     */
    long X509_V_ERR_UNABLE_TO_GET_CRL_ISSUER = 0x21;

    /**
     * Не может быть обработано одно из критических расширений
     */
    long X509_V_ERR_UNHANDLED_CRITICAL_EXTENSION = 0x22;

    /**
     * В расширениях сертификата отсутствует разрешением для подписи списка отзывов
     */
    long X509_V_ERR_KEYUSAGE_NO_CRL_SIGN = 0x23;

    /**
     * Не может быть обработано одно из критических расширений списка отзывов
     */
    long X509_V_ERR_UNHANDLED_CRITICAL_CRL_EXTENSION = 0x24;

    /**
     * Попытка использовать в качестве сертификата издателя сертификат, не являющийся сертификатом издателя
     * (не имеющий требуемых расширений)
     */
    long X509_V_ERR_INVALID_NON_CA = 0x25;

    /**
     * Превышена максимально допустимая длина цепочки прокси-серверов. Используется только в
     * соответствии с RFC 3820
     */
    long X509_V_ERR_PROXY_PATH_LENGTH_EXCEEDED = 0x26;

    /**
     * Сертификат не имеет привелегии подписи Digital Signature в расширении Enhanced Key
     * Usage (EKU)
     */
    long X509_V_ERR_KEYUSAGE_NO_DIGITAL_SIGNATURE = 0x27;

    /**
     * Сертификаты прокси-серверов не разрешены
     */
    long X509_V_ERR_PROXY_CERTIFICATES_NOT_ALLOWED = 0x28;

    /**
     * Расширение сертификата содержит недопустимое значение (например, неверно закодировано)
     * или одновременно добавлены взаимоисключающие расширения
     */
    long X509_V_ERR_INVALID_EXTENSION = 0x29;

    /**
     * Расширение политики сертификата содержит недопустимое значение (например, неверно
     * закодировано) или одновременно добавлены взаимоисключающие расширения
     */
    long X509_V_ERR_INVALID_POLICY_EXTENSION = 0x2A;

    /**
     * Выставлен флаг требовать принудительной проверки политик сертификата, но политики
     * отсутствует
     */
    long X509_V_ERR_NO_EXPLICIT_POLICY = 0x2B;

    /**
     * В переданном списке отзывов недопустимый набор сертификатов
     */
    long X509_V_ERR_DIFFERENT_CRL_SCOPE = 0x2C;

    /**
     * Не поддерживается свойство расширения сертификата. Ошибка предусмотрена, но фактически никогда не возвращается
     */
    long X509_V_ERR_UNSUPPORTED_EXTENSION_FEATURE = 0x2D;

    /**
     * Нарушение ограничений форматов для имен в разрешенной части
     */
    long X509_V_ERR_PERMITTED_VIOLATION = 0x2F;

    /**
     * Нарушение ограничений форматов для имен в исключенной части
     */
    long X509_V_ERR_EXCLUDED_VIOLATION = 0x30;

    /**
     * Ограничение для имен включает поля MIN/MAX: не поддерживается
     * MAX: не поддерживается
     */
    long X509_V_ERR_SUBTREE_MINMAX = 0x31;
    /**
     * Ошибка, которую возвращает стороннее приложение при проверке. Данный код может
     * быть возвращен, только если явно задан самим приложением.
     */
    long X509_V_ERR_APPLICATION_VERIFICATION = 0x32;

    /**
     * Неподдерживаемое ограничение для данного типа имени. Поддерживаются только проверка
     * следующих типов имен: имя директории, имя DNS, email и URI.
     */
    long X509_V_ERR_UNSUPPORTED_CONSTRAINT_TYPE = 0x33;

    /**
     * Формат ограничения имени не может быть распознан, например, при попытке проверки
     * формата, не указанного в RFC3280 для адреса электронной почты
     */
    long X509_V_ERR_UNSUPPORTED_CONSTRAINT_SYNTAX = 0x34;

    /**
     * Неподдерживаемый синтаксис имени
     */
    long X509_V_ERR_UNSUPPORTED_NAME_SYNTAX = 0x35;

    /**
     * Ошибка проверки пути к списку отзыва сертификата
     */
    long X509_V_ERR_CRL_PATH_VALIDATION_ERROR = 0x36;


    /**
     * Функция для сравнения констант с возвращаемым из pkcs значением
     */
    public static boolean equalsPkcsRV(long l, NativeLong pkcsRV) {
        return NativeComparator.isRawUnsignedNativeLongEqualsLong(pkcsRV, l);
    }
}