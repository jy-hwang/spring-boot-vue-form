package org.africalib.form.dto;

import lombok.Getter;
import lombok.Setter;
import org.africalib.form.entity.Application;

@Getter
@Setter
public class ApplicationRequest {

  private String writerName;

  private String content;

  private Character gender;

  private Integer ageRange;

  public Application toEntity() {
    return null;
  }
}
