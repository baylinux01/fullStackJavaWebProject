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
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@StyleSheet("data:text/css;charset=utf-8,"
		   + ".btn:hover"
		   + "{ "
		   + "background-color:white !important; color:black !important;"
		   + "}")

public class TopHeader extends Div
{
	AppService appService;
	@Autowired
	public TopHeader(AppService appService)
	{
		super();
		this.appService=appService;
		
		String pagePath = UI.getCurrent().getInternals()
                .getActiveViewLocation().getPath();
		
		Div header=new Div();
		header.getStyle()
		.set("position", "absolute")
		.set("top","0px")
		.set("left","0px")
		.set("width", "100%")
		.set("height", "50px")
		.set("background-color", "black");
		
		add(header);
		
		Tabs menu = new Tabs();
		menu.setOrientation(Tabs.Orientation.HORIZONTAL);
		
		Tab tab1=new Tab();
		tab1.setLabel("Anasayfa");
		tab1.getStyle().setColor("white");
		menu.add(tab1);
		
		Tab tab2=new Tab();
		tab2.setLabel("Profil");
		tab2.getStyle().setColor("white");
		menu.add(tab2);
		
		
		Tab tab3=new Tab();
		tab3.setLabel("Gruplar");
		tab3.getStyle().setColor("white");
		menu.add(tab3);
		
		Tab tab4=new Tab();
		tab4.setLabel("Arkadaşlık");
		tab4.getStyle().setColor("white");
		menu.add(tab4);
		
		menu.addSelectedChangeListener(event -> {
		    Tab selected = event.getSelectedTab();
		    if (selected == tab1) 
		    {
		        UI.getCurrent().navigate(IndexView.class);
		    } 
		    else if (selected == tab2) 
		    {
		        UI.getCurrent().navigate(ProfileView.class);
		    } 
		    else if (selected == tab3) 
		    {
		        UI.getCurrent().navigate(GroupsView.class);
		    }
		    else if (selected == tab4) 
		    {
		        UI.getCurrent().navigate(FriendshipView.class);
		    }
		});
		add(menu);
		
		
		
		Button btn1=null;
		if(appService.loggedIn()==true)
		{
			btn1=new Button("Anasayfa");
		}
		else
		{
			btn1=new Button("Giriş Yap");
		}
		btn1.getStyle()
		.set("position", "absolute")
		.set("width", "110px")
		.set("height", "30px")
		.set("top", "5px")
		.set("left", "1120px")
		.set("background-color", "gray")
		.set("color", "white")
		.set("border", "1px solid black");
		btn1.addClassName("btn");
		//btn1.addClickListener(e->UI.getCurrent().navigate("/LoginView"));
		btn1.addClickListener(e->{
			if(appService.loggedIn()==true)
			{
				UI.getCurrent().navigate(IndexView.class);
			}
			else
			{
				UI.getCurrent().navigate(LoginView.class);
			}
		});
		add(btn1);
		
		
		Button btn2=null;
		if(appService.loggedIn()==true)
		{
			btn2=new Button("Hoşgeldiniz");
		}
		else
		{
			btn2=new Button("Kayıt Ol");
		}
		btn2.getStyle()
		.set("position", "absolute")
		.set("width", "110px")
		.set("height", "30px")
		.set("top", "5px")
		.set("left", "1240px")
		.set("background-color", "gray")
		.set("color", "white")
		.set("border", "1px solid black");
		btn2.addClassName("btn");
		//btn2.addClickListener(e->UI.getCurrent().navigate("/SignUpView"));
		btn2.addClickListener(e->
		{
			if(appService.loggedIn()==true)
			{
				
			}	
			else
			{
				UI.getCurrent().navigate(SignUpView.class);
			}
		});
		add(btn2);
		
	}
}
