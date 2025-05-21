package org.africalib.form.service;

import lombok.RequiredArgsConstructor;
import org.africalib.form.dto.FormRead;
import org.africalib.form.entity.Form;
import org.africalib.form.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseFormService implements FormService {

  private final FormRepository formRepository;

  @Override
  public List<FormRead> findAll() {
    List<FormRead> output = new ArrayList<>();

    List<Form> forms = formRepository.findAll();

    for( Form form : forms ) {
      // entity -> dto
      output.add(form.toRead());
    }
    // stream 을 사용해서 변경해보기

    return output;
  }

  @Override
  public FormRead findById(Long id) {
    Optional<Form> optionalForm = formRepository.findById(id);

    return optionalForm.map(Form::toRead).orElse(null);
  }
}
