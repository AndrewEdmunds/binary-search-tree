package com.binary_search_tree.main.Repo;

import com.binary_search_tree.main.Entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TreeStructureRepository extends CrudRepository<TreeStructureEntity, Long> {
}
