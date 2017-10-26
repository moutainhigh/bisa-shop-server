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
@RequestMapping("/l")//后期改为"user"
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

	private Logger logger =LogManager.getLogger(ShopUserController.class);
	
	@RequestMapping(value="/userCenter",method=RequestMethod.GET)
	public String userCenter(HttpServletRequest request, HttpServletResponse response,Model model,@CurrentUser UserInfoDto userInfoDto){
		/*User user = null;
		try {
			user = userInfoDto.getUser();
			if(user.getUsername()!=null){
				return "user/userCenter";
			}else{
				logger.debug("[/userCenter]could not get user from userInfoDto");
				return "index";
			}
		} catch (NullPointerException e) {
			logger.debug("NullPointerException:[/userCenter]could not get user from userInfoDto");
			return "index";
		}*/
		int user_guid = 359;
		String username = "18682268552";
		//查询当前账户绑定的账号
		List<User> userList = iWebAppUserService.getListUserByGuid(user_guid);
		for(User u :userList){
			switch(u.getL_type()){
			case 1:
				model.addAttribute("phone",u.getUsername());
				break;
			case 2:
				model.addAttribute("mail",u.getUsername());
				break;
				default:
					break;
			}
		}
		try {
			UInfo uInfo = iUInfoService.getUInfoByGuid(user_guid);
			if(uInfo.getUri_pic()!=null){
				model.addAttribute("img_pic",uInfo.getUri_pic());
			}else{
				String img_pic_path = request.getScheme() + "://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/resources/header/default_header/userico_avatar.png";
				model.addAttribute("img_pic",img_pic_path);
			}
		} catch (NullPointerException e) {
			//没有个人资料，报空指针
			String img_pic_path = request.getScheme() + "://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getContextPath()
					+ "/resources/header/default_header/userico_avatar.png";
			model.addAttribute("img_pic",img_pic_path);
		}
		model.addAttribute("username",username);
		return "user/userCenter";
	}
	
	@RequestMapping(value="/upload_portrait",method=RequestMethod.POST)
	public @ResponseBody String upload_portrait(HttpServletRequest request,HttpServletResponse response,String img_portrait,@CurrentUser UserInfoDto userInfoDto){
		User user = null;
		try {
			//user = userInfoDto.getUser();
			user = iWebAppUserService.getUserByGuidAndUsername(359, "18682268552");
			if(user.getUsername()!=null){
				/*
				 * 当前是登录状态
				 */
				String new_pic = null;//新的头像地址
				//判断图片是否为空
				if(img_portrait==null){
					return "null";
				}else{
					//上传图片不为空
				        @SuppressWarnings("restriction")
						BASE64Decoder decoder = new BASE64Decoder();
				      
				        int index = img_portrait.indexOf(",");
				        img_portrait = img_portrait.substring(index+1);
				            @SuppressWarnings("restriction")
							byte[] b = decoder.decodeBuffer(img_portrait);
				            //如果转换编码时报错，则检查img_portrait是否包含了头部信息如：data:image/jpeg;base64,这部分前缀不是需要转换的数据，需要去掉。
				            for(int i=0;i<b.length;++i)
				            {
				                if(b[i]<0){
				                    b[i]+=256;
				                }
				            } 
				            
				            // 文件名,用户名加密.png
				        	String writeFileName = EncryptionUtils.md5EnBit32(user.getUsername())+ ".png";
				        	
				        	//文件夹名字
				     		String strLocalFile = EncryptionUtils.md5EnBit32(user.getUnionid());
				     		
				     		//存到数据库的图片地址
				     		String _filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
							+ request.getContextPath() + "/resources/header/";
				     		 
				     		//存到本地的目录地址
					     	String path = request.getSession().getServletContext().getRealPath("/")
										+ "\\WEB-INF\\resources\\header\\"+strLocalFile;
				     		File rootFile = new File(path);
				     		
				     		//如果这个文件夹不存在，就创建一个
				     		if (!rootFile.exists()){
				     			rootFile.mkdirs();
				     		}
				     		
				     		//拼接新的图片保存地址
				     		new_pic =_filePath+ strLocalFile+"/"+writeFileName;
				     		
				     		//将图片64位编码转成图片存到某个文件夹目录下。
				     		logger.debug("new_pic:"+new_pic);
				     		
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
				if(uInfo!=null){
					/*
					 * 如果该用户已有用户资料且头像不为空。
					 */
					uInfo.setUri_pic(new_pic);
					boolean result = iUInfoService.updateUInfo(uInfo);
					if(!result){
						logger.error("[/upload_portrait]iUInfoService.updateUInfo(uInfo) excute failure");
						return "false";
					}else{
						return "true";
					}
				}else{
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
					if(!result){
						logger.error("[/upload_portrait]iUInfoService.addUInfo("+user_guid+") excute failure");
						return "false";
					}else{
						return "true";
					}
				}
				}
			}else{
				/*
				 * 当前登录状态异常，无法获得用户的user_guid;
				 */
				logger.debug("[/upload_portrait]could not get user from userInfoDto");
				return "false";
			}
		} catch (NullPointerException e) {
			logger.debug("NullPointerException:[/upload_portrait]could not get user from userInfoDto");
			return "false";
		}catch(IOException e1){
			e1.printStackTrace();
			logger.debug("IOException:[/upload_portrait]user_guid["+user.getUser_guid()+"]");
			return "false";
		}
	}
	
	 public static String transfer(String img_portrait){
         /*   
                int index = img_portrait.indexOf(",");
                 img_portrait = img_portrait.substring(index);*/
                 //如果转换编码时报错，则检查img_portrait是否包含了头部信息如：data:image/jpeg;base64,这部分前缀不是需要转换的数据，需要去掉。
                 @SuppressWarnings("restriction")
                   BASE64Decoder decoder = new BASE64Decoder();
                     @SuppressWarnings("restriction")
                         byte[] b;
                         try {
                              b = decoder.decodeBuffer(img_portrait);
                        
                     for(int i=0;i<b.length;++i)
                     {
                         if(b[i]<0){
                             b[i]+=256;
                         }
                     }
                    
                     File rootFile = new File("C:/Users/Administrator.DIY-20170222TLQ/Documents/pic_test");
                    //如果这个文件夹不存在，就创建一个
                    if (!rootFile.exists()){
                         rootFile.mkdirs();
                    }
                    //拼接新的图片保存地址
                    String new_pic ="C:/Users/Administrator.DIY-20170222TLQ/Documents/pic_test/test.png";
                    //将图片64位编码转成图片存到某个文件夹目录下。
                    
                     OutputStream out = new FileOutputStream(new_pic);   
                     out.write(b);
                     out.flush();
                     out.close();          
                    
                     System.out.println("64位编码转换成byte");
                         return img_portrait;
                         } catch (IOException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                              return "异常";
                         }
         }
   
   public static void main(String[] args) {
         String img_portrait = "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";
         transfer(img_portrait);
   }

	
}
