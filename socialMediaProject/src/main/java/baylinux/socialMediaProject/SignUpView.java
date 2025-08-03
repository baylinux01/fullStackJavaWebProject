package baylinux.socialMediaProject;


import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.UploadHandler;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;

@StyleSheet("data:text/css;charset=utf-8,"
		   + ".btn:hover"
		   + "{ "
		   + "background-color:white !important; color:black !important;"
		   + "}"
		 
		  )

@Route("/SignUpView")
public class SignUpView extends Div{

AppService appService;

String imagePath=null;

	@Autowired
	SignUpView(AppService appService)
	{
		super();
		this.appService=appService;
		this.getStyle().set("height", "800px");
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
		
		Button btn2=new Button("Ana Sayfa");
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
		//btn2.addClickListener(e->UI.getCurrent().navigate("/"));
		btn2.addClickListener(e->UI.getCurrent().navigate(IndexView.class));
		add(btn2);
		
		NativeLabel label1=new NativeLabel("İsminizi Giriniz: ");
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
		
		NativeLabel label2=new NativeLabel("Soyisminizi Giriniz: ");
		label2.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "180px")
		.set("left", "500px");
		label2.addClassName("label2");
		add(label2);
		TextField tf2=new TextField();
		tf2.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "200px")
		.set("left", "500px");
		tf2.addClassName("tf2");
		add(tf2);
		
		NativeLabel label3=new NativeLabel("Kullanıcı adınızı Giriniz: ");
		label3.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "260px")
		.set("left", "500px");
		label3.addClassName("label3");
		add(label3);
		TextField tf3=new TextField();
		tf3.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "280px")
		.set("left", "500px");
		tf3.addClassName("tf3");
		add(tf3);
		
		NativeLabel label4=new NativeLabel("Şifrenizi Giriniz: ");
		label4.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "340px")
		.set("left", "500px");
		label4.addClassName("label4");
		add(label4);
		PasswordField pf1=new PasswordField();
		pf1.setRevealButtonVisible(true);
		pf1.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "360px")
		.set("left", "500px");
		pf1.addClassName("pf1");
		pf1.addClassName("pf1");
		add(pf1);
		
		NativeLabel label5=new NativeLabel("Profil fotoğrafı seçiniz:  ");
		label5.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "420px")
		.set("left", "500px");
		label5.addClassName("label5");
		add(label5);
		Set<String> allowed = Set.of(".png", ".jpg", ".jpeg");
		Upload upload = new Upload(
				UploadHandler.toTempFile((meta, file) -> 
				{
			        String fileName = meta.fileName();
			        String ext = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
			        
			        if (!allowed.contains(ext)) 
			        {
			            System.out.println("dosya uzantısı uygun değil");
			        }
			        else
			        {
			        	imagePath=file.getAbsolutePath();
			        }

			          
			    })
		);
		upload.setI18n(
			    new UploadI18N()
			        .setDropFiles(
			            new UploadI18N.DropFiles()
			                .setOne("Buraya bırakın")
			                .setMany("Dosyaları buraya bırakın")
			        )
			        .setAddFiles(
			            new UploadI18N.AddFiles()
			                .setOne("Dosya seç")
			                .setMany("Dosyaları seç")
			        )
			        
			        .setError(new UploadI18N.Error()
			            .setTooManyFiles("Çok fazla dosya")
			            .setFileIsTooBig("Dosya çok büyük"))
			);
		upload.setMaxFiles(1);
		upload.getStyle()
		.set("position", "absolute")
//		.set("width", "200px")
//		.set("height", "30px")
		.set("top", "440px")
		.set("left", "500px");
		upload.addClassName("upload");
		add(upload);
		
		NativeLabel label6=new NativeLabel("Doğum Tarihinizi seçiniz:  ");
		label6.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "520px")
		.set("left", "500px");
		label6.addClassName("label6");
		add(label6);
		DatePicker datePicker = new DatePicker();
		datePicker.setPlaceholder("GG.AA.YYYY");
		datePicker.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
//		.set("height", "30px")
		.set("top", "540px")
		.set("left", "500px");
		datePicker.addClassName("datePicker");
		add(datePicker);
		
		NativeLabel label7=new NativeLabel("E-Mail Giriniz: ");
		label7.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "600px")
		.set("left", "500px");
		label7.addClassName("label7");
		add(label7);
		TextField tf7=new TextField();
		tf7.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "620px")
		.set("left", "500px");
		tf7.addClassName("tf7");
		add(tf7);
		Button btn2b=new Button("Kodu Gönder");
		btn2b.getStyle()
		.set("position", "absolute")
		.set("width", "130px")
		.set("height", "35px")
		.set("top", "620px")
		.set("left", "800px")
		.set("background-color", "gray")
		.set("color", "white")
		.set("border", "1px solid black");
		btn2b.addClassName("btn");
		btn2b.addClickListener(e->
		{
			appService.sendEMail(tf7.getValue());
			Dialog dialog = new Dialog();

		    // İçerik
		    VerticalLayout content = new VerticalLayout(
		        new H3("Kodunuz Gönderildi"),
		        new Paragraph("Kodunuz Gönderildi eğer kod gelmezse "
		        		+ "email adresinizin doğruluğunu kontrol edip "
		        		+ "yeni kod için tekrar kodu gönder butonuna basın"),
		        new Button("Tamam", ex -> dialog.close())
		    );
		    content.setAlignItems(Alignment.CENTER);
		    dialog.add(content);

		    // Modal davranışı
		    dialog.setModal(true);   // arka planı “kilitle”
		    dialog.setDraggable(true);
		    dialog.setResizable(false);

		    dialog.open();
		});
		add(btn2b);
		
		NativeLabel label8=new NativeLabel("Gönderilen Kodu Giriniz: ");
		label8.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "660px")
		.set("left", "500px");
		label8.addClassName("label8");
		add(label8);
		TextField tf8=new TextField();
		tf8.getStyle()
		.set("position", "absolute")
		.set("width", "280px")
		.set("height", "30px")
		.set("top", "680px")
		.set("left", "500px");
		tf8.addClassName("tf8");
		add(tf8);
		Button btn3=new Button("Kayıt ol");
		btn3.getStyle()
		.set("position", "absolute")
		.set("width", "110px")
		.set("height", "30px")
		.set("top", "720px")
		.set("left", "670px")
		.set("background-color", "gray")
		.set("color", "white")
		.set("border", "1px solid black");
		btn3.addClassName("btn");
		//btn3.addClickListener(e->UI.getCurrent().navigate("/"));
		btn3.addClickListener(e->UI.getCurrent().navigate(IndexView.class));
		add(btn3);
		
		
	}
}
