package org.jooqDemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {
    private Date createdOn;
    private Date updatedOn;
}
