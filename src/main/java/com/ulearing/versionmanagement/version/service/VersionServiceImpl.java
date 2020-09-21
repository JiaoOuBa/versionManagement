package com.ulearing.versionmanagement.version.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ulearing.versionmanagement.enums.LogStatusEnum;
import com.ulearing.versionmanagement.user.service.UserService;
import com.ulearing.versionmanagement.util.PageUtil;
import com.ulearing.versionmanagement.version.dao.VersionDao;
import com.ulearing.versionmanagement.version.dto.*;
import com.ulearing.versionmanagement.version.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 版本管理
 * 2020/9/8
 * tanhao
 */
@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    VersionDao versionDao;

    @Autowired
    UserService userService;

    @Override
    public List<ProjectModel> getProjectList(Integer region) {
        return versionDao.getProjectList(region);
    }

    @Override
    public List<String> getTagsByProject(Integer id) {
        return versionDao.getTagsByProject(id);
    }

    @Override
    public PageUtil<UpdateLogDTO> getUpdateLogs(GetLogsRequest request) {
        PageInfo<UpdateLogDTO> pageInfo = PageHelper.startPage(request.getPage(), request.getPageSize())
                                          .doSelectPageInfo(() -> versionDao.getUpdateLogs(request));
        pageInfo.getList().forEach(res -> {
            res.setDevUserName(userService.getUserName(res.getDevUserId()));
            res.setOpsUserName(userService.getUserName(res.getOpsUserId()));
        });
        return new PageUtil<>(pageInfo);
    }

    @Override
    public void updateStatus(Integer logId) {
        // TODO: 2020-09-18 获取当前用户id
        Integer opsUserId = 2;
        versionDao.updateStatus(logId, LogStatusEnum.STATUS_YGX.getCode(), opsUserId);
    }

    @Override
    public void deleteLogs(List<Integer> logIds) {
        versionDao.deleteLogs(logIds);
    }

    @Override
    public List<ProjectTagDTO> getNewTag(Integer region) {
        List<ProjectTagDTO> list = new ArrayList<>();
        List<ProjectModel> projectList = versionDao.getProjectList(region);
        for (ProjectModel project : projectList) {
            ProjectTagDTO newTags = versionDao.getNewTag(project.getId());
            // TODO: 2020-09-21 如果该项目没有version记录，是否展示？
            if (newTags != null) {
                newTags.setId(project.getId());
                newTags.setName(project.getName());
                list.add(newTags);
            }
        }
        return list;
    }

    @Override
    public List<VersionHisDTO> getVersionHis(Integer region, Integer projectId) {
        List<VersionHisDTO> versionHis = versionDao.getVersionHis(region, projectId);
        versionHis.forEach(res -> {
            res.setDevUserName(userService.getUserName(res.getDevUserId()));
            res.setOpsUserName(userService.getUserName(res.getOpsUserId()));
        });
        return versionHis;
    }

    @Override
    public void commitLog(List<CommitLogRequest> request) {
        for (CommitLogRequest commitLogRequest : request) {

            // 写入log表
            commitLogRequest.setStatus(LogStatusEnum.STATUS_DGX.getCode());
            // TODO: 2020-09-21 获取提交人userId
            commitLogRequest.setDevUserId(1);
            Integer logId = versionDao.insertLog(commitLogRequest);
            if (logId == null) {
                throw new RuntimeException("写入日志信息失败");
            }

            // 写入version表
            if (!CollectionUtils.isEmpty(commitLogRequest.getProjectVersionList())) {
                for (ProjectVersionDTO projectVersion : commitLogRequest.getProjectVersionList()) {
                    projectVersion.setLogId(logId);
                    versionDao.insertVersion(projectVersion);
                }
            }
        }
    }

}