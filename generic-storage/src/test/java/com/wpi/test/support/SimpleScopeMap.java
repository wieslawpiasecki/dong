package com.wpi.test.support;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wiesław Piasecki on 2015-01-02.
 */
public class SimpleScopeMap implements Scope {

    /**
     * This map contains for each bean value or ID the created object. The
     * objects are created with a spring object factory.
     */
    private final Map<String, Object> objectMap =
            new HashMap<String, Object>();

    /**
     * {@inheritDoc}
     */
    public Object get(final String theName,
                      final ObjectFactory theObjectFactory) {
        Object object = objectMap.get(theName);
        if (null == object) {
            object = theObjectFactory.getObject();
            objectMap.put(theName, object);
        }
        return object;
    }

    /**
     * {@inheritDoc}
     */
    public String getConversationId() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void registerDestructionCallback(final String theName,
                                            final Runnable theCallback) {
        // nothing to do ... this is optional and not required
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Object remove(final String theName) {
        return objectMap.remove(theName);
    }

}
