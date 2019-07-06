package cn.wbw.httpbootrest.util;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * properties 工具
 *
 * @author wbw
 * @date 2019/7/6 11:30
 */
public class PropUtil {
    private static PropertiesConfiguration propConfig = null;

    private static final PropUtil PROP_UTIL = new PropUtil();

    private PropUtil() {
    }

    public static PropUtil getProp(String propertiesFile) {
        //执行初始化
        init(propertiesFile);
        return PROP_UTIL;
    }

    /**
     * 初始化
     *
     * @param propertiesFile 属性文件
     */
    private static void init(String propertiesFile) {
        try {
            propConfig = new PropertiesConfiguration(propertiesFile);
            //自动重新加载
            propConfig.setReloadingStrategy(new FileChangedReloadingStrategy());
            //自动保存
            propConfig.setAutoSave(true);
            propConfig.save();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据Key获得对应的value
     *
     * @param key 键
     */
    public Object getValue(String key) {
        return propConfig.getProperty(key);
    }

    /**
     * 设置属性
     *
     * @param key   键
     * @param value 值
     */
    public void setProperty(String key, String value) {
        propConfig.setProperty(key, value);
    }

}
