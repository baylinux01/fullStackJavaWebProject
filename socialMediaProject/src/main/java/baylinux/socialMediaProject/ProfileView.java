package baylinux.socialMediaProject;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@RolesAllowed("USER")
@Route(value="/ProfileView",layout=MainLayout.class)
public class ProfileView extends Div{

}
