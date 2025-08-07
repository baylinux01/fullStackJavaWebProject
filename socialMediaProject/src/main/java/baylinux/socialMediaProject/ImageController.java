package baylinux.socialMediaProject;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imageapi")
public class ImageController {

    AppService appService;
    
    @Autowired
    public ImageController(AppService appService) {
        this.appService=appService;
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<byte[]> userPhoto(@PathVariable String username) 
    {
        AppUser appUser=null;
		try 
		{
			appUser = appService.daoForGet.getAppUserByUsername(username);
		} 
		catch (SQLException e) 
		{
			System.out.println("imageapide appUser veritabanından çekilemedi");
		}
        if (appUser == null) return ResponseEntity.notFound().build();

        byte[] bytes = appUser.getUserImageAsByteArray();
        if (bytes == null || bytes.length == 0) return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                             .contentType(MediaType.IMAGE_PNG)
                             .body(bytes);
    }
}