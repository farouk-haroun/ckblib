package com.canehealth.ckblib.graph;

import com.canehealth.ckblib.graph.model.DiseaseDisorderMention;
import com.canehealth.ckblib.graph.model.SignSymptomMention;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SignSymptomRepository extends ReactiveNeo4jRepository<SignSymptomMention, String> {

    Flux<SignSymptomMention> findAll();

    // Mono<DiseaseDisorderMention> findById(String cui);

    Mono<SignSymptomMention> findOneByCui(String cui);

    Flux<SignSymptomMention> findAllByNameLikeIgnoreCase(String name);

    @Query("MATCH (d:Disease) <-[:PRESENTATION_OF]- (s:Symptom {cui: $cui} ) RETURN d")
    Flux<DiseaseDisorderMention> findAllDiseasesWithSymptomsByCui(String cui);

    @Query("MERGE(d:Disease {cui: $dcui}) <-[:PRESENTATION_OF]-> (s:Symptom {cui: $scui}) RETURN d")
    Mono<DiseaseDisorderMention> mergeDiseaseWithSymptom(String dcui, String scui);

}
