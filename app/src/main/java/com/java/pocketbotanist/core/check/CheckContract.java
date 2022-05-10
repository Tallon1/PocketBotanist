package com.java.pocketbotanist.core.check;

import com.java.pocketbotanist.base.BaseListenerContract;
import com.java.pocketbotanist.base.BasePresenterContract;
import com.java.pocketbotanist.base.BaseViewContract;

public interface CheckContract {
    interface View extends BaseViewContract {
    }

    interface Presenter extends BasePresenterContract {
    }

    interface Interactor{
    }

    interface Listener extends BaseListenerContract {
    }
}
