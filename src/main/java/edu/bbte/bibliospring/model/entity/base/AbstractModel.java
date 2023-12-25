package edu.bbte.bibliospring.model.entity.base;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public abstract class AbstractModel {

    private String uuid;

    AbstractModel() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        AbstractModel that = (AbstractModel) obj;
        return Objects.equals(that.getUuid(), getUuid());
    }

    public UUID getUuid() {
        return UUID.fromString(uuid);
    }

    @PrePersist
    public void onPrePersist() {
        getUuid();
    }
}
