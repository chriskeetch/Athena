package com.keetch.mongo.model;


import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Version;
import org.bson.types.ObjectId;

public abstract class BaseEntity {

    @Id
    @Property("id")
    protected ObjectId id;

    @Version
    @Property("version")
    private Long version;

    public BaseEntity() {
        super();
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}