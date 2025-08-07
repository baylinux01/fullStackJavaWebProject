package baylinux.socialMediaProject;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import jakarta.annotation.security.PermitAll;


public class MainLayout extends Div implements RouterLayout, AfterNavigationObserver
{
	private final Div contentWrapper= new Div();
	
	
	@Override
    public void afterNavigation(AfterNavigationEvent event) 
	{
        // TopHeader'ı güncelle
		((TopHeader) getChildren().findFirst().orElse(null)).updateHeader();
    }
	
	@Override
    public void showRouterLayoutContent(HasElement content) 
	{
        contentWrapper.removeAll();          
        contentWrapper.getElement()
                    .appendChild(content.getElement()); 
    }
	
	
	
	AppService appService;
	
	@Autowired
	public MainLayout(AppService appService)
	{
		super();
		this.appService=appService;
		myBuild();
		
	}
	
	protected void myBuild()
	{
		add(new TopHeader(appService));
		add(contentWrapper);
	}

	
}
