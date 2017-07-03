package com.josephee.cs462.helper.repository;

import com.josephee.cs462.helper.domain.Helper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelperRepository extends JpaRepository<Helper, Long> {
}
