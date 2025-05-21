package org.africalib.form.controller;

import lombok.RequiredArgsConstructor;
import org.africalib.form.dto.FormRead;
import org.africalib.form.service.FormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/forms")
@RequiredArgsConstructor
public class FormController {

  private final FormService formService;

  @GetMapping("")
  public ResponseEntity<List<FormRead>> readAll() {
    List<FormRead> forms = formService.findAll();
    return new ResponseEntity<>(forms, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FormRead> readOne(@PathVariable Long id){
    FormRead formRead = formService.findById(id);

    if(formRead == null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(formRead, HttpStatus.OK);
  }

}
