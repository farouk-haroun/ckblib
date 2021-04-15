package com.canehealth.ckblib.graph.repository;

import com.canehealth.ckblib.graph.model.DiseaseDisorderMention;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DiseaseDisorderReactiveRepository extends ReactiveNeo4jRepository <DiseaseDisorderMention, String> {

    Flux<DiseaseDisorderMention> findAll();

    Mono<DiseaseDisorderMention> findById(String cui);

    Mono<DiseaseDisorderMention> findOneByCui(String cui);

    Flux<DiseaseDisorderMention> findAllByNameLikeIgnoreCase(String name);

    Flux<DiseaseDisorderMention> findAllBySymptomsName(String name);

    Flux<DiseaseDisorderMention> findAllByAnatomyName(String name);

    Flux<DiseaseDisorderMention> findAllByTreatmentName(String name);

    Flux<DiseaseDisorderMention> findAllByProceduresName(String name);

}
