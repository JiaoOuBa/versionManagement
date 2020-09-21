package com.ulearing.versionmanagement.version.dao;

import com.ulearing.versionmanagement.version.dto.GetLogsRequest;
import com.ulearing.versionmanagement.version.dto.ProjectTagDTO;
import com.ulearing.versionmanagement.version.dto.UpdateLogDTO;
import com.ulearing.versionmanagement.version.model.ProjectModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-17 16:08
 */
@Mapper
@Component
public interface VersionDao {

    @Select("select * from p_project_tab where region = #{region}")
    List<ProjectModel> getProjectList(Integer region);

    @Select("select version from l_version_tab where projectId = #{id}")
    List<String> getTagsByProject(Integer id);

    List<UpdateLogDTO> getUpdateLogs(GetLogsRequest request);

    @Update("update l_updatelog_tab set status = #{status},opsUserId = #{opsUserId},updateTime = LOCALTIMESTAMP where id = #{logId}")
    void updateStatus(@Param("logId") Integer logId,
                      @Param("status") Integer status,
                      @Param("opsUserId") Integer opsUserId);

    void deleteLogs(List<Integer> logIds);

    @Select("select version as newTag from l_version_tab where projectId = #{id}")
    ProjectTagDTO getNewTag(Integer id);
}
