package com.admin.serv;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dao.LoggingDAO;
import com.admin.dao.MasterDeviceDAO;
import com.dev.mgm.bean.LoggingEvent;
import com.dev.mgm.bean.LoggingEventJSON;
import com.dev.mgm.bean.MasterDeviceJSON;

@RestController
@RequestMapping("/AdminService")
public class AdminWebPortalService {
		@RequestMapping( value="/viewlog")
		public LoggingEventJSON get() {
			
			LoggingDAO logdao=new LoggingDAO();
			return logdao.getLogUser();

			
		}
		@CrossOrigin
		@RequestMapping( value="/viewlogs/{page_number}/{pagesize}" ,method=RequestMethod.GET)
		public List<LoggingEventJSON> getAllLogs(@PathVariable String page_number,@PathVariable String pagesize) {
			
			LoggingDAO logdao=new LoggingDAO();
			return logdao.getAllLogs(Integer.parseInt(page_number), Integer.parseInt(pagesize));
			
		}
		@CrossOrigin
		@RequestMapping( value="/viewdevice/{page_number}/{pagesize}" ,method=RequestMethod.GET)
		public List<MasterDeviceJSON> getAllMasterDeviceList(@PathVariable String page_number,@PathVariable String pagesize) {
			
			MasterDeviceDAO dao=new MasterDeviceDAO();
			return dao.getAllDevice(Integer.parseInt(page_number), Integer.parseInt(pagesize));
			
			
		}
		/*@CrossOrigin
		@RequestMapping(value="/changepassword/",method=RequestMethod.GET)
		public String changePassword() {
			
			System.out.println("Working");
			ChangePasswordDAO changePasswordDAO=new ChangePasswordDAO();
			return changePasswordDAO.changePassword(admin);
			return "Return";
		}*/
	
	
}
