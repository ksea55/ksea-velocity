package org.ksea.velocity.controller;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装一个共有类，便于测试Velocity的其它方法
 */
public class BaseVelocity {
    private static VelocityEngine ve;

    static {
        //初始化模版引擎
        ve = new VelocityEngine();
    }


    public static void parseVelocity(String templateName, VelocityContext vc) {

        //设置其资源加载路径为classpath
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        //指定使用ClasspathResourceLoader来加载vm文件
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        //对其进行初始化
        ve.init();

        //获取模版文件
        Template template = ve.getTemplate("velocityTemplate/" + templateName);

        StringWriter sw = new StringWriter();

        template.merge(vc, sw);
        System.out.println(sw.toString());

    }
}
