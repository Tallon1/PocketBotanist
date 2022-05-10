package com.java.pocketbotanist.core.check;

public class CheckInteractor implements CheckContract.Interactor {
    CheckContract.Listener checkListener;

    public CheckInteractor(CheckContract.Listener checkListener) {
        this.checkListener = checkListener;
    }
}
