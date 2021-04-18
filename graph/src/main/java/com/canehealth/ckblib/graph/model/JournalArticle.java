package com.canehealth.ckblib.graph.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;

@Node("Article")
@Data
public class JournalArticle {

    @Id
    private String pmid;

    @Version
    private Long version;

    public String name;

    // @Relationship(type = "EVIDENCE_OF", direction = OUTGOING)
    // private List<BaseRelation> diseases = new ArrayList<>();
}
