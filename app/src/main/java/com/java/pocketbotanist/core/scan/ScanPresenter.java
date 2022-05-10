package com.java.pocketbotanist.core.scan;

import android.os.Bundle;

import com.java.pocketbotanist.base.BasePresenter;
import com.java.pocketbotanist.core.check.CheckContract;
import com.java.pocketbotanist.core.scan.ScanContract;
import com.java.pocketbotanist.core.scan.ScanInteractor;
import com.java.pocketbotanist.model.Plant;

import java.util.List;

public class ScanPresenter extends BasePresenter implements ScanContract.Presenter, ScanContract.Listener {

    public final ScanContract.View scanView;

    public ScanPresenter(ScanContract.View scanView) {
        super(scanView);
        this.scanView = scanView;
    }
}