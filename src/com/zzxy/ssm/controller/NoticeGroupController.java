package com.zzxy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzxy.ssm.common.utils.Constants;
import com.zzxy.ssm.po.AprbTNoticeGroup;
import com.zzxy.ssm.po.AprbTNoticeGroupCustom;
import com.zzxy.ssm.po.AprbTNoticeGroupQueryVO;
import com.zzxy.ssm.po.AprbTOppoGroup;
import com.zzxy.ssm.po.AprbTOppoGroupCustom;
import com.zzxy.ssm.po.AprbTOppoGroupQueryVO;
import com.zzxy.ssm.service.NoticeGroupService;

/**
 * 提示信息群组Controller
 * 
 * @工程： 电话录音盒平台
 * @模块： 
 * 
 * @作者： 王文博
 * @创建日期： 2017年9月1日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
@Controller
@RequestMapping("/notice")
public class NoticeGroupController {
  
  @Autowired
  private NoticeGroupService noticeGroupService;
  
  /**
   * 提醒查询页面
   * 
   * @作者： 王文博
   * @创建日期：2017年9月1日
   *
   * @param noticeGroupQueryVO
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("listNoticeGroup")
  public ModelAndView listNoticeGroup(AprbTNoticeGroupQueryVO noticeGroupQueryVO)throws Exception {
    List<AprbTNoticeGroup> noticeGroups = noticeGroupService.listCustNoticeGroups(noticeGroupQueryVO);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("noticeGroups", noticeGroups);
    modelAndView.addObject("batchType", Constants.ASMG_T_CODE_INFO_BATCHTYPE_NOTICE);
    modelAndView.addObject("noticeGroupCustom", noticeGroupQueryVO.getAprbTNoticeGroupCustom());
    modelAndView.setViewName("group/notice/listNoticeGroup");
    return modelAndView;
  }
  
  /**
   * 编辑提醒客户信息
   * 
   * @作者： 王文博
   * @创建日期：2017年9月1日
   *
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("editNoticeCust")
  public ModelAndView editNoticeCust() throws Exception {
    AprbTNoticeGroup noticeGroup = new AprbTNoticeGroup();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("noticeGroup", noticeGroup);
    modelAndView.setViewName("group/notice/editNoticeCust");
    return modelAndView;
  }
  
  /**
   * 编辑提醒客户信息提交
   * 
   * @作者： 王文博
   * @创建日期：2017年9月1日
   *
   * @param oppoGroup
   * @param request
   * @return
   * @throws Exception String
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("editNoticeCustSubmit")
  public String editNoticeCustSubmit(AprbTNoticeGroup noticeGroup,HttpServletRequest request) throws Exception {
    String custNo = request.getParameter("custNo");
    String noticeType = request.getParameter("noticeType");
    String followStatus = request.getParameter("followStatus");
    noticeGroup.setCustNo(custNo.split(",")[0]);
    noticeGroup.setNoticeType(noticeType);
    noticeGroup.setFollowStatus(followStatus);
    noticeGroupService.saveNoticeGroup(noticeGroup);
    return "forward:listNoticeGroup.do";
  }
  
  /**
   * 根据条件查询消息提醒群组列表
   * 
   * @作者： 王文博
   * @创建日期：2017年9月4日
   *
   * @param noticeType
   * @param followStatus
   * @param noticeGroupCustom
   * @return
   * @throws Exception ModelAndView
   *
   * @修改记录（修改时间、作者、原因）：
   */
  @RequestMapping("queryListNoticeGroup")
  public ModelAndView queryListNoticeGroup(String noticeType,String followStatus,AprbTNoticeGroupCustom noticeGroupCustom) throws Exception{
    noticeGroupCustom.setNoticeType(noticeType);
    noticeGroupCustom.setFollowStatus(followStatus);
    List<AprbTNoticeGroup> noticeGroups = noticeGroupService.listCustNoticeGroups(new AprbTNoticeGroupQueryVO(noticeGroupCustom));
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("noticeGroups", noticeGroups);
    modelAndView.addObject("noticeGroupCustom", noticeGroupCustom);
    modelAndView.setViewName("group/notice/listNoticeGroup");
    return modelAndView;
  }
  
}
