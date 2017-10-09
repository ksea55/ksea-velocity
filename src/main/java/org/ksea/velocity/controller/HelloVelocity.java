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
 * 第一个运行的Velocity程序
 */
public class HelloVelocity {

    public static void main(String[] args) {

        //初始化模版引擎
        VelocityEngine ve = new VelocityEngine();
        //设置其资源加载路径为classpath
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        //指定使用ClasspathResourceLoader来加载vm文件
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        //对其进行初始化
        ve.init();

        //获取模版文件
        Template template = ve.getTemplate("velocityTemplate/helloVelocity.vm");

        //向模版中设置变量,这是Velocity的容器
        VelocityContext vc = new VelocityContext();

        //让容器中添加数据 key为name value为Velocity的数据
        vc.put("name", "Velocity");

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        //添加集合
        vc.put("list", list);


        StringWriter sw = new StringWriter();

        template.merge(vc, sw);
        System.out.println(sw.toString());

        /**
         *
         * 打印结果:
         *
         *
         * 打印变量值: hello Velocity

         对list数组进行遍历结果:
         1
         2
         3
         *
         *
         */
    }
}
