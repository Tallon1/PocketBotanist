package com.java.pocketbotanist.view;

import android.content.Intent;
import android.os.Bundle;

import com.java.pocketbotanist.databinding.ActivityRegisterBinding;
import com.java.pocketbotanist.base.BaseActivity;
import com.java.pocketbotanist.core.register.RegisterContract;
import com.java.pocketbotanist.core.register.RegisterPresenter;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    ActivityRegisterBinding binding;
    RegisterContract.Presenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    private void initViews() {
        registerPresenter = new RegisterPresenter(this);

        binding.btRegister.setOnClickListener(v -> registerPresenter.register(
                binding.etUsername.getText().toString(),
                binding.etEmail.getText().toString(),
                binding.etPassword.getText().toString(),
                binding.etRepeatPassword.getText().toString()
        ));
    }

    @Override
    public void setUsernameError(int error) {
        binding.etUsername.setError(getString(error));
    }

    @Override
    public void setEmailError(int error) {
        binding.etEmail.setError(getString(error));
    }

    @Override
    public void setPasswordError(int error) {
        binding.etPassword.setError(getString(error));
    }

    @Override
    public void setRepeatedPasswordError(int error) {
        binding.etRepeatPassword.setError(getString(error));
    }

    @Override
    public void onRegisterSuccess(int message) {
        showMessage(message);
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRegisterFailure(String message) {
        showMessage(message);
    }
}