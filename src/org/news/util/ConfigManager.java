package org.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

   private static Properties props = null;


   static {
      InputStream is = null;
      is = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
      if(is == null) {
         throw new RuntimeException("找不到数据库参数配置文件！");
      } else {
         props = new Properties();

         try {
            props.load(is);
         } catch (IOException var9) {
            throw new RuntimeException("数据库配置参数加载错误！", var9);
         } finally {
            try {
               is.close();
            } catch (IOException var8) {
               var8.printStackTrace();
            }

         }

      }
   }

   public static String getProperty(String key) {
      return props.getProperty(key);
   }
}
