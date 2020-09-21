package com.ulearing.versionmanagement.version.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ulearing.versionmanagement.enums.LogStatusEnum;
import com.ulearing.versionmanagement.user.dao.UserDao;
import com.ulearing.versionmanagement.util.PageUtil;
import com.ulearing.versionmanagement.version.dao.VersionDao;
import com.ulearing.versionmanagement.version.dto.GetLogsRequest;
import com.ulearing.versionmanagement.version.dto.ProjectTagDTO;
import com.ulearing.versionmanagement.version.dto.UpdateLogDTO;
import com.ulearing.versionmanagement.version.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    UserDao userDao;

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
            if (res.getDevUserId() != null) {
                res.setDevUserName(userDao.getUserName(res.getDevUserId()));
            }
            if (res.getOpsUserId() != null) {
                res.setOpsUserName(userDao.getUserName(res.getOpsUserId()));
            }
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
}