package tant.template.dao.test;

import org.apache.ibatis.jdbc.SQL;
import tant.template.entity.po.Test;

public class TestSqlProvider {

    public String insertSelective(Test record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("test");

            if (record.getId() != null) {
                sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDt() != null) {
            sql.VALUES("dt", "#{dt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Test record) {
        SQL sql = new SQL();
        sql.UPDATE("test");
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDt() != null) {
            sql.SET("dt = #{dt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
    public String createTestTable(){
        String sql="CREATE TABLE `test` (\n" +
                "\t`id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "\t`name` VARCHAR(50) NOT NULL,\n" +
                "\t`dt` DATETIME NOT NULL,\n" +
                "\tPRIMARY KEY (`id`)\n" +
                ")\n" +
                "COLLATE='utf8_general_ci'\n" +
                "ENGINE=InnoDB;";
        return sql;
    }
    public String insertTestData(){
        String sql="INSERT INTO `test`.`test` (`name`, `dt`) VALUES ('name1', '2018-09-11 11:45:05');";
        return sql;
    }
    public String dropTestTable(){
        return "DROP TABLE IF EXISTS `test`;";
    }
}