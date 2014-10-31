package fl.site.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class SiteMessages {

    private static final String BUNDLE_NAME = "site_resources";

    private static final Map<String, Locale> SUPPORTED_LOCALE = new HashMap<String, Locale>();

    private static final Map<String, ResourceBundle> BUNDLE_MAP = new HashMap<String, ResourceBundle>();

    static {
        SUPPORTED_LOCALE.put("zh_CN", Locale.CHINA);
        SUPPORTED_LOCALE.put("en", Locale.ENGLISH);
    }

    private SiteMessages() {
    }

    public static String getString(String key, String locale) {
        try {
            ResourceBundle bundle = getBundle(locale);
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String getCLString(String key) {
        return getString(key, "zh_CN");
    }

    public static String getString(String key, String locale, Object... params) {
        try {
            ResourceBundle bundle = getBundle(locale);
            return MessageFormat.format(bundle.getString(key), params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String getCLString(String key, Object... params) {
        return getString(key, "zh_CN", params);
    }

    private static ResourceBundle getBundle(String locale) {
        ResourceBundle bundle = BUNDLE_MAP.get(locale);
        if (bundle == null) {
            if (SUPPORTED_LOCALE.containsKey(locale)) {
                bundle = ResourceBundle.getBundle(BUNDLE_NAME, SUPPORTED_LOCALE.get(locale));
                BUNDLE_MAP.put(locale, bundle);
            } else {
                bundle = BUNDLE_MAP.get("en");
                if (bundle == null) {
                    bundle = ResourceBundle.getBundle(BUNDLE_NAME, SUPPORTED_LOCALE.get("en"));
                    BUNDLE_MAP.put("en", bundle);
                }
            }
        }
        return bundle;
    }

}
