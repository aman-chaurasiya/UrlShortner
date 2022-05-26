package com.urlshortner.repository;

import com.urlshortner.Entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<Url,Long> {


}
