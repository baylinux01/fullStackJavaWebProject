package baylinux.socialMediaProject;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;
import com.vaadin.flow.server.streams.DownloadResponse;

import jakarta.annotation.security.RolesAllowed;

@RolesAllowed("USER")
@Route(value="/AppUserView/:appUserUsername",layout=MainLayout.class)
public class AppUserView extends Div implements BeforeEnterObserver
{
	AppUser appUser=null;
	Image profilePhoto=null;
	
	@Override
    public void beforeEnter(BeforeEnterEvent event) {
        String username = event.getRouteParameters()
                               .get("appUserUsername")
                               .orElseThrow(); // veya Optional kontrolü
        try 
        {
            this.appUser = appService.daoForGet.getAppUserByUsername(username);
        } 
        catch (Exception e) 
        {
            System.out.println("AppUserView sayfasında user yüklenemedi");;
        }
        try
        {
        	 profilePhoto = new Image("/imageapi/user/" + username, "profilePhoto");
           
        }
        catch(Exception e)
        {
        	
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
	    
	    H1 username=new H1(appUser.getUsername());
	    username.getStyle()
	    .set("position", "absolute")
	    .set("top", "100px")
	    .set("left", "500px");
	    add(username);
	    profilePhoto.setWidth("100px");
	    profilePhoto.setHeight("150px");
	    profilePhoto.getStyle()
	    .set("position", "absolute")
	    .set("width", "300px")
	    .set("height", "500px")
	    .set("top", "100px")
	    .set("left", "100px");
	    add(profilePhoto);
	}


	
	
}
