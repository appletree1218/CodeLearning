package online.chenke.sourcecode.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface RecordMapper {
    Map selectRecord(@Param("recordId") String recordId);
}
