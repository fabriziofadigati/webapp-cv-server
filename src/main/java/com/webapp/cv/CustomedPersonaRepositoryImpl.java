package com.webapp.cv;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

public class CustomedPersonaRepositoryImpl implements CustomedPersonaRepository {

    private EntityManagerFactory entityManagerFactory;

    
    @PersistenceContext
    private EntityManager em = null;
    
    @Override
    public List<Persona> search(String terms, int limit, int offset) {

        em = entityManagerFactory.createEntityManager();

        FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
        em.getTransaction().begin();

        // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        org.hibernate.search.query.dsl.QueryBuilder qb = fullTextEntityManager
            .getSearchFactory()
            .buildQueryBuilder().forEntity(Persona.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
        .keyword()
        .onFields("nome", "cognome", "via", 
        "comuneresidenza", "cap", "nazionalita", 
        "sesso", "email", "numerocellulare", 
        "codicefiscale", "attualepartitaiva",
        "desideratapartitaiva")
        .matching(terms)
        .createQuery();

        // wrap Lucene query in a javax.persistence.Query
        javax.persistence.Query jpaQuery =
        fullTextEntityManager.createFullTextQuery(luceneQuery, Persona.class);

        // execute search
        List<Persona> result = jpaQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        
        return result;
       
    }


}