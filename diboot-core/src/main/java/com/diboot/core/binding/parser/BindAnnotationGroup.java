package com.diboot.core.binding.parser;

import com.diboot.core.binding.annotation.BindEntity;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.annotation.BindField;
import com.diboot.core.binding.annotation.BindMetadata;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * VO绑定注解的归类分组，用于缓存解析后的结果
 * @author Mazhicheng<br>
 * @version 1.0<br>
 * @date 2019/04/03 <br>
 */
public class BindAnnotationGroup {
    /**
     * Metadata注解
     */
    private List<FieldAnnotation> bindMetadataAnnotations;
    /**
     * 字段关联注解
     */
    private List<FieldAnnotation> bindFieldAnnotations;
    /**
     * 实体关联注解
     */
    private List<FieldAnnotation> bindEntityAnnotations;
    /**
     * 实体集合关联注解
     */
    private List<FieldAnnotation> bindEntityListAnnotations;

    /**
     * 添加注解
     * @param fieldName
     * @param annotation
     */
    public void addBindAnnotation(String fieldName, Annotation annotation){
        if(annotation instanceof BindMetadata){
            if(bindMetadataAnnotations == null){
                bindMetadataAnnotations = new ArrayList<>();
            }
            bindMetadataAnnotations.add(new FieldAnnotation(fieldName, annotation));
        }
        else if(annotation instanceof BindField){
            if(bindFieldAnnotations == null){
                bindFieldAnnotations = new ArrayList<>();
            }
            bindFieldAnnotations.add(new FieldAnnotation(fieldName, annotation));
        }
        else if(annotation instanceof BindEntity){
            if(bindEntityAnnotations == null){
                bindEntityAnnotations = new ArrayList<>();
            }
            bindEntityAnnotations.add(new FieldAnnotation(fieldName, annotation));
        }
        else if(annotation instanceof BindEntityList){
            if(bindEntityListAnnotations == null){
                bindEntityListAnnotations = new ArrayList<>();
            }
            bindEntityListAnnotations.add(new FieldAnnotation(fieldName, annotation));
        }
    }

    public List<FieldAnnotation> getBindMetadataAnnotations() {
        return bindMetadataAnnotations;
    }

    public List<FieldAnnotation> getBindFieldAnnotations() {
        return bindFieldAnnotations;
    }

    public List<FieldAnnotation> getBindEntityAnnotations() {
        return bindEntityAnnotations;
    }

    public List<FieldAnnotation> getBindEntityListAnnotations() {
        return bindEntityListAnnotations;
    }

    public boolean isNotEmpty() {
        return bindMetadataAnnotations != null || bindFieldAnnotations != null || bindEntityAnnotations != null || bindEntityListAnnotations != null;
    }
}
