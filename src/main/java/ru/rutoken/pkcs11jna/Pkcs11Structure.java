/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

public abstract class Pkcs11Structure extends Structure {
    public Pkcs11Structure() {
        super(getAlign());
    }

    public Pkcs11Structure(Pointer pointer) {
        super(pointer, getAlign());
    }

    private static int getAlign() {
        return Platform.isWindows() ? Structure.ALIGN_NONE : Structure.ALIGN_DEFAULT;
    }
}
