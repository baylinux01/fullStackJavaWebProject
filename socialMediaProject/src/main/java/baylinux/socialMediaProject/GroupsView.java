package baylinux.socialMediaProject;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value="/GroupsView",layout=MainLayout.class)
public class GroupsView extends Div
{

	AppService appService;
	@Autowired
	public GroupsView(AppService appService)
	{
		super();
		this.appService=appService;
	}
}
