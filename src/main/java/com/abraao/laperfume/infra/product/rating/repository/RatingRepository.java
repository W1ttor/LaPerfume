package com.abraao.laperfume.infra.product.rating.repository;

import com.abraao.laperfume.domain.product.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RatingRepository extends JpaRepository<Rating, UUID>, JpaSpecificationExecutor<Rating> {


    @Query("""
        select r from Rating r
        where 1=1
        and r.rating > :rate
    """)
    Set<Rating> findAllByRatingGreaterThan(@Param("rate") Integer rate);


    @NativeQuery("""
        select r.* from rating r
        where 1=1
        and r.rating > :rate
    """)
    Set<Rating> findAllByRatingGreaterThan2(@Param("rate") Integer rate);
}
