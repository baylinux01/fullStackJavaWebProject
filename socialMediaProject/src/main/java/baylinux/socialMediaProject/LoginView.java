package baylinux.socialMediaProject;

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

@Route("/LoginView")
public class LoginView extends Div{

		LoginView()
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
			
			Button btn1=new Button("Ana Sayfa");
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
			//btn1.addClickListener(e->UI.getCurrent().navigate("/"));
			btn1.addClickListener(e->UI.getCurrent().navigate(IndexView.class));
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
