package com.badminton.controller;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class Wechat {
	
	public static void main(String[] arg) {
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId("wxf67c2bdba9d635dc"); // 设置微信公众号的appid
		config.setSecret("cd84d18cef60278987021ea595615386"); // 设置微信公众号的app corpSecret
		config.setToken(null); // 设置微信公众号的token
		config.setAesKey(null); // 设置微信公众号的EncodingAESKey
		
		WxMpService wxService = new WxMpServiceImpl();// 实际项目中请注意要保持单例，不要在每次请求时构造实例，具体可以参考demo项目
		wxService.setWxMpConfigStorage(config);
		
		
		WxMenu wxMenu = new WxMenu();

		// 用户的openid在下面地址获得 
		
		try {
			WxMpUser wmUser = wxService.getUserService().userInfo("olaEw1VRmmJHsTEeCI9pFv7kJI6o");
			System.out.println(wmUser.toString());
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	
}
