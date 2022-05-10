package com.java.pocketbotanist.core.scan;

import com.java.pocketbotanist.base.BaseListenerContract;
import com.java.pocketbotanist.base.BasePresenterContract;
import com.java.pocketbotanist.base.BaseViewContract;

public interface ScanContract {
    interface View extends BaseViewContract {

    }

    interface Presenter extends BasePresenterContract {
    }

    interface Interactor {
    }

    interface Listener extends BaseListenerContract {
    }
}