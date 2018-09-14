package tant.template.dao.test;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Repository;
import tant.template.entity.po.Test;

import java.util.List;

@Repository()
public interface TestDAO {
    @Delete({
        "delete from test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into test (id, `name`, ",
        "dt)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{dt,jdbcType=TIMESTAMP})"
    })
    int insert(Test record);

    @InsertProvider(type=TestSqlProvider.class, method="insertSelective")
    int insertSelective(Test record);

    @Select({
        "select",
        "id, `name`, dt",
        "from test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="dt", property="dt", jdbcType=JdbcType.TIMESTAMP)
    })
    Test selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Test record);

    @Update({
        "update test",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "dt = #{dt,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Test record);
    @InsertProvider(type=TestSqlProvider.class, method="createTestTable")
    int initDB();
@InsertProvider(type=TestSqlProvider.class, method="insertTestData")
    int insertTestDT();
    @DeleteProvider(type=TestSqlProvider.class, method="dropTestTable")
int dropTestDB();
    @Select("select * from test")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="dt", property="dt", jdbcType=JdbcType.TIMESTAMP)
    })
     List<Test> selectALL();
}