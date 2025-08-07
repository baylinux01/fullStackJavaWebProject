package baylinux.socialMediaProject;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@RolesAllowed("USER")
@Route(value="/AppUserView/:appUserUsername",layout=MainLayout.class)
public class AppUserView extends Div implements BeforeEnterObserver
{
	AppUser appUser=null;
	
	@Override
    public void beforeEnter(BeforeEnterEvent event) {
        String username = event.getRouteParameters()
                               .get("appUserUsername")
                               .orElseThrow(); // veya Optional kontrolü
        try 
        {
            this.appUser = appService.daoForGet.getAppUserByUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException("Kullanıcı yüklenemedi", e);
        }
        myBuild();
    }
	
	
	AppService appService;
	
	@Autowired
	AppUserView(AppService appService)
	{
		this.appService=appService;
		
	}
	
	
	void myBuild() 
	{
	    
	    if (appUser != null) {
	        add(new Paragraph(appUser.getUsername()));
	    }
	}
	
}
