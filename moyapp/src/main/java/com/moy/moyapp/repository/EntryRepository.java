package com.moy.moyapp.repository;

import java.util.List;
import com.moy.moyapp.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry,Long>
{
    List<Entry> findByName(String name);
    List<Entry> findByVillage(String village);

}
