package com.istad.booksresourceapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Book {
private int id;
private String title;
private int authorID;
private String genre;
private Boolean isPublic;
}
