package at.refugeescode.profiles.view;

import at.refugeescode.profiles.persistence.model.Profiles;
import at.refugeescode.profiles.persistence.repository.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class NewParticipant {

    @ModelAttribute("newParticipant")
    Profiles newParticipant(){
        return new Profiles();
    }
    @Autowired
    ProfilesRepository profilesRepository;
    @GetMapping("/addParticipant")
    String page2(){
        return "newParticipant";
    }

    @PostMapping("/addParticipant")
    String addParticipant(@RequestParam String name,@RequestParam String introduction,@RequestParam String description
            ,@RequestParam String githubUrl,@RequestParam List<String> skills){
    Profiles profiles =new Profiles();
    profiles.setName(name);
    profiles.setGithubUrl(githubUrl);
    profiles.setDescription(description);
    profiles.setIntroduction(introduction);
    profiles.setSkills(skills);
    profilesRepository.save(profiles);

    return "redirect:/";
    }



}
