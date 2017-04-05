package mb.sys.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mb.sys.entity.SysUser;
import mb.sys.facade.SysUserFacade;

@Controller
public class SysIndexController {
	
	@Resource
	private SysUserFacade sysUserFacade;
	
	
	@RequestMapping("sysindex.html")
	public ModelAndView index(){
		
		System.out.println(this.sysUserFacade);
		
		SysUser su=this.sysUserFacade.getUser();
		System.out.println(su.getName());
		return new ModelAndView("sysindex");
	}
}
