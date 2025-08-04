package baylinux.socialMediaProject;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@StyleSheet("data:text/css;charset=utf-8,"
		   + ".btn:hover"
		   + "{ "
		   + "background-color:white !important; color:black !important;"
		   + "}"
		 
		  )

@Route(value="/LoginView",layout=MainLayout.class)
public class LoginView extends Div{

		AppService appService;
		@Autowired
		LoginView(AppService appService)
		{
			super();
			this.appService=appService;
			
			
			NativeLabel label1=new NativeLabel("Kullanıcı Adınızı Giriniz: ");
			label1.getStyle()
			.set("position", "absolute")
			.set("width", "280px")
			.set("height", "30px")
			.set("top", "100px")
			.set("left", "500px");
			label1.addClassName("label1");
			add(label1);
			TextField tf1=new TextField();
			tf1.getStyle()
			.set("position", "absolute")
			.set("width", "280px")
			.set("height", "30px")
			.set("top", "120px")
			.set("left", "500px");
			tf1.addClassName("tf1");
			add(tf1);
			
			NativeLabel label2=new NativeLabel("Şifrenizi Giriniz: ");
			label2.getStyle()
			.set("position", "absolute")
			.set("width", "280px")
			.set("height", "30px")
			.set("top", "180px")
			.set("left", "500px");
			label2.addClassName("label2");
			add(label2);
			PasswordField pf1=new PasswordField();
			pf1.getStyle()
			.set("position", "absolute")
			.set("width", "280px")
			.set("height", "30px")
			.set("top", "200px")
			.set("left", "500px");
			pf1.addClassName("pf1");
			add(pf1);
			
			Button btn3=new Button("Giriş Yap");
			btn3.getStyle()
			.set("position", "absolute")
			.set("width", "110px")
			.set("height", "30px")
			.set("top", "260px")
			.set("left", "670px")
			.set("background-color", "gray")
			.set("color", "white")
			.set("border", "1px solid black");
			btn3.addClassName("btn");
			//btn2.addClickListener(e->UI.getCurrent().navigate("/"));
			btn3.addClickListener(e->UI.getCurrent().navigate(IndexView.class));
			add(btn3);
		}
}
