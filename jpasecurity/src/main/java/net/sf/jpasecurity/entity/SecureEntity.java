/*
 * Copyright 2008 Arne Limburg
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
package net.sf.jpasecurity.entity;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

/**
 * This is an interface implemented by every entity
 * that is managed by JPA Security.
 * @author Arne Limburg
 */
public interface SecureEntity {

    boolean isContained(EntityManager entityManager);
    boolean isRemoved();
    SecureEntity merge(EntityManager entityManager);
    void persist(EntityManager entityManager);
    void refresh(EntityManager entityManager);
    void lock(EntityManager entityManager, LockModeType lockMode);
    void remove(EntityManager entityManager);
}