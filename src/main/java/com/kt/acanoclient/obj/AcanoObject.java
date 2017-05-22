package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.ID;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.apache.http.message.BasicNameValuePair;
import org.dom4j.Node;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public abstract class AcanoObject {

    public abstract String getNewObjectPath();

    public abstract String getId();

    public abstract void parseBody(Node bodyNode);


    public List<BasicNameValuePair> buildPostParams() {
        List<BasicNameValuePair> params = new ArrayList<>();
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors =
                propertyUtilsBean.getPropertyDescriptors(this);
        Class clazz = this.getClass();
        for (PropertyDescriptor descriptor : descriptors) {
            try {
                String name = descriptor.getName();
                Field field = this.getClass().getDeclaredField(name);
                ID idAnnotation = field.getAnnotation(ID.class);
                if (idAnnotation != null) {
                    continue;
                }
                if (getReadMethod(clazz, descriptor) != null) {

                    String v = new BeanUtilsBean().getProperty(this, name);
                    params.add(new BasicNameValuePair(name, v));
                }
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | NoSuchFieldException e) {

            }
        }
        return params;
    }


    public String buildPutBody() {
        Map<String, String> props = new HashMap<>();
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors =
                propertyUtilsBean.getPropertyDescriptors(this);
        Class clazz = this.getClass();
        for (PropertyDescriptor descriptor : descriptors) {
            try {
                String name = descriptor.getName();
                Field field = this.getClass().getDeclaredField(name);
                ID idAnnotation = field.getAnnotation(ID.class);
                if (idAnnotation != null) {
                    continue;
                }
                if (getReadMethod(clazz, descriptor) != null) {

                    String v = new BeanUtilsBean().getProperty(this, name);
                    props.put(name, v);
                }
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | NoSuchFieldException e) {

            }
        }

        List<String> parts = new ArrayList<>();
        for (Map.Entry<String, String> entry : props.entrySet()) {
            if (StringUtils.isBlank(entry.getValue())) {
                continue;
            }
            try {
                String part = entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
//            String part = entry.getKey() + "=" + entry.getValue();
                parts.add(part);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return StringUtils.join(parts, "&");
    }



    private Method getReadMethod(Class clazz, PropertyDescriptor descriptor) {
        return (MethodUtils.getAccessibleMethod(clazz, descriptor.getReadMethod()));
    }

    protected String readTextValue(Node node) {
        if (node == null) {
            return null;
        } else {
            return node.getText();
        }
    }

    protected int readIntValue(Node node) {
        return transformToInt(readTextValue(node));
    }

    protected boolean readBooleanValue(Node node) {
        return transformToBoolean(readTextValue(node));
    }

    private int transformToInt(String v) {
        if (v != null) {
            try {
                return Integer.valueOf(v);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    private boolean transformToBoolean(String v) {
        return Boolean.valueOf(v);
    }
}
