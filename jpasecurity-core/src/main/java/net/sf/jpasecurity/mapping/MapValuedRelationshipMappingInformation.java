/*
 * Copyright 2012 Arne Limburg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package net.sf.jpasecurity.mapping;

import java.util.Map;

import net.sf.jpasecurity.CascadeType;
import net.sf.jpasecurity.ExceptionFactory;
import net.sf.jpasecurity.FetchType;

/**
 * @author Arne Limburg
 */
public class MapValuedRelationshipMappingInformation extends CollectionValuedRelationshipMappingInformation {

    private Class<?> keyClass;

    public MapValuedRelationshipMappingInformation(String propertyName,
                                                   Class<?> keyClass,
                                                   ClassMappingInformation relatedClassMapping,
                                                   ClassMappingInformation declaringClassMapping,
                                                   PropertyAccessStrategy propertyAccessStrategy,
                                                   ExceptionFactory exceptionFactory,
                                                   FetchType fetchType,
                                                   CascadeType... cascadeTypes) {
        super(propertyName,
              Map.class,
              relatedClassMapping,
              declaringClassMapping,
              propertyAccessStrategy,
              exceptionFactory,
              fetchType,
              cascadeTypes);
    }

    public Class<?> getKeyClass() {
        return keyClass;
    }

    public boolean isMapMapping() {
        return true;
    }
}