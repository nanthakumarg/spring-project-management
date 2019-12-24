package com.theybytecloud.pma.dao;

import com.theybytecloud.pma.dto.ChartData;
import com.theybytecloud.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, count(*) as value " +
            "FROM project " +
            "GROUP BY stage ")
    public List<ChartData> getProjectStatus();
}
