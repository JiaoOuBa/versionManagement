package com.ulearing.versionmanagement.version.service;

import com.ulearing.versionmanagement.util.PageUtil;
import com.ulearing.versionmanagement.version.dto.*;
import com.ulearing.versionmanagement.version.model.ProjectModel;

import java.util.List;

/**
 * 2020/9/8
 * tanhao
 */
public interface VersionService {

    /**
     * 获取项目列表
     * @param region
     * @return
     */
    List<ProjectModel> getProjectList(Integer region);

    /**
     * 获取指定项目的tags列表
     * @param id
     * @return
     */
    List<String> getTagsByProject(Integer id);

    /**
     * 获取更新日志列表
     * @param request
     * @return
     */
    PageUtil<UpdateLogDTO> getUpdateLogs(GetLogsRequest request);

    /**
     * 修改更新状态(运维更新之后，修改状态)
     * @param logId
     */
    void updateStatus(Integer logId);

    /**
     * 删除更新日志
     * @param logIds
     */
    void deleteLogs(List<Integer> logIds);

    /**
     * 获取区域的每个项目的最新版本号
     * @param region
     * @return
     */
    List<ProjectTagDTO> getNewTag(Integer region);

    /**
     * 获取单个区域下，单个项目的更新历史
     * @param region
     * @param projectId
     * @return
     */
    List<VersionHisDTO> getVersionHis(Integer region, Integer projectId);

    /**
     * 提交更新日志(多个区域，多个项目的版本)
     * @param request
     */
    void commitLog(List<CommitLogRequest> request);
}
