package online.chenke.sourcecode.mybatis;

import online.chenke.sourcecode.mybatis.mapper.ScaleRecordMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Map;

public class MyBatisTest {
    public static void main(String[] args) {
        InputStream is = MyBatisTest.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        ScaleRecordMapper mapper = sqlSession.getMapper(ScaleRecordMapper.class);
        Map map = mapper.selectLastRecord("6675671067190624256");
        System.out.println(map);
        sqlSession.close();
    }
}
