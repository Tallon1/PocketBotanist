package com.java.pocketbotanist.view;

import static android.view.View.*;

import static org.tensorflow.lite.TensorFlowLite.init;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.java.pocketbotanist.R;
import com.java.pocketbotanist.base.BaseFragment;
import com.java.pocketbotanist.core.main.MainPresenter;
import com.java.pocketbotanist.core.scan.ScanContract;
import com.java.pocketbotanist.core.scan.ScanInteractor;
import com.java.pocketbotanist.core.scan.ScanPresenter;
import com.java.pocketbotanist.databinding.ActivityMainBinding;
import com.java.pocketbotanist.databinding.ActivityScanBinding;
import com.java.pocketbotanist.databinding.FragmentScanBinding;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.common.TensorProcessor;
import org.tensorflow.lite.support.common.ops.NormalizeOp;
import org.tensorflow.lite.support.image.ImageProcessor;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.image.ops.ResizeWithCropOrPadOp;
import org.tensorflow.lite.support.label.TensorLabel;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ScanFragment extends BaseFragment implements ScanContract.View {

    private ScanPresenter presenter;
    private RecyclerView.Adapter scanAdapter;
    private ActivityScanBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = ActivityScanBinding.inflate(getLayoutInflater());
        presenter = new com.java.pocketbotanist.core.scan.ScanPresenter(this);
        init();

        return binding.getRoot();
    }
}