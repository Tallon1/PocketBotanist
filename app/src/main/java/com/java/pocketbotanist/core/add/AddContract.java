package com.java.pocketbotanist.core.add;

import com.java.pocketbotanist.base.BaseListenerContract;
import com.java.pocketbotanist.base.BasePresenterContract;
import com.java.pocketbotanist.base.BaseViewContract;
import com.java.pocketbotanist.model.UserPlant;

public interface AddContract {
    interface View extends BaseViewContract {
        void setNameError(int error);

        void plantAdded(int message, UserPlant plant);
    }

    interface Presenter extends BasePresenterContract {
        void addPlant(UserPlant plant);
    }

    interface Interactor {
        void performAddPlant(UserPlant plant);
    }

    interface Listener extends BaseListenerContract {
        void onSuccess(int message, UserPlant plant);
        void onFailure(String message);
    }
}