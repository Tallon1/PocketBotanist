package com.java.pocketbotanist.core.scan;

public class ScanInteractor implements ScanContract.Interactor {
    private ScanContract.Listener scanListener;

    public ScanInteractor(ScanContract.Listener scanListener) {
        this.scanListener = scanListener;
    }
}