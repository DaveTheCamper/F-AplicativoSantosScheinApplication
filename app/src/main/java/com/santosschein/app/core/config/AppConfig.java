package com.santosschein.app.core.config;

import com.santosschein.app.BuildConfig;

public final class AppConfig {

    private final Environment environment;
    private final String apiBaseUrl;

    public AppConfig() {
        this(Environment.from(BuildConfig.ENVIRONMENT), BuildConfig.API_BASE_URL);
    }

    public AppConfig(Environment environment, String apiBaseUrl) {
        this.environment = environment;
        this.apiBaseUrl = apiBaseUrl;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public boolean isMockMode() {
        return environment == Environment.MOCK;
    }
}
