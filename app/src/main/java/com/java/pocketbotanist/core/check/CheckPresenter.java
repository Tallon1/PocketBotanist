package com.java.pocketbotanist.core.check;

import com.java.pocketbotanist.base.BasePresenter;

public class CheckPresenter extends BasePresenter implements CheckContract.Presenter, CheckContract.Listener {

    public final CheckContract.View checkView;

    public CheckPresenter(CheckContract.View checkView) {
        super(checkView);
        this.checkView = checkView;
    }
}