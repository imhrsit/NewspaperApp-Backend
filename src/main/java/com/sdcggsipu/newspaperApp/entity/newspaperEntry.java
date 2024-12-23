package com.sdcggsipu.newspaperApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "newspaper_entries")

@Data
public class newspaperEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;
}
