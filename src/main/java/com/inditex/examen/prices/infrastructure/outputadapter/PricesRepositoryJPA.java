package com.inditex.examen.prices.infrastructure.outputadapter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository()
public interface PricesRepositoryJPA extends CrudRepository<PricesEntity, Long> {
    @Query(value = "from PricesEntity t where t.startDate <= :requestDate and t.endDate >= :requestDate and t.productId = :productId")
    List<PricesEntity> findByIdAndDataRange(@Param("requestDate") Date requestDate, @Param("productId") Long productId);
}
