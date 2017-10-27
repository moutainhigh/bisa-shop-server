package com.bisa.hkshop.gigi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bisa.health.appserver.gigi.service.IUInfoService;
import com.bisa.health.appserver.gigi.service.IWebAppUserService;
import com.bisa.health.appserver.utils.EncryptionUtils;
import com.bisa.health.beans.dto.UserInfoDto;
import com.bisa.health.model.UInfo;
import com.bisa.health.model.User;
import com.bisa.health.routing.annotation.CurrentUser;

import sun.misc.BASE64Decoder;

@Controller
@RequestMapping("/user")
public class ShopUserController {
	/**
	 * 登录请求地址
	 */
	@Value("${login.url}")
	private String login_url;
	@Autowired
	private IWebAppUserService iWebAppUserService;

	@Autowired
	private IUInfoService iUInfoService;

	private Logger logger = LogManager.getLogger(ShopUserController.class);

	@RequestMapping(value = "/userCenter", method = RequestMethod.GET)
	public String userCenter(HttpServletRequest request, HttpServletResponse response, Model model,
			@CurrentUser UserInfoDto userInfoDto) {
		User user = null;
		try {
			user = userInfoDto.getUser();
			if (user.getUsername() != null) {
				int user_guid = user.getUser_guid();
				// 查询当前账户绑定的账号
				List<User> userList = iWebAppUserService.getListUserByGuid(user_guid);
				for (User u : userList) {
					switch (u.getL_type()) {
					case 1:
						model.addAttribute("phone", u.getUsername());
						break;
					case 2:
						model.addAttribute("mail", u.getUsername());
						break;
					default:
						break;
					}
				}
				try {
					UInfo uInfo = iUInfoService.getUInfoByGuid(user_guid);
					if (uInfo.getUri_pic() != null) {
						model.addAttribute("img_pic", uInfo.getUri_pic());
					} else {
						String img_pic_path = request.getScheme() + "://" + request.getServerName() + ":"
								+ request.getServerPort() + request.getContextPath()
								+ "/resources/header/default_header/userico_avatar.png";
						model.addAttribute("img_pic", img_pic_path);
					}
				} catch (NullPointerException e) {
					// 没有个人资料，报空指针
					String img_pic_path = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + request.getContextPath()
							+ "/resources/header/default_header/userico_avatar.png";
					model.addAttribute("img_pic", img_pic_path);
				}
				model.addAttribute("username", user.getUsername());
				return "user/userCenter";
			} else {
				logger.debug("[/userCenter]could not get user from userInfoDto");
				return "index";
			}
		} catch (NullPointerException e) {
			logger.debug("NullPointerException:[/userCenter]could not get user from userInfoDto");
			return "index";
		}
	}

	@RequestMapping(value = "/upload_portrait", method = RequestMethod.POST)
	public @ResponseBody String upload_portrait(HttpServletRequest request, HttpServletResponse response,
			String img_portrait, @CurrentUser UserInfoDto userInfoDto) {
		User user = null;
		try {
			user = userInfoDto.getUser();
			if (user.getUsername() != null) {
				/*
				 * 当前是登录状态
				 */
				String new_pic = null;// 新的头像地址
				// 判断图片是否为空
				if (img_portrait == null) {
					return "null";
				} else {
					// 上传图片不为空
					@SuppressWarnings("restriction")
					BASE64Decoder decoder = new BASE64Decoder();

					int index = img_portrait.indexOf(",");
					img_portrait = img_portrait.substring(index + 1);
					@SuppressWarnings("restriction")
					byte[] b = decoder.decodeBuffer(img_portrait);
					// 如果转换编码时报错，则检查img_portrait是否包含了头部信息如：data:image/jpeg;base64,这部分前缀不是需要转换的数据，需要去掉。
					for (int i = 0; i < b.length; ++i) {
						if (b[i] < 0) {
							b[i] += 256;
						}
					}
					// 文件名,用户名加密.png
					String writeFileName = EncryptionUtils.md5EnBit32(user.getUsername()) + ".png";

					// 文件夹名字
					String strLocalFile = EncryptionUtils.md5EnBit32(user.getUnionid());

					// 存到数据库的图片地址
					String _filePath = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + request.getContextPath() + "/resources/header/";

					// 存到本地的目录地址
					String path = request.getSession().getServletContext().getRealPath("/")
							+ "\\WEB-INF\\resources\\header\\" + strLocalFile;
					File rootFile = new File(path);

					// 如果这个文件夹不存在，就创建一个
					if (!rootFile.exists()) {
						rootFile.mkdirs();
					}

					// 拼接新的图片保存地址
					new_pic = _filePath + strLocalFile + "/" + writeFileName;

					// 将图片64位编码转成图片存到某个文件夹目录下。
					logger.debug("new_pic:" + new_pic);

					File targetFile = new File(path, writeFileName);

					OutputStream out = new FileOutputStream(targetFile);
					out.write(b);

					out.flush();
					out.close();
					/*
					 * 先将编码格式的img_portrait转成图片.jpg或png.
					 * 存到本地文件夹,然后将这个本地存储地址存到数据库就可以了.
					 */

					int user_guid = user.getUser_guid();
					UInfo uInfo = iUInfoService.getUInfoByGuid(user_guid);
					if (uInfo != null) {
						/*
						 * 如果该用户已有用户资料且头像不为空。
						 */
						uInfo.setUri_pic(new_pic);
						boolean result = iUInfoService.updateUInfo(uInfo);
						if (!result) {
							logger.error("[/upload_portrait]iUInfoService.updateUInfo(uInfo) excute failure");
							return "false";
						} else {
							return "true";
						}
					} else {
						/*
						 * 如果该用户没有添加个人资料,则添加个人资料
						 */
						uInfo = new UInfo();
						uInfo.setRole_id(1);
						uInfo.setSalt(user.getUsername());
						uInfo.setUnionid(EncryptionUtils.md5EnBit32(user_guid + ""));
						uInfo.setUser_guid(user_guid);
						uInfo.setUri_pic(new_pic);
						boolean result = iUInfoService.addUInfo(uInfo);
						if (!result) {
							logger.error("[/upload_portrait]iUInfoService.addUInfo(" + user_guid + ") excute failure");
							return "false";
						} else {
							return "true";
						}
					}
				}
			} else {
				/*
				 * 当前登录状态异常，无法获得用户的user_guid;
				 */
				logger.debug("[/upload_portrait]could not get user from userInfoDto");
				return "false";
			}
		} catch (NullPointerException e) {
			logger.debug("NullPointerException:[/upload_portrait]could not get user from userInfoDto");
			return "false";
		} catch (IOException e1) {
			e1.printStackTrace();
			logger.debug("IOException:[/upload_portrait]user_guid[" + user.getUser_guid() + "]");
			return "false";
		}
	}

}
