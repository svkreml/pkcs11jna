package svkreml.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.NativeLongByReference;
import ru.rutoken.pkcs11jna.Pkcs11;

/*
 * по документации:
 * https://esmart.ru/upload/iblock/0c3/esmart_token_gost_developer_guide.pdf
 * https://esmart.ru/upload/iblock/765/v6.P11_RusExt_12.pdf
 *
 * https://esmart.ru/download/
 */
@SuppressWarnings("unused")
public interface EsmartPkcs11 extends Pkcs11 {

    /**
     * Создание запроса на выпуск сертификата
     *
     * @param hSession   идентификатор сессии;
     * @param publicKey  идентификатор объекта типа CKO_PUBLIC_KEY, для которого создается запрос;
     * @param dn         Distinguished Name запроса. В параметре передается массив строк, где в первой
     *                   строке располагается тип поля в текстовом формате или идентификатор
     *                   объекта (CN - например). Во второй строке должно находиться значение поля в
     *                   UTF8. Последующие поля передаются в следующих парах строк. Количество
     *                   строк должно быть кратно двум;
     * @param dnLen      количество строк в массиве, на который ссылается параметр dn;
     * @param csr        указатель на память, куда будет помещен содержимое запроса. Память должна
     *                   быть выделена заранее. Чтобы узнать необходимый размер памяти, необходимо
     *                   вызвать функцию передав NULL в csr. Необходимый размер будет возвращен в
     *                   параметре cstLen;
     * @param cstLen     размер буфера памяти под csr;
     * @param privateKey идентификатор объекта типа CKO_PRIVATE_KEY, для которого создается запрос;
     * @param attrs      дополнительные атрибуты для включения в запрос. Формат аналогичен формату параметра dn;
     * @param attrsLen   количество строк в массиве, на который ссылается параметр attrs;
     * @param exts       расширения для включения в запрос. В параметре передается массив строк, где в
     *                   первой строке располагается тип поля в текстовом формате или идентификатор объекта
     *                   (keyUsage - например). Во второй строке должно находиться значение поля в UTF8. В третьей
     *                   строке должен быть указано требование в данному
     *                   расширению, 0 – не критическое, 1 – критическое. Последующие поля передаются в следующих
     *                   строках. Количество строк должно быть кратно трем;
     * @param extsLen    количество строк в массиве, на который ссылается параметр exts.
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * Параметры dn, attr и ext должны быть представлены в виде непрерывного массива, в котором
     * поля разделены нулевым символом '\0'. Например, dn необходимо передавать в виде
     * "CN\0name\0C\0RU\0"
     * <p>
     * Поддерживаются стандартные поля запроса, задаваемые в виде длинного или короткого имени:
     * Краткое имя Полное имя OID Описание
     * Стандартные поля для параметров Distinguished name по RFC 5280
     * CN commonName 2.5.4.3 Основное имя
     * SN surname 2.5.4.4 Фамилия
     * G givenName 2.5.4.42 Имя и отчество
     * C countryName 2.5.4.6 Название страны, передается двумя заглавными
     * буквами (RU/US/GB) согласно ГОСТ 7.67-2003
     * (ИСО 3166-1:1997)
     * L localityName 2.5.4.7 Населенный пункт
     * ST / S stateOrProvinceName 2.5.4.8 Регион
     * - - 2.5.4.9 Адрес: улица и дом
     * O organizationName 2.5.4.10 Название организации
     * OU organizationalUnitName 2.5.4.11 Название структурной единицы (отдела)
     * E emailAddress 1.2.840.113549.1.9.1 Адрес электронной почты
     * Поля сертификата по ФЗ № 63-ФЗ и приказу № 795 «Об утверждении требований к форме
     * квалифицированного сертификата ключа проверки электронной подписи»
     * - - 1.2.643.100.1 ОГРН
     * - - 1.2.643.100.3 СНИЛС
     * - - 1.2.643.3.131.1.1 ИНН
     * <p>
     * Для передачи параметров алгоритмов ГОСТ используются стандартные значения OID по RFC 4491 и
     * методическим рекомендациям ТК26.
     * Для запроса на сертификат, содержащий идентификатор ключевой пары по алгоритму ГОСТ Р 34.10-
     * 2012 в 256-битном режиме, дополнительно необходимо передать OID 1.2.643.7.1.1.2.2 в качестве
     * имени атрибута с любым значением атрибута. По умолчанию, если OID 1.2.643.7.1.1.2.2 не передан
     * функции, запрос будет сформирован для ключевой пары по алгоритму ГОСТ Р 34.10-2001.
     */
    NativeLong C_ISBC_CreateCSR(
            NativeLong /*CK_SESSION_HANDLE*/ hSession,
            Object /*CK_OBJECT_HANDLE*/ publicKey,
            byte[] /*CK_CHAR_PTR*/ dn,
            NativeLong /*CK_ULONG*/ dnLen,
            byte[] /*CK_BYTE_PTR*/ csr,
            NativeLongByReference /*CK_ULONG_PTR*/ cstLen,
            Object /*CK_OBJECT_HANDLE*/ privateKey,
            byte[] /*CK_CHAR_PTR*/ attrs,
            NativeLong /*CK_ULONG*/ attrsLen,
            byte[] /*CK_CHAR_PTR*/ exts,
            NativeLong /*CK_ULONG*/ extsLen
    );

    /**
     * Подпись данных в соответствии с PKCS#7
     *
     * @param hSession         идентификатор сессии;
     * @param pData            данные для подписи;
     * @param ulDataLen        размер данных для подписи;
     * @param hSignCertificate идентификатор объекта типа CKO_CERTIFICATE, указывающий на
     *                         сертификат создателя сообщения;
     * @param pOut             указатель на массив байт, в который передаются данные. Память
     *                         должна быть выделена заранее. Чтобы узнать необходимый размер
     *                         памяти необходимо вызвать функцию, передав NULL в pOut. Необходимый размер будет
     *                         возвращен в параметре pulOutLen;
     * @param pulOutLen        указатель на длину созданного буфера;
     * @param hPrivateKey      идентификатор объекта типа CKO_PRIVATE_KEY, указывающий на закрытый ключ создателя сообщения;
     * @param hCertificates    указатель на массив сертификатов, которые следует добавить в сообщение;
     * @param ulCertificateLen количество сертификатов в параметре hCertificate;
     * @param ulFlags          флаги. Переменная CK_ULONG может иметь следующие значения:
     *                         0 – исходные данные, на которые ссылается указатель pData,
     *                         сохраняются вместе с подписанным сообщением;
     *                         0x40 – исходные данные, на которые ссылается указатель
     *                         pData, не сохраняются вместе с подписанным сообщением.
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * CKR_VENDOR_CERT_EXPIRED
     * (см. раздел 10), если истек срок действия сертификата, который выбран для подписи.
     */
    NativeLong C_ISBC_pkcs7Sign(
            NativeLong /*CK_SESSION_HANDLE*/ hSession,
            byte[] /*CK_BYTE_PTR*/ pData,
            NativeLong /*CK_ULONG*/ ulDataLen,
            Object /*CK_OBJECT_HANDLE*/ hSignCertificate,
            byte[] /*CK_BYTE_PTR*/ pOut,
            NativeLongByReference /*CK_ULONG_PTR*/ pulOutLen,
            Object /*CK_OBJECT_HANDLE*/ hPrivateKey,
            Object[] /*CK_OBJECT_HANDLE_PTR*/ hCertificates,
            NativeLong /*CK_ULONG*/ ulCertificateLen,
            NativeLong /*CK_ULONG*/ ulFlags
    );

    /**
     * Простая проверка подписи PKCS#7
     *
     * @param pPkcs7     указатель на байт-массив, содержащий объект данных, подписанный в
     *                   формате PKCS#7;
     * @param ulPkcs7Len размер объекта данных, на который ссылается указатель pPkcs7;
     * @param pData      указатель на массив, содержащий данные, если таковые отсутствуют
     *                   непосредственно в самом объекте данных (если при создании подписи
     *                   ulFlags=0x40);
     * @param ulDataLen  размер объекта данных, на который ссылается указатель pData.
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * Функция C_ISBC_pkcs7Verify используется только для базовой проверки математической верности электронной подписи.
     * Для расширенной проверки электронной функции следует использовать
     * функцию C_ISBC_pkcs7VerifyEx, включающую дополнительные возможности.
     */
    NativeLong C_ISBC_pkcs7Verify(
            byte[] /*CK_BYTE_PTR*/ pPkcs7,
            NativeLong /*CK_ULONG*/ ulPkcs7Len,
            byte[] /*CK_BYTE_PTR*/ pData,
            NativeLong /*CK_ULONG*/ ulDataLen
    );

    /**
     * Функция проверки сертификата в цепочке с возможностью проверки по списку отзыва
     *
     * @param hSession                  идентификатор сессии;
     * @param certificateToVerify       идентификатор проверяемого сертификата;
     * @param trustedCertificates       указатель на массив доверенных сертификатов;
     * @param trustedCertificatesLength размер массива;
     * @param certificateChain          указатель на массив сертификатов, не помеченных в качестве доверенных;
     * @param certificateChainLength    размер массива;
     * @param crls                      указатель на массив указателей на списки отзыва;
     * @param crlsLengths               указатель на массив размеров списков отзыва;
     * @param crlsLength                размер массивов.
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * Функция может возвращать не определенную стандартом ошибку CKR_VENDOR_VERIFY_ERR (см.
     * раздел 10), если проверка сертификата завершилась с ошибкой.
     * <p>
     * Функция предназначена для проверки выбранного сертификата в доверенной цепочке. Для успешной
     * проверки сертификата должны быть выполнены следующие условия:
     * – проверяемый сертификат и каждый сертификат в цепочке должны иметь верную электронную подпись
     * (быть математически верными);
     * – корневой сертификат иерархии и все промежуточные сертификаты в цепочке должны присутствовать на карте;
     * – опционально, функции могут быть переданы списки отзыва сертификатов в формате DER.
     * Чтобы отключить проверку, вместо списков передается NULL.
     */
    NativeLong C_ISBC_CertVerify(
            NativeLong /*CK_SESSION_HANDLE*/ hSession,
            CKO_CERTIFICATE /*CK_OBJECT_HANDLE*/ certificateToVerify,
            CKO_CERTIFICATE[] /*CK_OBJECT_HANDLE_PTR*/ trustedCertificates,
            NativeLong /*CK_ULONG*/ trustedCertificatesLength,
            CKO_CERTIFICATE[] /*CK_OBJECT_HANDLE_PTR*/ certificateChain,
            NativeLong /*CK_ULONG*/ certificateChainLength,
            byte[] /*CK_BYTE_PTR*/ crls,
            NativeLong[] /*CK_ULONG_PTR*/ crlsLengths,
            NativeLong /*CK_ULONG*/ crlsLength
    );

    /**
     * Расширенная проверка подписи, включающая в себя
     * проверку цепочки сертификатов, наличие доверенного
     * корневого сертификата и
     * проверку по спискам отзыва
     *
     * @param hSession       идентификатор сессии;
     * @param pPkcs7         указатель на байт-массив, содержащий объект данных, подписанный в формате PKCS#7;
     * @param ulPkcs7Len     размер объекта данных, на который ссылается указатель pPkcs7;
     * @param pData          указатель на массив, содержащий данные, если таковые отсутствуют
     *                       непосредственно в самом объекте данных (если при создании подписи
     *                       ulFlags=0x40);
     * @param ulDataLen      размер объекта данных, на который ссылается указатель pData;
     * @param crls           указатель на массив указателей на списки отзыва;
     * @param crlsLengths    указатель на массив размеров списков отзыва;
     * @param crlsLength     размер массивов;
     * @param ignoreCrlCheck игнорировать проверку сертификата по списку отзыва.
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * Условия успешной проверки подписи с помощью данной функции:
     * - все сертификаты в цепочке должны быть математически верны (иметь верную электронную
     * подпись);
     * -все сертификаты в цепочке должны иметь соответствующие расширения (например расширения для подписи данных
     * для пользовательских сертфикатов, подписи CRL или других сертификатов для сертфиикатов УЦ);
     * - все сертификаты в цепочки должны быть действительны по сроку на момент выполнения
     * подписи;
     * - корневой сертификат иерархии должен быть записан на карту с атрибутом CKA_TRUSTED;
     * - произведена успешная проверка всех сертификатов в цепочке по спискам отзыва.
     * Для успешной проверки подписи списки отзыва должны удовлетворять следующим условиям:
     * - все переданные списки отзыва должны быть математически верны (иметь верную электронную подпись);
     * - все списки отзыва не должны быть истекшими.
     * Проверка по списку отзыва сертификатов повышает уровень доверия. Текущие списки отзыва сертификатов должны
     * регулярно обновляться на ПЭВМ, на которых проводится проверка подписи. Отключать возможность проверки подписи
     * допускается только для проверки функционирования системы.
     * Сертификаты и списки отзыва CRL должны быть переданы в функцию в кодировке DER.
     */
    NativeLong C_ISBC_pkcs7VerifyEx(
            NativeLong /*CK_SESSION_HANDLE*/ hSession,
            byte[] /*CK_BYTE_PTR*/ pPkcs7,
            NativeLong /*CK_ULONG*/ ulPkcs7Len,
            byte[] /*CK_BYTE_PTR*/ pData,
            NativeLong /*CK_ULONG*/ ulDataLen,
            byte[] /*CK_BYTE_PTR*/ crls,
            NativeLongByReference /*CK_ULONG_PTR*/ crlsLengths,
            NativeLong /*CK_ULONG*/ crlsLength,
            boolean /*CK_BBOOL*/ ignoreCrlCheck
    );


    /**
     * Инициализация токена или карты с применением базовых параметров
     *
     * @param slotID     ID слота/считывателя смарт-карт;
     * @param pPin       значение SO PIN;
     * @param ulPinLen   длина pPin;
     * @param pLabel     метка токена;
     * @param bSoPinRc   число попыток ввода неверного SO PIN подряд. Фиксированное значение, равное 10 попыткам,
     *                   задавать значения бесполезно;
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


    /**
     * Инициализация токена или карты с применением профиля, т.е. набора расширенных параметров
     *
     * @param slotID         ID слота/считывателя смарт-карт;
     * @param pPin           значение SO PIN;
     * @param ulPinLen       длина pPin;
     * @param pLabel         метка токена;
     * @param bProfileId     идентификатор профиля;
     * @param bSoPinRc       число попыток ввода неверного SO PIN подряд. Фиксированное значение,
     *                       равное 10 попыткам, задается при первоначальной инициализации криптографического чипа.
     *                       Ограничение в 10 попыток нельзя изменить при инициализации токена/карты функциями PKCS11.
     *                       Переданное функции значение игнорируется;
     * @param bUserPinRc     число попыток ввода неверного User PIN подряд. Значение должно быть
     *                       в диапазоне >0 и <= 254. Таким образом, максимальное значение количества попыток равно 254.
     * @param bDataFileSize  размер блока памяти, отведенный под один объект данных CKO_DATA.
     *                       Длина одного блока составляет 256 байт. Переданное значение игнорируется, размер блока
     *                       определяется динамически при записи конкретного
     *                       объекта;
     * @param bDataFileCount изначальное количество объектов данных при задании параметров файловой системы;
     * @param bCertFileSize  размер блока памяти, отведенный под один объект сертификатов
     *                       CKO_CERTIFICATE. Длина одного блока составляет 256 байт. Переданное значение игнорируется,
     *                       размер блока определяется динамически при
     *                       записи конкретного объекта;
     * @param bCertFileCount изначальное количество объектов сертификатов при задании параметров
     *                       файловой системы;
     * @param bPubFileSize   размер блока памяти, отведенный под один объект открытого ключа
     *                       CKO_PUBLIC_KEY. Длина одного блока составляет 256 байт. Переданное значение игнорируется,
     *                       размер блока определяется динамически при
     * @param bPubFileCount  изначальное количество объектов открытых ключей при задании параметров файловой системы;
     * @param bPrFileSize    размер блока памяти, отведенный под один объект закрытого ключа
     *                       CKO_PRIVATE_KEY. Длина одного блока составляет 256 байт. Переданное значение игнорируется,
     *                       размер блока определяется динамически при записи конкретного объекта;
     * @param bPrFileCount   изначальное количество объектов закрытых ключей при задании параметров файловой системы;
     * @param bSKFileSize    размер блока памяти, отведенный под один объект симметричного ключа
     *                       CKO_SECRET_KEY. Один блок занимает 256 байт. Переданное значение
     *                       игнорируется, размер блока определяется динамически при записи конкретного объекта;
     * @param bSKFileCount   изначальное количество объектов симметричных ключей при задании параметров файловой системы;
     * @param bSM            активация опции Secure Messaging. Всегда следует передавать 0, т.к. данная опция не поддерживается;
     * @param bConf          Дополнительные параметры профиля, например, активация работы с биометрией (не поддерживается).
     *                       Рекомендуется устанавливать значение 0.
     *                       Если при создании объекта значение не было задано, используется значение по умолчанию 0x04.
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * Функция предназначена для разметки файловой системы при инициализации. В отличие от функции
     * C_ISBC_InitToken в данной функции присутствует возможность задать дополнительные параметры разметки файловой системы.
     * В соответствии с особенностями работой файловой системы смарт-карт и токенов СКЗИ «ESMART Token ГОСТ» параметры объектов,
     * заданные при инициализации, будут динамически изменены при создании новых объектов.
     * Параметры, соответствующие размеру блока, при инициализации могут быть переданы любые. При
     * фактическом создании объекта его размер будет задан динамически. Параметры, определяющие количество создаваемых объектов,
     * задают только первоначальное значение. Например, при инициализации
     * передано значение bCertFileCount равное 3. При попытке создания 4-го объекта типа «сертификат» автоматически будет
     * выделено новое адресное пространство в памяти для создания новых объектов.
     * В качестве значения параметров bSM и bConf следует передавать 0. Можно передавать и любое другое значение,
     * но оно будет игнорироваться
     */
    NativeLong C_ISBC_InitTokenProfile(
            NativeLong /*CK_SLOT_ID*/ slotID,
            byte[]  /*CK_UTF8CHAR_PTR*/ pPin,
            NativeLong /*CK_ULONG*/ ulPinLen,
            byte[]  /*CK_UTF8CHAR_PTR*/ pLabel,
            byte /*CK_BYTE*/ bProfileId,
            byte /*CK_BYTE*/ bSoPinRc,
            byte /*CK_BYTE*/ bUserPinRc,
            byte /*CK_BYTE*/ bDataFileSize,
            byte /*CK_BYTE*/ bDataFileCount,
            byte /*CK_BYTE*/ bCertFileSize,
            byte /*CK_BYTE*/ bCertFileCount,
            byte /*CK_BYTE*/ bPubFileSize,
            byte /*CK_BYTE*/ bPubFileCount,
            byte /*CK_BYTE*/ bPrFileSize,
            byte /*CK_BYTE*/ bPrFileCount,
            byte /*CK_BYTE*/ bSKFileSize,
            byte /*CK_BYTE*/ bSKFileCount,
            byte /*CK_BYTE*/ bSM,
            byte /*CK_BYTE*/ bConf
    );


    /**
     * Получение параметров профиля, заданного при инициализации функцией C_ISBC_GetProfile
     *
     * @param slotID          ID слота/считывателя смарт-карт;
     * @param pbVerMsb        старший байт номера версии разметки токена, возвращает 1;
     * @param pbVerLsb        старший байт номера версии разметки токена, возвращает 1;
     * @param pbProfileId     идентификатор профиля, возвращается значение, заданное при инициализации с данным профилем;
     * @param pbSoPinRc       число попыток ввода SO PIN, значение должны быть >0 и <= 0x0F. Значения
     *                        0x0F означает, что счетчик отключен (если карта/токен это поддерживает);
     * @param pbUserPinRc     число попыток ввода User PIN, значение должны быть >0 и <= 0x0F. Значения 0x0F означает,
     *                        что счетчик отключен (если карта/токен это поддерживает);
     * @param pbDataFileSize  размер блока памяти, отведенный под один объект данных CKO_DATA.
     *                        Длина одного блока составляет 256 байт. Переданное значение игнорируется, размер блока
     *                        определяется динамически при записи конкретного объекта;
     * @param pbDataFileCount изначальное количество объектов симметричных ключей при задании параметров файловой системы;
     * @param pbCertFileSize  размер блока памяти, отведенный под один объект данных CKO_DATA.
     *                        Длина одного блока составляет 256 байт. Возвращаемое значение актуально только для информации,
     *                        размер блока определяется динамически при записи конкретного объекта;
     * @param pbCertFileCount изначальное количество объектов симметричных ключей при задании параметров файловой системы;
     * @param pbPubFileSize   размер блока памяти, отведенный под один объект данных CKO_DATA.
     *                        Длина одного блока составляет 256 байт. Возвращаемое значение актуально только для информации,
     *                        размер блока определяется динамически при записи конкретного объекта;
     * @param pbPubFileCount  изначальное количество объектов симметричных ключей при задании параметров файловой системы;
     * @param pbPrFileSize    размер блока памяти, отведенный под один объект данных CKO_DATA.
     *                        Длина одного блока составляет 256 байт. Возвращаемое значение актуально только для информации,
     *                        размер блока определяется динамически при  записи конкретного объекта;
     * @param pbPrFileCount   изначальное количество объектов симметричных ключей при задании параметров файловой системы;
     * @param pbSKFileSize    размер блока памяти, отведенный под один объект данных CKO_DATA.
     *                        Длина одного блока составляет 256 байт. Возвращаемое значение актуально только для информации,
     *                        размер блока определяется динамически при записи конкретного объекта;
     * @param pbSKFileCount   изначальное количество объектов симметричных ключей при задании параметров файловой системы;
     * @param pbSM            Использование Secure Messaging, всегда возвращается 0;
     * @param pbConf          использование биометрии, возвращается то значение, которое было задано
     *                        при создании профиля функцией C_ISBC_InitTokenProfile. По умолчанию функция C_ISBC_InitTokenProfile
     *                        устанавливает значение 0x04.
     * @return CKR_OK – функция выполнена успешно.
     */

    NativeLong C_ISBC_GetProfile(
            NativeLong /*CK_SLOT_ID */ slotID,
            ByteByReference /*CK_BYTE * */ pbVerMsb,
            ByteByReference /*CK_BYTE * */ pbVerLsb,
            ByteByReference /*CK_BYTE * */ pbProfileId,
            ByteByReference /*CK_BYTE * */ pbSoPinRc,
            ByteByReference /*CK_BYTE * */ pbUserPinRc,
            ByteByReference /*CK_BYTE * */ pbDataFileSize,
            ByteByReference /*CK_BYTE * */ pbDataFileCount,
            ByteByReference /*CK_BYTE * */ pbCertFileSize,
            ByteByReference /*CK_BYTE * */ pbCertFileCount,
            ByteByReference /*CK_BYTE * */ pbPubFileSize,
            ByteByReference /*CK_BYTE * */ pbPubFileCount,
            ByteByReference /*CK_BYTE * */ pbPrFileSize,
            ByteByReference /*CK_BYTE * */ pbPrFileCount,
            ByteByReference /*CK_BYTE * */ pbSKFileSize,
            ByteByReference /*CK_BYTE * */ pbSKFileCount,
            ByteByReference /*CK_BYTE * */ pbSM,
            ByteByReference /*CK_BYTE * */ pbConf
    );

    /**
     * Получение информации о контейнерах CryptoPro, записанных на карту/токен
     *
     * @param slotID      ID слота/считывателя смарт-карт;
     * @param pulCount    количество контейнеров;
     * @param pbNames     имена контейнеров. Память должна быть выделена заранее. Чтобы узнать
     *                    необходимый размер памяти необходимо вызвать функцию передав NULL в
     *                    pbNames. Необходимый размер будет возвращен в параметре pulNamesLen;
     * @param pulNamesLen размер буфера pbNames;
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * Работа с функцией выполняется в 2 этапа.
     * На первом этапе определяется требуемый объем выделяемой памяти. Для этого функция вызывается
     * первый раз и в параметре pbNames передается NULL. Функция вернет размер массива, содержащего
     * TLV-структуры с именами контейнеров КриптоПРО, в параметре pulNamesLen.
     * На втором этапе нужно выделить память под этот массив, и вызвать функцию повторно, передав
     * указатель на него в параметре pbNames.
     * TLV-структуры с именами контейнеров имеют следующий формат:
     * Формат pbNames: последовательно тегов 0x30, содержащих тег 0x16 с именем контейнера в кодировке ISO 646
     * (IA5) (преобразуется к CP1251)
     */

    NativeLong C_ISBC_GetCryptoProInfo(
            NativeLong /*CK_SLOT_ID */ slotID,
            NativeLongByReference /*CK_ULONG * */ pulCount,
            byte[] /*CK_BYTE * */ pbNames,
            NativeLongByReference /*CK_ULONG * */ pulNamesLen
    );

    /**
     * Получение информации о сертификате, хранящеся в контейнере CryptoPro, записанном на карту/токен
     *
     * @param slotID     ID слота/считывателя смарт-карт;
     * @param pbCertName Имя контейнера криптопро в кодировке CP1251, для которого запрашивается чтение сертификата;
     * @param ulNameLen  Размер массива pbCertName;
     * @param pbCert     Массив, содержащий сертификат КриптоПРО из контейнера с именем pbCertName;
     * @param pulCertLen Размер буфера pbCert;
     * @return CKR_OK – функция выполнена успешно.
     * <p>
     * Для чтения сертификата из контейнера необходимо получить имя контейнера с помощью функции
     * C_ISBC_GetCryptoProInfo.
     * Работа с функцией выполняется в 2 этапа.
     * Сперва следует вызвать эту функцию, передав в параметре pbCertName имя контейнера КриптоПРО, полученного на
     * предыдущем шаге в кодировке CP1251, размер этого массива в параметре ulNameLen и NULL в параметре pbCert.
     * Функция вернет размер массива, содержащего сертификат КриптоПРО, в параметре pulCertLen.
     * Вторым шагом нужно выделить память под этот массив, и вызвать функцию
     * повторно, передав указатель на него в параметре pbCert.
     */
    NativeLong C_ISBC_GetCryptoProCertificate(
            NativeLong /*CK_SLOT_ID */ slotID,
            byte[] /*CK_BYTE * */ pbCertName,
            NativeLong /*CK_ULONG*/ ulNameLen,
            byte[] /*CK_BYTE * */ pbCert,
            NativeLongByReference /*CK_ULONG * */  pulCertLen
    );

    /**
     * Проверка возможности работать с проверкой Secure Messaging
     *
     * @param slotID ID слота/считывателя смарт-карт;
     * @param pbRes  Указатель на возвращаемое значение:
     *               0 – не поддерживается;
     *               1 – поддерживается, но не активирован;
     *               2 – поддерживается и активирован.
     * @return CKR_OK – функция выполнена успешно
     * <p>
     * Для смарт-карт и токенов СКЗИ «ESMART Token ГОСТ» опция Secure Messaging не поддерживается.
     * Функция всегда возвращает 0.
     */

    NativeLong C_ISBC_CheckSM(
            NativeLong /*CK_SLOT_ID*/ slotID,
            ByteByReference /*CK_BYTE * */ pbRes
    );

    /**
     * Чтение журнала событий на ESMART Token ГОСТ
     *
     * @param hSession   идентификатор сессии;
     * @param type       должно равняться 0;
     * @param pData      указатель на буфер. NULL если нужно узнать размер;
     * @param pulDataLen размер буфера
     * @return CKR_OK – функция выполнена успешно. Функция может возвращать код ошибки CKR_VENDOR_SCRIB_NOT_FOUND
     * (см. раздел 10), если файл журнала событий отсутствует.
     * <p>
     * Формат каждой записи - 6 байт. Первые 4 байта представляют дату записи в секундах, начиная с
     * 01.01.2016 0:00:00 UTC. Следующий байт передает код события. Последний байт зарезервирован (RFU).
     * <p>
     * Код события:
     * 0x01 – Первичная персонализация
     * 0x02 – Инициализация функцией C_InitToken
     * 0x03 – Смена ПИН пользователя
     * 0x04 – Смена ПИН администратора
     * 0x05 – Не удачная попытка авторизации по ПИН пользователя
     * 0x06 – Не удачная попытка авторизации по ПИН администратора
     * Коды 0x03 - 0x06 могут комбинироваться с флагом 0x80, если событие связано с минидрайвером.
     * Коды 0x05 - 0x06 могут комбинироваться с флагом 0x40, если источник события неизвестен.
     */
    NativeLong C_ISBC_ScribbleRead(
            NativeLong /*CK_SESSION_HANDLE*/ hSession,
            byte /*CK_BYTE*/ type,
            byte[] /*CK_BYTE_PTR*/ pData,
            NativeLongByReference /*CK_ULONG_PTR*/ pulDataLen
    );
}
