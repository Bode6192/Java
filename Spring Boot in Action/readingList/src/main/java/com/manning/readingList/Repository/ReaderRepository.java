package com.manning.readingList.Repository;

import com.manning.readingList.Entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {

    Reader findByUsername(String username);
}
