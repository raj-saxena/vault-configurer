package com.example;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.vault.config.SecretBackendConfigurer;
import org.springframework.cloud.vault.config.VaultConfigurer;

@AutoConfiguration
public class MyVaultSecretConfigurer implements VaultConfigurer {
    @Override
    public void addSecretBackends(SecretBackendConfigurer configurer) {
        configurer.add("secret/my-DIFFERENT-application");
        configurer.registerDefaultKeyValueSecretBackends(false);
        configurer.registerDefaultDiscoveredSecretBackends(true);
    }
}
