package com.wpi.common.context.annotation;

/**
 * Created by Wiesław Piasecki on 2015-01-02.
 */
/*
 * StereotypedBeanNameGenerator
 * Date of creation: 2010-10-26
 *
 * Copyright (c) CompuGROUP Software GmbH,
 * This software is the confidential and proprietary information of
 * CompuGROUP Software GmbH. You shall not disclose such confidential
 * information and shall use it only in accordance with the terms of
 * the license agreement you entered into with CompuGROUP Software GmbH.
 */
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Set;

public class StereotypedBeanNameGenerator implements BeanNameGenerator {
    /***/
    private static final String COMPONENT_ANNOTATION_CLASSNAME = "org.springframework.stereotype.Component";

    /** {@inheritDoc} */
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        if (definition instanceof AnnotatedBeanDefinition) {
            String beanName = determineBeanNameFromAnnotation((AnnotatedBeanDefinition) definition);
            if (StringUtils.hasText(beanName)) {
                // Explicit bean value found.
                return beanName;
            }
        }
        // Fallback: generate a unique default bean value.
        return buildDefaultBeanName(definition, registry);
    }

    /**
     * Derive a bean value from one of the annotations on the class.
     *
     * @param annotatedDef
     *                the annotation-aware bean definition
     * @return the bean value, or <code>null</code> if none is found
     */
    protected String determineBeanNameFromAnnotation(AnnotatedBeanDefinition annotatedDef) {
        AnnotationMetadata amd = annotatedDef.getMetadata();
        Set<String> types = amd.getAnnotationTypes();
        String beanName = null;
        for (String type : types) {
            Map<String, Object> attributes = amd.getAnnotationAttributes(type);
            if (isStereotypeWithNameValue(type, amd.getMetaAnnotationTypes(type), attributes)) {
                String value = (String) attributes.get("value");
                if (StringUtils.hasLength(value)) {
                    if (beanName != null && !value.equals(beanName)) {
                        throw new IllegalStateException("Stereotype annotations suggest inconsistent "
                                + "component names: '" + beanName + "' versus '" + value + "'");
                    }
                    beanName = value;
                }
            }
        }
        return beanName;
    }

    /**
     * Check whether the given annotation is a stereotype that is allowed to suggest a component value through its
     * annotation <code>value()</code>.
     *
     * @param annotationType
     *                the value of the annotation class to check
     * @param metaAnnotationTypes
     *                the names of meta-annotations on the given annotation
     * @param attributes
     *                the map of attributes for the given annotation
     * @return whether the annotation qualifies as a stereotype with component value
     */
    protected boolean isStereotypeWithNameValue(String annotationType, Set<String> metaAnnotationTypes,
                                                Map<String, Object> attributes) {

        boolean isStereotype =
                annotationType.equals(COMPONENT_ANNOTATION_CLASSNAME)
                        || (metaAnnotationTypes != null && metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME));
        return (isStereotype && attributes != null && attributes.containsKey("value"));
    }

    /**
     * Derive a default bean value from the given bean definition (delegating to
     * {@link BeanDefinitionReaderUtils#generateBeanName(BeanDefinition, BeanDefinitionRegistry)}).
     *
     * @param definition
     *                the bean definition to build a bean value for
     * @param registry
     *                the bean definition registry that the given definition is supposed to be registered with
     * @return the default bean value (never <code>null</code>)
     */
    private String buildDefaultBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return BeanDefinitionReaderUtils.generateBeanName(definition, registry);
    }
}
