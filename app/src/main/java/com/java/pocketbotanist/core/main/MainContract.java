package com.java.pocketbotanist.core.main;

import com.java.pocketbotanist.base.BaseListenerContract;
import com.java.pocketbotanist.base.BasePresenterContract;
import com.java.pocketbotanist.base.BaseViewContract;
import com.java.pocketbotanist.model.User;

public interface MainContract {
    interface View extends BaseViewContract {
        void requireLogin();
        void setUser(User username);
        void setEmail(String email);
    }

    interface Presenter extends BasePresenterContract {
        void checkIfUserIsLoggedIn();
        void onDrawerOptionLogoutClick();
    }

    interface Interactor {
        void performGetUserData();
        void performLogout();
    }

    interface Listener extends BaseListenerContract {
        void onSuccess(User user);
        void onFailure();
    }
}
