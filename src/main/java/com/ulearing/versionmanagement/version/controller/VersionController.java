package com.ulearing.versionmanagement.version.controller;

import com.ulearing.versionmanagement.enums.ResultEnum;
import com.ulearing.versionmanagement.result.Result;
import com.ulearing.versionmanagement.result.ResultVo;
import com.ulearing.versionmanagement.util.PageUtil;
import com.ulearing.versionmanagement.version.dto.*;
import com.ulearing.versionmanagement.version.model.ProjectModel;
import com.ulearing.versionmanagement.version.service.VersionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 版本管理
 * 2020/9/8
 * tanhao
 */
@RestController
public class VersionController {

    @Autowired
    VersionService versionService;

    /**
     * 获取项目列表
     * @param region
     * @return
     */
    @ApiOperation(value = "获取项目列表")
    @GetMapping("/getProjects")
    public ResultVo<List<ProjectModel>> getProjectList(@ApiParam("区域") @RequestParam(value = "region") Integer region){
        return Result.success(versionService.getProjectList(region));
    }


    /**
     * 获取指定项目的tags列表
     */
    @ApiOperation(value = "获取指定项目的tags列表")
    @GetMapping("/getTags")
    public ResultVo<List<String>> getTagsByProject(@ApiParam("项目id") @RequestParam(value = "projectId") Integer id) {
        return Result.success(versionService.getTagsByProject(id));
    }


    /**
     * 获取更新日志列表
     */
    @PostMapping("/getUpdateLogs")
    @ApiOperation(value = "获取更新日志列表")
    public ResultVo<PageUtil<UpdateLogDTO>> getUpdateLogs(@RequestBody GetLogsRequest request) {
        try {
            return Result.success(versionService.getUpdateLogs(request));
        } catch (Exception e) {
            return Result.error(ResultEnum.FAILED.getCode(), e.getMessage());
        }
    }


    /**
     * 提交更新日志(多个区域，多个项目的版本)
     */
    @PostMapping("/commitLog")
    @ApiOperation(value = "提交更新日志")
    public ResultVo commitLog(@RequestBody List<CommitLogRequest> request) {
        try {
            versionService.commitLog(request);
            return Result.success();
        } catch (Exception e) {
            return Result.error(ResultEnum.FAILED.getCode(), e.getMessage());
        }
    }

    /**
     * 删除更新日志
     */
    @GetMapping("/deleteLogs")
    @ApiOperation(value = "删除更新日志")
    public ResultVo deleteLogs(@ApiParam("日志id集合") @RequestParam(value = "logIds") List<Integer> logIds) {
        versionService.deleteLogs(logIds);
        return Result.success();
    }


    /**
     * 修改更新状态(运维更新之后，修改状态)
     */
    @GetMapping("/updateStatus")
    @ApiOperation(value = "修改更新状态")
    public ResultVo updateStatus(@ApiParam("日志id") @RequestParam(value = "logId") Integer logId) {
        versionService.updateStatus(logId);
        return Result.success();
    }

    /**
         * 获取区域的每个项目的最新版本号
     */
    @ApiOperation(value = "获取区域的每个项目的最新版本号")
    @GetMapping("/getNewTag")
    public ResultVo<List<ProjectTagDTO>> getNewTag(@ApiParam("区域") @RequestParam(value = "region") Integer region){
        return Result.success(versionService.getNewTag(region));
    }

    /**
     * 获取单个区域下，单个项目的更新历史
     */
    @ApiOperation(value = "获取单个区域下，单个项目的更新历史")
    @GetMapping("/getVersionHis")
    public ResultVo<List<VersionHisDTO>> getVersionHis(@ApiParam("区域") @RequestParam(value = "region") Integer region,
                                                       @ApiParam("项目id") @RequestParam(value = "projectId") Integer projectId) {
        try {
            return Result.success(versionService.getVersionHis(region, projectId));
        } catch (Exception e) {
            return Result.error(ResultEnum.FAILED.getCode(), e.getMessage());
        }
    }

}
