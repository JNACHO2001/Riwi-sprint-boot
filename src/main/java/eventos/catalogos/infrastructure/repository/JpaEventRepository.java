package eventos.catalogos.infrastructure.repository;

import eventos.catalogos.infrastructure.entities.EventEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaEventRepository extends JpaRepository<EventEntity, Long>, JpaSpecificationExecutor<EventEntity> {

    @EntityGraph(attributePaths = { "venue" })
    List<EventEntity> findByVenueId(Long venueId);

    @EntityGraph(attributePaths = { "venue" })
    @Query("SELECT e FROM EventEntity e WHERE e.date BETWEEN :startDate AND :endDate")
    List<EventEntity> findByDateRange(@Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Override
    @EntityGraph(attributePaths = { "venue" })
    List<EventEntity> findAll();

    @Override
    @EntityGraph(attributePaths = { "venue" })
    List<EventEntity> findAll(org.springframework.data.jpa.domain.Specification<EventEntity> spec);
}
