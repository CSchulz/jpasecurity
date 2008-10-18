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
package net.sf.jpasecurity.jpql.compiler;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.sf.jpasecurity.jpql.parser.JpqlSubselect;

/**
 * This class evaluates JPQL queries. If in-memory-evaluation
 * cannot be performed a call to a specified <tt>EntityManager</tt> is used.
 * @author Arne Limburg
 */
public class EntityManagerEvaluator extends InMemoryEvaluator {

    private EntityManager entityManager;
    private JpqlCompiler compiler;

    public EntityManagerEvaluator(EntityManager entityManager, JpqlCompiler compiler) {
        this.entityManager = entityManager;
        this.compiler = compiler;
    }

    public boolean visit(JpqlSubselect node, InMemoryEvaluationParameters data) {
        try {
            Set<String> namedParameters = compiler.getNamedParameters(node);
            Query query = entityManager.createQuery(node.toString());
            for (String namedParameter: namedParameters) {
                query.setParameter(namedParameter, data.getNamedParameterValue(namedParameter));
            }
            data.setResult(query.getResultList());
            return false;
        } catch (NotEvaluatableException e) {
            data.setResultUndefined();
            return false;
        }
    }
}