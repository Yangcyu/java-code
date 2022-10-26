package pers.ycy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ycy.javacode.mvcgen.dtoGenerate.dao.ColumnInfoDAO;
import pers.ycy.javacode.mvcgen.dtoGenerate.entity.ColumnInfoDO;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class JavaCodeApplicationTests {

    @Autowired
    private ColumnInfoDAO columnInfoDAO;
    @Test
    void contextLoads() {
        QueryWrapper<ColumnInfoDO> wrapper = new QueryWrapper<>();
        List<ColumnInfoDO> list = columnInfoDAO.selectList(wrapper);
        assert(list.size()==1);
    }
    @Test
    void contextLoad2() {
        QueryWrapper<ColumnInfoDO> wrapper = new QueryWrapper<>();
        List<ColumnInfoDO> list = columnInfoDAO.selectList(wrapper);
        assert(list.size()==2);
    }

}
