package framework;

import utils.LoggerManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsManager {
    private Properties properties;
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final String envFilePath = System.getProperty("user.dir") + File.separator + "environments.properties";
    private static CredentialsManager instance;
    private String envId;

    private CredentialsManager() {
        initialize();
    }

    private void initialize() {
        log.info("Reading credentials");
        String wpEnvironmentId = System.getProperty("envId");
        if ((wpEnvironmentId == null) || (wpEnvironmentId.isEmpty())) {
            envId = "user";
        } else {
            envId = wpEnvironmentId.toLowerCase();
        }
        log.info("WordPress Environment Id --> " + envId);

        properties = new Properties();
        Properties envProperties = new Properties();
        try {
            envProperties.load(new FileInputStream(envFilePath));
        } catch (IOException e) {
            log.error("unable to load properties file");
        }
        properties.putAll(envProperties);
    }

    public static CredentialsManager getInstance() {
        if (instance == null) {
            instance = new CredentialsManager();
        }
        return instance;
    }

    private String getEnvironmentSetting(String setting) {
        return (String) getInstance().properties.get(setting);
    }

    public String getEnvId() {
        return envId;
    }

    public String getBaseURL() {
        return getEnvironmentSetting(getEnvId() + ".baseURL");
    }

    public String getPassword() {
        return getEnvironmentSetting(getEnvId() + ".password");
    }

    public String getEmail() {
        return getEnvironmentSetting(getEnvId() + ".email");
    }

    public String getLoginURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".loginURL");
    }

    public String getProductsURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".products");
    }

    public String getCartURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".cart");
    }

    public String getCategoryURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".category");
    }

    public String getBrandURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".brand");
    }

    public String getDetailsURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".details");
    }
    public String getCheckoutURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".checkout");
    }

    public String getPaymentURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".payment");
    }

    public String getPaymentDoneURL() {
        return getBaseURL() + getEnvironmentSetting(getEnvId() + ".payment_done");
    }
}
