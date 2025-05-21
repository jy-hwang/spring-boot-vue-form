package org.africalib.form.controller;

import lombok.RequiredArgsConstructor;
import org.africalib.form.dto.ApplicationRequest;
import org.africalib.form.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/applications")
public class ApplicationController {

  private final ApplicationService applicationService;

  @PostMapping("")
  public ResponseEntity<Void> addOne(@RequestBody ApplicationRequest applicationRequest){
    applicationService.save(applicationRequest);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
