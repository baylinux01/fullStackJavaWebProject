package baylinux.socialMediaProject;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@StyleSheet("data:text/css;charset=utf-8,"
		   + ".btn:hover"
		   + "{ "
		   + "background-color:white !important; color:black !important;"
		   + "}"
		   
			
			)
@Route("")
public class IndexView extends Div
{
	public IndexView()
	{
		
		Div header=new Div();
		header.getStyle()
		.set("position", "absolute")
		.set("top","0px")
		.set("left","0px")
		.set("width", "100%")
		.set("height", "50px")
		.set("background-color", "black");
		
		add(header);
		
		Button btn1=new Button("Giriş Yap");
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
		btn1.addClickListener(e->UI.getCurrent().navigate(LoginView.class));
		add(btn1);
		
		
		Button btn2=new Button("Kayıt Ol");
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
		btn2.addClickListener(e->UI.getCurrent().navigate(SignUpView.class));
		add(btn2);
		
	}
}
