package com.lieve.base.mapper;

import com.lieve.base.entity.City;
import org.apache.ibatis.annotations.*;

/**
 * @author sunlijiang
 * @date 2019/6/29
 */
@Mapper
public interface CityMapper {

    @Select({"SELECT * FROM CITY WHERE state = #{state}"})
    City findByState(@Param("state") String state);

    /**
     *
     * @param city
     * @return
     */
    @Insert("insert into city(id, name, state) values(#{city.id}, #{city.name}, #{city.state})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("city") City city);

}
