package com.example;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.cloud.vault.config.SecretBackendConfigurer;
import org.springframework.cloud.vault.config.VaultConfigurer;
import org.springframework.cloud.vault.config.VaultProperties;

public class MyBootstrapInitializer implements BootstrapRegistryInitializer {

    @Override
    public void initialize(BootstrapRegistry registry) {
        registry.register(VaultConfigurer.class, context -> configurer -> {
            var appName = context.get(VaultProperties.class).getApplicationName();
            configurer.add("secret/%s".formatted(appName));
            configurer.registerDefaultKeyValueSecretBackends(false);
            configurer.registerDefaultDiscoveredSecretBackends(true);
        });
    }
}
