package baylinux.socialMediaProject;


import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import jakarta.annotation.security.PermitAll;

@StyleSheet("data:text/css;charset=utf-8,"
		   + ".btn:hover"
		   + "{ "
		   + "background-color:white !important; color:black !important;"
		   + "}")

@AnonymousAllowed
@Route(value="",layout = MainLayout.class)
public class IndexView extends Div implements BeforeEnterObserver
{
	@Override
	public void beforeEnter(BeforeEnterEvent event) 
	{
		myBuild();
		
	}
	
	AppService appService;
	@Autowired
	public IndexView(AppService appService)
	{
		super();
		this.appService=appService;
		
	}
	
	protected void myBuild()
	{
		
	}
	
}
