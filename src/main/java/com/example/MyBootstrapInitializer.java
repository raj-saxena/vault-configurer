package com.example;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.cloud.vault.config.VaultConfigurer;

public class MyBootstrapInitializer implements BootstrapRegistryInitializer {
    @Override
    public void initialize(BootstrapRegistry registry) {
        registry.register(
                VaultConfigurer.class,
                (context) -> new MyVaultSecretConfigurer()
        );
    }
}
