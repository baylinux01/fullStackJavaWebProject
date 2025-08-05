package baylinux.socialMediaProject;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@RolesAllowed("USER")
@Route(value="/FriendshipView",layout=MainLayout.class)
public class FriendshipView extends Div
{
	AppService appService;
	@Autowired
	public FriendshipView(AppService appService)
	{
		super();
		this.appService=appService;
		
		
	}
}
