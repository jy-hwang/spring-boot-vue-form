package org.africalib.form.entity;

import jakarta.persistence.*;
import org.africalib.form.dto.FormRead;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "forms")
// 신청서 양식
public class Form {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 500)
  private String description;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public FormRead toRead() {
    FormRead formRead = new FormRead();

    formRead.setId(this.id);
    formRead.setTitle(this.title);
    formRead.setDescription(this.description);
    formRead.setCreatedAt(this.createdAt);

    return formRead;
  }
}
