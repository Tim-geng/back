package com.baidu.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.pagehelper.PageHelper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 配置包config下的配置类MyConfig
 * @Configuration与@Component相同都是给人看的依赖注入
 */
@Configuration
public class MyConfig {
    /**
     * bean节点返回什么这里就配什么
     * 把这个方法改为bean的办法就是加@bean,这里返回的对象就会进ioc容器
     */
    @Bean
    public HttpMessageConverters getHttpMessageConverters(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero
        );
        List<MediaType> mediaTrackers = new ArrayList<>();
        mediaTrackers.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTrackers);
        StringHttpMessageConverter stringHttpMessageConverter;
        stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(fastJsonHttpMessageConverter,stringHttpMessageConverter);
        return httpMessageConverters;
    }
    public PageHelper getPageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        /*分页合理化*/
        properties.setProperty("reasonable","true");
        /*数据库类型*/
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
