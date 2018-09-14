package tant.template.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import tant.template.entity.po.Test;

@Service("ServiceTest")
@Slf4j
public class test {

    @Autowired
    tant.template.dao.test.TestDAO test;

    /**
     * 直接获取数据
     *
     * @return
     */
    public List<String> gettestlist() {
        List<String> l = new ArrayList<>();
        l.add("哈喽，hadoop");
        l.add("哈喽，hbase");
        l.add("哈喽，hive");
        l.add("哈喽，pig");
        l.add("哈喽，zookeeper");
        return l;

    }

    public void initDB() {
        log.info("1.删除测试表");
        test.dropTestDB();
        log.info("2.创建测试表");
        test.initDB();
        log.info("3.插入测试数据");
        test.insertTestDT();
    }

    public List<Test> getTestListFromMysql() {
        return test.selectALL();
    }
}

