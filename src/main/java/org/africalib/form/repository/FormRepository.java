package org.africalib.form.repository;

import org.africalib.form.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

  // 특정 ID로 신청서 조회
  Optional<Form> findById(Long id);

}
