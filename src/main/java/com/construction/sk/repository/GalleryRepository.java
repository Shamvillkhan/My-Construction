package com.construction.sk.repository;

import com.construction.sk.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    List<Gallery> findByCategoryIgnoreCaseContaining(String keyword);
}
