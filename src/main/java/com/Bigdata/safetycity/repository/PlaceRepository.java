package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.datas.Place;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

	/**
	 * 범죄 장소 조회
	 * @param name
	 * @return List<Place>
	 */
	List<Place> findPlaceByName(String name);

	/**
	 * 범죄 장소 Top3 조회
	 * @param name
	 * @return Place(살인)
	 * findTop3PlaceByNameOrderByCountDesc
	 * findTop5ByTimeOrderByCountDesc
	 */
	List<Place> findTop3ByNameOrderByCountDesc(String name);
}