package com.qat.crud.domain.Bundle.BAR.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qat.crud.domain.Bundle.model.Bundle;

@Mapper
public interface BundleMapper {

    @Select("select * from bundle where \"status\" != 'deleted'")
    List<Bundle> fetchAll();

    @Select("select * from bundle where \"id\" = #{id} and \"status\" != 'deleted' ")
    Bundle fetchById(@Param("id") int id);

    @Insert("insert into bundle (\"namePackage\", \"zipCodeOrigin\", \"zipCodeDestin\", \"description\", \"status\")   values(#{namePackage}, #{zipCodeOrigin}, #{zipCodeDestin}, #{description}, #{status}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean insert(Bundle bundle);

    @Update("update bundle set \"namePackage\" = #{namePackage}, \"zipCodeOrigin\" = #{zipCodeOrigin}, \"zipCodeDestin\" = #{zipCodeDestin}, \"description\" = #{description}, \"status\" = #{status} where \"id\" = #{id} ")
    boolean updatedById(Bundle bundle);

    @Delete("delete from bundle where \"id\" = #{id}")
    boolean deleteById(@Param("id") int id);

}
