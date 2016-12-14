package com.transn.houtai.util;

import java.math.BigDecimal;

public class Config {

	/**
	 * 响应码数据字典
	 */
	public final static int STATUS_200 = 200;
	public final static String MSG_200 = "正常处理，并data中有返回数据";
	public final static String MSG_CREATE_200 = "创建成功";
	public final static String MSG_DELETE_200 = "删除成功";
	public final static String MSG_UPDATE_200 = "更新成功";
	public final static String MSG_LOGIN_200 = "登录成功";
	public final static String MSG_CHECK_200 = "检查登陆成功";
	public final static String MSG_OUT_200 = "退出成功";
	public final static String KICK_OUT_200 = "踢出成功";
	public final static String MSG_JOIN_200 = "加入群成功";
	public final static String MSG_UNJOIN_200 = "管理员拒绝成员加入群组";
	public final static String MSG_TOADMIN_200 = "操作成功";
	public final static String MSG_FAV_200 = "收藏成功";
	public final static String MSG_RESTPASSWORD_200 = "密码设置成功";
	public final static String MSG_SENDSMSSUCCESS_200 = "验证码已发送，请查收";
	public final static String MSG_INVITEJOINGROUP_200 = "邀请加入群组成功";
	public final static String MSG_INVITE_200 = "邀请成功";
	public final static String MSG_CONTACTAPPLYSUCCESS_200 = "关注成功";
	public final static String MSG_DELETECONTACTSUCESS_200 = "取消关注成功";
	public final static String MSG_ADDBULACKSUCESS_200 = "添加黑名单成功";
	public final static String MSG_DELETEBULACKSUCESS_200 = "删除黑名单成功";
	public final static String MSG_SHARESUCESS_200 = "分享成功";
	public final static String MSG_REGIST_200 = "注册成功";
	public final static String MSG_CHECKED_200 = "激活成功";
	public final static String MSG_DISPALY_200 = "置顶成功";
	public final static String MSG_NODISPALY_200 = "取消置顶成功";
	public final static String MSG_ORDERCREATE_200 = "订单生成成功";
	public final static String MSG_PAY_200 = "支付成功";
	public final static String MSG_PAY_201 = "支付失败";
	public final static String MSG_ORDERCANCEL_200 = "订单取消成功";
	public final static String MSG_ORDERDELE_200 = "订单删除成功";
	public final static String MSG_REFRESH_200 = "刷新成功";
	public final static String MSG_AUTH_200 = "认证成功";

	public final static String MSG_CREATEACTIVITY_200 = "报名成功";
	public final static int STATUS_201 = 201;
	public final static int STATUS_301 = 301;
	public final static String MSG_201 = "正常处理，但 data中没有返回数据";
	public final static String MSG_NOTMOBILE_201 = "填写的手机号码错误，请重新填写";
	public final static String MSG_NOTMOBILEERROR_201 = "填写的手机号码格式错误，请重新填写";
	public final static String MSG_NOMSGCODE_201 = "短信验证码已过有效时间";
	public final static String MSG_REGISTSMS_201 = "填写的员工号错误，请重新填写";
	public final static String MSG_CHANGEPWD_201 = "抱歉,您今天请求更改密码短信条数过多";
	public final static String MSG_NOSMSNUM_201 = "抱歉,您发送短信过于频繁,请稍后重试";
	public final static String MSG_CREATE_201 = "小组名称已被抢注，请重填";
	public final static String MSG_DELETE_201 = "解散失败，权限不够";
	public final static String MSG_UPLOAD_201 = "上传失败";
	public final static String MSG_UPDATE_201 = "更新失败";
	public final static String MSG_UPDATENOUSER_201 = "此用户不存在";
	public final static String MSG_REALNAME_201 = "昵称已存在";
	public final static String MSG_NODATA_201 = "无此数据";
	public final static String MSG_SHARE_201 = "用户已报名";
	public final static String MSG_ATTENTION_201 = "分享失败";
	public final static String MSG_JOINFALSEPWD_201 = "加入群组失败，密码错误";
	public final static String MSG_CANNOTAGREE_201 = "无权限同意申请者入群";
	public final static String MSG_NOSECNOA_201 = "无权限拒绝申请者入群";
	public final static String MSG_USERMESSAGE_201 = "同步用户推送消息列表失败";
	public final static String MSG_USERISLIVE_201 = "已经加入过该群";
	public final static String MSG_NOPERMISSION_201 = "无权限修改";
	public final static String MSG_NOACESS_201 = "无权限操作";
	public final static String MSG_GROUPNOPWD_201 = "没有上传群组密码";
	public final static String MSG_ISOPENERR_201 = "群组权限设置错误";
	public final static String MSG_NULLGROUPID_201 = "群组ID为空";
	public final static String MSG_PASSWORD_201 = "两次密码输入的不同";
	public final static String MSG_NOUSER_201 = "填写的手机号码错误，请重新填写";
	public final static String MSG_ISMEMBER_201 = "您已经加入此群组";
	public final static String MSG_CREATEERROR_201 = "创建失败";
	public final static String MSG_SKILL_201 = "此技能已经添加过，请重新选择";
	public final static String MSG_GROUPNAME_201 = "请设置小组名称";
	public final static String MSG_ISNOTUSER_201 = "手机号未注册，请重填";
	public final static String MSG_QRCODE_CREATEFAILS_201 = "抱歉，二维码生成失败";
	public final static String MSG_ALREADFriend_201 = "此用户已经为您的好友";
	public final static String MSG_ALREADAPPLY_201 = "此用户已关注";
	public final static String MSG_BLACKFriend_201 = "对方设置黑名单，无法关注";
	public final static String MSG_ALREADBLACK_201 = "已经对此用户设置黑名单";
	public final static String MSG_NOTHISGROUP_201 = "此群组已经解散";
	public final static String MSG_USERNOTFIND_201 = "未找到此注册用户";
	public final static String MSG_USERINFOERROR_201 = "用户信息错误";
	public final static String MSG_PROPERTIESERROR_201 = "请求参数信息错误";
	public final static String MSG_NOTINGROUP_201 = "请先加入群组";
	public final static String MSG_COURSEHADSHARE_201 = "此课程已经分享";
	public final static String MSG_COURSEHADFAV_201 = "此课程已经收藏";
	public final static String MSG_NOTHISFAVCOURSE_201 = "无此类收藏课程";
	public final static String MSG_XUEYE_201 = "您已经上传过该炫页";
	public final static String MSG_DRYCARGO_201 = "您已经上传过该简历";
	public final static String MSG_NOREGIST_201 = "此用户未注册";
	public final static String MSG_NOLOGIN_201 = "此用户无权限登陆";
	public final static String MSG_KNGMODIFY_201 = "没有权限修改该知识";
	public final static String MSG_ACTIVELINKERROR_201 = "此激活链接失效";
	public final static String MSG_ACTIVED_201 = "此用户已经激活";
	public final static String MSG_NOTEMAIL_201 = "填写的email错误，请重新填写";
	public final static String MSG_NOTEMAIL_202 = "员工号错误，请重填";
	public final static String MSG_LIKE_201 = "您已经赞过";
	public final static String MSG_ISFAV_201 = "您已经收藏过";
	public final static String MSG_ISDELETE_201 = "任务已过期";
	public final static String MSG_PUSHFAIL_201 = "消息推送失败";
	public final static String MSG_PUSHFAIL_203 = "任务时间重复";
	public final static String MSG_PUSHFAIL_204 = "该时间范围内已有其他日程";
	public final static String MSG_PUSHFAIL_205 = "用户日程已删除";
	public final static String MSG_PUSHFAIL_206 = "日程不存在";
	public final static String MSG_PUSHFAIL_207 = "官方日程不允许修改";
	public final static String MSG_PUSHFAIL_208 = "报名任务已经通过";
	public final static String MSG_PUSHFAIL_220 = "该用户已经被锁定";
	public final static String MSG_PUSHFAIL_210 = "该会议金额不符合要求";
	public final static String MSG_PUSHFAIL_221 = "该订单正在支付";
	public final static String MSG_PUSHFAIL_209 = "该会议报名人数不足";
	public final static String MSG_PUSHFAIL_211 = "该会议订单已经因超时被系统自动取消";
	public final static String MSG_PUSHFAIL_212 = "该译员已经在预约列表里面";

	public final static String MSG_POSITION_201 = "获取地理坐标失败";
	public final static String MSG_LIFE_201 = "生活不存在";

	public final static String MSG_ERRORCODE_201 = "填写的验证码错误，请重新获取";
	public final static String MSG_ERRORTOMUCH_201 = "手机验证码多次错误，请重新获取新的短信验证码";
	public final static String MSG_FREQUENT_201 = "请等待60秒再次发送短信验证码";
	public final static String MSG_SENDMSGERROR_201 = "发送短信验证码失败";
	public final static String MSG_CODEFAILURE_201 = "请输入正确的验证码";

	public final static String MSG_FAV_201 = "您已经添加过此译员";
	public final static String MSG_FAVDAY_201 = "该用户不存在";
	public final static String MSG_JOB_201 = "当前岗位与感兴趣岗位不允许相同，请重新选择";
	public final static String MSG_VERSION_201 = "当前版本已经存在";
	public final static String MSG_NOFAVSTUDYED_201 = "您还没有已学完的收藏课程";
	public final static String MSG_NOFAVSTUDYING_201 = "您还没有正在学的收藏课程";
	public final static String MSG_NOSTUDYCOURSE_201 = "您还没有学习课程";
	public final static String MSG_MAILTEMPLE_ERROR = "邮件模板生成失败";
	public final static String MSG_ERROP_ADDCITEMS_201 = "调用转码回调接口时 参数非法";
	public final static String MSG_ERROP_ADDCITEMFINDK_201 = "调用转码回调接口时 通过cid没有找到知识";
	public final static String MSG_ERROP_GETKNGP_201 = "获取知识信息是 参数非法";
	public final static String MSG_ERROCKEY_201 = "云存储配置信息有误";
	public final static String MSG_DRYCAROGEXIT_201 = "该干货已经被分享过";
	public final static String MSG_REGISTFAIL_201 = "您输入的用户名与类型不匹配";
	public final static String MSG_EMAILUSER_201 = "该email已经注册过，请";
	public final static String MSG_EMAILUSERNOCHECK_201 = "该email注册过，未激活，请先激活";
	public final static String MSG_THRIDFAILURE_201 = "无此登录方式";
	public final static String MSG_REGISTTYPE_201 = "注册类型不匹配";
	public final static String MSG_REGISTNOCHECK_201 = "该用户未被激活";
	public final static String MSG_XUANYEGEXIT_201 = "该炫页已经被分享过";
	public final static String MSG_PASSWORDERROR_201 = "密码不正确";
	public final static String MSG_NEWGROUPCOURSENULL_201 = "群组课程数据异常";
	public final static String MSG_DISPALY_201 = "置顶失败，权限不够";
	public final static String MSG_NODISPALY_201 = "取消置顶失败，权限不够";
	public final static String MSG_DISPALYCOUNT_201 = "置顶数量已经超限";
	public final static String MSG_NOFAV_201 = "您还收藏课程";
	public final static String MSG_SIGNUP_201 = "非报名时间";
	public final static String MSG_SIGNUPMAX_201 = "报名人数已满";
	public final static String MSG_SIGNUPNOW_201 = "您已经报名该活动";
	public final static String MSG_COURSEDELETE_201 = "此课程已经删除";
	public final static String MSG_NOGROUP_201 = "活动没有选择群租";
	public final static String MSG_SIGNEXPRE_201 = "活动已过期";
	public final static String MSG_SIGNEXPRE_202 = "用户验证码删除失败";
	public final static String MSG_USERINFOERROR_202 = "用户信息不完整";
	public final static String MSG_USERFRIEND_202 = "添加的名单在最佳搭档里面已存在";
	public final static String MSG_USERFRIEND_203 = "添加的名单在黑名单里面已存在";
	public final static String MSG_USERFRIEND_204 = "添加的名单在系统里不存在";
	public final static String MSG_USERRESUME_201 = "导入译员用户失败";

	public final static int STATUS_202 = 202;
	public final static String MSG_202 = "退出失败！";

	public final static int STATUS_203 = 203;
	public final static String MSG_203 = "认证失败,token和token_secret没有记录或缺失导致";

	public final static int STATUS_204 = 204;
	public final static String MSG_204 = "申请加入成功，请等待管理员同意";

	public final static int STATUS_205 = 205;
	public final static String MSG_205 = "您不在该群内，无法参加话题讨论，请先加入该群";

	public final static int STATUS_206 = 206;
	public final static String MSG_ALREADY_206 = "已操作过";

	public final static int STATUS_400 = 400;
	public final static String MSG_400 = "手机号已注册，请重填";

	public final static int STATUS_401 = 401;
	public final static String MSG_401 = "邮箱已注册，请重填";

	public final static int STATUS_403 = 403;
	public final static String MSG_403 = "未授权，当前发起请求的用户没有访问此接口的权限";

	public final static int STATUS_404 = 404;
	public final static String MSG_404 = "密码错误，请重填";

	public final static int STATUS_405 = 405;
	public final static String MSG_405 = "当前发起请求的用户已经被禁止";

	public final static int STATUS_406 = 406;
	public final static String MSG_406 = "根据当前提供的输入信息无法找到对应的资源";

	public final static int STATUS_407 = 407;
	public final static String MSG_407 = "手机号没注册，请注册";

	public final static int STATUS_408 = 408;
	public final static String MSG_408 = "认证码不存在";

	public final static int STATUS_409 = 409;
	public final static String MSG_409 = "认证码已失效";

	public final static int STATUS_500 = 500;
	public final static String MSG_500 = "请求参数无效";

	public final static int STATUS_501 = 501;
	public final static String MSG_501 = "缺失设备硬件信息";

	public final static int STATUS_502 = 502;
	public final static String MSG_502 = "缺失地理位置信息";

	public final static int STATUS_503 = 503;
	public final static String MSG_503 = "请求超时";

	public final static int STATUS_505 = 505;
	public final static String MSG_505 = "服务器端发生错误";

	public final static int STATUS_510 = 510;
	public final static String MSG_510 = "请求参数的长度非法";

	public final static int STATUS_504 = 504;
	public final static String MSG_504 = "数据中心接口请求发送未知错误";

	public final static int STATUS_600 = 600;
	public final static String MSG_600 = "请求的接口失效";

	public final static int STATUS_601 = 601;
	public final static String MSG_NOGROUP_601 = "该群已解散";

	public final static int STATUS_701 = 701;
	public final static String MSG_NOGROUP_701 = "该用户已经登录";

	public final static int STATUS_801 = 801;
	public final static String MSG_NOGROUP_801 = "用户登录已失效，请重新登录";

	public final static String MSG_NOGROUP_901 = "原密码错误，请重填";

	public final static String MSG_NOGROUP_902 = "简介导入失败，请您联系客服人员";



}
